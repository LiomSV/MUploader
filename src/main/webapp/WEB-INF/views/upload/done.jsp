<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
               

    <c:choose>	  
        <c:when test="${error == true }">
            <div class="hero-unit">
                <h1><spring:message code="notDone" text="Oops!" /></h1>
                <p><spring:message code="notDoneMessage" text="Something was wrong :(" /></p>
            </div>
        </c:when>
        <c:otherwise>  
		    <div class="hero-unit">
			    <h1><spring:message code="done" text="Well done!" /></h1>
			    <p><spring:message code="doneMessage" text="You song was uploaded successfully. Everybody can listen it now!" /></p>
			</div>
	    </c:otherwise>
    </c:choose>
           
    <div class="progress">
        <div class="bar" style="width: 100%;"></div>
    </div>                  
    <a href="home"><button type="submit" class="span4 offset4 btn btn-primary"><spring:message code="ok" text="OK" /></button></a>
   