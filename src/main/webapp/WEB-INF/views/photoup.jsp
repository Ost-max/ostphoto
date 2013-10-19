   <%@page import="java.util.Map.Entry"%>
  <%@ page import = "java.util.Map" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/chosen/chosen.jquery.js" type="text/javascript"></script>
  <script src="${pageContext.request.contextPath}/resources/chosen/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/chosen/chosen.css">
<div id="photoup" >
        <h3>Upload a photo</h3>
         ${param.uploadOk}
        <form:form method="post" commandName="photoUpForm" action="${pageContext.request.contextPath}/admin/photo" enctype="multipart/form-data">
            <form:errors path="*" cssClass="upfErr" /><br>
	    	<form:select path="category" data-placeholder="Choose a categories..." class="chosen-select" multiple="true" style="width:350px;" tabindex="4">
			  <form:options items="${categoryList}" itemValue="id" itemLabel="name" />
	    	</form:select>
	    	<br><br>
	    	<form:input path="file" type="file"/>  
            <input type="submit"/>
   </form:form>
    <script type="text/javascript">
    var config = {
      '.chosen-select'           : {},
      '.chosen-select-deselect'  : {allow_single_deselect:true},
      '.chosen-select-no-single' : {disable_search_threshold:10},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width'     : {width:"95%"}
    }
    for (var selector in config) {
      $(selector).chosen(config[selector]);
    }
  </script>
   </div>