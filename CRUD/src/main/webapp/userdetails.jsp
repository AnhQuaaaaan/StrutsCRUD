<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết người dùng</title>
</head>
<body>

    <h1>Thông tin người dùng</h1>

    <%-- Hiển thị thông tin user nếu tồn tại --%>
    <table border="1">
        <tr>
            <td><strong>ID:</strong></td>
            <td><bean:write name="user" property="id"/></td>
        </tr>
        <tr>
            <td><strong>Họ tên:</strong></td>
            <td><bean:write name="user" property="fullname"/></td>
        </tr>
        <tr>
            <td><strong>Tên đăng nhập:</strong></td>
            <td><bean:write name="user" property="username"/></td>
        </tr>
        <tr>
            <td><strong>Email:</strong></td>
            <td><bean:write name="user" property="email"/></td>
        </tr>
        <tr>
            <td><strong>Số điện thoại:</strong></td>
            <td><bean:write name="user" property="phone"/></td>
        </tr>
    </table>

    <%-- Hiển thị thông báo nếu không tìm thấy user --%>
    <p style="color: red;">
        <bean:write name="message" ignore="true"/>
    </p>

    <br>
    <a href="index.do">Quay lại danh sách</a>

</body>
</html>
