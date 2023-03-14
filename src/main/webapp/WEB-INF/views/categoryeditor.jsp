  <%@page import="java.util.Map.Entry"%>
  <%@ page import = "java.util.Map" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
     <br>
<div id="cat" >

        <h3>Categories:</h3>
        ${param.editOk}
       <br>
            <a href="${pageContext.request.contextPath}/admin/photo/all">all</a> &nbsp;  
            <a href="${pageContext.request.contextPath}/admin/photo/none">none</a> &nbsp;  
       <c:forEach items="${categoryList}" var="category">                   
                  <a href="${pageContext.request.contextPath}/admin/photo/${category.name}">${category.name}</a> &nbsp; 
                </c:forEach>
                <br>
              
        <form:form method="post" commandName="categoryEdit" action="${pageContext.request.contextPath}/admin/photo/addcat" enctype="multipart/form-data">
            <form:errors path="*" cssClass="upfErr" /><br>
            <form:input path="name" type="text"  />  
            <input  type="submit" value="add"/>
   </form:form>
   </div>
   <br>

   
<div id="photolist">
	<h3>${curCat.name} photos:</h3>
	${curCat.isSlider}
	          <c:forEach items="${photoList}" var="photo">                      
	<div class="photocontainer">
		<div class="photosetings">
			<a href="${pageContext.request.contextPath}/admin/photo/delete/${photo.id}">x</a>
		</div>
		<div class="imgholder"
			style="background-image: url('${pageContext.request.contextPath}/admin/photo/s/${photo.update}/${photo.fileName}')">
		</div>
	</div>
       </c:forEach>

</div>