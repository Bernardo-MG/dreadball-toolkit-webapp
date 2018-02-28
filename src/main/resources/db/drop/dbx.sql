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
-- This SQL script creates the tables to hold the data for the Dreadball Xtreme entities.
-- ****************************************


-- ****************************************
--                DROPS
-- ****************************************


-- Aggregation tables

DROP TABLE IF EXISTS player_affinities;
DROP TABLE IF EXISTS player_hated_affinities;
DROP TABLE IF EXISTS sponsor_affinity_groups;
DROP TABLE IF EXISTS sponsor_affinity_avas_affinity_groups;


-- Availabilities tables

DROP TABLE IF EXISTS sponsor_affinity_avas;
DROP TABLE IF EXISTS sponsor_asset_avas;


-- Team tables

DROP TABLE IF EXISTS sponsors;


-- player tables

DROP TABLE IF EXISTS affinity_players;
DROP TABLE IF EXISTS composite_affinity_players;
DROP TABLE IF EXISTS affinity_player_components;
DROP TABLE IF EXISTS affinity_groups;
