<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action = "${pageContext.request.contextPath }/admin/category/update" method = "post" enctype="multipart/form-data">
	<input type="text" name="categoryid" hidden="hidden" value="${cate.categoryid }">
	
	<label for="categoryname">Category name:</label><br>
	<input type="text" id="categoryname" name="categoryname" value="${cate.categoryname }"><br>
	<label for="images">Link image:</label><br>
	<input type="text" id="images" name="images" value="${cate.images }" required> <br>
	
	<label for="images1">Upload file:</label><br>
	<input type="file" id="images1" name="images1" value="${cate.images }" required> <br>
	
	<label for="status">Status: </label><br>
	<input type="radio" id="ston" name="status" value="1" checked>
	<label for="css">Hoạt động</label><br>
 	<input type="radio" id="stoff" name="status" value="0">
  	<label for="javascript">Khóa</label> <br>
  	<hr>
  	<input type="submit" value="insert"> <br>
</form>