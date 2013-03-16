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
        
        var r = Raphael("statistics"),
	        pie = r.piechart(400, 160, 150, ${data.getValues().toString() }, {
	            legend: ${data.getTagnames() },
	            legendpos: "east",
	            href: ${data.getHrefs() },
	            minPercent: "5"
	        });
	  
        pie.hover(f1, f2);   	    

    };
    </script>
    
    <h2><spring:message code="stat" text="User statistics"/>: ${username }</h2>
    
    <ul class="nav nav-tabs">
        <c:choose> 
            <c:when test='${sort == "like" }'>   
		        <li class="active"><a href="${path }"><spring:message code="stat.like" text="Liked tracks"/></a></li>
		        <li><a href="${path }/../views"><spring:message code="stat.views" text="Listened tracks"/></a></li>
		    </c:when>  
            <c:when test='${sort == "views" }'>   
                <li><a href="${path }/../like"><spring:message code="stat.like" text="Liked tracks"/></a></li>
                <li class="active"><a href="${path }"><spring:message code="stat.views" text="Listened tracks"/></a></li>
            </c:when> 
        </c:choose>		                  
    </ul>
    
    <div id="statistics"></div>