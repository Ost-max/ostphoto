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
<body>
<h1>
	Welcome to administrator panel! 
</h1>
Map<String, String[]> parameters = request.getParameterMap();
for(Entry<String, String[]> parameter : parameters.entrySet()) {
     System.out.println(parameter.getKey() + " " + parameter.getValue());
}

<%-- <spring:message code="label.remember" /> --%>

<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>

${debugInfo}<br>
    <c:forEach items="${viewList}" var="viewName">
                <jsp:include page="${viewName}.jsp" />
      </c:forEach>
</body>
</html>
