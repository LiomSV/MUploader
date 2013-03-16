<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
               
    <div class="container">            
        <%@ include file="radiobuttons.jsp" %>
    </div>
    <h2><spring:message code="${message }" text="Header"/></h2>    
    
    <div class="container-fluid">       
        <c:forEach begin="1" end="${(artistList.size()+1) / 3 }" var="i">
            <div class="row-fluid">
                <c:forEach begin="0" end="2" var="j">
                    <c:set var="index" value="${(i-1)*3+j }"></c:set>               
                    <c:if test="${index < artistList.size() }">
                        <div class="span4">
                            <h2>${artistList.get(3*(i-1)+j).getLetter() }</h2>
                            <c:forEach items="${artistList.get(index) }" var="artist">
                                <a href="artist/${artist.getIdArtist() }/1">${artist.getName() }</a><br>    
                            </c:forEach>
                        </div>
                    </c:if>                
               </c:forEach>        
            </div>                 
        </c:forEach>
    </div>      