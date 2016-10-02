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
--               AFFINITIES
-- ****************************************

INSERT INTO affinity_groups (id, name) VALUES (1, 'alien');
INSERT INTO affinity_groups (id, name) VALUES (2, 'asterian');
INSERT INTO affinity_groups (id, name) VALUES (3, 'big_picture');
INSERT INTO affinity_groups (id, name) VALUES (4, 'convict');
INSERT INTO affinity_groups (id, name) VALUES (5, 'cunning');
INSERT INTO affinity_groups (id, name) VALUES (6, 'dreadball');
INSERT INTO affinity_groups (id, name) VALUES (7, 'forge_father');
INSERT INTO affinity_groups (id, name) VALUES (8, 'greedy');
INSERT INTO affinity_groups (id, name) VALUES (9, 'guard');
INSERT INTO affinity_groups (id, name) VALUES (10, 'hunter');
INSERT INTO affinity_groups (id, name) VALUES (11, 'insectoid');
INSERT INTO affinity_groups (id, name) VALUES (12, 'jack');
INSERT INTO affinity_groups (id, name) VALUES (13, 'machine-mind');
INSERT INTO affinity_groups (id, name) VALUES (14, 'mr_roboto');
INSERT INTO affinity_groups (id, name) VALUES (15, 'outcast');
INSERT INTO affinity_groups (id, name) VALUES (16, 'pirate');
INSERT INTO affinity_groups (id, name) VALUES (17, 'plant');
INSERT INTO affinity_groups (id, name) VALUES (18, 'proud');
INSERT INTO affinity_groups (id, name) VALUES (19, 'psycho');
INSERT INTO affinity_groups (id, name) VALUES (20, 'rebel');
INSERT INTO affinity_groups (id, name) VALUES (21, 'reluctant');
INSERT INTO affinity_groups (id, name) VALUES (22, 'striker');
INSERT INTO affinity_groups (id, name) VALUES (23, 'tech_guys');
INSERT INTO affinity_groups (id, name) VALUES (24, 'vat_brothers');
INSERT INTO affinity_groups (id, name) VALUES (25, 'vicious');
INSERT INTO affinity_groups (id, name) VALUES (26, 'weird_science');
INSERT INTO affinity_groups (id, name) VALUES (27, 'worker');

-- ****************************************
--                 UNITS
-- ****************************************


-- ---------
-- DBX units
-- ---------

