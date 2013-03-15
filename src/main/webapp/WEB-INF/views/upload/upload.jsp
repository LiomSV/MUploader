<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="example" id="drop_zone">Drop files here</div>
<output id="list" name="list"></output>


<script>
  function handleFileSelect(evt) {
    evt.stopPropagation();
    evt.preventDefault();

    var files = evt.dataTransfer.files;
    var f = files[0];
    
    
    
    var reader = new FileReader();
    reader.onloadend = function(evt) {
    	document.getElementById('list').textContent = evt.target.result;
    	//document.getElementById('files').nodeValue = evt.target.result;
    };
    reader.readAsText(f);
 
    

  }

  function handleDragOver(evt) {
    evt.stopPropagation();
    evt.preventDefault();
    evt.dataTransfer.dropEffect = 'copy'; // Explicitly show this is a copy.
  }

  // Setup the dnd listeners.
  var dropZone = document.getElementById('drop_zone');
  dropZone.addEventListener('dragover', handleDragOver, false);
  dropZone.addEventListener('drop', handleFileSelect, false);
</script>

<form id="form1" name="form1" method="post" action="upload/test" enctype="multipart/form-data">
    <input type="submit" value="go!" />
    <input type="file" id="files" name="files" multiple />
</form>

<form:form method="post" action="upload/info" 
    modelAttribute="uploadForm" enctype="multipart/form-data">
    <div class="row-fluid">
        <div class="span4">
            <input name="file" type="file"  /> 
            <input class="btn btn-primary" type="submit" value="Upload"/>
            <c:if test="${not empty fileError}">
                <div class="alert alert-error" style=margin-top:10px;>${fileError}</div>
            </c:if>
            
        </div>
    </div>
 </form:form>


    <div class="progress">
        <div class="bar bar-warning" style="width: 100%;"></div>
    </div>   
    
    