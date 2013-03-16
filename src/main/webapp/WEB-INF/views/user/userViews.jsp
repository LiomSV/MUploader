<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="resources/js/raphael-min.js"></script>
<script src="resources/js/g.raphael.js"></script>    
<script src="resources/js/g.pie.js"></script>        
 
    <script>
    window.onload = function () {        
        var f1 = function () {
            this.sector.stop();
            this.sector.scale(1.03, 1.03, this.cx, this.cy);

            if (this.label) {
                this.label[0].stop();
                this.label[0].attr({ r: 7.5 });
                this.label[1].attr({ "font-weight": 800 });
            }
        }
        
        var f2 = function () {
            this.sector.animate({ transform: 's1 1 ' + this.cx + ' ' + this.cy }, 500, "bounce");

            if (this.label) {
                this.label[0].animate({ r: 5 }, 500, "bounce");
                this.label[1].attr({ "font-weight": 400 });
            }   
        }
        
        var r = Raphael("likeStatistics"),
	        pie = r.piechart(300, 100, 100, ${likes.getValues().toString() }, {
	            legend: ${likes.getTagnames() },
	            legendpos: "west",
	            href: ${likes.getHrefs() }
	        });
	    
	    var r2 = Raphael("viewStatistics"),
		    pie2 = r2.piechart(200, 100, 100, ${views.getValues().toString() }, {
		        legend: ${views.getTagnames() },
		        legendpos: "east",
		        href: ${views.getHrefs() }
		    });
        
        pie.hover(f1, f2);   	    
	    pie2.hover(f1,f2);

    };
    </script>
    
    <h2>${username }</h2>
    
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="span6">
                <h4>Likes</h4>
            </div>
            <div class="span6">
                <h4>Listenings</h4>
            </div>
        </div>            
        <div class="row-fluid">
            <div class="span6">                
                <div id="likeStatistics"></div>
            </div>
            <div class="spab6">
                <div id="viewStatistics"></div>
            </div>    
        </div>    
    </div>