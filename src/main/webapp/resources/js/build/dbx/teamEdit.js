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
		type : 'PUT',
		data : {
			templateName : template
		},
		success : function(data) {
		},
		error : function() {
			console.log('An error occurred while adding a unit through AJAX');
		}
	});
}