-- Ada-Lorana
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (100, 'affinity', 'ada-lorana_guard', 'ada-lorana_guard_affinity', 4, 5, 4, 3, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (101, 'affinity', 'ada-lorana_jack', 'ada-lorana_jack_affinity', 5, 5, 4, 3, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (102, 'affinity', 'ada-lorana_striker', 'ada-lorana_striker_affinity', 5, 5, 4, 3, 4, 'STRIKER', false);

-- Asterians
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (103, 'affinity', 'asterian_guard', 'asterian_guard_affinity', 4, 6, 4, 3, 5, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (104, 'affinity', 'asterian_jack', 'asterian_jack_affinity', 5, 6, 4, 3, 5, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (105, 'affinity', 'asterian_striker', 'asterian_striker_affinity', 5, 6, 4, 3, 5, 'STRIKER', false);

-- Kalyshi
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (106, 'affinity', 'kalyshi_jack', 'kalyshi_jack_affinity', 5, 6, 4, 3, 5, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (107, 'affinity', 'kalyshi_striker', 'kalyshi_striker_affinity', 5, 6, 4, 3, 5, 'STRIKER', false);

-- Convicts
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (108, 'affinity', 'convict_guard', 'convict_guard_affinity', 4, 5, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (109, 'affinity', 'convict_jack', 'convict_jack_affinity', 5, 5, 5, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (110, 'affinity', 'convict_striker', 'convict_striker_affinity', 6, 5, 4, 4, 4, 'STRIKER', false);

-- Crystallans
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (111, 'affinity', 'crystallan_guard', 'crystallan_guard_affinity', 4, 4, 5, 3, 5, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (112, 'affinity', 'crystallan_jack', 'crystallan_jack_affinity', 5, 4, 5, 3, 5, 'JACK', false);

-- Forge fathers
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (113, 'affinity', 'forge_father_guard', 'forge_father_guard_affinity', 4, 4, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (114, 'affinity', 'forge_father_jack', 'forge_father_jack_affinity', 4, 4, 4, 5, 3, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (115, 'affinity', 'forge_father_striker', 'forge_father_striker_affinity', 5, 4, 4, 5, 3, 'STRIKER', false);

-- Brokkr
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (116, 'affinity', 'brokr_guard', 'brokr_guard_affinity', 4, 4, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (117, 'affinity', 'brokr_jack', 'brokr_jack_affinity', 5, 4, 4, 5, 3, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (118, 'affinity', 'brokr_striker', 'brokr_striker_affinity', 5, 4, 4, 5, 3, 'STRIKER', false);

-- Hobgoblins
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (119, 'affinity', 'hulk_guard', 'hulk_guard_affinity', 4, 5, 5, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (120, 'affinity', 'hobgoblin_jack', 'hobgoblin_jack_affinity', 5, 5, 5, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (121, 'affinity', 'hobgoblin_striker', 'hobgoblin_striker_affinity', 5, 5, 5, 4, 4, 'STRIKER', false);

-- Humans (male)
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (122, 'affinity', 'human_male_guard', 'human_male_guard_affinity', 4, 5, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (123, 'affinity', 'human_male_jack', 'human_male_jack_affinity', 5, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (124, 'affinity', 'human_male_striker', 'human_male_striker_affinity', 5, 5, 4, 4, 4, 'STRIKER', false);

-- Humans (female)
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (125, 'affinity', 'human_female_guard', 'human_female_guard_affinity', 4, 5, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (126, 'affinity', 'human_female_jack', 'human_female_jack_affinity', 5, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (127, 'affinity', 'human_female_striker', 'human_female_striker_affinity', 5, 5, 4, 4, 4, 'STRIKER', false);

-- Judwan
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (128, 'affinity', 'judwan_striker', 'judwan_striker_affinity', 5, 6, 4, 4, 5, 'STRIKER', false);

-- Koris
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (129, 'affinity', 'koris_guard', 'koris_guard_affinity', 4, 4, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (130, 'affinity', 'koris_jack', 'koris_jack_affinity', 5, 4, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (131, 'affinity', 'koris_striker', 'koris_striker_affinity', 5, 4, 4, 4, 4, 'STRIKER', false);

-- Marauders
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (132, 'affinity', 'marauder_guard', 'marauder_guard_affinity', 4, 5, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (133, 'affinity', 'marauder_jack', 'marauder_jack_affinity', 5, 5, 4, 3, 5, 'STRIKER', false);

-- Martians
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (134, 'affinity', 'martian_guard', 'martian_guard_affinity', 4, 5, 5, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (135, 'affinity', 'martian_jack', 'martian_jack_affinity', 5, 5, 5, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (136, 'affinity', 'martian_striker', 'martian_striker_affinity', 5, 5, 5, 4, 4, 'STRIKER', false);

-- Nameless
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (137, 'affinity', 'nameless_guard_sticky', 'nameless_guard_sticky_affinity', 4, 4, 5, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (138, 'affinity', 'nameless_guard_hard', 'nameless_guard_hard_affinity', 4, 5, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (139, 'affinity', 'nameless_striker', 'nameless_striker_affinity', 5, 6, 4, 4, 4, 'STRIKER', false);

-- Rebs
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (140, 'affinity', 'rin_guard', 'rin_guard_affinity', 4, 5, 5, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (141, 'affinity', 'gaelian_jack', 'gaelian_jack_affinity', 5, 7, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (142, 'affinity', 'sorak_jack', 'sorak_jack_affinity', 5, 5, 4, 3, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (143, 'affinity', 'ralarat_striker', 'ralarat_striker_affinity', 5, 6, 3, 4, 5, 'STRIKER', false);

-- Robots
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (144, 'affinity', 'robot_guard', 'robot_guard_affinity', 4, 5, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (145, 'affinity', 'robot_jack', 'robot_jack_affinity', 4, 6, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (146, 'affinity', 'robot_striker', 'robot_striker_affinity', 5, 5, 4, 3, 5, 'STRIKER', false);

-- Sphyr
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (147, 'affinity', 'sphyr_guard', 'sphyr_guard_affinity', 4, 6, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (148, 'affinity', 'sphyr_jack', 'sphyr_jack_affinity', 5, 6, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (149, 'affinity', 'sphyr_striker', 'sphyr_striker_affinity', 5, 6, 4, 4, 4, 'STRIKER', false);

-- Teratons
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (150, 'affinity', 'teraton_guard', 'teraton_guard_affinity', 4, 5, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (151, 'affinity', 'teraton_jack', 'teraton_jack_affinity', 4, 5, 4, 5, 3, 'JACK', false);

-- Tsudochan
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (152, 'affinity', 'tsudochan_jack', 'tsudochan_jack_affinity', 5, 5, 4, 4, 5, 'JACK', false);

-- Veer-Myn
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (153, 'affinity', 'veer-myn_guard', 'veer-myn_guard_affinity', 4, 6, 5, 3, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (154, 'affinity', 'veer-myn_striker', 'veer-myn_striker_affinity', 5, 6, 5, 3, 4, 'STRIKER', false);

-- Zees
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (155, 'affinity', 'zee_jack', 'zee_jack_affinity', 5, 5, 5, 3, 5, 'JACK', false);

-- Z'zor
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (156, 'affinity', 'zzor_guard', 'zzor_guard_affinity', 4, 5, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (157, 'affinity', 'zzor_jack', 'zzor_jack_affinity', 5, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (158, 'affinity', 'zzor_striker', 'zzor_striker_affinity', 5, 6, 5, 4, 4, 'STRIKER', false);

-- Other players
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (159, 'affinity', 'avaran_treebeast', 'avaran_treebeast_affinity', 4, 3, 4, 5, 3, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (160, 'affinity', 'jetari_brawler', 'jetari_brawler_affinity', 3, 4, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (161, 'affinity', 'jetari_thrower', 'jetari_thrower_affinity', 4, 5, 3, 4, 5, 'STRIKER', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (162, 'affinity', 'nameless_bloodsucker', 'nameless_bloodsucker_affinity', 4, 6, 5, 3, 4, 'JACK', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (163, 'affinity', 'pusk_rampager', 'pusk_rampager_affinity', 4, 4, 4, 6, 4, 'GUARD', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (164, 'affinity', 'vlorox_spinpede', 'vlorox_spinpede_affinity', 4, 4, 4, 5, 3, 'STRIKER', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (165, 'affinity', 'yndij_reaver', 'yndij_reaver_affinity', 5, 6, 4, 3, 4, 'STRIKER', false);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (166, 'affinity', 'zee_buccaneer', 'zee_buccaneer_affinity', 5, 5, 5, 3, 5, 'JACK', false);

-- Giants
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (167, 'affinity', 'alpha_simian', 'alpha_simian_affinity', 5, 5, 4, 3, 4, 'JACK', true);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (168, 'affinity', 'barricade', 'barricade_affinity', 4, 6, 5, 3, 4, 'GUARD', true);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (169, 'affinity', 'big_mech', 'big_mech_affinity', 4, 5, 4, 4, 3, 'JACK', true);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (170, 'affinity', 'chovar', 'chovar_affinity', 5, 6, 4, 5, 5, 'JACK', true);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (171, 'affinity', 'iron_ancestor', 'iron_ancestor_affinity', 5, 6, 4, 5, 5, 'KEEPER', true);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (172, 'affinity', 'krastavor', 'krastavor_affinity', 4, 6, 4, 3, 4, 'JACK', true);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (173, 'affinity', 'nameless_spawn', 'nameless_spawn_affinity', 4, 5, 5, 3, 4, 'GUARD', true);
INSERT INTO units (id, unit_type, name, template_name, armor, movement, skill, speed, strength, position, giant)
    VALUES (174, 'affinity', 'sann_gar', 'sann_gar_affinity', 4, 5, 5, 4, 3, 'KEEPER', true);

-- --------------
-- Affinity units
-- --------------

-- Ada-Lorana
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (100, 23, 15, 10);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (101, 18, 12, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (102, 23, 15, 10);

-- Asterians
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (103, 15, 10, 7);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (104, 15, 10, 7);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (105, 20, 13, 8);

-- Kalyshi
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (106, 17, 11, 7);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (107, 23, 15, 10);

-- Convicts
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (108, 23, 15, 10);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (109, 9, 6, 4);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (110, 12, 8, 5);

-- Crystallans
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (111, 18, 12, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (112, 15, 10, 7);

-- Forge fathers
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (113, 20, 13, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (114, 14, 9, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (115, 14, 9, 6);

-- Brokkr
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (116, 21, 14, 10);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (117, 14, 9, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (118, 12, 8, 6);

-- Hobgoblins
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (119, 30, 20, 13);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (120, 14, 9, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (121, 17, 11, 8);

-- Humans (male)
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (122, 15, 10, 7);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (123, 12, 8, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (124, 15, 10, 7);

-- Humans (female)
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (125, 15, 10, 7);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (126, 14, 9, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (127, 15, 10, 7);

-- Judwan
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (128, 23, 15, 10);

-- Koris
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (129, 18, 12, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (130, 17, 11, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (131, 17, 11, 8);

-- Marauders
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (132, 20, 13, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (133, 14, 9, 6);

-- Martians
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (134, 15, 10, 7);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (135, 12, 8, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (136, 15, 10, 7);

-- Nameless
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (137, 14, 9, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (138, 23, 15, 10);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (139, 20, 13, 8);

-- Rebs
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (140, 18, 12, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (141, 20, 13, 9);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (142, 15, 10, 7);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (143, 23, 15, 10);

-- Robots
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (144, 21, 14, 9);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (145, 21, 14, 9);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (146, 21, 14, 9);

-- Sphyr
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (147, 18, 12, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (148, 14, 9, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (149, 18, 12, 8);

-- Teratons
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (150, 23, 15, 10);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (151, 15, 10, 7);

-- Tsudochan
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (152, 15, 10, 7);

-- Veer-Myn
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (153, 18, 12, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (154, 17, 11, 8);

-- Zees
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (155, 11, 7, 5);

-- Z'zor
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (156, 26, 17, 12);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (157, 14, 9, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (158, 17, 11, 8);

-- Other players
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (159, 14, 9, 6);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (160, 24, 16, 11);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (161, 21, 14, 9);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (162, 18, 12, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (163, 18, 12, 8);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (164, 17, 11, 7);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (165, 24, 16, 11);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (166, 11, 7, 5);

-- Giants
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (167, 45, 30, 20);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (168, 41, 27, 18);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (169, 44, 29, 19);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (170, 35, 23, 15);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (171, 48, 32, 21);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (172, 41, 27, 18);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (173, 48, 32, 21);
INSERT INTO affinity_units (id, cost_stranger, cost_ally, cost_friend) VALUES (174, 44, 29, 19);

-- --------------
-- Unit abilities
-- --------------

-- Ada-Lorana: phaser
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (100, 41);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (101, 41);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (102, 41);

-- Asterian guard: poison blade
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (103, 43);

-- Asterian jack: fragile, poison blade
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (104, 20);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (104, 43);

-- Asterian striker: fragile blade
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (105, 20);

-- Kalyshi jack: backstab, shove
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (106, 6);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (106, 62);

-- Kalyshi striker: jump
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (107, 28);

-- Convicts: explosive collar
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (108, 18);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (109, 18);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (110, 18);

-- Convict guard: threatening
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (108, 75);

-- Crystallans: harmonics
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (111, 23);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (112, 23);

-- Forge father guard: steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (113, 68);

-- Brokkr: steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (116, 68);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (117, 68);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (118, 68);

-- Brokkr striker: grizzled
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (118, 22);

-- Hulk guard: mighty, steady, trail blazer
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (119, 33);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (119, 68);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (119, 78);

-- Hobgoblins: stench
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (120, 69);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (121, 69);

-- Human (female) jack: running interference
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (123, 60);

-- Judwan: pacifist, long arms, misdirect
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (128, 40);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (128, 31);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (128, 36);

-- Koris: spinner
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (129, 67);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (130, 67);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (131, 67);

-- Koris guard: gotcha
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (129, 21);

-- Koris jack: portal
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (130, 44);

-- Martians: ray gun
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (134, 52);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (135, 52);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (136, 52);

-- Nameless sticky guard: gotcha
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (137, 21);

-- Nameless hard guard: can't feel a thing, steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (138, 8);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (138, 68);

-- Nameless striker: a safe pair of hands
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (139, 3);

-- Rin guard: pummel
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (140, 47);

-- Gaelian jack: charge
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (141, 9);

-- Sorak jack: a safe pair of hands
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (142, 3);

-- Ralarat striker: jump, slippery customer
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (143, 28);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (143, 65);

-- Robots: quick change artist
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (144, 49);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (145, 49);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (146, 49);

-- Sphyr: tail
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (147, 72);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (148, 72);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (149, 72);

-- Teratons: teleport
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (150, 74);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (151, 74);

-- Tsudochan: push
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (152, 48);

-- Zees: runaround, duck & weave
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (155, 59);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (155, 16);

-- Z'zor: can't feel a thing
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (156, 8);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (157, 8);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (158, 8);

-- Z'zor guard: steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (156, 68);

-- Other players, avaran treebeast: can't feel a thing, tongue
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (159, 8);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (159, 76);

-- Other players, jetari brawler: can't feel a thing, grizzled
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (160, 8);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (160, 22);

-- Other players, jetari thrower: 360 vision, a safe pair of hands
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (161, 1);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (161, 3);

-- Other players, nameless bloodsucker: poison blade, steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (162, 43);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (162, 68);

-- Other players, pusk rampager: ram, resilient
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (163, 51);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (163, 54);

-- Other players, vlorox spinpede: can't feel a thing, rolling
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (164, 8);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (164, 57);

-- Other players, yndij reaver: backflip, duck and weave, jump
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (165, 5);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (165, 16);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (165, 28);

-- Other players, zee buccaneer: duck and weave, runaround
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (166, 16);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (166, 59);

-- Giant, Alpha Simian: show off, stretch, threatening
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (167, 63);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (167, 70);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (167, 75);

-- Giant, Barricade: comin' through, stretch, threatening
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (168, 10);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (168, 70);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (168, 75);

-- Giant, Big Mech: can't feel a thing, show off, threatening
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (169, 8);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (169, 63);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (169, 75);

-- Giant, Chovar: mind control, steady
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (170, 34);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (170, 68);

-- Giant, Iron Ancestor: can't feel a thing
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (171, 8);

-- Giant, Krastavor: steady, stretch, threatening
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (172, 68);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (172, 70);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (172, 75);

-- Giant, Nameless Spawn: gotcha, threatening
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (173, 21);
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (173, 75);

-- Giant, Sann-gar:  threatening
INSERT INTO unit_abilities (unit_id, ability_id) VALUES (173, 75);

-- ---------------
-- Unit affinities
-- ---------------

-- Ada-Lorana: proud
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (100, 18);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (101, 18);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (102, 18);

-- Ada-Lorana guard: guard
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (100, 9);

-- Ada-Lorana jack: jack
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (101, 12);

-- Ada-Lorana striker: striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (102, 22);

-- Asterian: cunning
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (103, 5);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (104, 5);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (105, 5);

-- Asterian guard: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (103, 25);

-- Asterian jack: asterian
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (104, 2);

-- Asterian striker: striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (104, 22);

-- Kalyshi: asterian
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (106, 2);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (107, 2);

-- Kalyshi jack: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (106, 25);

-- Kalyshi striker: big picture
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (107, 3);

-- Convicts: convict
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (108, 4);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (109, 4);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (110, 4);

-- Convict guard: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (108, 25);

-- Convict jack: greedy
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (109, 8);

-- Convict striker: cunning
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (110, 5);

-- Crystallans: proud
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (111, 18);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (112, 18);

-- Crystallan guard: guard
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (111, 9);

-- Crystallan jack: alien
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (111, 1);

-- Forge fathers: forge father
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (113, 7);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (114, 7);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (115, 7);

-- Forge father guard: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (113, 25);

-- Forge father jack: dreadball
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (114, 6);

-- Forge father striker: striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (114, 22);

-- Brokkrs: forge father
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (116, 7);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (117, 7);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (118, 7);

-- Brokkr guard: guard
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (116, 9);

-- Brokkr jack: worker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (117, 27);

-- Brokkr striker: cunning
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (118, 5);

-- Hobgoblin hulk guard: psycho, vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (119, 19);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (119, 25);

-- Hobgoblin: outcast
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (120, 19);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (121, 19);

-- Hobgoblin jack: greedy
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (120, 8);

-- Hobgoblin striker: cunning
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (121, 5);

-- Human (male): dreadball
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (122, 6);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (123, 6);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (124, 6);

-- Human (male) guard: guard
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (122, 9);

-- Human (male) jack: jack
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (123, 12);

-- Human (male) striker: striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (124, 22);

-- Human (female): dreadball
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (125, 6);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (126, 6);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (127, 6);

-- Human (female) guard: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (125, 25);

-- Human (female) jack: cunning
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (126, 5);

-- Human (female) striker: striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (127, 22);

-- Judwan: proud, striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (128, 18);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (128, 22);

-- Koris guard: hunter, vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (129, 10);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (129, 25);

-- Koris jack: alien, tech guy
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (130, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (130, 23);

-- Koris jack: cunning, tech guy
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (131, 5);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (131, 23);

-- Marauder guard: guard, psycho
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (132, 9);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (132, 19);

-- Marauder jack: outcast, worker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (133, 15);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (133, 27);

-- Martians: vicious, weird science, alien
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (134, 25);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (134, 26);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (134, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (135, 25);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (135, 26);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (135, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (136, 25);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (136, 26);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (136, 1);

-- Nameless: alien
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (137, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (138, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (139, 1);

-- Nameless sticky guard: cunning
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (137, 5);

-- Nameless hard guard: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (138, 25);

-- Nameless striker: striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (139, 22);

-- Rebs: rebel
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (140, 20);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (141, 20);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (142, 20);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (143, 20);

-- Reb rin guard: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (140, 25);

-- Reb gaelian jack: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (141, 15);

-- Reb sorak jack: alien
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (142, 1);

-- Reb raralat striker: cunning
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (143, 5);

-- Robots: mr roboto, tech guys
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (144, 14);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (144, 23);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (145, 14);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (145, 23);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (146, 14);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (146, 23);

-- Sphyr: dreadball
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (147, 6);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (148, 6);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (149, 6);

-- Sphyr guard: hunter
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (147, 10);

-- Sphyr jack: proud
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (148, 18);

-- Sphyr striker: alien
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (148, 1);

-- Teraton: alien
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (150, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (151, 1);

-- Teraton guard: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (150, 25);

-- Teraton jack: proud
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (151, 18);

-- Tsudochan: alien, weird science
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (152, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (152, 26);

-- Veer-myn: outcast
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (153, 15);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (154, 15);

-- Veer-myn guard: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (153, 25);

-- Veer-myn striker: striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (154, 22);

-- Zees: pirate, cunning, weird science
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (155, 16);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (155, 5);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (155, 26);

-- Z'zor: insectoid
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (156, 11);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (157, 11);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (158, 11);

-- Z'zor guard: vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (156, 25);

-- Z'zor jack: worker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (157, 27);

-- Z'zor jack: cunning
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (158, 5);

-- Other players, avaran treebeast: hunter, plant
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (159, 10);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (159, 17);

-- Other players, jetari brawler: dreadball, guard, mr roboto
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (160, 6);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (160, 9);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (160, 14);

-- Other players, jetari thrower: dreadball, mr roboto, striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (161, 6);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (161, 14);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (161, 22);

-- Other players, nameless bloodsucker: alien, insectoid, vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (162, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (162, 11);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (162, 25);

-- Other players, pusk rampager: hunter, psycho
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (163, 10);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (163, 19);

-- Other players, vlorox spinpede: alien, reluctant
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (164, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (164, 21);

-- Other players, yndij reaver: alien, rebel, striker
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (165, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (164, 20);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (164, 22);

-- Other players, zee buccaneer: cunning, pirate
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (166, 5);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (166, 16);

-- Giant, Alpha Simian: alien, hunter, reluctant
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (167, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (167, 10);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (167, 21);

-- Giant, Barricade: mr roboto, tech guys, vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (168, 14);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (168, 23);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (168, 25);

-- Giant, Big Mech: mr roboto, reluctant, weird science
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (169, 14);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (169, 21);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (169, 26);

-- Giant, Chovar: alien, outcast, reluctant
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (170, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (170, 15);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (170, 21);

-- Giant, Iron Ancestor: forge father, vicious
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (171, 7);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (171, 25);

-- Giant, Krastavor: insectoid, mr roboto
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (172, 11);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (172, 14);

-- Giant, Nameless Spawn: alien, hunter, outcast
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (173, 1);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (173, 10);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (173, 15);

-- Giant, Sann-gar: cunning, hunter, outcast
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (174, 5);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (174, 10);
INSERT INTO unit_affinities (unit_id, affinity_id) VALUES (174, 15);

-- ---------------------
-- Unit hated affinities
-- ---------------------

-- Crystallans: hates forge fathers
INSERT INTO unit_hated_affinities (unit_id, affinity_id) VALUES (111, 7);
INSERT INTO unit_hated_affinities (unit_id, affinity_id) VALUES (112, 7);

-- Giant, Alpha Simian: hates dreadball
INSERT INTO unit_hated_affinities (unit_id, affinity_id) VALUES (167, 6);

-- -------------------------
-- Affinities availabilities
-- -------------------------

-- Sponsor affinities groups
INSERT INTO sponsor_affinity_avas(id, name, rank_increase)
    VALUES (1, 'A', true);
INSERT INTO sponsor_affinity_avas(id, name, rank_increase)
    VALUES (2, 'B', true);
INSERT INTO sponsor_affinity_avas(id, name, rank_increase)
    VALUES (3, 'C', false);
INSERT INTO sponsor_affinity_avas(id, name, rank_increase)
    VALUES (4, 'D', true);
INSERT INTO sponsor_affinity_avas(id, name, rank_increase)
    VALUES (5, 'E', false);

-- Group A affinities: alien, cunning, plant, reluctant, striker
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (1, 1);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (1, 5);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (1, 17);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (1, 21);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (1, 22);

-- Group B affinities: dreadball, big picture, psycho, rebel, worker
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (2, 6);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (2, 3);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (2, 19);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (2, 20);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (2, 27);

-- Group C affinities: asterian, convict, forge father, guard, tech guys, vat brothers
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (3, 2);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (3, 4);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (3, 7);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (3, 9);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (3, 23);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (3, 24);

-- Group D affinities: insectoid, jack, mr roboto, proud, vicious
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (4, 11);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (4, 12);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (4, 14);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (4, 18);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (4, 25);

-- Group E affinities: greedy, hunter, machine mind, outcast, pirate, weird science
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (5, 8);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (5, 10);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (5, 13);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (5, 15);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (5, 16);
INSERT INTO sponsor_affinity_avas_affinity_groups(
    sponsor_affinity_ava_id, affinity_id)
    VALUES (5, 26);
