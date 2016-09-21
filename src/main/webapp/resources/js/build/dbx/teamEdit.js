/**
 * Licensed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
/**
 * Scripts for DBX team edition.
 * 
 * Mostly it takes care of AJAX calls.
 */

$(document).ready(function() {
	$(document).on("click", ".addPlayer", function() {
		var row = $(this).parent().parent();
		addPlayerFromTable(row.index());
	});

	$(document).on("click", ".removePlayer", function() {
		var row = $(this).parent().parent();
		removePlayerFromTable(row);
	});

	$("#dice").on("change paste keyup", function() {
		setAssets($("#dice").val(),
				$("#sabotageCards").val(),
				$("#moveCards").val(),
				$("#wagers").val(),
				$("#cheerleaders").val(),
				$("#medibots").val());
	});

	$("#sabotageCards").on("change paste keyup", function() {
		setAssets($("#dice").val(),
				$("#sabotageCards").val(),
				$("#moveCards").val(),
				$("#wagers").val(),
				$("#cheerleaders").val(),
				$("#medibots").val());
	});

	$("#moveCards").on("change paste keyup", function() {
		setAssets($("#dice").val(),
				$("#sabotageCards").val(),
				$("#moveCards").val(),
				$("#wagers").val(),
				$("#cheerleaders").val(),
				$("#medibots").val());
	});

	$("#wagers").on("change paste keyup", function() {
		setAssets($("#dice").val(),
				$("#sabotageCards").val(),
				$("#moveCards").val(),
				$("#wagers").val(),
				$("#cheerleaders").val(),
				$("#medibots").val());
	});

	$("#cheerleaders").on("change paste keyup", function() {
		setAssets($("#dice").val(),
				$("#sabotageCards").val(),
				$("#moveCards").val(),
				$("#wagers").val(),
				$("#cheerleaders").val(),
				$("#medibots").val());
	});

	$("#medibots").on("change paste keyup", function() {
		setAssets($("#dice").val(),
				$("#sabotageCards").val(),
				$("#moveCards").val(),
				$("#wagers").val(),
				$("#cheerleaders").val(),
				$("#medibots").val());
	});
});

function addPlayerFromTable(row) {
	var table = $("#availableUnits").DataTable();
	var info = table.page.info();
	var page = info.page;
	var pageSize = info.length;
	var index = (page * pageSize) + row;
	var template = table.row(index).data()[0];

	addPlayer(template);
}

function removePlayerFromTable(row) {
	var table = $("#teamUnits");
	var position = row.find("td").eq(1).html();

	removePlayer(position);
}

function addPlayer(template) {
	var ajaxUrl = $(location).attr('href') + "/players";

	$.ajax({
		url : ajaxUrl,
		type : 'POST',
		dataType: 'json',
		contentType: 'application/json;',
		processData:false,
		data : JSON.stringify({
			templateName : template
		}),
		success : function(team) {
			loadTeamUnits(team.players);
			$("#teamValue").val(team.valoration);
		},
		error : function() {
			console.log('An error occurred while adding a unit through AJAX');
		}
	});
}

function removePlayer(pos) {
	var ajaxUrl = $(location).attr('href') + "/players";

	$.ajax({
		url : ajaxUrl,
		type : 'DELETE',
		dataType: 'json',
		contentType: 'application/json;',
		processData:false,
		data : JSON.stringify({
			position : pos
		}),
		success : function(team) {
			loadTeamUnits(team.players);
			$("#teamValue").val(team.valoration);
		},
		error : function() {
			console
					.log('An error occurred while removing a unit through AJAX');
		}
	});
}

function setAssets(coachingDice, sabotageCards, specialMoveCards, wagers, cheerleaders, mediBots) {
	var ajaxUrl = $(location).attr('href') + "/assets";

	$.ajax({
		url : ajaxUrl,
		type : 'PUT',
		dataType: 'json',
		contentType: 'application/json;',
		processData:false,
		data : JSON.stringify({
			coachingDice : coachingDice,
			sabotageCards : sabotageCards,
			specialMoveCards : specialMoveCards,
			wagers : wagers,
			cheerleaders : cheerleaders,
			mediBots : mediBots
		}),
		success : function(team) {
			$("#dice").val(team.coachingDice);
			$("#sabotageCards").val(team.sabotageCards);
			$("#moveCards").val(team.specialMoveCards);
			$("#wagers").val(team.wagers);
			$("#cheerleaders").val(team.cheerleaders);
			$("#medibots").val(team.mediBots);
			loadTeamAssetCost(team);
		},
		error : function() {
			console.log('An error occurred while setting the sabotage cards through AJAX');
		}
	});
}

function loadTeamUnits(units) {
	var table = $("#teamUnits");
	var tbody = table.children('tbody');
	var row;

	tbody.empty();

	$.each(units, function(position, unit) {
		addUnitToTable(position, unit);
	});
}

function loadTeamAssetCost(team) {
	$("#spentRank").val(team.rankCost);
	$("#teamValue").val(team.valoration);
}

function addUnitToTable(position, unit) {
	var tbody = $("#teamUnits").children('tbody');
	var abilities = "";
	var abilityName;
	var abilityDesc;

	jQuery.each(unit.abilities, function(index, ability) {
		if (index > 0) {
			abilities += ", ";
		}
		
		abilityName = ability.name_i18n;
		abilityDesc = ability.description_i18n;

		abilities += "<span class=\"tooltip-text\" data-toggle=\"tooltip\" data-placement=\"top\"";
		abilities += "title=\"" + abilityDesc + "\"";
		abilities += ">" + abilityName + "</span>";
	});

	row = "<tr>"
			+ "<td><i class=\"fa fa-trash table-action removePlayer\" aria-hidden=\"true\"></i></td>"
			+ "<td>"
			+ position
			+ "</td>"
			+ "<td>"
			+ unit.name
			+ "</td>"
			+ "<td>"
			+ unit.template_name_i18n
			+ "</td>"
			+ "<td>"
			+ unit.role_i18n
			+ "</td>"
			+ "<td>"
			+ unit.attributes.movement
			+ "</td>"
			+ "<td>"
			+ unit.attributes.speed
			+ "</td>"
			+ "<td>"
			+ unit.attributes.strength
			+ "</td>"
			+ "<td>"
			+ unit.attributes.skill
			+ "</td>"
			+ "<td>"
			+ unit.attributes.armor
			+ "</td>"
			+ "<td>"
			+ abilities
			+ "</td>"
			+ "<td>"
			+ unit.cost
			+ "</td>" + "</tr>";

	tbody.last().append(row);
}
