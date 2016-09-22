/**
 * Licensed under the MIT License (http://www.opensource.org/licenses/mit-license.php)
 */
/**
 * Scripts for DBX team edition.
 * 
 * Mostly it takes care of AJAX calls.
 */

function countRank(rankClass, selected) {
	var rank;
	
	rank = 0;
	$.each(selected, function(index, value) {
		if ($(value).hasClass(rankClass)) {
			rank++;
		}
	});
	
	return rank;
}

function refreshRank() {
	var rankInput;
	var selected;
	var rankCount;
	var baseRank;

	// Gets the selected inputs
	selected = $('input:checked');
	
	rankCount = countRank('increaseRank', selected);

	// Gets the initial rank field
	rankInput = $('#initialRank');
	
	baseRank = 5;
	rankInput.val(baseRank + rankCount);
}

$(document).ready(function() {
	$(document).on("change", "input:radio", refreshRank);
});
