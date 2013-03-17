window.onload = function() {
	for(var i = 0; i < ${length }; ++i){
		document.getElementById("like${track.getIdTrack() }").addEventListener("onclick", setLike${track.getIdTrack() }, false);
		liked${track.getIdTrack() }();
	}
}