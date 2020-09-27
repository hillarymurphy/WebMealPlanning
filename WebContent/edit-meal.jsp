<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Meal</title>
</head>
<body>
<form action="editMealServlet" method="post">
Main: <input type="text" name="main" value="${mealToEdit.main}">
Vegetable: <input type="text" name="vegetable" value="${mealToEdit.vegetable}">
Fruit: <input type="text" name="fruit" value="${mealToEdit.fruit}">
<input type="hidden" name="id" value="${mealToEdit.id}">
<input type="submit" value="Save Edited Meal">
</form>

</body>
</html>