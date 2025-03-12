<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<% request.getSession().removeAttribute("userForm"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Người Dùng</title>
    <link rel="stylesheet" type="text/css" href="./assest/styles.css">
</head>
<body>
    <h1>Thêm Người Dùng</h1>
    
    <html:form action="/add-user" method="post">
        <table>
        	<tr>
                <td>Username:</td>
                <td><html:text property="username"  /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><html:password property="password"  /></td>
            </tr>
            <tr>
                <td>Fullname:</td>
                <td><html:text property="fullname"  /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><html:text property="email"  /></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><html:text property="phone"  /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <html:submit value="Thêm" />
                </td>
            </tr>
        </table>
    </html:form>

    <br>
    <a href="index.do">Quay lại danh sách</a>
</body>
</html>
