<!DOCTYPE html>

<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html lang="en">

<jsp:include page="fragments/header.jsp" />

<body>
	<header class="header">
		<jsp:include page="fragments/menu.jsp" />
	</header>

	<section id="main-section" class="container-fluid">
		<header class="page-header">
			<h1>Dreadball Webapp Template</h1>
		</header>
		<p>A template demo to prepare an UI for a webapp offering several
			utilities for Dreadball.</p>

		<section id="game_selection">
			<div class="row">
				<h2>Pick a game</h2>
				<div class="btn-group" role="group" aria-label="Choose game">
					<button type="button"
						onclick="location.href = './dbo_team_pick.html';"
						class="btn btn-default" id="dreadball">Dreadball</button>
					<button type="button" class="btn btn-default" id="dreadball_xtreme">Dreadball
						Xtreme</button>
				</div>
			</div>
		</section>
	</section>

	<jsp:include page="fragments/footer.jsp" />
</body>

</html>
