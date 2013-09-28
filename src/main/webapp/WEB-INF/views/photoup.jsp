   <%@page import="java.util.Map.Entry"%>
  <%@ page import = "java.util.Map" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    <body>
        <h1>Upload a photo</h1>
        <%
        Map<String, String[]> parameters = request.getParameterMap();
for(Entry<String, String[]> parameter : parameters.entrySet()) {
     System.out.println(parameter.getKey() + " " + parameter.getValue());
}
%>
         ${uploadOk}
        <form:form method="post" commandName="photoUpForm" action="${pageContext.request.contextPath}/admin/photo" enctype="multipart/form-data">
            <form:errors path="*" cssClass="upfErr" /><br>
            <form:input path="file" type="file"/>  
            <input type="submit"/>
   </form:form>