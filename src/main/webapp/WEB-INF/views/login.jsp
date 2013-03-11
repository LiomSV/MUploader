<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

	    <h1 align="center">

		    <c:choose>
		        <c:when test="${param.logout == true}">
		           <spring:message code="login.return" text="Come again!" />
		        </c:when>
		        <c:when test="${param.logout == false}">
		            <spring:message code="login.welcome" text="Welcome!" />
		        </c:when>
		        <c:otherwise>
		            <spring:message code="login.welcome" text="Welcome!" />
		        </c:otherwise>
		    </c:choose>
		</h1>   
 		   
        <div class="span6 offset3">
   
		    <ul class="nav nav-tabs">    
		        <li class="active"><a href=""><spring:message code="login.signIn" text="Sign in" /></a></li>  
		        <li><a href="registration"><spring:message code="registration.registration" text="Registration" /></a></li>
		    </ul>             
                <form class="form-horizontal" id="login" action="<c:url value='j_spring_security_check' />"
                        method="POST" >
                    <c:if test="${param.activated == true}" >
                      <div class="alert alert-success control-group">
                          <spring:message code="activateSuccess" text="You were activated."/>
                      </div>
                    </c:if>
                    <c:if test="${param.fail == true}" >
                      <div class="alert alert-error control-group">
                          <spring:message code="login.error" text="Invalid login or password!"/>
                      </div>
                    </c:if>
                    <div class="control-group">
                        <label class="control-label" for="inputLogin"><spring:message code="login.login" text="login" /></label>
                        <div class="controls">
                            <input type="text" id="inputLogin" name="inputLogin" placeholder="<spring:message code="login.login" text="login" />">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPassword"><spring:message code="login.password" text="Password" /></label>
                        <div class="controls">
                            <input type="password" id="inputPassword" name="inputPassword" placeholder="<spring:message code="login.password" text="Password" />">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">                
                            <button type="submit" class="btn btn-primary"><spring:message code="login.signIn" text="Sign in" /></button>
                        </div>
                    </div>                  
                </form>    
        </div>                            
            