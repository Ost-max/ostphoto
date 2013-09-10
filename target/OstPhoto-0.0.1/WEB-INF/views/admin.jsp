<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
		<title>Administrator panel</title>
		       <base href="${pageContext.request.contextPath}">
</head>
<body>
<h1>
	Welcome to administrator panel! 
</h1>

<%-- <spring:message code="label.remember" /> --%>
${uploadOk}

<form:errors path="uploadError" cssClass="error"></form:errors>

<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
 error:  ${error}
    <body>
        <h1>Upload a photo</h1>
        <form:form method="post" commandName="uploadPhoto" enctype="multipart/form-data">
     
            <form:input path="file" type="file"/>  
            <input type="submit"/>
   </form:form>
</body>
</html>
