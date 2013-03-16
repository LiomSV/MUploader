<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
        <h2><spring:message code="header.admin" text="Users" /></h2>
        
        <c:if test="${pages > 1 }">	        
	        <div class="pagination">
	            <ul>
	                <c:choose>
	                    <c:when test="${page == 1 }">
	                        <li class="disabled"><a>&laquo;</a></li>
	                    </c:when>                           
	                    <c:otherwise>
	                        <li><a href="users/${page-1 }">&laquo;</a></li>
	                    </c:otherwise>
	                </c:choose>
	                
	                <c:forEach var="i" begin="1" end="${pages }">
		                <c:choose>
		                    <c:when test="${i == page }">
		                        <li class="disabled"><a>${i }</a></li>
		                    </c:when>                           
		                    <c:otherwise>
		                        <li><a href="users/${i }">${i }</a></li>
		                    </c:otherwise>
		                </c:choose>                        
	                </c:forEach>                    
	                
	                <c:choose>
	                    <c:when test="${page == pages }">
	                        <li class="disabled"><a>&raquo;</a></li>
	                    </c:when>                           
	                    <c:otherwise>
	                        <li><a href="users/${page+1 }">&raquo;</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </ul>
	        </div>
        </c:if>	        
        <table class="table table-bordered table-striped">
            <tr>
                <th><spring:message code="id" text="Id" /></th>
                <th><spring:message code="login" text="login" /></th>
                <th><spring:message code="password" text="Password" /></th>
                <th><spring:message code="email" text="E-Mail" /></th>
                <th><spring:message code="activation" text="Activation" /></th>
            </tr>
            <c:forEach items="${userList }" var="user">                           	            
		        <tr>
		            <td>${user.getIdUser() }</td>
		            <td>${user.getUsername() }</td>
		            <td>${user.getPassword() }</td>
		            <td>${user.getMail() }</td>
		            <td>
    		            <c:choose>
						    <c:when test="${user.getEnabled() }">
						        <a class="btn btn-success btn-block" href="${path }/deactivate/${user.getIdUser() }">Activated</a>
						    </c:when>						    
						    <c:otherwise>
						        <a class="btn btn-danger btn-block" href="${path }/activate/${user.getIdUser() }">Deactivated</a>
						    </c:otherwise>
						</c:choose>
		            </td>
		        </tr>
	        </c:forEach>          
        </table>
        
  