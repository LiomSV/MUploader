<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link rel="stylesheet" href="<c:url value="resources/css/tagcloud.css"/>" type="text/css"/>
    
    <script type="text/javascript" src="<c:url value="resources/js/audio-player.js"/>"></script>  
    <script type="text/javascript">  
        AudioPlayer.setup("<c:url value='resources/player.swf'/>", {  
            width: 290
        });  
    </script>
    
    	
	<div class="container-fluid">
	    <div class="row-fluid">
            
            <div class="span8">
                <h3 align="center">    
                    <spring:message code="home.lastuploaded" text="Last Uploaded" />
                </h3>                
                                
                <div class="accordion" id="accordion">
					
				    <c:forEach items="${trackList }" var="track">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${track.getIdTrack() }">
								   ${track.getArtist().getName() } - ${track.getTitle() }
								</a>
							</div>
							<div id="collapse${track.getIdTrack() }" class="accordion-body collapse">
								<div class="accordion-inner">							      				      				        								    
								    <p id="audioplayer_${track.getIdTrack() }">Mp3 track would be here.</p>  
								    <script type="text/javascript">  
								        AudioPlayer.embed("audioplayer_"+${track.getIdTrack() }, {
								            soundFile : "resources/mp3/"+${track.getIdTrack() }+".mp3",
								            width : "100%",
								            transparentpagebg : "yes"
								        });  
								    </script>
								</div>
								<div class="container-fluid">
                                    <div class="row-fluid">		
									    <div class="span6">	  
										    <h6><spring:message code="track.uploader" text="Uploader: " /><a href="#">${track.getUser().getUsername() }</a></h6>																    
										</div>
										<div class="span6">       
										    <h6><spring:message code="track.date" text="Date: " />${track.getTime() }</h6>
										</div>
                                    </div>
                                </div>										
							</div>
						</div>
					</c:forEach>
										
				</div> 				                                                                         
            </div>
            
            
            <div class="span4">
                <h3 align="center">    
                    <spring:message code="home.populartags" text="Popular Tags" />
                </h3>
                <div class="tags">				
				    <ul>
		                <li class="tag1"><a href="#">Lorem ipsum</a></li> 
		                <li class="tag2"><a href="#">Dolor sit amet</a></li>
		                <li class="tag3"><a href="#">Consectetur adipiscing elit</a></li>
		                <li class="tag2"><a href="#">Proin </a></li>
		                <li class="tag4"><a href="#">Sagittis libero</a></li>
		                <li class="tag1"><a href="#">Aliquet augue</a></li>
		                <li class="tag1"><a href="#">Quisque dui lacus</a></li>
		                <li class="tag5"><a href="#">Consequat</a></li>
		                <li class="tag1"><a href="#">Quisque dui lacus</a></li>
		                <li class="tag6"><a href="#">Consequat</a></li>
		                <li class="tag2"><a href="#">Dictum non</a></li>
		                <li class="tag1"><a href="#">Venenatis et tortor</a></li>
		                <li class="tag3"><a href="#">Suspendisse mauris</a></li>
		                <li class="tag7"><a href="#">In accumsan </a></li>
		                <li class="tag1"><a href="#">Egestas neque</a></li>
		                <li class="tag5"><a href="#">Mauris eget felis</a></li>
		                <li class="tag1"><a href="#">Suspendisse</a></li>
		                <li class="tag2"><a href="#">condimentum eleifend nulla</a></li>
	                </ul>
	            </div>	          	
            </div>
        </div>
    </div>
    
   