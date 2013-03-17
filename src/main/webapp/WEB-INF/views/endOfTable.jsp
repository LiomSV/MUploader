<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>      
        <script>            
        
            function doLike${track.getIdTrack() }(event) {
                $.get("like/${track.getIdTrack() }", {},
                        function(data) {
                            document.getElementById("rating_${track.getIdTrack() }").innerHTML = data.likes;                            
                            if (data.liked == true )
                                document.getElementById("like${track.getIdTrack() }").className = "btn btn-mini btn-success";
                            else
                                document.getElementById("like${track.getIdTrack() }").className = "btn btn-mini";   
                        }, "json");
            }
            
            function isLiked${track.getIdTrack() }(event) {   
            	$.get("isliked/${track.getIdTrack() }", {},
            	    function(data) {
            		    if (data.liked == true )
            		    	document.getElementById("like${track.getIdTrack() }").className = "btn btn-mini btn-success";
            		    else
            		    	document.getElementById("like${track.getIdTrack() }").className = "btn btn-mini";	
            		}, "json");
            }
            
            
            
            $("#like${track.getIdTrack() }").ready(isLiked${track.getIdTrack() });                        
        </script>
    
    
    <td>        
        <a class="audio" href="resources/mp3/${track.getFile() }.mp3" id="track_${track.getIdTrack() }"></a>
        <div id="played_${track.getIdTrack() }" style="display : none">false</div>
    </td>
    <td>
        <i class="icon-heart <spring:theme code="icon" />"></i><a id="rating_${track.getIdTrack() }">${track.getRating() }</a> <i class="icon-music <spring:theme code="icon" />"></i><a id="views_${track.getIdTrack() }">${track.getViews() }</a><br>
        <div class="btn-group">                         
            <button type="button" id="like${track.getIdTrack() }" class="btn btn-mini" 
                onclick="doLike${track.getIdTrack() }()">like</button>                        
            <a href="#myModal${track.getIdTrack() }" role="button" class="btn btn-mini" data-toggle="modal"><i class="icon-plus <spring:theme code="icon" />"></i></a>
            <a class="btn btn-mini" href="resources/mp3/${track.getFile() }.mp3"><i class="icon-download <spring:theme code="icon" />"></i></a>
        </div>        
    </td>
    
    <div id="myModal${track.getIdTrack() }" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-body">
		    <p><spring:message code="playlist.choose" text="Choose playlist." /></p>
            <select id="select_${track.getIdTrack() }">
        		<c:forEach items="${lists }" var="list">
		            <option value="${list.getIdPlaylist() }">${list.getName() }</option>
				</c:forEach>
		    </select>                
        </div>
        <div class="modal-footer">            
            <button class="btn" data-dismiss="modal" aria-hidden="true" onclick="forAdd${track.getIdTrack() }()" ><spring:message code="add" text="add" /></button>
            <button class="btn" data-dismiss="modal" aria-hidden="true"><spring:message code="cancel" text="cancel" /></button>            
		</div>
	</div>
	
	<script>
    function forAdd${track.getIdTrack() } (){
        var idPlaylist = $("#select_${track.getIdTrack() } option:selected").val();	   
    	$.get("add/${track.getIdTrack() }/"+idPlaylist); 
    }
	</script>