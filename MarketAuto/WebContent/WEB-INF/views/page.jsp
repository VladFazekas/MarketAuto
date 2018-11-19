<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<spring:url var="css" value="resources/css" />
<spring:url var="js" value="resources/js" />
<spring:url var="pictures" value="resources/pictures" />


<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Market Auto - ${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/myapp.css" rel="stylesheet">    
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
	<%@include file="./shared/navbar.jsp" %>
    <!-- Page Content -->    
    <c:if test="${userClickHome}">
    <%@include file="home.jsp" %>
	</c:if>
	<c:if test="${userClickAbout}">
    <%@include file="about.jsp" %>
	</c:if>
	<c:if test="${userClickContact}">
    <%@include file="contact.jsp" %>
	</c:if>
	<c:if test="${userClickAllProducts or userClickCategoryProducts}">
    <%@include file="listProducts.jsp" %>
	</c:if>
	<c:if test="${userClickManageProd}">
    <%@include file="manageProducts.jsp" %>
	</c:if>
	
    <!-- Footer -->
    <%@include file="./shared/footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="${js}/jquery.js"></script>
    <script src="${js}/bootstrap.bundle.min.js"></script>
    <script src="${js}/jquery.dataTables.js"></script>
    <script src="${js}/myapp.js"></script>
    

  </body>

</html>
