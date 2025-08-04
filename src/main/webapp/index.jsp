<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
    <script src="js/student.js"></script>
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

<%--Calling a Java Class from JSP--%>
<p>Upper case of sd20206: <%= org.example.demo6.FunUtils.makeItUpper("sd20206")%></p>

<form action="StudentServlet">
    First name: <input type="text" name="firstName">
    <br>
    Last name: <input type="text" name="lastName">
    <br>
    <select name = "country">
        <option>Lao</option>
        <option>Singapore</option>
        <option>Vietnam</option>
    </select>
    <br>

    <input type="checkbox" name="favoriteLanguage" value="Java">Java
    <input type="checkbox" name="favoriteLanguage" value="C#">C#
    <input type="checkbox" name="favoriteLanguage" value="Javascript">Javascript
    <input type="checkbox" name="favoriteLanguage" value="PHP">PHP

    <br>

    <input type="submit" value="Submit"/>

</form>

<hr>
<h3>Post new student using AJAX</h3>
<form>
    <div id="responseDiv"></div>
    <div>
        <label>Id</label>
        <input type="text" id="student_id" name="student_id">
    </div>
    <div>
        <label>Name</label>
        <input type="text" id="student_name" name="student_name">
    </div>
    <div>
        <label>Email</label>
        <input type="text" id="student_email" name="student_email">
    </div>
    <div>
        <label>Phone</label>
        <input type="text" id="student_phone" name="student_phone">
    </div>
    <div>
        <button type="button" onclick="saveStudent()">Add</button>
        <button type="button" onclick="showStudents()">Show</button>
    </div>
</form>




<a href="hello-servlet">Hello Servlet</a>
</body>
</html>