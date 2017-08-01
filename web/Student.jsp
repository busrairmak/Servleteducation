<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Student</title>
</head>
<body>
<a href="/">Go to Home Page</a>
<c:if test="${student.name ==null}">
<h2>Add Student </h2>
<form action="?operation=add"method="POST">
  <table>
    <tr>
      <td>NAME:</td>
      <td><input type="text" name="name"/></td>
    </tr>
    <tr>
    <td>NO:</td>
    <td><input type="text" name="no"/></td>
  </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Add"/></td>
    </tr>

  </table>
</form>

</c:if>



<c:if test="${student.name !=null}">
  <h2> Edit Student </h2>
  <form action="?operation=update&id=${student.id}"method="POST">
    <table>
      <tr>
        <td>NAME:</td>
        <td><input type="text" name="name" value="${student.name}"/></td>
      </tr>
      <tr>
      <td>NO:</td>
      <td><input type="text" name="no" value="${student.no}"/></td>
    </tr>
      <tr>
        <td colspan="2"><input type="submit" value="update"/></td>
      </tr>

    </table>
  </form>

</c:if>

<table>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>No</th>
  </tr>
  <c:forEach var="student" items="${list}">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.no}</td>
      <td>
        <a href="?operation=delete&id=${student.id}">Delete</a>
      </td>
      <td>
        <a href="?operation=edit&id=${student.id}">Edit</a>
      </td>

    </tr>

  </c:forEach>
</table>

</body>
</html>