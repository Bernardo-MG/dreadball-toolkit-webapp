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
--                CREATION
-- ****************************************


-- Unit tables

CREATE TABLE affinity_groups (
    id                      INTEGER PRIMARY KEY,
    name                    VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE affinity_player_components (
    id                      INTEGER PRIMARY KEY,
    name                    VARCHAR(30) NOT NULL UNIQUE,
    location_id             INTEGER NOT NULL DEFAULT 0,
    cost                    INTEGER NOT NULL DEFAULT 0,
    armor                   INTEGER NOT NULL DEFAULT 0,
    movement                INTEGER NOT NULL DEFAULT 0,
    skill                   INTEGER NOT NULL DEFAULT 0,
    speed                   INTEGER NOT NULL DEFAULT 0,
    strength                INTEGER NOT NULL DEFAULT 0,
    cost_ally               INTEGER NOT NULL DEFAULT 0,
    cost_friend             INTEGER NOT NULL DEFAULT 0,
    cost_stranger           INTEGER NOT NULL DEFAULT 0,
    FOREIGN KEY (location_id) REFERENCES component_locations (id) ON DELETE CASCADE
);

CREATE TABLE composite_affinity_players (
    id                      INTEGER PRIMARY KEY,
    template_name           VARCHAR(30) NOT NULL UNIQUE,
    name                    VARCHAR(30) NOT NULL DEFAULT '',
    armor                   INTEGER NOT NULL DEFAULT 0,
    movement                INTEGER NOT NULL DEFAULT 0,
    skill                   INTEGER NOT NULL DEFAULT 0,
    speed                   INTEGER NOT NULL DEFAULT 0,
    strength                INTEGER NOT NULL DEFAULT 0,
    position                VARCHAR(30) NOT NULL DEFAULT 'JACK',
    giant                   BOOLEAN NOT NULL DEFAULT FALSE,
    mvp                     BOOLEAN NOT NULL DEFAULT FALSE,
    cost_ally               INTEGER NOT NULL DEFAULT 0,
    cost_friend             INTEGER NOT NULL DEFAULT 0,
    cost_stranger           INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE affinity_players (
    id                      INTEGER PRIMARY KEY,
    cost_ally               INTEGER NOT NULL DEFAULT 0,
    cost_friend             INTEGER NOT NULL DEFAULT 0,
    cost_stranger           INTEGER NOT NULL DEFAULT 0
);


-- Team tables

CREATE TABLE sponsors (
    id                      INTEGER PRIMARY KEY,
    name                    VARCHAR(30) NOT NULL DEFAULT '',
    cash                    INTEGER NOT NULL DEFAULT 0,
    rank                    INTEGER NOT NULL DEFAULT 0
);


-- Availabilities tables

CREATE TABLE sponsor_asset_avas (
    id                      INTEGER PRIMARY KEY,
    cost_affinity           INTEGER NOT NULL DEFAULT 0,
    cost_cheerleader        INTEGER NOT NULL DEFAULT 0,
    cost_cheerleader_unlock INTEGER NOT NULL DEFAULT 0,
    cost_dice               INTEGER NOT NULL DEFAULT 0,
    cost_medibot            INTEGER NOT NULL DEFAULT 0,
    cost_sabotage           INTEGER NOT NULL DEFAULT 0,
    cost_special_move       INTEGER NOT NULL DEFAULT 0,
    cost_wager              INTEGER NOT NULL DEFAULT 0,
    max_wager               INTEGER NOT NULL DEFAULT 0,
    min_team_cost           INTEGER NOT NULL DEFAULT 0
);

CREATE TABLE sponsor_affinity_avas (
    id                      INTEGER PRIMARY KEY,
    name                    VARCHAR(30) NOT NULL DEFAULT '',
    rank_increase           BOOLEAN NOT NULL DEFAULT FALSE
);


-- Aggregation tables

CREATE TABLE player_affinities (
    player_id               INTEGER,
    affinity_id             INTEGER,
    FOREIGN KEY (affinity_id) REFERENCES affinity_groups (id) ON DELETE CASCADE,
    FOREIGN KEY (player_id) REFERENCES affinity_players (id) ON DELETE CASCADE
);

CREATE TABLE player_hated_affinities (
    player_id               INTEGER,
    affinity_id             INTEGER,
    FOREIGN KEY (affinity_id) REFERENCES affinity_groups (id) ON DELETE CASCADE,
    FOREIGN KEY (player_id) REFERENCES affinity_players (id) ON DELETE CASCADE
);

CREATE TABLE sponsor_affinity_groups (
    sponsor_id              INTEGER,
    group_id                INTEGER,
    FOREIGN KEY (sponsor_id) REFERENCES sponsors (id) ON DELETE CASCADE,
    FOREIGN KEY (group_id) REFERENCES affinity_groups (id) ON DELETE CASCADE
);

CREATE TABLE sponsor_affinity_avas_affinity_groups (
    sponsor_affinity_ava_id    INTEGER,
    affinity_id                INTEGER,
    FOREIGN KEY (sponsor_affinity_ava_id) REFERENCES sponsor_affinity_avas (id) ON DELETE CASCADE,
    FOREIGN KEY (affinity_id) REFERENCES affinity_groups (id) ON DELETE CASCADE
);
