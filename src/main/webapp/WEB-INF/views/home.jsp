<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<link rel="stylesheet" href="<spring:theme code="cloudStyle"/>" type="text/css"/>
<%@ page import="org.vsp.mup.domain.Track" %>
    
    	
	<div class="container-fluid">
	    <div class="row-fluid">
            
            <div class="span8">
                <h3 align="center">    
                    <spring:message code="home.lastuploaded" text="Last Uploaded" />                    
                </h3>              
                                
                <div class="accordion" id="accordion">
					
				    <c:forEach items="${trackList }" var="track">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapse${track.getIdTrack() }">
								   ${track.getArtist().getName() } - ${track.getTitle() }
								</a>
							</div>
							<div id="collapse${track.getIdTrack() }" class="accordion-body collapse">
								    <table class="table">
								        <%@ include file="endOfTable.jsp" %>
								    </table>
								<div class="container-fluid">
                                    <div class="row-fluid">		
									    <div class="span6">	  
										    <h6><spring:message code="track.uploader" text="Uploader" />: <a href="user/${track.getUser().getIdUser() }">${track.getUser().getUsername() }</a></h6>																    
										</div>
										<div class="span6">       
										    <h6><spring:message code="track.date" text="Date" />: ${dateFormatTransformer.format(track.getTime()) }</h6>
										</div>
                                    </div>
                                    <div class="row-fluid">     
                                        <div class="span12"> 
                                            
                                                <c:forEach items="${track.getTags() }" var="tag">
                                                    <a href="tag/${tag.getIdTag() }/1"><span class="label label-success">${tag.getTagname() }</span></a> 
                                                </c:forEach>
                                             
                                        </div>
                                    </div> 
                                </div>										
							</div>
						</div>
					</c:forEach>
										
				</div> 				                                                                         
            </div>
            
            
            <div class="span4">
                <h3 align="center">    
                    <spring:message code="home.populartags" text="Popular Tags" />
                </h3>
                <div class="tags">				
				    <ul>
		                <c:forEach items="${tagList }" var="tag">
                            <li class="tag${tag.getPopularity() }"><a href="tag/${tag.getIdTag() }/1">${tag.getTagname() }</a></li>		                
		                </c:forEach> 		                
	                </ul>
	            </div>	          	
                <sec:authorize access="hasRole('ROLE_ADMIN')">                    
                    <a class="btn btn-warning btn-block" href="home/updateCloud"><spring:message code="home.updateCloud" text="Update cloud" /></a>
                </sec:authorize>
            </div>
        </div>
    </div>
    
   