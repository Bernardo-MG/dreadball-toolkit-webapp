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
-- This SQL script populates the tables with test data.
-- ****************************************


-- ****************************************
--                ABILITIES
-- ****************************************

DELETE FROM ABILITIES;

INSERT INTO ABILITIES (id, name) VALUES (1, 'ability_1');
INSERT INTO ABILITIES (id, name) VALUES (2, 'ability_2');
INSERT INTO ABILITIES (id, name) VALUES (3, 'ability_3');
INSERT INTO ABILITIES (id, name) VALUES (4, 'ability_4');
INSERT INTO ABILITIES (id, name) VALUES (5, 'ability_5');

-- ****************************************
--               AFFINITIES
-- ****************************************

DELETE FROM AFFINITY_GROUPS;

INSERT INTO AFFINITY_GROUPS (id, name) VALUES (1, 'affinity_1');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (2, 'affinity_2');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (3, 'affinity_3');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (4, 'affinity_4');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (5, 'affinity_5');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (6, 'affinity_6');

-- ****************************************
--                PLAYERS
-- ****************************************


-- -----------
-- DBX players
-- -----------

DELETE FROM PLAYERS;

-- Test team 1
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (1, 'affinity', 'player_1', 'player_1_affinity', 4, 5, 4, 3, 4, 'GUARD', false);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (2, 'affinity', 'player_2', 'player_2_affinity', 5, 5, 4, 3, 4, 'JACK', false);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (3, 'affinity', 'player_3', 'player_3_affinity', 5, 5, 4, 3, 4, 'STRIKER', false);

-- Giants
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (51, 'affinity', 'giant_1', 'giant_1_affinity', 5, 5, 4, 3, 4, 'JACK', true);

-- ----------------
-- Affinity players
-- ----------------

DELETE FROM AFFINITY_PLAYERS;

-- Test team 1
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (1, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (2, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (3, 23, 15, 10);

-- Giants
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (51, 45, 30, 20);

-- ----------------
-- Player abilities
-- ----------------

DELETE FROM PLAYER_ABILITIES;

-- Test team 1
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (1, 1);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (2, 1);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (3, 1);

-- Giant
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (51, 2);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (51, 3);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (51, 4);

-- -----------------
-- Player affinities
-- -----------------

DELETE FROM PLAYER_AFFINITIES;

-- Test team 1
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (1, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (2, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (3, 1);

-- Giant
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (51, 2);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (51, 3);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (51, 4);

-- -----------------------
-- Player hated affinities
-- -----------------------

DELETE FROM PLAYER_HATED_AFFINITIES;

-- Giant
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (51, 5);

-- -------------------------
-- Affinities availabilities
-- -------------------------

DELETE FROM AFFINITY_SETS;
DELETE FROM AFFINITY_OPTIONS;

-- Sponsor affinities groups
INSERT INTO AFFINITY_SETS(id, name, rank_increase) VALUES (1, 'A', true);
INSERT INTO AFFINITY_SETS(id, name, rank_increase) VALUES (2, 'B', true);
INSERT INTO AFFINITY_SETS(id, name, rank_increase) VALUES (3, 'C', false);
INSERT INTO AFFINITY_SETS(id, name, rank_increase) VALUES (4, 'D', true);
INSERT INTO AFFINITY_SETS(id, name, rank_increase) VALUES (5, 'E', false);

-- Group A affinities
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (1, 1);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (1, 2);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (1, 3);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (1, 4);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (1, 5);

-- Group B affinities
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (2, 1);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (2, 2);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (2, 3);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (2, 4);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (2, 5);

-- Group C affinities
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (3, 1);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (3, 2);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (3, 3);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (3, 4);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (3, 5);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (5, 6);

-- Group D affinities
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (4, 1);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (4, 2);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (4, 3);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (4, 4);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (4, 5);

-- Group E affinities
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (5, 1);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (5, 2);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (5, 3);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (5, 4);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (5, 5);
INSERT INTO AFFINITY_OPTIONS(sponsor_affinity_ava_id, affinity_id) VALUES (5, 6);
