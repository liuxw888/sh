<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/sh/product/addProduct1" method="post" enctype="multipart/form-data">
	产品类型：<select name="producttypeid">
			<c:forEach items="${pts }" var="pt">
				<option value="${pt.id }">${pt.name }</option>
			</c:forEach>
			</select><br>
			产品名字：<input type="text" name="name" /><br>
			产品颜色：<input type="text" name="color" /><br>
			产品价格：<input type="text" name="price" /><br>
			产品描述：<input type="text" name="description" /><br>
			产品照片：<input type="file" name="img" /><br>
			<input type="submit" value="新增">
	</form>
</body>
</html>