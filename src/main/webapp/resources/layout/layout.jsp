<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html> 
<html>
    <head>
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <link rel="stylesheet" href="<spring:theme code="styleSheet" />" type="text/css"/>
        
        <script src="<c:url value="resources/js/jquery-1.9.1.js"/>"></script>                            
        <script src="<c:url value="resources/js/bootstrap.js"/>"></script>
	</head>
	<body>
        <div class="container">
            
            <div class="row">                
                <tiles:insertAttribute name="header" ignore="true" />
            </div>                
            
            <div class="row">
                <tiles:insertAttribute name="body" ignore="true" />          
            </div>
            
            <div class="row">
                <tiles:insertAttribute name="footer" ignore="true" />
            </div>
            
        </div>          
             
    </body>
</html>