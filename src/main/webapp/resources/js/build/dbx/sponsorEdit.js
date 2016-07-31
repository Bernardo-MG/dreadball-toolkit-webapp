/**
 * Licensed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
/**
 * Scripts for DBX team edition.
 * 
 * Mostly it takes care of AJAX calls.
 */

$(document).ready(function() {
	$(document).on("change", "input:radio", function() {
		refreshRank();
	});
});

function refreshRank() {
	var selected = $('input:checked');
	var rankInput = $('#initialRank');
	var rankBonus;

	rankBonus = 0;

	$.each(selected, function(index, value) {
		if ($(value).hasClass('increaseRank')) {
			rankBonus++;
		}
	});

	rankInput.val(5 + rankBonus);
}
