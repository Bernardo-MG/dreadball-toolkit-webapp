/**
 * Licensed under the MIT License
 * (http://www.opensource.org/licenses/mit-license.php)
 */
/**
 * Scripts for DBX team edition. Mostly it takes care of AJAX calls.
 */

function onAddPlayerSuccess(team) {
   loadTeamUnits(team.players);
   $("#teamValue").val(team.valoration);
}

function onAddPlayerError() {
   console.log('An error occurred while adding a unit through AJAX');
}

function addPlayer(template) {
   var ajaxUrl = $(location).attr('href') + "/players";
   var sentData;

   sentData = JSON.stringify({
      templateName : template
   });

   $.ajax({
      url : ajaxUrl,
      type : 'POST',
      dataType : 'json',
      contentType : 'application/json;',
      processData : false,
      data : sentData,
      success : onAddPlayerSuccess,
      error : onAddPlayerError
   });
}

function onRemovePlayerSuccess(team) {
   loadTeamUnits(team.players);
   $("#teamValue").val(team.valoration);
}

function onRemovePlayerError() {
   console.log('An error occurred while removing a unit through AJAX');
}

function removePlayer(pos) {
   var ajaxUrl = $(location).attr('href') + "/players";
   var sentData;

   sentData = JSON.stringify({
      position : pos
   });

   $.ajax({
      url : ajaxUrl,
      type : 'DELETE',
      dataType : 'json',
      contentType : 'application/json;',
      processData : false,
      data : sentData,
      success : onRemovePlayerSuccess,
      error : onRemovePlayerError
   });
}

function onSetAssetsSuccess(team) {
   $("#dice").val(team.coachingDice);
   $("#sabotageCards").val(team.sabotageCards);
   $("#moveCards").val(team.specialMoveCards);
   $("#wagers").val(team.wagers);
   $("#cheerleaders").val(team.cheerleaders);
   $("#medibots").val(team.mediBots);
   loadTeamAssetCost(team);
}

function onSetAssetsError() {
   console
         .log('An error occurred while setting the sabotage cards through AJAX');
}

function setAssets(coachingDice, sabotageCards, specialMoveCards, wagers,
      cheerleaders, mediBots) {
   var ajaxUrl = $(location).attr('href') + "/assets";
   var sentData;

   sentData = JSON.stringify({
      coachingDice : coachingDice,
      sabotageCards : sabotageCards,
      specialMoveCards : specialMoveCards,
      wagers : wagers,
      cheerleaders : cheerleaders,
      mediBots : mediBots
   });

   $.ajax({
      url : ajaxUrl,
      type : 'PUT',
      dataType : 'json',
      contentType : 'application/json;',
      processData : false,
      data : sentData,
      success : onSetAssetsSuccess,
      error : onSetAssetsError
   });
}
