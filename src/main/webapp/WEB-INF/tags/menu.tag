<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1"%>

<spring:url value="/" var="homeUrl"/>
    
<nav id="navbar-main" class="navbar navbar-main navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar-main-body"
				aria-expanded="false" aria-controls="navbar-main">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${ homeUrl }">Dreadball Webapp Template Demo</a>
		</div>

		<div id="navbar-main-body"
			class="navbar-body navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="./dbo_team_pick.html">Dreadball</a></li>
				<li><a href="#">Dreadball Xtreme</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Codex <span
						class="chevron_toggleable fa fa-chevron-up" aria-hidden="true"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="./players_list.html">Players</a></li>
						<li><a href="./mvp_list.html">MVPs</a></li>
						<li><a href="#">Teams</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>