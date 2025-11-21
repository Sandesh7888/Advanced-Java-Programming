<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="uploadphoto" enctype="multipart/form-data" method="post">
		Id: <input type="text" name="id"> <br> <br> Name: <input
			type="text" name="name"> <br> <br> Photo: <input
			type="file" name="photo" accept="Image/*"> <br> <br>

		<input type="submit" value="Submit">
	</form>

</body>
</html>