<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/book.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<script type="text/javascript">
	function confirm() {
		return (window.confirm('Do you want to delete ?'));
	}
</script>
</head>
<body>
	<form:form id="bookForm" name="bookForm" action="save"
		modelAttribute="book">
		<form:hidden path="bookId" />
		<table>
			<caption>
				<b>Enter book Details</b>
			</caption>
			<tbody>
				<tr>
					<td>Enter book name :</td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" /></td>
				</tr>
				<tr>
					<td>Enter book price :</td>
					<td><form:input path="price" /></td>
					<td><form:errors path="price" /></td>
				</tr>
				<tr>
					<td>Enter author name :</td>
					<td><form:input path="author" /></td>
					<td><form:errors path="author" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<div class="btnContainer">
							<input type="reset" value="Reset" />
							<c:set var="operation" value="Update"></c:set>
							<c:if test="${empty book.bookId}">
								<c:set var="operation" value="Add"></c:set>
							</c:if>
							<input type="submit" value="${operation}"
								onclick="bookFormValidate();" />
						</div>
					</td>
				</tr>
			</tbody>

		</table>

	</form:form>
	<span id="hideMe">${msg}</span>
	<br />
	<br />
	<c:if test="${not empty bookList}">
		<table class="books" border="2">
			<caption>
				<b>Books Details</b>
			</caption>
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
					<th>Author</th>
					<th colspan="2">Operations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${bookList}" var="book">
					<tr>
						<td>${book.name}</td>
						<td>${book.price}</td>
						<td>${book.author}</td>
						<td><a href="update?bookId=${book.bookId}">Update</a></td>
						<td><a href="delete?bookId=${book.bookId}"
							onclick="return confirm();">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>



	<script type="text/javascript" src="js/book_validation.js"></script>
</body>
</html>