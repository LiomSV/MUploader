<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

	    <h1 align="center">
		    <spring:message code="registration.registration" text="Registration" />		   
		</h1>   
 		   
        <div class="span6 offset3">
   
		    <ul class="nav nav-tabs">    
		        <li><a href="login"><spring:message code="login.signIn" text="Sign in" /></a></li>  
		        <li class="active"><a href=""><spring:message code="registration.registration" text="Registration" /></a></li>
		    </ul>             
                <form class="form-horizontal" id="registration" action="addUser"
                        method="POST"  >
                    <div class="alert alert-info">
                        <spring:message code="registration.advice" text="You should fill in all fields for registration." />
                    </div>
                    <c:if test="${param.error == true}" >
                        <div class="alert alert-error control-group">
                            <c:if test="${param.emptyUsername == true}" >
                                <spring:message code="registration.emptyUsername" text="Enter a login." /><br>
                            </c:if>
                            <c:if test="${param.userExist == true}" >
                                <spring:message code="registration.userExist" text="Login like this is already exist." /><br>                               
                            </c:if>                            
                            <c:if test="${param.emptyPassword == true}" >
		                        <spring:message code="registration.emptyPassword" text="Enter a password." /><br>		                        
		                    </c:if>
		                    <c:if test="${param.confirmPassword == true}" >                            
                                <spring:message code="registration.confirmPassword" text="Password was not confirmed." /><br>                                
                            </c:if>
                            <c:if test="${param.invalidMail == true}" >                            
                                <spring:message code="registration.invalidMail" text="Invalid e-mail." /><br>
                            </c:if>
                        </div>
                    </c:if>                    
                    <div class="control-group">                        
                        <label class="control-label" for="username"><spring:message code="registration.login" text="Login" /></label>
                        <div class="controls">
                            <input type="text" id="username" name="username" placeholder="<spring:message code="registration.login" text="Login" />" pattern="^[a-zA-Z0-9-.]+">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="password"><spring:message code="registration.password" text="Password" /></label>
                        <div class="controls">
                            <input type="password" id="password" name="password" placeholder="<spring:message code="registration.password" text="Password" />">
                        </div>
                    </div>                    
                    <div class="control-group">
                        <label class="control-label" for="confirmPassword"><spring:message code="registration.confirm" text="Confirm password" /></label>
                        <div class="controls">
                            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="<spring:message code="registration.confirm" text="Confirm password" />">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="mail"><spring:message code="registraion.email" text="E-Mail" /></label>
                        <div class="controls">
                            <input type="text" id="mail" name="mail" placeholder="<spring:message code="registration.email" text="E-Mail" />">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">                
                            <button type="submit" class="btn btn-primary"><spring:message code="registration.do" text="Continue" /></button>
                        </div>
                    </div>                  
                </form>    
        </div>                            
            