<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
                
               
        <h2><spring:message code="playlist" text="Playlist"/>: ${playlist.getName() }</h2>
        <a class="btn btn-danger btn-small" href="delete/playlist/${playlist.getIdPlaylist() }">delete playlist</a>
        <br><br>
        
        <script type="text/javascript" src="<c:url value="resources/js/audio-player.js"/>"></script>  
	    <script type="text/javascript">  
	        AudioPlayer.setup("<c:url value='resources/flash/player.swf'/>", {  
	           width: '100%',
	           quality: 'high',
               lefticon: '0xFFFFFF',
               righticon: '0xFFFFFF',
               leftbg: '0x357CCE',
               rightbg: '0x32BD63',
               rightbghover: '0x2C9D54',
               wmode: 'transparent',
               transparentpagebg : "yes",
               loop : "yes"
	       });  
	    </script>  
	      
        <c:if test="${playlist.getTracks().size() > 0 }">	        
		    <p id="audioplayer_1">Mp3 track would be here.</p>  
		    <script type="text/javascript">  
		        AudioPlayer.embed("audioplayer_1", {
		            soundFile : "${files}",
		            titles : "${titles}",
		            artists : "${artists}"
		        });  
		    </script>
        </c:if>		    
                		           
	    <c:forEach items="${playlist.getTracks() }" var="track">
	        <li><a href="">${track.getArtist().getName() } - ${track.getTitle() }</a></li>
	    </c:forEach>		   
	     