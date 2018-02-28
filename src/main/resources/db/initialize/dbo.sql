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
--                CREATION
-- ****************************************


-- Unit tables

CREATE TABLE composite_advancement_players (
    id                      INTEGER PRIMARY KEY,
    template_name           VARCHAR(30) NOT NULL DEFAULT '',
    name                    VARCHAR(30) NOT NULL DEFAULT '',
    cost                    INTEGER NOT NULL DEFAULT 0,
    armor                   INTEGER NOT NULL DEFAULT 0,
    movement                INTEGER NOT NULL DEFAULT 0,
    skill                   INTEGER NOT NULL DEFAULT 0,
    speed                   INTEGER NOT NULL DEFAULT 0,
    strength                INTEGER NOT NULL DEFAULT 0,
    position                VARCHAR(30) NOT NULL DEFAULT 'JACK',
    giant                   BOOLEAN NOT NULL DEFAULT FALSE,
    mvp                     BOOLEAN NOT NULL DEFAULT FALSE,
    experience              INTEGER NOT NULL DEFAULT 0,
    rank                    INTEGER NOT NULL DEFAULT 0,
    grafted_implant_id      INTEGER,
    FOREIGN KEY (grafted_implant_id) REFERENCES player_components (id) ON DELETE CASCADE
);

CREATE TABLE advancement_players (
    id                      INTEGER PRIMARY KEY,
    template_name           VARCHAR(30) NOT NULL DEFAULT '',
    name                    VARCHAR(30) NOT NULL DEFAULT '',
    cost                    INTEGER NOT NULL DEFAULT 0,
    armor                   INTEGER NOT NULL DEFAULT 0,
    movement                INTEGER NOT NULL DEFAULT 0,
    skill                   INTEGER NOT NULL DEFAULT 0,
    speed                   INTEGER NOT NULL DEFAULT 0,
    strength                INTEGER NOT NULL DEFAULT 0,
    position                VARCHAR(30) NOT NULL DEFAULT 'JACK',
    giant                   BOOLEAN NOT NULL DEFAULT FALSE,
    mvp                     BOOLEAN NOT NULL DEFAULT FALSE,
    experience              INTEGER NOT NULL DEFAULT 0,
    rank                    INTEGER NOT NULL DEFAULT 0,
    grafted_implant_id      INTEGER,
    FOREIGN KEY (grafted_implant_id) REFERENCES player_components (id) ON DELETE CASCADE
);

CREATE TABLE simple_players (
    id                      INTEGER PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES players(id)
);


-- Team tables

CREATE TABLE team_rules (
    id                      INTEGER PRIMARY KEY,
    name                    VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE team_types (
    id                      INTEGER PRIMARY KEY,
    name                    VARCHAR(30) NOT NULL UNIQUE
);


-- Availabilities tables

CREATE TABLE team_type_asset_avas (
    id                      INTEGER PRIMARY KEY,
    team_type_id            INTEGER NOT NULL DEFAULT 0,
    cost_card               INTEGER NOT NULL DEFAULT 0,
    cost_cheerleader        INTEGER NOT NULL DEFAULT 0,
    cost_coaching           INTEGER NOT NULL DEFAULT 0,
    cost_dice               INTEGER NOT NULL DEFAULT 0,
    initial_card            INTEGER NOT NULL DEFAULT 0,
    initial_cheerleader     INTEGER NOT NULL DEFAULT 0,
    initial_dice            INTEGER NOT NULL DEFAULT 0,
    max_card                INTEGER NOT NULL DEFAULT 0,
    max_cheerleader         INTEGER NOT NULL DEFAULT 0,
    max_dice                INTEGER NOT NULL DEFAULT 0,
    def_coach               BOOLEAN NOT NULL DEFAULT FALSE,
    off_coach               BOOLEAN NOT NULL DEFAULT FALSE,
    sup_coach               BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (team_type_id) REFERENCES team_types (id) ON DELETE CASCADE
);

CREATE TABLE team_type_player_avas (
    id                      INTEGER PRIMARY KEY,
    team_type_id            INTEGER,
    player_id               INTEGER,
    initial                 INTEGER NOT NULL DEFAULT 0,
    max                     INTEGER NOT NULL DEFAULT 0,
    FOREIGN KEY (team_type_id) REFERENCES team_types (id) ON DELETE CASCADE,
    FOREIGN KEY (player_id) REFERENCES players (id) ON DELETE CASCADE
);


-- Aggregation tables

CREATE TABLE team_type_rules (
    team_type_id            INTEGER,
    team_rule_id            INTEGER,
    FOREIGN KEY (team_type_id) REFERENCES team_types (id) ON DELETE CASCADE,
    FOREIGN KEY (team_rule_id) REFERENCES team_rules (id) ON DELETE CASCADE
);

CREATE TABLE composite_player_components (
    player_id               INTEGER,
    component_id            INTEGER,
    FOREIGN KEY (player_id) REFERENCES players (id) ON DELETE CASCADE,
    FOREIGN KEY (component_id) REFERENCES player_components (id) ON DELETE CASCADE
);
