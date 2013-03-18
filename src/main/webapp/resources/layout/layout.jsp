<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html> 
<html>
    <head>
        <c:url value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/mup/" var="rootAddress" />
        <base href="${rootAddress}" />
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <link rel="stylesheet" href="<spring:theme code="styleSheet" />" type="text/css"/>
        
        <script src="resources/js/jquery-1.9.1.js"></script>                                   
        <script src="resources/js/bootstrap.js"></script>                   
        
        <style type="text/css">
            .drop_zone{border:2px dashed #bbb;-moz-border-radius:5px;-webkit-border-radius:5px;border-radius:5px;padding:25px;text-align:center;font:20pt bold,"Vollkorn";color:#bbb;height:300px}
        </style>
        
        <script type="text/javascript" src="<c:url value="resources/js/jquery.min.js"/>"></script>
	    <script type="text/javascript" src="<c:url value="resources/js/jquery.swfobject.min.js"/>"></script>
        <script type="text/javascript" src="<c:url value="resources/js/audioplayer.js"/>"></script>               
	</head>
	<body>
        <div id="dropbox">
        <div class="container">
            
            <div class="row">                
                <tiles:insertAttribute name="header" ignore="true" />
            </div>                
            
            <div class="row">
                <tiles:insertAttribute name="body" ignore="true" />          
            </div>                                       
            
            <div class="row">
                <br>
                <tiles:insertAttribute name="footer" ignore="true" />
            </div>
            
        </div>       
        </div>   
             
    </body>
</html>