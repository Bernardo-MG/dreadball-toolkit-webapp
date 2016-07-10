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
		addPlayerFromTable();
	});
});

function addPlayerFromTable() {
	addPlayer("template");
}

function addPlayer(template) {
	var ajaxUrl = $(location).attr('href') + "/players";

	$.ajax({
		url : ajaxUrl,
		type: 'PUT',
		data : {
			templateName : template
		},
		success : function(data) {
			alert('Data sent');
		},
		error : function() {
			alert('An error occurred');
		}
	});
}
