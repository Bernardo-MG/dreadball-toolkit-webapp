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

INSERT INTO ABILITIES (id, name) VALUES
   (1, 'ability_1'),
   (2, 'ability_2'),
   (3, 'ability_3'),
   (4, 'ability_4'),
   (5, 'ability_5');

-- ****************************************
--               AFFINITIES
-- ****************************************

INSERT INTO AFFINITY_GROUPS (id, name) VALUES
   (1, 'affinity_1'),
   (2, 'affinity_2'),
   (3, 'affinity_3'),
   (4, 'affinity_4'),
   (5, 'affinity_5'),
   (6, 'affinity_6');

-- ****************************************
--                PLAYERS
-- ****************************************


-- -----------
-- DBX players
-- -----------

-- Test team 1
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant, mvp) VALUES
   (1, 'affinity', 'player_A', 'player_A_affinity', 4, 5, 4, 3, 4, 'GUARD', false, false),
   (2, 'affinity', 'player_C', 'player_C_affinity', 5, 5, 4, 3, 4, 'JACK', false, false),
   (3, 'affinity', 'player_B', 'player_B_affinity', 5, 5, 4, 3, 4, 'STRIKER', false, false),

-- Giants
   (51, 'affinity', 'giant', 'player_giant_affinity', 5, 5, 4, 3, 4, 'JACK', true, false);

-- ----------------
-- Affinity players
-- ----------------

-- Test team 1
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES
   (1, 23, 15, 10),
   (2, 18, 12, 8),
   (3, 23, 15, 10),

-- Giants
   (51, 45, 30, 20);

-- ----------------
-- Player abilities
-- ----------------

-- Test team 1
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES
   (1, 1),
   (2, 1),
   (3, 1),

-- Giant
   (51, 2),
   (51, 3),
   (51, 4);

-- -----------------
-- Player affinities
-- -----------------

-- Test team 1
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES
   (1, 1),
   (2, 1),
   (3, 1),

-- Giant
   (51, 2),
   (51, 3),
   (51, 4);

-- -----------------------
-- Player hated affinities
-- -----------------------

-- Giant
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES
   (51, 5);

-- -------------------------
-- Affinities availabilities
-- -------------------------

-- Sponsor affinities groups
INSERT INTO AFFINITY_SETS(id, name, rank_increase) VALUES
   (1, 'A', true),
   (2, 'B', true),
   (3, 'C', false),
   (4, 'D', true),
   (5, 'E', false);

-- Group A affinities
INSERT INTO AFFINITY_OPTIONS(affinity_set_id, affinity_id) VALUES
   (1, 1),
   (1, 2),
   (1, 3),
   (1, 4),
   (1, 5),

-- Group B affinities
   (2, 1),
   (2, 2),
   (2, 3),
   (2, 4),
   (2, 5),

-- Group C affinities
   (3, 1),
   (3, 2),
   (3, 3),
   (3, 4),
   (3, 5),
   (5, 6),

-- Group D affinities
   (4, 1),
   (4, 2),
   (4, 3),
   (4, 4),
   (4, 5),

-- Group E affinities
   (5, 1),
   (5, 2),
   (5, 3),
   (5, 4),
   (5, 5),
   (5, 6);
