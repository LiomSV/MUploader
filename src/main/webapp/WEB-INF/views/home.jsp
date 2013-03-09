<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link rel="stylesheet" href="<c:url value="resources/css/tagcloud.css"/>" type="text/css"/>
    	
	<div class="container-fluid">
	    <div class="row-fluid">
            <div class="span8">
                <h3 align="center">    
                    <spring:message code="home.lastuploaded" text="Last Uploaded" />
                </h3>                
                
                <div class="accordion" id="accordion2">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
							   House of the Rising Sun - Animals :: lox :: 01.03.2013 16:15
							</a>
						</div>
						<div id="collapseOne" class="accordion-body collapse in">
							<div class="accordion-inner">
							    <script type="text/javascript" src="<c:url value="resources/js/audio-player.js"/>"></script>  
			    <script type="text/javascript">  
			        AudioPlayer.setup("<c:url value='resources/player.swf'/>", {  
			           width: 290
			       });  
			    </script>  
      
        
			    <p id="audioplayer_1">Mp3 track would be here.</p>  
			    <script type="text/javascript">  
			        AudioPlayer.embed("audioplayer_1", {
			            soundFile : "<c:url value='resources/mp3/1.mp3'/>",
			            width : "100%",
			            transparentpagebg : "yes"
			        });  
			    </script>
							</div>
						</div>
					</div>
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo">
							    Freaky Like Me - Madcon
							</a>
						</div>
						<div id="collapseTwo" class="accordion-body collapse">
							<div class="accordion-inner">
							   <p id="audioplayer_2">Mp3 track would be here.</p>  
							    <script type="text/javascript">  
							        AudioPlayer.embed("audioplayer_2", {
							            soundFile : "<c:url value='resources/mp3/2.mp3'/>",
							            noinfo : "yes"
							        });  
							    </script>
							</div>
						</div>
					</div>
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
    
   