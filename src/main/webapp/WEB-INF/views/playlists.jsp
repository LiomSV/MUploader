<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
        
        <h2><spring:message code="playlist.playlists" text="My lists"/></h2>
        
        <form class="form-inline" action="playlists/new">
            <input type="text" placeholder="New playlist" id="name" name="name">
		    <button type="submit" class="btn">Create</button>
	    </form>
                
        <c:choose>	
            <c:when test="${playlists.size() == 0 }">
	            <div class="hero-unit">
	                <h1><spring:message code="upload.notDone" text="Oops!" /></h1>
	                <p><spring:message code="playlist.noplaylists" text="You didn't create any playlist" /></p>
	            </div>
            </c:when>	 
            <c:otherwise>       
                <ul>		        
			        <c:forEach items="${playlists }" var="playlist">
			            <li><h4><a href="playlist/${playlist.getIdPlaylist() }">${playlist.getName() }</a></h4></li>
			        </c:forEach>
                </ul>			        
            </c:otherwise>		        
        </c:choose>		            