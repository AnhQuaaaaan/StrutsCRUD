<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Người Dùng</title>
    <link rel="stylesheet" type="text/css" href="./assest/styles.css">
</head>
<body>

    <h2>Danh Sách Người Dùng</h2>
    <logic:present name="message">
    <p style="color: red;"><bean:write name="message"/></p>
	</logic:present>

    <!-- Nút thêm người dùng -->
  <button class="btn-add" onclick="window.location.href='add.do'">Thêm Người Dùng</button>


    <!-- Bảng danh sách user -->
    <table>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Fullname</th>
            <th></th>
        </tr>

        <logic:notEmpty name="listUser">
            <logic:iterate name="listUser" id="user">
                <tr>
                    <td><bean:write name="user" property="id"/></td>
                    <td><bean:write name="user" property="username"/></td>
                    <td><bean:write name="user" property="email"/></td>
                    <td><bean:write name="user" property="phone"/></td>
                    <td><bean:write name="user" property="fullname"/></td>
                    <td>
    					<html:link page="/showedit.do" paramId="id" paramName="user" paramProperty="id" styleClass="btn-edit">Sửa</html:link>
    					<html:link page="/delete-user.do" paramId="id" paramName="user" paramProperty="id" styleClass="btn-delete" onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</html:link>
    					<html:link page="/view-user.do" paramId="id" paramName="user" paramProperty="id" styleClass="btn-view">Xem</html:link>
					</td>

                </tr>
            </logic:iterate>
        </logic:notEmpty>

        <logic:empty name="listUser">
            <tr>
                <td colspan="6" style="text-align: center; color: red;">Không có người dùng nào!</td>
            </tr>
        </logic:empty>
    </table>

</body>
</html>
