<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
               

    <c:choose>	  
        <c:when test="${error == true }">
            <div class="hero-unit">
                <h1><spring:message code="upload.notDone" text="Oops!" /></h1>
                <p><spring:message code="upload.notDoneMessage" text="Something was wrong :(" /></p>
            </div>
        </c:when>
        <c:otherwise>  
		    <div class="hero-unit">
			    <h1><spring:message code="upload.done" text="Well done!" /></h1>
			    <p><spring:message code="upload.doneMessage" text="You song was uploaded successfully. Everybody can listen it now!" /></p>
			</div>
	    </c:otherwise>
    </c:choose>
           
    <div class="span6 offset3 progress">
       <div class="bar bar-success" style="width: 33%;"><spring:message code="upload.step" text="Step" /> 1</div>
       <div class="bar bar-success" style="width: 34%;"><spring:message code="upload.step" text="Step" /> 2</div>
       <div class="bar bar-success" style="width: 33%;"><spring:message code="upload.step" text="Step" /> 3</div>
    </div>                  
    <a href="home"><button type="submit" class="span4 offset4 btn btn-success"><spring:message code="ok" text="OK" /></button></a>
   