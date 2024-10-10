<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action = "${pageContext.request.contextPath }/admin/category/insert" method = "post" enctype="multipart/form-data">
	<label for="categoryname">Category name:</label><br>
	<input type="text" id="categoryname" name="categoryname"><br>
	<label for="images">Link image:</label><br>
	<input type="text" id="images" name="images"> <br>
	
	<label for="images1">Upload file:</label><br>
	<input type="file" id="images1" name="images1"> <br>
	
	<label for="status">Status: </label><br>
	<input type="radio" id="ston" name="status" value="1">
	<label for="css">Hoạt động</label><br>
 	<input type="radio" id="stoff" name="status" value="0">
  	<label for="javascript">Khóa</label> <br>
  	<hr>
  	<input type="submit" value="insert"> <br>
</form>