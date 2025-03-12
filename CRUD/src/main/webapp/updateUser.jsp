<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Người Dùng</title>
<link rel="stylesheet" type="text/css" href="./assest/styles.css">
</head>
<body>
	<h1>Sửa Người Dùng</h1>

	<html:form action="/update-user" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><html:text name="user" property="id" readonly="true"
						disabled="true" /> <html:hidden name="user" property="id" /></td>
			</tr>

			<tr>
				<td>Username</td>
				<td><html:text name="user" property="username" readonly="true"
						disabled="true" /></td>
			</tr>
			<tr>
				<td>Fullname</td>
				<td><html:text name="user" property="fullname" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><html:text name="user" property="email" /></td>
			</tr>
			<tr>
				<td>Phone</td>
				<td><html:text name="user" property="phone" /></td>
			</tr>
			<tr>
				<td colspan="2"><html:submit value="Cập nhật" /></td>
			</tr>
		</table>
	</html:form>

	<br>
	<a href="index.do">Quay lại danh sách</a>
</body>
</html>
