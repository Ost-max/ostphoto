  <%@page import="java.util.Map.Entry"%>
  <%@ page import = "java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
		<title>Administrator panel</title>
		       <base href="${pageContext.request.contextPath}">
		
</head>
       <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminstyle.css">
<body>
<a href="<c:url value="/admin"/>">Main</a>
<a href="<c:url value="/admin/photo"/>">Photo</a>
<a href="<c:url value="/admin/calendar"/>">Calendar</a>
<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
<h2>
	Welcome to administrator panel! 
</h2>

<%-- <spring:message code="label.remember" /> --%>



${debugInfo}<br>
    <c:forEach items="${viewList}" var="viewName">
                <jsp:include page="${viewName}.jsp" />
      </c:forEach>
</body>
</html>

