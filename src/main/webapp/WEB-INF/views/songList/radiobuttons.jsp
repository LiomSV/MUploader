<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
    
    <div class="btn-group span5 offset3">
        <a class="btn btn-large btn-primary" href="artists"><spring:message code="artist" text="Artist"/></a>
        <a class="btn btn-large btn-primary" href="rating"><spring:message code="rating" text="Rating"/></a>
        <a class="btn btn-large btn-primary" href="views"><spring:message code="views" text="Views"/></a>
    </div>