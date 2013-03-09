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
                        method="POST" >
                    <div class="alert alert-info">
                        <spring:message code="registration.advice" text="You should fill in all fields for registration." />
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="login"><spring:message code="registration.login" text="Login" /></label>
                        <div class="controls">
                            <input type="text" id="login" name="login" placeholder="<spring:message code="registration.login" text="Login" />">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="password"><spring:message code="registration.password" text="Password" /></label>
                        <div class="controls">
                            <input type="password" id="password" name="password" placeholder="<spring:message code="registration.password" text="Password" />">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="confirmPassword"><spring:message code="registration.confirmPassword" text="Confirm Password" /></label>
                        <div class="controls">
                            <input type="password" id="confirmPassword" name="confirmPassword" placeholder="<spring:message code="registration.confirmPassword" text="Confirm Password" />">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="email"><spring:message code="registraion.email" text="E-Mail" /></label>
                        <div class="controls">
                            <input type="text" id="email" name="email" placeholder="<spring:message code="registration.email" text="E-Mail" />">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">                
                            <button type="submit" class="btn btn-primary"><spring:message code="registration.do" text="Continue" /></button>
                        </div>
                    </div>                  
                </form>    
        </div>                            
            