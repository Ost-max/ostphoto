  <%@page import="java.util.Map.Entry"%>
  <%@ page import = "java.util.Map" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    <body>
        <h1>Categories:</h1>
         ${editOk}<br>

<%
Map<String, String[]> parameters = request.getParameterMap();
for(Entry<String, String[]> parameter : parameters.entrySet()) {
     System.out.println(parameter.getKey() + " " + parameter.getValue());
}
     %>
       <c:forEach items="${categoryList}" var="category">                   
                   #<a href="#">${category.name}</a> &nbsp; 
                </c:forEach>
                <br>
        <form:form method="post" commandName="categoryEdit" action="${pageContext.request.contextPath}/admin/photo/catedit" enctype="multipart/form-data">
            <form:errors path="*" cssClass="upfErr" /><br>
            <form:input path="name" type="text"/>  
            <input type="button" value="add"/>
   </form:form>