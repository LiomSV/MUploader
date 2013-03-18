<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="resources/js/jquery-ui-1.9.2.custom.js"></script>  
               
    <form class="" id="songEdit" action="upload/view"
            method="POST" >                    
        <div class="container-fluid">
            <div class="row-fluid"> 
                <div class="span6">   	           
			        <c:if test="${param.error == true }">
			            <div class="alert alert-error control-group"><spring:message code="upload.emptyField" text="Title and artist must not be empty." /></div>
			        </c:if>
			        <div class="control-group">                        
			            <label class="control-label" for="title"><spring:message code="track.title" text="Title" /></label>
			            <div class="controls">
			                <input class="span12" type="text" id="title" name="title" value="${id3List.get(0) }" placeholder="<spring:message code="track.title" text="Title" />">
			            </div>
			        </div>
			        <div class="control-group">
			            <label class="control-label" for="artistName"><spring:message code="track.artist" text="Artist" /></label>
			            <div class="controls">
			                <input class="span12" type="text" id="artistName" name="artistName" value="${id3List.get(1) }" placeholder="<spring:message code="track.artist" text="Artist" />">
			            </div>
			        </div>   

                        <div class="row-fluid"> 
                            <div class="span6">
						        <div class="control-group">
						            <label class="control-label" for="genre"><spring:message code="track.genre" text="Genre" /></label>
						            <div class="controls">
						                <input type="text" id="genre" name="genre" value="${id3List.get(2) }" placeholder="<spring:message code="track.genre" text="Genre" />">
						            </div>
						        </div>
                            </div>						        
						    <div class="span6">    
						        <div class="control-group">
						            <label class="control-label" for="tagLine"><spring:message code="track.tags" text="Tags" /></label>
						            <div class="controls">
						                <input type="text" id="tagLine" name="tagLine" value="${tagLine }" placeholder="<spring:message code="track.tags" text="Tags" />">
						            </div>
						        </div>  
						    </div>
				        </div>
   
			    </div>
	            <div class="span6">    
				    <div class="control-group">
				        <label class="control-label" for="description"><spring:message code="track.description" text="Description" /></label>
					    <textarea id="description" name="description" style="resize: none"
					        class="span12" rows="15" cols="60" placeholder="<spring:message code="track.typeDescription" text="Type description here." />" >${id3List.get(3) }</textarea>
				    </div>	    			    
				 </div> 
		    </div>   
        </div>			  
           
        <div class="span6 offset3 progress">
	        <div class="bar bar-success" style="width: 33%;"><spring:message code="upload.step" text="Step" /> 1</div>
	        <div class="bar bar-warning" style="width: 34%;"><spring:message code="upload.step" text="Step" /> 2</div>
	        <div class="bar bar-danger" style="width: 33%;"><spring:message code="upload.step" text="Step" /> 3</div>
	    </div>  
	                       
        <div class="control-group">
            <div class="controls">                            
                <button type="submit" class="span2 offset5 btn btn-success"><spring:message code="continue" text="Continue" /></button>                
            </div>
        </div>         
                 
    </form>     
