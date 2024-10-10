package vn.iotstar.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.entity.Category;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.ICategoryService;


@MultipartConfig()
@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add", "/admin/category/insert", "/admin/category/delete", "/admin/category/edit", "/admin/category/update"})
public class CategoryController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ICategoryService cateService = new CategoryService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/add")) {
			req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/categories")) {
			List<Category> list = cateService.findAll();
			req.setAttribute("listcate", list);
			req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
		}
		else if (url.contains("/admin/category/delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				cateService.delete(id);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			resp.sendRedirect(req.getContextPath()+ "/admin/categories");
		}
		else if (url.contains("/admin/category/edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Category cate = cateService.findById(id);
			req.setAttribute("cate", cate);
			req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();
		if (url.contains("/admin/category/insert")) {
			//lấy dữ liệu từ view
			String categoryname = req.getParameter("categoryname");
			int status = Integer.parseInt(req.getParameter("status"));
			String images = req.getParameter("images");
			
			//đưa vào Model
			Category category = new Category();
			category.setCategoryname(categoryname);
			category.setStatus(status);
			
			
			//Xử lý upload file
			String fname="";
			String uploadPath = "E:\\upload";
			File uploadDir = new File(uploadPath);
			if(!uploadDir.exists()) {
				uploadDir.mkdir();	
			}
			try {
				Part part =req.getPart("images1");
				if(part.getSize()>0) {
					String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
					//đổi tên file
					int index = filename.lastIndexOf(".");
					String ext = filename.substring(index+1);
					fname = System.currentTimeMillis() + "." + ext;
					//upload file
					part.write(uploadPath + "/" + fname);
					//ghi tên file  vào data
					category.setImages(fname);
				} else if (images != null) {
					category.setImages(images);
				} else {
					category.setImages("avatar.png");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//truyền Model vào insert
			cateService.insert(category);
			
			//trả về view
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
			
		}
	}

}
