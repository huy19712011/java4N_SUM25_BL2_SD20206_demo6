<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Update Product</title>
</head>
<body>
<h3>Update Product</h3>
<form action="/products/update" method="post">
  <table>
    <tr>
      <td><label>Id</label></td>
      <td><input type="text" name="id" value="${product.id}" readonly/></td>
    </tr>
    <tr>
      <td><label>Name</label></td>
      <td><input type="text" name="name" value="${product.name}"/></td>
    </tr>
    <tr>
      <td><label>Category</label></td>
      <td>
        <select name="category_id">
          <c:forEach var="category" items="${categories}">
            <option value="${category.id}" ${category.id == categoryId ? 'selected="selected"' : ''}>${category.name}</option>
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

