        <script>            
        
            function doLike${track.getIdTrack() }(event) {
                $.get("like/${track.getIdTrack() }", {},
                        function(data) {
                            document.getElementById("rating_${track.getRating() }").innerHTML = data.likes;                            
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
            <button class="btn btn-mini"><i class="icon-plus <spring:theme code="icon" />"></i></button>
            <button class="btn btn-mini"><i class="icon-download <spring:theme code="icon" />"></i></button>
        </div>        
    </td>