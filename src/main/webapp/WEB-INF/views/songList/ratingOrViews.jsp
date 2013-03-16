<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
        
        <script type="text/javascript" src="<c:url value="resources/js/audio-player.js"/>"></script>  
        <script type="text/javascript">  
            AudioPlayer.setup("<c:url value='resources/player.swf'/>", {            	
            });  
        </script>
                    
        <div class="container">            
            <%@ include file="radiobuttons.jsp" %>
        </div>
        <h2><spring:message code="${message }" text="Header"/></h2>
        
        <c:if test="${pages > 1 }">	        
	        <div class="pagination">
	            <ul>
	                <c:choose>
	                    <c:when test="${page == 1 }">
	                        <li class="disabled"><a>&laquo;</a></li>
	                    </c:when>                           
	                    <c:otherwise>
	                        <li><a href="tag/${tag.getIdTag() }/${page-1 }">&laquo;</a></li>
	                    </c:otherwise>
	                </c:choose>
	                
	                <c:forEach var="i" begin="1" end="${pages }">
	                    <c:choose>
	                        <c:when test="${i == page }">
	                            <li class="disabled"><a>${i }</a></li>
	                        </c:when>                           
	                        <c:otherwise>
	                            <li><a href="tag/${tag.getIdTag() }/${i }">${i }</a></li>
	                        </c:otherwise>
	                    </c:choose>                        
	                </c:forEach>                    
	                
	                <c:choose>
	                    <c:when test="${page == pages }">
	                        <li class="disabled"><a>&raquo;</a></li>
	                    </c:when>                           
	                    <c:otherwise>
	                        <li><a href="tag/${tag.getIdTag() }/${page+1 }">&raquo;</a></li>
	                    </c:otherwise>
	                </c:choose>
	            </ul>
	        </div>
        </c:if>	        
        <table class="table table-striped">
            <c:forEach items="${trackList }" var="track">                                         
                <tr>
                    <td>${track.getTitle() }</td>
                    <td>${track.getArtist().getName() }</td>
                    <td>${track.getGenre() }</td>
                    <%@ include file="/WEB-INF/views/endOfTable.jsp" %>
                </tr>
            </c:forEach>    
            <tr><td></td><td></td><td></td><td></td><td></td></tr>      
        </table>