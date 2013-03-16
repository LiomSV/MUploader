    <td>
        <p id="audioplayer_${track.getIdTrack() }">Mp3 track would be here.</p>
        <script type="text/javascript">
             AudioPlayer.embed("audioplayer_${track.getIdTrack() }", {
                 soundFile : "resources/mp3/${track.getFile() }.mp3",
                 width : "100%",
                 transparentpagebg : "yes",
                 noinfo : "yes"
             });
        </script>
    </td>
    <td>
        <i class="icon-heart <spring:theme code="icon" />"></i>${track.getRating() } <i class="icon-music <spring:theme code="icon" />"></i>${track.getViews() }<br>
        <div class="btn-group">                         
            <button class="btn btn-mini">like</button>                         
            <button class="btn btn-mini"><i class="icon-plus <spring:theme code="icon" />"></i></button>
            <button class="btn btn-mini"><i class="icon-download <spring:theme code="icon" />"></i></button>
        </div>        
    </td>