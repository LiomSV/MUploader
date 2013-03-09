<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page contentType="text/html;charset=UTF-8" %>
    <div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="<c:url value="/"/>"><b>MusicUploader</b></a>
			<ul class="nav">
				<sec:authorize  access="isAuthenticated()">                         					                                            
					<li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="">
                          <spring:message code="header.songs" text="Songs" />
                          <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><spring:message code="header.songs.artist" text="Artist" /></a></li>
                            <li><a href="#"><spring:message code="header.songs.rating" text="Raiting" /></a></li>
                            <li><a href="#"><spring:message code="header.songs.views" text="Views" /></a></li>
                        </ul>
                    </li>
					<li><a href=""><spring:message code="header.upload" text="Upload" /></a></li>
					<li><a href="#"><spring:message code="header.search" text="Search" /></a></li>					
				</sec:authorize> 
				<sec:authorize  access="hasRole('ROLE_ADMIN')">
				    <li><a href="#"><spring:message code="header.admin" text="Admin" /></a></li>
				</sec:authorize> 
			</ul>
			<ul class="nav pull-right">
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">
					   <spring:message code="header.settings" text="Settings" />
					   <b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a  href="?lang=en"><spring:message code="header.settings.en" /></a></li>
						<li><a href="?lang=ru"><spring:message code="header.settings.ru" /></a></li>
						<li class="divider" />
						<li><a href="?theme=light"><spring:message code="header.settings.light" /></a></li>
						<li><a href="?theme=dark"><spring:message code="header.settings.dark" /></a></li>                            
					</ul>
				</li>
				<sec:authorize  access="isAuthenticated()">                        
					<li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="">
                          <sec:authentication property="principal.username" />
                          <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><spring:message code="header.user.profile" text="Profile" /></a></li>
                            <li><a href="#"><spring:message code="header.user.myplaylists" text="My playlist" /></a></li>
                            <li class="divider" />
                            <li><a href="<c:url value="j_spring_security_logout" />" >
                                <spring:message code="header.user.logout" text="Logout" />
                            </a></li>
                        </ul>
                    </li>							
				</sec:authorize>
			</ul>
		</div>
    </div>     