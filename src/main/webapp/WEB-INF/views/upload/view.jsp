<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html;charset=UTF-8" %>
        <div class="container-fluid">
            <div class="row-fluid"> 
                <div class="span6">                                                        
                    <label class="control-label"><spring:message code="track.title" text="Title" /></label>
                    <input class="span12" type="text" value="${id3List.get(0) }" disabled="disabled" />
                    <label class="control-label" for="artistName"><spring:message code="track.artist" text="Artist" /></label>
                    <input class="span12" type="text" value="${id3List.get(1) }" disabled="disabled" />

                    <div class="row-fluid"> 
                        <div class="span6">
                            <div class="control-group">
                                <label class="control-label" for="genre"><spring:message code="track.genre" text="Genre" /></label>
                                <input class="span12" type="text" value="${id3List.get(2) }" disabled="disabled" />                                
                            </div>
                        </div>                              
                        <div class="span6">    
                            <div class="control-group">
                                <label class="control-label" for="tagLine"><spring:message code="track.tags" text="Tags" /></label>
                                <input class="span12" type="text" value="${tagLine }" disabled="disabled" />
                            </div>  
                        </div>
                    </div>
   
                </div>
                <div class="span6">    
                    <div class="control-group">
                        <label class="control-label" for="description"><spring:message code="track.description" text="Description" /></label>
                        <textarea id="description" rows="1" cols="1" style="display: none">${id3List.get(3) }</textarea>
                        <div id="descriptionView"> </div>  
                    </div>                      
                 </div> 
            </div>   
        </div>            
           
        <div class="span6 offset3 progress">
            <div class="bar bar-success" style="width: 33%;"><spring:message code="upload.step" text="Step" /> 1</div>
            <div class="bar bar-success" style="width: 34%;"><spring:message code="upload.step" text="Step" /> 2</div>
            <div class="bar bar-warning" style="width: 33%;"><spring:message code="upload.step" text="Step" /> 3</div>
        </div>                   
               
        <a href="upload/info"><button class="offset4 span2 btn"><spring:message code="back" text="Back" /></button></a>
        <a href="upload/done"><button class="span2 btn btn-success"><spring:message code="continue" text="Continue" /></button></a>        

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
                