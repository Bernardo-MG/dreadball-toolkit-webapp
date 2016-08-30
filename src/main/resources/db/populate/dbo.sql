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
-- This SQL script populates the tables with the latest Dreadball data, for both the
-- original and Xtreme versions.
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
--                 UNITS
-- ****************************************

-- ---------
-- DBO units
-- ---------

-- Humans (male)
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (1, 'simple', 'human_male_guard', 'human_male_guard', 10, 4, 5, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (2, 'simple', 'human_male_jack', 'human_male_jack', 8, 4, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (3, 'simple', 'human_male_striker', 'human_male_striker', 10, 5, 5, 4, 4, 4, 'STRIKER', false);

-- Orx/Goblins
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (4, 'simple', 'orx_guard', 'orx_guard', 13, 4, 5, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (5, 'simple', 'goblin_jack', 'goblin_jack', 9, 4, 5, 4, 3, 5, 'STRIKER', false);

-- Veer-Myn
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (6, 'simple', 'veer-myn_guard', 'veer-myn_guard', 12, 4, 6, 5, 3, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (7, 'simple', 'veer-myn_striker', 'veer-myn_striker', 11, 5, 6, 5, 3, 4, 'STRIKER', false);

-- Forge fathers
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (8, 'simple', 'forge_father_guard', 'forge_father_guard', 13, 4, 4, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (9, 'simple', 'forge_father_jack', 'forge_father_jack', 9, 4, 4, 4, 5, 3, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (10, 'simple', 'forge_father_striker', 'forge_father_striker', 9, 5, 4, 4, 5, 3, 'STRIKER', false);

-- Robots
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (11, 'simple', 'robot_guard', 'robot_guard', 0, 4, 5, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (12, 'simple', 'robot_jack', 'robot_jack', 14, 4, 6, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (13, 'simple', 'robot_striker', 'robot_striker', 0, 5, 5, 4, 3, 5, 'STRIKER', false);

-- Z'zor
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (14, 'simple', 'zzor_guard', 'zzor_guard', 17, 4, 5, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (15, 'simple', 'zzor_jack', 'zzor_jack', 9, 4, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (16, 'simple', 'zzor_striker', 'zzor_striker', 11, 5, 6, 5, 4, 4, 'STRIKER', false);

-- Judwan
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (17, 'simple', 'judwan_striker', 'judwan_striker', 15, 5, 6, 5, 4, 4, 'STRIKER', false);

-- Humans (female)
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (18, 'simple', 'human_female_guard', 'human_female_guard', 10, 4, 5, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (19, 'simple', 'human_female_jack', 'human_female_jack', 9, 4, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (20, 'simple', 'human_female_striker', 'human_female_striker', 10, 5, 5, 4, 4, 4, 'STRIKER', false);

-- Asterians
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (21, 'simple', 'asterian_guard', 'asterian_guard', 10, 4, 6, 4, 3, 5, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (22, 'simple', 'asterian_jack', 'asterian_jack', 10, 4, 6, 4, 3, 5, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (23, 'simple', 'asterian_striker', 'asterian_striker', 13, 5, 6, 4, 3, 5, 'STRIKER', false);

-- Nameless
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (24, 'simple', 'nameless_guard_sticky', 'nameless_guard_sticky', 9, 4, 4, 5, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (25, 'simple', 'nameless_guard_hard', 'nameless_guard_hard', 15, 4, 5, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (26, 'simple', 'nameless_striker', 'nameless_striker', 13, 5, 6, 4, 4, 4, 'STRIKER', false);

-- Teratons
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (27, 'simple', 'teraton_guard', 'teraton_guard', 15, 4, 5, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (28, 'simple', 'teraton_jack', 'teraton_jack', 15, 4, 5, 4, 5, 3, 'JACK', false);

-- Zees
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (29, 'simple', 'zee_jack', 'zee_jack', 9, 4, 5, 5, 3, 5, 'JACK', false);

-- Sphyr
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (30, 'simple', 'sphyr_guard', 'sphyr_guard', 12, 4, 6, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (31, 'simple', 'sphyr_jack', 'sphyr_jack', 9, 4, 6, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (32, 'simple', 'sphyr_striker', 'sphyr_striker', 12, 5, 6, 4, 4, 4, 'STRIKER', false);

-- Brokkr
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (33, 'simple', 'brokr_guard', 'brokr_guard', 12, 4, 4, 4, 4, 5, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (34, 'simple', 'brokr_jack', 'brokr_jack', 9, 4, 4, 4, 4, 5, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (35, 'simple', 'brokr_striker', 'brokr_striker', 9, 5, 4, 4, 4, 5, 'STRIKER', false);

-- Rebs
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (36, 'simple', 'rin_guard', 'rin_guard', 12, 4, 5, 5, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (37, 'simple', 'gaelian_jack', 'gaelian_jack', 13, 4, 7, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (38, 'simple', 'sorak_jack', 'sorak_jack', 10, 4, 5, 4, 4, 3, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (39, 'simple', 'ralarat_striker', 'ralarat_striker', 15, 5, 6, 5, 3, 4, 'STRIKER', false);

-- Hobgoblins
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (40, 'simple', 'hulk_guard', 'hulk_guard', 20, 4, 5, 5, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (41, 'simple', 'hobgoblin_jack', 'hobgoblin_jack', 9, 4, 5, 5, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (42, 'simple', 'hobgoblin_striker', 'hobgoblin_striker', 11, 5, 5, 5, 4, 4, 'STRIKER', false);

-- Martians
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (43, 'simple', 'martian_guard', 'martian_guard', 10, 4, 6, 5, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (44, 'simple', 'martian_jack', 'martian_jack', 9, 4, 6, 5, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (45, 'simple', 'martian_striker', 'martian_striker', 10, 5, 6, 5, 4, 4, 'STRIKER', false);

-- Convicts
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (46, 'simple', 'convict_guard', 'convict_guard', 16, 4, 5, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (47, 'simple', 'convict_jack', 'convict_jack', 9, 4, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (48, 'simple', 'convict_striker', 'convict_striker', 11, 5, 5, 4, 4, 4, 'STRIKER', false);

-- Kalyshi
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (49, 'simple', 'kalyshi_jack', 'kalyshi_jack', 11, 4, 6, 4, 3, 5, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (50, 'simple', 'kalyshi_striker', 'kalyshi_striker', 14, 5, 6, 4, 3, 5, 'STRIKER', false);

-- Crystallans
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (51, 'simple', 'crystallan_guard', 'crystallan_guard', 12, 4, 4, 4, 4, 5, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (52, 'simple', 'crystallan_jack', 'crystallan_jack', 10, 4, 4, 4, 4, 5, 'JACK', false);

-- Tsudochan
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (53, 'simple', 'tsudochan_jack', 'tsudochan_jack', 10, 4, 5, 4, 4, 4, 'JACK', false);

-- Koris
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (54, 'simple', 'koris_guard', 'koris_guard', 12, 4, 4, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (55, 'simple', 'koris_jack', 'koris_jack', 11, 4, 4, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (56, 'simple', 'koris_striker', 'koris_striker', 11, 5, 4, 4, 4, 4, 'STRIKER', false);

-- Ada-Lorana
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (57, 'simple', 'ada-lorana_guard', 'ada-lorana_guard', 15, 4, 5, 4, 3, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (58, 'simple', 'ada-lorana_jack', 'ada-lorana_jack', 12, 4, 5, 4, 3, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, cost, armor, movement, skill, speed, strength, position, giant)
    VALUES (59, 'simple', 'ada-lorana_striker', 'ada-lorana_striker', 15, 5, 5, 4, 3, 4, 'STRIKER', false);

-- ------------
-- Simple units
-- ------------

INSERT INTO simple_units (id) VALUES (1);
INSERT INTO simple_units (id) VALUES (2);
INSERT INTO simple_units (id) VALUES (3);
INSERT INTO simple_units (id) VALUES (4);
INSERT INTO simple_units (id) VALUES (5);
INSERT INTO simple_units (id) VALUES (6);
INSERT INTO simple_units (id) VALUES (7);
INSERT INTO simple_units (id) VALUES (8);
INSERT INTO simple_units (id) VALUES (9);
INSERT INTO simple_units (id) VALUES (10);
INSERT INTO simple_units (id) VALUES (11);
INSERT INTO simple_units (id) VALUES (12);
INSERT INTO simple_units (id) VALUES (13);
INSERT INTO simple_units (id) VALUES (14);
INSERT INTO simple_units (id) VALUES (15);
INSERT INTO simple_units (id) VALUES (16);
INSERT INTO simple_units (id) VALUES (17);
INSERT INTO simple_units (id) VALUES (18);
INSERT INTO simple_units (id) VALUES (19);
INSERT INTO simple_units (id) VALUES (20);
INSERT INTO simple_units (id) VALUES (21);
INSERT INTO simple_units (id) VALUES (22);
INSERT INTO simple_units (id) VALUES (23);
INSERT INTO simple_units (id) VALUES (24);
INSERT INTO simple_units (id) VALUES (25);
INSERT INTO simple_units (id) VALUES (26);
INSERT INTO simple_units (id) VALUES (27);
INSERT INTO simple_units (id) VALUES (28);
INSERT INTO simple_units (id) VALUES (29);
INSERT INTO simple_units (id) VALUES (30);
INSERT INTO simple_units (id) VALUES (31);
INSERT INTO simple_units (id) VALUES (32);
INSERT INTO simple_units (id) VALUES (33);
INSERT INTO simple_units (id) VALUES (34);
INSERT INTO simple_units (id) VALUES (35);
INSERT INTO simple_units (id) VALUES (36);
INSERT INTO simple_units (id) VALUES (37);
INSERT INTO simple_units (id) VALUES (38);
INSERT INTO simple_units (id) VALUES (39);
INSERT INTO simple_units (id) VALUES (40);
INSERT INTO simple_units (id) VALUES (41);
INSERT INTO simple_units (id) VALUES (42);
INSERT INTO simple_units (id) VALUES (43);
INSERT INTO simple_units (id) VALUES (44);
INSERT INTO simple_units (id) VALUES (45);
INSERT INTO simple_units (id) VALUES (46);
INSERT INTO simple_units (id) VALUES (47);
INSERT INTO simple_units (id) VALUES (48);
INSERT INTO simple_units (id) VALUES (49);
INSERT INTO simple_units (id) VALUES (50);
INSERT INTO simple_units (id) VALUES (51);
INSERT INTO simple_units (id) VALUES (52);
INSERT INTO simple_units (id) VALUES (53);
INSERT INTO simple_units (id) VALUES (54);
INSERT INTO simple_units (id) VALUES (55);
INSERT INTO simple_units (id) VALUES (56);
INSERT INTO simple_units (id) VALUES (57);
INSERT INTO simple_units (id) VALUES (58);
INSERT INTO simple_units (id) VALUES (59);

-- --------------
-- Unit abilities
-- --------------

-- Forge father guard: steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (8, 68);

-- Robots: quick change artist
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (11, 49);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (12, 49);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (13, 49);

-- Z'zor: can't feel a thing
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (14, 8);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (15, 8);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (16, 8);

-- Z'zor guard: steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (14, 68);

-- Z'zor jack: slide
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (15, 64);

-- Judwan: pacifist
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (17, 40);

-- Judwan: long arms
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (17, 31);

-- Judwan: misdirect
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (17, 36);

-- Human (female) jack: running interference
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (19, 60);

-- Asterian guard: dirty tricks
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (21, 12);

-- Asterian jack and striker: fragile
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (22, 20);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (23, 20);

-- Asterian jack: taking a dive
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (22, 73);

-- Nameless sticky guard: gotcha
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (24, 21);

-- Nameless hard guard: can't feel a thing
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (25, 8);

-- Nameless hard guard: steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (25, 68);

-- Nameless striker: a safe pair of hands
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (26, 3);

-- Teratons: teleport
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (27, 74);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (28, 74);

-- Zees: it wasn't me
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (29, 27);

-- Zees: runaround
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (29, 59);

-- Sphyr: tail
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (30, 72);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (31, 72);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (32, 72);

-- Brokkr: steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (33, 68);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (34, 68);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (35, 68);

-- Brokkr striker: grizzled
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (35, 22);

-- Rin guard: pummel
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (36, 47);

-- Gaelian jack: charge
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (37, 9);

-- Sorak jack: a safe pair of hands
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (38, 3);

-- Ralarat striker: jump
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (39, 28);

-- Ralarat striker: slippery customer
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (39, 65);

-- Hulk guard: mighty
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (40, 33);

-- Hulk guard: steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (40, 68);

-- Hulk guard: trail blazer
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (40, 78);

-- Hobgoblins: stench
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (41, 69);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (42, 69);

-- Martians: fragile
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (43, 20);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (44, 20);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (45, 20);

-- Martian jack: illegal
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (44, 25);

-- Martian striker: a safe pair of hands
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (45, 3);

-- Convicts: shock collar
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (46, 61);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (47, 61);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (48, 61);

-- Convict guard: threatening
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (46, 75);

-- Kalyshi jack: shove
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (49, 62);

-- Kalyshi jack: backstab
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (49, 6);

-- Kalyshi striker: jump
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (50, 28);

-- Crystallans: harmonics
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (51, 23);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (52, 23);

-- Tsudochan: push
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (53, 48);

-- Koris: spinner
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (54, 67);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (55, 67);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (56, 67);

-- Koris guard: gotcha
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (54, 21);

-- Koris jack: portal
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (55, 44);

-- Ada-Lorana: phaser
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (57, 41);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (58, 41);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (59, 41);

-- ****************************************
--               TEAM RULES
-- ****************************************

INSERT INTO team_rules (id, name) VALUES (1, 'monkey_business');
INSERT INTO team_rules (id, name) VALUES (2, 'boiled_down');

-- ****************************************
--               TEAM TYPES
-- ****************************************

INSERT INTO team_types (id, name) VALUES (1, 'humans_male');
INSERT INTO team_types (id, name) VALUES (2, 'orx_goblins');
INSERT INTO team_types (id, name) VALUES (3, 'veer-myn');
INSERT INTO team_types (id, name) VALUES (4, 'forge_fathers');
INSERT INTO team_types (id, name) VALUES (5, 'robots');
INSERT INTO team_types (id, name) VALUES (6, 'zzor');
INSERT INTO team_types (id, name) VALUES (7, 'judwan');
INSERT INTO team_types (id, name) VALUES (8, 'humans_female');
INSERT INTO team_types (id, name) VALUES (9, 'asterian');
INSERT INTO team_types (id, name) VALUES (10, 'nameless');
INSERT INTO team_types (id, name) VALUES (11, 'teratons');
INSERT INTO team_types (id, name) VALUES (12, 'zees');
INSERT INTO team_types (id, name) VALUES (13, 'sphyr');
INSERT INTO team_types (id, name) VALUES (14, 'brokkr');
INSERT INTO team_types (id, name) VALUES (15, 'rebs');
INSERT INTO team_types (id, name) VALUES (16, 'hobgoblins');
INSERT INTO team_types (id, name) VALUES (17, 'martians');
INSERT INTO team_types (id, name) VALUES (18, 'convicts');
INSERT INTO team_types (id, name) VALUES (19, 'kalyshi');
INSERT INTO team_types (id, name) VALUES (20, 'crystallans');
INSERT INTO team_types (id, name) VALUES (21, 'tsudochans');
INSERT INTO team_types (id, name) VALUES (22, 'koris');
INSERT INTO team_types (id, name) VALUES (23, 'ada-lorana');
INSERT INTO team_types (id, name) VALUES (24, 'mutants');
INSERT INTO team_types (id, name) VALUES (25, 'mechanite');

-- -------------------
-- Unit availabilities
-- -------------------

-- These follow the same order as the unit registration section
-- In most cases this is: guard, jack and striker

-- Humans (male)
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (1, 1, 1, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (2, 1, 2, 3, 6);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (3, 1, 3, 3, 6);

-- Orx/Goblins
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (4, 2, 4, 3, 6);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (5, 2, 5, 5, 10);

-- Veer-Myn
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (6, 3, 6, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (7, 3, 7, 6, 12);

-- Forge fathers
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (8, 4, 8, 3, 6);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (9, 4, 9, 3, 6);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (10, 4, 10, 2, 4);

-- Robots
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (11, 5, 12, 6, 14);

-- Z'zor
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (12, 6, 14, 1, 2);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (13, 6, 15, 5, 10);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (14, 6, 16, 2, 4);

-- Judwan
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (15, 7, 17, 6, 12);

-- Humans (female)
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (16, 8, 18, 1, 2);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (17, 8, 19, 4, 8);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (18, 8, 20, 3, 6);

-- Asterians
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (19, 9, 21, 1, 2);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (20, 9, 22, 3, 6);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (21, 9, 23, 4, 8);

-- Nameless
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (22, 10, 24, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (23, 10, 25, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (24, 10, 26, 4, 8);

-- Teratons
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (25, 11, 27, 4, 8);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (26, 11, 28, 4, 8);

-- Zees
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (27, 12, 29, 10, 14);

-- Sphyr
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (28, 13, 30, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (29, 13, 31, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (30, 13, 32, 4, 8);

-- Brokkr
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (31, 14, 33, 4, 8);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (32, 14, 34, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (33, 14, 35, 2, 4);

-- Rebs
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (34, 15, 36, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (35, 15, 37, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (36, 15, 38, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (37, 15, 39, 2, 4);

-- Hobgoblins
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (38, 16, 40, 1, 2);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (39, 16, 41, 4, 8);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (40, 16, 42, 2, 4);

-- Martians
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (41, 17, 43, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (42, 17, 44, 4, 8);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (43, 17, 45, 2, 4);

-- Convicts
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (44, 18, 46, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (45, 18, 47, 3, 6);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (46, 18, 48, 3, 6);

-- Kalyshi
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (47, 19, 49, 4, 8);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (48, 19, 50, 4, 8);

-- Crystallans
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (49, 20, 51, 5, 10);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (50, 20, 52, 3, 6);

-- Tsudochan
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (51, 21, 53, 8, 14);

-- Koris
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (52, 22, 54, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (53, 22, 55, 5, 10);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (54, 22, 56, 1, 2);

-- Ada-Lorana
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (55, 23, 57, 1, 2);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (56, 23, 58, 2, 4);
INSERT INTO team_type_unit_avas (id, team_type_id, unit_id, initial, max) VALUES (57, 23, 59, 3, 6);

-- --------------------
-- Asset availabilities
-- --------------------

-- The costs of the assets are always the same:
-- Dreadball Card: 10
-- Coaching Die: 6
-- Cheerleader: 8
-- Coaching Staff: 8

-- The assets maximums are always the same:
-- Dreadball Card: 7
-- Coaching Die: 7
-- Cheerleader: 7


-- Humans (male): 1 dice, 2 cards
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (1, 1, 10, 8, 8, 6, 2, 0, 1, 7, 7, 7, FALSE, FALSE, FALSE);

-- Orx/Goblins: 1 dice, 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (2, 2, 10, 8, 8, 6, 1, 0, 1, 7, 7, 7, FALSE, FALSE, FALSE);

-- Veer-Myn: 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (3, 3, 10, 8, 8, 6, 1, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Forge fathers: 1 dice, 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (4, 4, 10, 8, 8, 6, 1, 0, 1, 7, 7, 7, FALSE, FALSE, FALSE);

-- Robots: 1 dice, 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (5, 5, 10, 8, 8, 6, 1, 0, 1, 7, 7, 7, FALSE, FALSE, FALSE);

-- Z'zor: 1 dice, 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (6, 6, 10, 8, 8, 6, 1, 0, 1, 7, 7, 7, FALSE, FALSE, FALSE);

-- Judwan: 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (7, 7, 10, 8, 8, 6, 1, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Humans (female): 4 dice
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (8, 8, 10, 8, 8, 6, 0, 0, 4, 7, 7, 7, FALSE, FALSE, FALSE);

-- Asterians: Defensive coaching staff
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (9, 9, 10, 8, 8, 6, 0, 0, 0, 7, 7, 7, TRUE, FALSE, FALSE);

-- Nameless: Nothing
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (10, 10, 10, 8, 8, 6, 0, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Teratons: Nothing
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (11, 11, 10, 8, 8, 6, 0, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Zees: 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (12, 12, 10, 8, 8, 6, 1, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Sphyr: 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (13, 13, 10, 8, 8, 6, 1, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Brokkr: 1 dice, 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (14, 14, 10, 8, 8, 6, 1, 0, 1, 7, 7, 7, FALSE, FALSE, FALSE);

-- Rebs: Nothing
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (15, 15, 10, 8, 8, 6, 0, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Hobgoblins: 2 dice, 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (16, 16, 10, 8, 8, 6, 1, 0, 2, 7, 7, 7, FALSE, FALSE, FALSE);

-- Martians: 3 dice, 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (17, 17, 10, 8, 8, 6, 1, 0, 3, 7, 7, 7, FALSE, FALSE, FALSE);

-- Convicts: Offensive Coaching Staff
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (18, 18, 10, 8, 8, 6, 0, 0, 0, 7, 7, 7, FALSE, TRUE, FALSE);

-- Kalyshi: Nothing
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (19, 19, 10, 8, 8, 6, 0, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Crystallans: 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (20, 20, 10, 8, 8, 6, 1, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Tsudochan: 2 cards
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (21, 21, 10, 8, 8, 6, 2, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Koris: 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (22, 22, 10, 8, 8, 6, 1, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Ada-Lorana: 1 die, 1 card
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (23, 23, 10, 8, 8, 6, 1, 0, 1, 7, 7, 7, FALSE, FALSE, FALSE);

-- Mutants: Nothing, costs doubled
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (24, 24, 20, 16, 16, 12, 0, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);

-- Mechanite: Nothing
INSERT INTO team_type_asset_avas (id, team_type_id,
    cost_card, cost_cheerleader, cost_coaching, cost_dice,
    initial_card, initial_cheerleader, initial_dice,
    max_card, max_cheerleader, max_dice,
    def_coach, off_coach, sup_coach)
    VALUES (25, 25, 10, 8, 8, 6, 0, 0, 0, 7, 7, 7, FALSE, FALSE, FALSE);
