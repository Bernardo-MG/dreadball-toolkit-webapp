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
});

function addPlayerFromTable(row) {
	var table = $("#availableUnits").DataTable();
	var template = table.row(row).data()[0];

	addPlayer(template);
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

function loadTeamUnits(players){
	var table = $("#teamUnits");
	var tbody = table.children('tbody');
	var row;
	
	tbody.empty();
	
	$.each(players, function( k, v ) {
			row = "<tr>" 
				+ "<td><i class=\"fa fa-trash table-action\" aria-hidden=\"true\"></i></td>"
				+ "<td>" + k + "</td>"
				+ "<td>" + players[1].template_name + "</td>"
				+ "<td></td>"
				+ "<td></td>"
				+ "<td></td>"
				+ "<td></td>"
				+ "<td></td>"
				+ "<td></td>"
				+ "<td></td>"
				+ "<td></td>"
				+ "<td></td>"
				+ "</tr>";
			
			tbody.last().append(row);
		});
}
