<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add new Product</title>
</head>
<body>
<h3>Add Product</h3>
<form action="/products/insert" method="post">
  <table>
    <tr>
      <td><label>Id</label></td>
      <td><input type="text" name="id"/></td>
    </tr>
    <tr>
      <td><label>Name</label></td>
      <td><input type="text" name="name"/></td>
    </tr>
    <tr>
      <td><label>Category</label></td>
      <td>
        <select name="category_id">
          <c:forEach var="category" items="${categories}">
            <option value="${category.id}" >${category.name}</option>
          </c:forEach>
        </select>
      </td>
    </tr>
    <tr>
      <td><label></label></td>
      <td><input type="submit" value="Save"/></td>
    </tr>
  </table>
</form>
</body>
</html>
