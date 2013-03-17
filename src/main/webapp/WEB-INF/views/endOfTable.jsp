        <script>            
        
            function doLike${track.getIdTrack() }(event) {
            	var xhr = new XMLHttpRequest();               
            	xhr.addEventListener("load", isLiked${track.getIdTrack() }, false);
            	xhr.open("POST", "like/${track.getIdTrack() }", true);
                xhr.send(null);
                
            }
            
            function isLiked${track.getIdTrack() }(event) {
            	var xhr = new XMLHttpRequest();                                               
            	xhr.addEventListener("load", function() {	                      
	                        var response = xhr.responseText;
	                        if (response == "true"){
	                        	document.getElementById("like${track.getIdTrack() }").className = "btn btn-mini btn-success";                              
	                        } else {
	                        	document.getElementById("like${track.getIdTrack() }").className = "btn btn-mini";  
	                        }                                                       
                      }
                      , false); 
            	xhr.open("POST", "isliked/${track.getIdTrack() }", true);
            	xhr.send(null);
            }
            
            $("#like${track.getIdTrack() }").ready(isLiked${track.getIdTrack() });
            
            function play${track.getIdTrack() }(event) {
            	document.getElementById("like${track.getIdTrack() }").className = "btn btn-mini btn-warning";    	
            }
                        
        </script>
    
    
    <td>        
        <a class="audio" href="resources/mp3/${track.getFile() }.mp3" id="track_${track.getIdTrack() }"></a>
        <div id="played_${track.getIdTrack() }" style="display : none">false</div>
    </td>
    <td>
        <i class="icon-heart <spring:theme code="icon" />"></i><a id="rating_${track.getRating() }">${track.getRating() }</a> <i class="icon-music <spring:theme code="icon" />"></i><a id="views_${track.getViews() }">${track.getViews() }</a><br>
        <div class="btn-group">                         
            <button type="button" id="like${track.getIdTrack() }" class="btn btn-mini" 
                onclick="doLike${track.getIdTrack() }()">like</button>                        
            <button class="btn btn-mini"><i class="icon-plus <spring:theme code="icon" />"></i></button>
            <button class="btn btn-mini"><i class="icon-download <spring:theme code="icon" />"></i></button>
        </div>        
    </td>