<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Meals</title>
</head>
<body>
<form method="post" action="navigationServlet">
<table>
<c:forEach items="${requestScope.allMeals}" var="currentmeal">
<tr>
	<td><input type="radio" name="id" value="${currentmeal.id}"></td>
	<td>${currentmeal.main}</td>
	<td>${currentmeal.vegetable}</td>
	<td>${currentmeal.fruit}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToMeal">
<input type="submit" value="delete" name="doThisToMeal">
<input type="submit" value="add" name="doThisToMeal">
</form>
</body>
</html>