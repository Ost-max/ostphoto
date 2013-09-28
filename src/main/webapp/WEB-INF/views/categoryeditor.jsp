  <%@page import="java.util.Map.Entry"%>
  <%@ page import = "java.util.Map" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<div id="cat" >
 <base href="${pageContext.request.contextPath}">
        <h3>Categories:</h3>
         ${editOk}<br>
       <c:forEach items="${categoryList}" var="category">                   
                  <a href="cat/photo/${category.name}">${category.name}</a> &nbsp; 
                </c:forEach>
   
        <form:form method="post" commandName="categoryEdit" action="${pageContext.request.contextPath}/photo/catedit" enctype="multipart/form-data">
            <form:errors path="*" cssClass="upfErr" /><br>
            <form:input path="name" type="text"/>  
            <input type="button" value="add"/>
   </form:form>
   </div>