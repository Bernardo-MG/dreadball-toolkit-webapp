--
--  Copyright 2015 the original author or authors
--
--  Licensed under the Apache License, Version 2.0 (the "License"); you may not
--  use this file except in compliance with the License. You may obtain a copy of
--  the License at
--
--  http://www.apache.org/licenses/LICENSE-2.0
--
--  Unless required by applicable law or agreed to in writing, software
--  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
--  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
--  License for the specific language governing permissions and limitations under
--  the License.
--


-- ****************************************
-- This SQL script creates the tables to hold the data for the Dreadball Original entities.
-- ****************************************


-- ****************************************
--                DROPS
-- ****************************************


-- Aggregation tables

DROP TABLE IF EXISTS team_type_rules;
DROP TABLE IF EXISTS composite_player_components;


-- Availabilities tables

DROP TABLE IF EXISTS team_type_player_avas;
DROP TABLE IF EXISTS team_type_asset_avas;


-- Team tables

DROP TABLE IF EXISTS team_types;
DROP TABLE IF EXISTS team_rules;


-- player tables

DROP TABLE IF EXISTS simple_players;
DROP TABLE IF EXISTS advancement_players;
DROP TABLE IF EXISTS composite_advancement_players;
