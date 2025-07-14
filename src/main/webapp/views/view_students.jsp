<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 7/14/2025
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Students</h1>
<c:forEach var="tempStudent" items="${student_list}">
    ${tempStudent} <br>
</c:forEach>
</body>
</html>
