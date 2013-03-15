<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

        <script>
            window.onload = function() {
                var dropbox = document.getElementById("dropbox");
                dropbox.addEventListener("dragenter", noop, false);
                dropbox.addEventListener("dragexit", noop, false);
                dropbox.addEventListener("dragover", noop, false);
                dropbox.addEventListener("drop", dropUpload, false);
            }

            function noop(event) {
                event.stopPropagation();
                event.preventDefault();
            }

            function dropUpload(event) {
                noop(event);
                var files = event.dataTransfer.files;

                for (var i = 0; i < files.length; i++) {
                    if (files[i].name.match(/.+mp3/    ))    
                        upload(files[i]);
                }
            }

            function upload(file) {
                document.getElementById("status").innerHTML = "Uploading " + file.name;

                var formData = new FormData();
                formData.append("file", file);

                var xhr = new XMLHttpRequest();
                xhr.upload.addEventListener("progress", uploadProgress, false);
                xhr.addEventListener("load", uploadComplete, false);
                xhr.open("POST", "upload/uploading", true); // If async=false, then you'll miss progress bar support.
                xhr.send(formData);
            }

            function uploadProgress(event) {
                // Note: doesn't work with async=false.
                var progress = Math.round(event.loaded / event.total * 33);
                document.getElementById("status").style.width = progress + "%";
                document.getElementById("statusFiller").style.width = (33-progress) + "%";
            }

            function uploadComplete(event) {
            	document.getElementById("continueButtonOn").style.display = "block";
            	document.getElementById("continueButtonOff").style.display = "none";
            	document.getElementById("status").innerHTML = "<spring:message code='upload.uploaded' text='Uploaded!' />!";
            }
        </script>

        <div class="drop_zone"><spring:message code="upload.dropMessage" text="Drop you track anywhere at site." /></div>
        
        <div class="progress">
            
        </div>


    <div class="span6 offset3 progress">
        <div id="status" class="bar bar-success"></div>
        <div id="statusFiller" class="bar bar-warning" style="width: 33%;"><spring:message code="upload.step" text="Step" /> 1</div>
        <div class="bar bar-danger" style="width: 34%;"><spring:message code="upload.step" text="Step" /> 2</div>
        <div class="bar bar-danger" style="width: 33%;"><spring:message code="upload.step" text="Step" /> 3</div>
    </div>   
    <button id="continueButtonOff" class="span2 offset5 btn btn-success disabled"><spring:message code="continue" text="Continue" /></button>
    <a id="continueButtonOn" href="upload/info" style="display:none"><button class="span2 offset5 btn btn-success"><spring:message code="continue" text="Continue" /></button></a>        
    
    