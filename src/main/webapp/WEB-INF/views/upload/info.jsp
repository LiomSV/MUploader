<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
               
    <form class="" id="songEdit" action="upload/view"
            method="POST" >                    
        <div class="container-fluid">
            <div class="row-fluid"> 
                <div class="span6">   	           
			        <div class="control-group">                        
			            <label class="control-label" for="title"><spring:message code="track.title" text="Title" /></label>
			            <div class="controls">
			                <input class="span12" type="text" id="title" name="title" placeholder="<spring:message code="track.title" text="Title" />">
			            </div>
			        </div>
			        <div class="control-group">
			            <label class="control-label" for="artistName"><spring:message code="track.artist" text="Artist" /></label>
			            <div class="controls">
			                <input class="span12" type="text" id="artistName" name="artistName" placeholder="<spring:message code="track.artist" text="Artist" />">
			            </div>
			        </div>   

                        <div class="row-fluid"> 
                            <div class="span6">
						        <div class="control-group">
						            <label class="control-label" for="genre"><spring:message code="track.genre" text="Genre" /></label>
						            <div class="controls">
						                <input type="text" id="genre" name="genre" placeholder="<spring:message code="track.genre" text="Genre" />">
						            </div>
						        </div>
                            </div>						        
						    <div class="span6">    
						        <div class="control-group">
						            <label class="control-label" for="tagLine"><spring:message code="track.tags" text="Tags" /></label>
						            <div class="controls">
						                <input type="text" id="tagLine" name="tagLine" placeholder="<spring:message code="track.tags" text="Tags" />">
						            </div>
						        </div>  
						    </div>
				        </div>
   
			    </div>
	            <div class="span6">    
				    <div class="control-group">
				        <label class="control-label" for="description"><spring:message code="track.description" text="Description" /></label>
					    <textarea id="description" name="description" style="resize: none"
					        class="span12" rows="15" cols="60" placeholder="<spring:message code="track.typeDescription" text="Type description here." />" ></textarea>
				    </div>	    			    
				 </div> 
		    </div>   
        </div>			  
           
        <div class="progress">
            <div class="bar" style="width: 33%;"></div>
            <div class="bar bar-warning" style="width: 67%;"></div>
        </div>                  
        <div class="control-group">
            <div class="controls">                
                <a href="upload/cancel"><button class="span2 btn btn-danger"><spring:message code="cancel" text="Cancel" /></button></a>
                <button type="submit" class="span2 offset4 btn btn-primary"><spring:message code="continue" text="Continue" /></button>                
            </div>
        </div>         
                 
    </form>

AAA <br> ${a } <br> ${b }                    
 