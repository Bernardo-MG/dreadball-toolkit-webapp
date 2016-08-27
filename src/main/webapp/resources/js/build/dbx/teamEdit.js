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
		setDice($(this).val());
	});

	$("#sabotageCards").on("change paste keyup", function() {
		setSabotageCards($(this).val());
	});

	$("#moveCards").on("change paste keyup", function() {
		setSpecialMoveCards($(this).val());
	});

	$("#wagers").on("change paste keyup", function() {
		setWagers($(this).val());
	});

	$("#cheerleaders").on("change paste keyup", function() {
		setCheerleaders($(this).val());
	});

	$("#medibots").on("change paste keyup", function() {
		setMediBots($(this).val());
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
		data : {
			templateName : template
		},
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
	var ajaxUrl = $(location).attr('href') + "/players" + "?position=" + pos;

	$
			.ajax({
				url : ajaxUrl,
				type : 'DELETE',
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

function setDice(dice) {
	var ajaxUrl = $(location).attr('href') + "/assets/dice";

	$.ajax({
		url : ajaxUrl,
		type : 'PUT',
		data : {
			dice : dice
		},
		success : function(team) {
			$("#dice").val(team.dice);
			loadTeamAssetCost(team);
		},
		error : function() {
			console.log('An error occurred while setting the dice through AJAX');
		}
	});
}

function setSabotageCards(cards) {
	var ajaxUrl = $(location).attr('href') + "/assets/sabotage";

	$.ajax({
		url : ajaxUrl,
		type : 'PUT',
		data : {
			cards : cards
		},
		success : function(team) {
			$("#sabotageCards").val(team.sabotage_cards);
			loadTeamAssetCost(team);
		},
		error : function() {
			console.log('An error occurred while setting the sabotage cards through AJAX');
		}
	});
}

function setSpecialMoveCards(cards) {
	var ajaxUrl = $(location).attr('href') + "/assets/move";

	$.ajax({
		url : ajaxUrl,
		type : 'PUT',
		data : {
			cards : cards
		},
		success : function(team) {
			$("#moveCards").val(team.special_move_cards);
			loadTeamAssetCost(team);
		},
		error : function() {
			console.log('An error occurred while setting the special move cards through AJAX');
		}
	});
}

function setWagers(wagers) {
	var ajaxUrl = $(location).attr('href') + "/assets/wager";

	$.ajax({
		url : ajaxUrl,
		type : 'PUT',
		data : {
			wagers : wagers
		},
		success : function(team) {
			$("#wagers").val(team.wagers);
			loadTeamAssetCost(team);
		},
		error : function() {
			console.log('An error occurred while setting the wagers through AJAX');
		}
	});
}

function setCheerleaders(cheerleaders) {
	var ajaxUrl = $(location).attr('href') + "/assets/cheerleader";

	$.ajax({
		url : ajaxUrl,
		type : 'PUT',
		data : {
			cheerleaders : cheerleaders
		},
		success : function(team) {
			$("#cheerleaders").val(team.cheerleaders);
			loadTeamAssetCost(team);
		},
		error : function() {
			console.log('An error occurred while setting the cheerleaders through AJAX');
		}
	});
}

function setMediBots(medibots) {
	var ajaxUrl = $(location).attr('href') + "/assets/medibots";

	$.ajax({
		url : ajaxUrl,
		type : 'PUT',
		data : {
			medibots : medibots
		},
		success : function(team) {
			$("#medibots").val(team.medibots);
			loadTeamAssetCost(team);
		},
		error : function() {
			console.log('An error occurred while setting the medibots through AJAX');
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
	$("#spentRank").val(team.rank_cost);
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
