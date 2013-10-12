  <%@page import="java.util.Map.Entry"%>
  <%@ page import = "java.util.Map" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<div id="cat" >

        <h3>Categories:</h3>
         ${editOk}<br>
       <c:forEach items="${categoryList}" var="category">                   
                  <a href="cat/photo/${category.name}">${category.name}</a> &nbsp; 
                </c:forEach>
                <br>
        <form:form method="post" commandName="categoryEdit" action="${pageContext.request.contextPath}/admin/photo/addcat" enctype="multipart/form-data">
            <form:errors path="*" cssClass="upfErr" /><br>
            <form:input path="name" type="text"/>  
            <input  type="submit" value="add"/>
   </form:form>
   </div>
   <br>
   <div id="photolist" >
          <c:forEach items="${photoList}" var="photo">       
          
                  <img src="${pageContext.request.contextPath}/admin/photo/s/${photo.update}/${photo.fileName}" />&nbsp; 
                </c:forEach>
   </div>