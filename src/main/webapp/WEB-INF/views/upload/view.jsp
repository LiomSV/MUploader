<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

        <div class="container-fluid">
            <div class="row-fluid"> 
                <div class="span6">                                                        
                    <label class="control-label"><spring:message code="track.title" text="Title" /></label>
                    <label class="well well-small">${track.getTitle() }</label>
                    <label class="control-label" for="artistName"><spring:message code="track.artist" text="Artist" /></label>
                    <label class="well well-small">${artistName }</label>   

                    <div class="row-fluid"> 
                        <div class="span6">
                            <div class="control-group">
                                <label class="control-label" for="genre"><spring:message code="track.genre" text="Genre" /></label>
                                <label class="well well-small">${track.getGenre() }</label>
                            </div>
                        </div>                              
                        <div class="span6">    
                            <div class="control-group">
                                <label class="control-label" for="tagLine"><spring:message code="track.tags" text="Tags" /></label>
                                <label class="well well-small">${tagLine }</label>
                            </div>  
                        </div>
                    </div>
   
                </div>
                <div class="span6">    
                    <div class="control-group">
                        <label class="control-label" for="description"><spring:message code="track.description" text="Description" /></label>
                        <textarea id="description" rows="1" cols="1" style="display: none">${track.getDescription() }</textarea>
                        <div id="descriptionView"> </div>  
                    </div>                      
                 </div> 
            </div>   
        </div>            
           
        <div class="progress">
            <div class="bar" style="width: 66%;"></div>
            <div class="bar bar-warning" style="width: 34%;"></div>
        </div>                  
               
        <a href="upload/cancel"><button class="span2 btn btn-danger"><spring:message code="cancel" text="Cancel" /></button></a>
        <a href="upload/done"><button class="span2 offset4 btn btn-primary"><spring:message code="continue" text="Continue" /></button></a>        

                <script src="resources/js/markdown.js"></script>                
                <script>
                  function Editor(input, preview)
                  {
                    this.update = function () {
                      preview.innerHTML = markdown.toHTML(input.value);
                    }
                    input.editor = this;
                    this.update();
                  }
                  var $ = function (id) { return document.getElementById(id); };
                  new Editor($("description"), $("descriptionView"));
                </script>      
                