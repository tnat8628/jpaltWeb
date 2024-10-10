package vn.iotstar.services;

import java.util.List;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.entity.Category;

public class CategoryService implements ICategoryService{

	ICategoryDao cateDao = new CategoryDao();
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return cateDao.count();
	}

	@Override
	public List<Category> findAll(int page, int pagesize) {
		// TODO Auto-generated method stub
		return cateDao.findAll(page, pagesize);
	}

	@Override
	public List<Category> findByCategoryname(String catname) {
		// TODO Auto-generated method stub
		return cateDao.findByCategoryname(catname); //!
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

	@Override
	public Category findById(int cateid) {
		// TODO Auto-generated method stub
		return cateDao.findById(cateid);
	}

	@Override
	public void delete(int cateid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		
	}

}
