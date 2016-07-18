/**
 * Licensed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
/**
 * Scripts for DBX team edition.
 * 
 * Mostly it takes care of AJAX calls.
 */

$(document).ready(function() {
	$(".addPlayer").click(function(event) {
		var row = $(this).parent().parent();
		addPlayerFromTable(row.index());
	});

	$(document).on("click", ".removePlayer", function() {
		var row = $(this).parent().parent();
		removePlayerFromTable(row);
	});
});

function addPlayerFromTable(row) {
	var table = $("#availableUnits").DataTable();
	var template = table.row(row).data()[0];

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
		success : function(result) {
			loadTeamUnits(result);
		},
		error : function() {
			console.log('An error occurred while adding a unit through AJAX');
		}
	});
}

function removePlayer(pos) {
	var ajaxUrl = $(location).attr('href') + "/players" + "?position=" + pos ;

	$.ajax({
		url : ajaxUrl,
		type : 'DELETE',
		success : function(result) {
			loadTeamUnits(result);
		},
		error : function() {
			console.log('An error occurred while removing a unit through AJAX');
		}
	});
}

function loadTeamUnits(players){
	var table = $("#teamUnits");
	var tbody = table.children('tbody');
	var row;
	
	tbody.empty();
	
	$.each(players, function( position, unit ) {
			var abilities = "";
			
			jQuery.each(unit.abilities, function(index, ability) {
			    if(index > 0){
			    	abilities += ", ";
			    }
			    
			    abilities += ability.name;
			});
			
			row = "<tr>" 
				+ "<td><i class=\"fa fa-trash table-action removePlayer\" aria-hidden=\"true\"></i></td>"
				+ "<td>" + position + "</td>"
				+ "<td>" + unit.template_name + "</td>"
				+ "<td>" + unit.template_name + "</td>"
				+ "<td>" + unit.role + "</td>"
				+ "<td>" + unit.attributes.movement + "</td>"
				+ "<td>" + unit.attributes.speed + "</td>"
				+ "<td>" + unit.attributes.strength + "</td>"
				+ "<td>" + unit.attributes.skill + "</td>"
				+ "<td>" + unit.attributes.armor + "</td>"
				+ "<td>" + abilities + "</td>"
				+ "<td>" + unit.cost + "</td>"
				+ "</tr>";
			
			tbody.last().append(row);
		});
}
