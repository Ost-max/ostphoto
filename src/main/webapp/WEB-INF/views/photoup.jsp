   <%@page import="java.util.Map.Entry"%>
  <%@ page import = "java.util.Map" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<div id="photoup" >
        <h3>Upload a photo</h3>
         ${uploadOk}
        <form:form method="post" commandName="photoUpForm" action="${pageContext.request.contextPath}/admin/photo" enctype="multipart/form-data">
            <form:errors path="*" cssClass="upfErr" /><br>
	    	<form:select path="categoryid">
			  <form:option value="0" label="choise..." />
			  <form:options items="${categoryList}" itemValue="id" itemLabel="name" />
	    	</form:select>
	    	<br>
	    	<form:input path="file" type="file"/>  
            <input type="submit"/>
   </form:form>
   </div>