/**
 * Licensed under the MIT License
 * (http://www.opensource.org/licenses/mit-license.php)
 */
/**
 * Scripts for DBX team edition. Mostly it takes care of AJAX calls.
 */

function addUnitToTable(position, unit) {
   var tbody = $("#teamUnits").children('tbody');
   var abilities = "";
   var abilityName;
   var abilityDesc;

   jQuery
         .each(
               unit.abilities,
               function(index, ability) {
                  if (index > 0) {
                     abilities += ", ";
                  }

                  abilityName = ability.name_i18n;
                  abilityDesc = ability.description_i18n;

                  abilities += "<span class=\"tooltip-text\" data-toggle=\"tooltip\" data-placement=\"top\"";
                  abilities += "title=\"" + abilityDesc + "\"";
                  abilities += ">" + abilityName + "</span>";
               });

   row = "<tr>";
   row += "<td><i class=\"fa fa-trash table-action removePlayer\" aria-hidden=\"true\"></i></td>";
   row += "<td>";
   row += position;
   row += "</td>";
   row += "<td>";
   row += unit.name;
   row += "</td>";
   row += "<td>";
   row += unit.template_name_i18n;
   row += "</td>";
   row += "<td>";
   row += unit.role_i18n;
   row += "</td>";
   row += "<td>";
   row += unit.attributes.movement;
   row += "</td>";
   row += "<td>";
   row += unit.attributes.speed;
   row += "</td>";
   row += "<td>";
   row += unit.attributes.strength;
   row += "</td>";
   row += "<td>";
   row += unit.attributes.skill;
   row += "</td>";
   row += "<td>";
   row += unit.attributes.armor;
   row += "</td>";
   row += "<td>";
   row += abilities;
   row += "</td>";
   row += "<td>";
   row += unit.cost;
   row += "</td>" + "</tr>";

   tbody.last().append(row);
}

function loadTeamUnits(units) {
   var table = $("#teamUnits");
   var tbody = table.children('tbody');
   var row;

   tbody.empty();

   $.each(units, addUnitToTable);
}

function loadTeamAssetCost(team) {
   $("#spentRank").val(team.rankCost);
   $("#teamValue").val(team.valoration);
}

function addPlayerFromTable(row) {
   var table = $("#availableUnits").DataTable();
   var info = table.page.info();
   var page = info.page;
   var pageSize = info.length;
   var index = (page * pageSize) + row;
   var template = table.row(index).data()[0];

   // Sends the data to the backend
   addPlayer(template);
}

function removePlayerFromTable(row) {
   var table = $("#teamUnits");
   var position = row.find("td").eq(1).html();

   // Sends the data to the backend
   removePlayer(position);
}

function onClickAddPlayer() {
   var row = $(this).parent().parent();
   addPlayerFromTable(row.index());
}

function onClickRemovePlayer() {
   var row = $(this).parent().parent();
   removePlayerFromTable(row);
}

function onChangeAssets() {
   var dice;
   var sabotage;
   var move;
   var wagers;
   var cheerleaders;
   var medibots;

   dice = $("#dice").val();
   sabotage = $("#sabotageCards").val();
   move = $("#moveCards").val();
   wagers = $("#wagers").val();
   cheerleaders = $("#cheerleaders").val();
   medibots = $("#medibots").val();

   setAssets(dice, sabotage, move, wagers, cheerleaders, medibots);
}

$(document).ready(function() {
   // Player addition/removal handlers
   $(document).on("click", ".addPlayer", onClickAddPlayer);
   $(document).on("click", ".removePlayer", onClickRemovePlayer);

   // Assets change handlers
   $("#dice").on("change paste keyup", onChangeAssets);
   $("#sabotageCards").on("change paste keyup", onChangeAssets);
   $("#moveCards").on("change paste keyup", onChangeAssets);
   $("#wagers").on("change paste keyup", onChangeAssets);
   $("#cheerleaders").on("change paste keyup", onChangeAssets);
   $("#medibots").on("change paste keyup", onChangeAssets);
});
