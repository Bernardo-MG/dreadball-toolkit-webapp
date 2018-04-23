--
--  Copyright 2015 the original author or authors
--
--  Licensed under the Apache License, Version 2.0 (the "License"), you may not
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
-- This SQL script populates the tables with the latest Dreadball data.
--
-- It includes only data that is common for both the original and Xtreme
-- versions.
-- ****************************************

-- ****************************************
-- A note aboud ids.
--
-- For the units, the following id ranges have been used:
-- DBO players: 0 to 99
-- DBX players: 100 to 199
-- DBO MVPs and giants: 200 to 299
-- DBX MVPs, giants and free agents: 300 to 399
-- ****************************************


-- ****************************************
--                ABILITIES
-- ****************************************

INSERT INTO ABILITIES (id, name) VALUES
   (1, 'vision_360'),
   (2, 'adaptable'),
   (3, 'a_safe_pair_of_hands'),
   (4, 'alert'),
   (5, 'backflip'),
   (6, 'backstab'),
   (7, 'blood_money'),
   (8, 'cant_feel_a_thing'),
   (9, 'charge'),
   (10, 'comin_through'),
   (11, 'crowd_puller'),
   (12, 'dirty_tricks'),
   (13, 'does_this_hurt'),
   (14, 'driller'),
   (16, 'duck_and_weave'),
   (17, 'even_the_odds'),
   (18, 'explosive_collar'),
   (19, 'fan_favourite'),
   (20, 'fragile'),
   (21, 'gotcha'),
   (22, 'grizzled'),
   (23, 'harmonics'),
   (24, 'heal'),
   (25, 'illegal'),
   (26, 'illegal_modifications'),
   (27, 'it_wasnt_me'),
   (28, 'jump'),
   (29, 'keeper'),
   (30, 'klutz'),
   (31, 'long_arms'),
   (32, 'lucky'),
   (33, 'mighty'),
   (34, 'mind_control'),
   (35, 'mind_like_water'),
   (36, 'misdirect'),
   (37, 'mutant_native'),
   (38, 'nemesis'),
   (39, 'one_mind'),
   (40, 'pacifist'),
   (41, 'phaser'),
   (42, 'pile_driver'),
   (43, 'poison_blade'),
   (44, 'portal'),
   (45, 'portal_master'),
   (46, 'prima_donna'),
   (47, 'pummel'),
   (48, 'push'),
   (49, 'quick_change_artist'),
   (50, 'quick_recovery'),
   (51, 'ram'),
   (52, 'ray_gun'),
   (53, 'really_lucky'),
   (54, 'resilient'),
   (55, 'resources'),
   (56, 'roll'),
   (57, 'rolling'),
   (58, 'rule_of_law'),
   (59, 'runaround'),
   (60, 'running_interference'),
   (61, 'shock_collar'),
   (62, 'shove'),
   (63, 'show_off'),
   (64, 'slide'),
   (65, 'slippery_customer'),
   (66, 'snack'),
   (67, 'spinner'),
   (68, 'steady'),
   (69, 'stench'),
   (70, 'stretch'),
   (71, 'stubborn'),
   (72, 'tail'),
   (73, 'taking_a_dive'),
   (74, 'teleport'),
   (75, 'threatening'),
   (76, 'tongue'),
   (77, 'toxic_immunity'),
   (78, 'trail_blazer'),
   (79, 'toxic'),
   (80, 'uncontrolled'),
   (81, 'vigour');
