<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello SD20206!" %>
</h1>
<br/>

<%--expressions--%>
<p>The time on server is: <%= new java.util.Date() %>  </p>
<p>Converting to Upper Case: <%= new String("Hello sd20206").toUpperCase()%></p>
<p>Summary of 3 and 5 = <%= 3 + 5%></p>

<%--scriptlets--%>
<%
    for (int i = 1; i < 6; ++i) {

        out.println("Item " + i);
        out.println("<br>");
    }
%>

<%--JSP Declarations--%>
<%!
    String makeItLower(String data) {

        return data.toLowerCase();
    }
%>
<p>Lower case of SD20206: <%= makeItLower("HELLO SD20206") %></p>




<a href="hello-servlet">Hello Servlet</a>
</body>
</html>