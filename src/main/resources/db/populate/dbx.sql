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
-- This SQL script populates the tables with the latest Dreadball data.
--
-- It includes only data that is for both the Xtreme version.
-- ****************************************

-- ****************************************
-- A note aboud ids.
--
-- For the players, the following id ranges have been used:
-- DBO players: 0 to 99
-- DBX players: 100 to 199
-- DBO MVPs and giants: 200 to 299
-- DBX MVPs, giants and free agents: 300 to 399
-- ****************************************


-- ****************************************
--               AFFINITIES
-- ****************************************

INSERT INTO AFFINITY_GROUPS (id, name) VALUES (1, 'alien');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (2, 'asterian');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (3, 'big_picture');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (4, 'convict');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (5, 'cunning');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (6, 'dreadball');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (7, 'forge_father');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (8, 'greedy');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (9, 'guard');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (10, 'hunter');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (11, 'insectoid');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (12, 'jack');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (13, 'machine_mind');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (14, 'mr_roboto');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (15, 'outcast');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (16, 'pirate');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (17, 'plant');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (18, 'proud');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (19, 'psycho');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (20, 'rebel');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (21, 'reluctant');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (22, 'striker');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (23, 'tech_guys');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (24, 'vat_brothers');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (25, 'vicious');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (26, 'weird_science');
INSERT INTO AFFINITY_GROUPS (id, name) VALUES (27, 'worker');

-- ****************************************
--                 UNITS
-- ****************************************


-- ---------
-- DBX players
-- ---------

-- Ada-Lorana
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (100, 'affinity', 'ada_lorana_guard', 'ada_lorana_guard_affinity', 4, 5, 4, 3, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (101, 'affinity', 'ada_lorana_jack', 'ada_lorana_jack_affinity', 5, 5, 4, 3, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (102, 'affinity', 'ada_lorana_striker', 'ada_lorana_striker_affinity', 5, 5, 4, 3, 4, 'STRIKER');

-- Asterians
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (103, 'affinity', 'asterian_guard', 'asterian_guard_affinity', 4, 6, 4, 3, 5, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (104, 'affinity', 'asterian_jack', 'asterian_jack_affinity', 5, 6, 4, 3, 5, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (105, 'affinity', 'asterian_striker', 'asterian_striker_affinity', 5, 6, 4, 3, 5, 'STRIKER');

-- Kalyshi
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (106, 'affinity', 'kalyshi_jack', 'kalyshi_jack_affinity', 5, 6, 4, 3, 5, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (107, 'affinity', 'kalyshi_striker', 'kalyshi_striker_affinity', 5, 6, 4, 3, 5, 'STRIKER');

-- Convicts
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (108, 'affinity', 'convict_guard', 'convict_guard_affinity', 4, 5, 5, 4, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (109, 'affinity', 'convict_jack', 'convict_jack_affinity', 5, 5, 5, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (110, 'affinity', 'convict_striker', 'convict_striker_affinity', 6, 5, 4, 4, 4, 'STRIKER');

-- Crystallans
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (111, 'affinity', 'crystallan_guard', 'crystallan_guard_affinity', 4, 4, 5, 3, 5, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (112, 'affinity', 'crystallan_jack', 'crystallan_jack_affinity', 5, 4, 5, 3, 5, 'JACK');

-- Forge fathers
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (113, 'affinity', 'forge_father_guard', 'forge_father_guard_affinity', 4, 4, 4, 5, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (114, 'affinity', 'forge_father_jack', 'forge_father_jack_affinity', 4, 4, 4, 5, 3, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (115, 'affinity', 'forge_father_striker', 'forge_father_striker_affinity', 5, 4, 4, 5, 3, 'STRIKER');

-- Brokkr
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (116, 'affinity', 'brokr_guard', 'brokr_guard_affinity', 4, 4, 4, 5, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (117, 'affinity', 'brokr_jack', 'brokr_jack_affinity', 5, 4, 4, 5, 3, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (118, 'affinity', 'brokr_striker', 'brokr_striker_affinity', 5, 4, 4, 5, 3, 'STRIKER');

-- Hobgoblins
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (119, 'affinity', 'hulk_guard', 'hulk_guard_affinity', 4, 5, 5, 5, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (120, 'affinity', 'hobgoblin_jack', 'hobgoblin_jack_affinity', 5, 5, 5, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (121, 'affinity', 'hobgoblin_striker', 'hobgoblin_striker_affinity', 5, 5, 5, 4, 4, 'STRIKER');

-- Humans (male)
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (122, 'affinity', 'human_male_guard', 'human_male_guard_affinity', 4, 5, 4, 4, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (123, 'affinity', 'human_male_jack', 'human_male_jack_affinity', 5, 5, 4, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (124, 'affinity', 'human_male_striker', 'human_male_striker_affinity', 5, 5, 4, 4, 4, 'STRIKER');

-- Humans (female)
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (125, 'affinity', 'human_female_guard', 'human_female_guard_affinity', 4, 5, 4, 4, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (126, 'affinity', 'human_female_jack', 'human_female_jack_affinity', 5, 5, 4, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (127, 'affinity', 'human_female_striker', 'human_female_striker_affinity', 5, 5, 4, 4, 4, 'STRIKER');

-- Judwan
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (128, 'affinity', 'judwan_striker', 'judwan_striker_affinity', 5, 6, 4, 4, 5, 'STRIKER');

-- Koris
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (129, 'affinity', 'koris_guard', 'koris_guard_affinity', 4, 4, 4, 4, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (130, 'affinity', 'koris_jack', 'koris_jack_affinity', 5, 4, 4, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (131, 'affinity', 'koris_striker', 'koris_striker_affinity', 5, 4, 4, 4, 4, 'STRIKER');

-- Marauders
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (132, 'affinity', 'marauder_guard', 'marauder_guard_affinity', 4, 5, 5, 4, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (133, 'affinity', 'marauder_jack', 'marauder_jack_affinity', 5, 5, 4, 3, 5, 'STRIKER');

-- Martians
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (134, 'affinity', 'martian_guard', 'martian_guard_affinity', 4, 5, 5, 4, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (135, 'affinity', 'martian_jack', 'martian_jack_affinity', 5, 5, 5, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (136, 'affinity', 'martian_striker', 'martian_striker_affinity', 5, 5, 5, 4, 4, 'STRIKER');

-- Nameless
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (137, 'affinity', 'nameless_guard_sticky', 'nameless_guard_sticky_affinity', 4, 4, 5, 4, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (138, 'affinity', 'nameless_guard_hard', 'nameless_guard_hard_affinity', 4, 5, 4, 5, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (139, 'affinity', 'nameless_striker', 'nameless_striker_affinity', 5, 6, 4, 4, 4, 'STRIKER');

-- Rebs
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (140, 'affinity', 'rin_guard', 'rin_guard_affinity', 4, 5, 5, 4, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (141, 'affinity', 'gaelian_jack', 'gaelian_jack_affinity', 5, 7, 4, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (142, 'affinity', 'sorak_jack', 'sorak_jack_affinity', 5, 5, 4, 3, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (143, 'affinity', 'ralarat_striker', 'ralarat_striker_affinity', 5, 6, 3, 4, 5, 'STRIKER');

-- Robots
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (144, 'affinity', 'robot_guard', 'robot_guard_affinity', 4, 5, 4, 5, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (145, 'affinity', 'robot_jack', 'robot_jack_affinity', 4, 6, 4, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (146, 'affinity', 'robot_striker', 'robot_striker_affinity', 5, 5, 4, 3, 5, 'STRIKER');

-- Sphyr
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (147, 'affinity', 'sphyr_guard', 'sphyr_guard_affinity', 4, 6, 4, 4, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (148, 'affinity', 'sphyr_jack', 'sphyr_jack_affinity', 5, 6, 4, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (149, 'affinity', 'sphyr_striker', 'sphyr_striker_affinity', 5, 6, 4, 4, 4, 'STRIKER');

-- Teratons
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (150, 'affinity', 'teraton_guard', 'teraton_guard_affinity', 4, 5, 4, 5, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (151, 'affinity', 'teraton_jack', 'teraton_jack_affinity', 4, 5, 4, 5, 3, 'JACK');

-- Tsudochan
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (152, 'affinity', 'tsudochan_jack', 'tsudochan_jack_affinity', 5, 5, 4, 4, 5, 'JACK');

-- Veer-Myn
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (153, 'affinity', 'veer_myn_guard', 'veer_myn_guard_affinity', 4, 6, 5, 3, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (154, 'affinity', 'veer_myn_striker', 'veer_myn_striker_affinity', 5, 6, 5, 3, 4, 'STRIKER');

-- Zees
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (155, 'affinity', 'zee_jack', 'zee_jack_affinity', 5, 5, 5, 3, 5, 'JACK');

-- Z'zor
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (156, 'affinity', 'zzor_guard', 'zzor_guard_affinity', 4, 5, 5, 4, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (157, 'affinity', 'zzor_jack', 'zzor_jack_affinity', 5, 5, 4, 4, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (158, 'affinity', 'zzor_striker', 'zzor_striker_affinity', 5, 6, 5, 4, 4, 'STRIKER');

-- Other players
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (159, 'affinity', 'avaran_treebeast', 'avaran_treebeast_affinity', 4, 3, 4, 5, 3, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (160, 'affinity', 'jetari_brawler', 'jetari_brawler_affinity', 3, 4, 5, 4, 3, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (161, 'affinity', 'jetari_thrower', 'jetari_thrower_affinity', 4, 5, 3, 4, 5, 'STRIKER');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (162, 'affinity', 'nameless_bloodsucker', 'nameless_bloodsucker_affinity', 4, 6, 5, 3, 4, 'JACK');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (163, 'affinity', 'pusk_rampager', 'pusk_rampager_affinity', 4, 4, 4, 6, 4, 'GUARD');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (164, 'affinity', 'vlorox_spinpede', 'vlorox_spinpede_affinity', 4, 4, 4, 5, 3, 'STRIKER');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (165, 'affinity', 'yndij_reaver', 'yndij_reaver_affinity', 5, 6, 4, 3, 4, 'STRIKER');
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role)
    VALUES (166, 'affinity', 'zee_buccaneer', 'zee_buccaneer_affinity', 5, 5, 5, 3, 5, 'JACK');

-- Giants
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (167, 'affinity', 'alpha_simian', 'alpha_simian_affinity', 5, 5, 4, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (168, 'affinity', 'barricade', 'barricade_affinity', 4, 6, 5, 3, 4, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (169, 'affinity', 'big_mech', 'big_mech_affinity', 4, 5, 4, 4, 3, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (170, 'affinity', 'chovar', 'chovar_affinity', 5, 6, 4, 5, 5, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (171, 'affinity', 'iron_ancestor', 'iron_ancestor_affinity', 5, 6, 4, 5, 5, 'KEEPER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (172, 'affinity', 'krastavor', 'krastavor_affinity', 4, 6, 4, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (173, 'affinity', 'nameless_spawn', 'nameless_spawn_affinity', 4, 5, 5, 3, 4, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant)
    VALUES (174, 'affinity', 'sann_gar', 'sann_gar_affinity', 4, 5, 5, 4, 3, 'KEEPER', true);

-- MVPs
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (175, 'affinity', 'anne_marie_helder', 'anne_marie_helder_affinity', 4, 5, 5, 4, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (176, 'affinity', 'asylum', 'asylum_affinity', 4, 6, 5, 3, 4, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (177, 'affinity', 'ateo_adysi', 'ateo_adysi_affinity', 5, 6, 5, 4, 3, 'STRIKER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (178, 'affinity', 'brickbat_vognar', 'brickbat_vognar_affinity', 4, 5, 5, 4, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (179, 'affinity', 'brute_force', 'brute_force_affinity', 4, 5, 5, 4, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (180, 'affinity', 'buzzcut', 'buzzcut_affinity', 4, 6, 5, 4, 2, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (181, 'affinity', 'crypt', 'crypt_affinity', 4, 4, 5, 4, 2, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (182, 'affinity', 'dead_man_davitz', 'dead_man_davitz_affinity', 4, 5, 6, 5, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp, giant)
    VALUES (183, 'affinity', 'dozer', 'dozer_affinity', 4, 4, 4, 5, 3, 'GUARD', true, true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (184, 'affinity', 'drake', 'drake_affinity', 4, 5, 5, 4, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (185, 'affinity', 'the_enforcer', 'the_enforcer_affinity', 4, 7, 4, 3, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (186, 'affinity', 'the_excavator', 'the_excavator_affinity', 4, 4, 6, 5, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (187, 'affinity', 'firewall', 'firewall_affinity', 3, 5, 4, 5, 3, 'KEEPER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (188, 'affinity', 'galdo', 'galdo_affinity', 4, 6, 4, 4, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (189, 'affinity', 'gorim_ironstone', 'gorim_ironstone_affinity', 5, 5, 4, 4, 3, 'STRIKER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (190, 'affinity', 'grak', 'grak_affinity', 4, 5, 6, 4, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (191, 'affinity', 'hector_weiss', 'hector_weiss_affinity', 4, 4, 3, 4, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (192, 'affinity', 'irsala', 'irsala_affinity', 4, 5, 4, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (193, 'affinity', 'john_doe', 'john_doe_affinity', 4, 4, 5, 4, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (194, 'affinity', 'jonathan_gabe_gabriel', 'jonathan_gabe_gabriel_affinity', 4, 5, 4, 4, 3, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (195, 'affinity', 'kailasa', 'kailasa_affinity', 4, 6, 4, 3, 4, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (196, 'affinity', 'kryphos', 'kryphos_affinity', 4, 5, 3, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (197, 'affinity', 'lucky_logan', 'lucky_logan_affinity', 4, 6, 3, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (198, 'affinity', 'ludwig', 'ludwig_affinity', 4, 6, 4, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (199, 'affinity', 'lyra_the_fixer', 'lyra_the_fixer_affinity', 4, 6, 5, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (200, 'affinity', 'mee_kel_judwan', 'mee_kel_judwan_affinity', 5, 6, 3, 3, 5, 'STRIKER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (201, 'affinity', 'mellisandra', 'mellisandra_affinity', 4, 5, 4, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (202, 'affinity', 'mzei_kein', 'mzei_kein_affinity', 4, 5, 5, 4, 4, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (203, 'affinity', 'nightshade', 'nightshade_affinity', 5, 6, 4, 3, 4, 'STRIKER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (204, 'affinity', 'number_88', 'number_88_affinity', 4, 8, 4, 2, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (205, 'affinity', 'phantasm', 'phantasm_affinity', 4, 6, 4, 3, 3, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (206, 'affinity', 'the_praetorian', 'the_praetorian_affinity', 5, 6, 3, 4, 4, 'STRIKER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (207, 'affinity', 'reek_rolat', 'reek_rolat_affinity', 4, 5, 6, 3, 3, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (208, 'affinity', 'rico_van_dien', 'rico_van_dien_affinity', 5, 6, 3, 4, 4, 'STRIKER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (209, 'affinity', 'riller', 'riller_affinity', 4, 5, 4, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (210, 'affinity', 'schnorkel', 'schnorkel_affinity', 4, 4, 5, 4, 4, 'GUARD', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (211, 'affinity', 'slippery_joe', 'slippery_joe_affinity', 5, 5, 4, 3, 5, 'STRIKER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (212, 'affinity', 'thunder_chris', 'thunder_chris_affinity', 4, 6, 4, 3, 3, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (213, 'affinity', 'tycho_brahe', 'tycho_brahe_affinity', 4, 6, 4, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (214, 'affinity', 'the_veteran', 'the_veteran_affinity', 5, 5, 4, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (215, 'affinity', 'wildcard', 'wildcard_affinity', 4, 6, 4, 3, 4, 'JACK', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (216, 'affinity', 'wyn_grethzki', 'wyn_grethzki_affinity', 5, 5, 3, 4, 5, 'STRIKER', true);
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, mvp)
    VALUES (217, 'affinity', 'yurik_yurikson', 'yurik_yurikson_affinity', 4, 4, 4, 5, 3, 'GUARD', true);

-- --------------
-- Affinity players
-- --------------

-- Ada-Lorana
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (100, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (101, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (102, 23, 15, 10);

-- Asterians
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (103, 15, 10, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (104, 15, 10, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (105, 20, 13, 8);

-- Kalyshi
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (106, 17, 11, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (107, 23, 15, 10);

-- Convicts
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (108, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (109, 9, 6, 4);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (110, 12, 8, 5);

-- Crystallans
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (111, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (112, 15, 10, 7);

-- Forge fathers
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (113, 20, 13, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (114, 14, 9, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (115, 14, 9, 6);

-- Brokkr
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (116, 21, 14, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (117, 14, 9, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (118, 12, 8, 6);

-- Hobgoblins
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (119, 30, 20, 13);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (120, 14, 9, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (121, 17, 11, 8);

-- Humans (male)
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (122, 15, 10, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (123, 12, 8, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (124, 15, 10, 7);

-- Humans (female)
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (125, 15, 10, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (126, 14, 9, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (127, 15, 10, 7);

-- Judwan
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (128, 23, 15, 10);

-- Koris
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (129, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (130, 17, 11, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (131, 17, 11, 8);

-- Marauders
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (132, 20, 13, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (133, 14, 9, 6);

-- Martians
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (134, 15, 10, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (135, 12, 8, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (136, 15, 10, 7);

-- Nameless
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (137, 14, 9, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (138, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (139, 20, 13, 8);

-- Rebs
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (140, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (141, 20, 13, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (142, 15, 10, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (143, 23, 15, 10);

-- Robots
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (144, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (145, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (146, 21, 14, 9);

-- Sphyr
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (147, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (148, 14, 9, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (149, 18, 12, 8);

-- Teratons
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (150, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (151, 15, 10, 7);

-- Tsudochan
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (152, 15, 10, 7);

-- Veer-Myn
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (153, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (154, 17, 11, 8);

-- Zees
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (155, 11, 7, 5);

-- Z'zor
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (156, 26, 17, 12);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (157, 14, 9, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (158, 17, 11, 8);

-- Other players
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (159, 14, 9, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (160, 24, 16, 11);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (161, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (162, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (163, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (164, 17, 11, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (165, 24, 16, 11);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (166, 11, 7, 5);

-- Giants
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (167, 45, 30, 20);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (168, 41, 27, 18);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (169, 44, 29, 19);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (170, 35, 23, 15);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (171, 48, 32, 21);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (172, 41, 27, 18);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (173, 48, 32, 21);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (174, 44, 29, 19);

-- MVPs
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (175, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (176, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (177, 27, 18, 12);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (178, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (179, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (180, 26, 17, 11);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (181, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (182, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (183, 44, 29, 19);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (184, 27, 18, 12);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (185, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (186, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (187, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (188, 14, 9, 6);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (189, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (190, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (191, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (192, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (193, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (194, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (195, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (196, 35, 23, 15);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (197, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (198, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (199, 17, 11, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (200, 27, 18, 12);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (201, 26, 17, 11);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (202, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (203, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (204, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (205, 26, 17, 11);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (206, 26, 17, 11);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (207, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (208, 27, 18, 12);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (209, 23, 15, 10);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (210, 9, 6, 4);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (211, 17, 11, 7);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (212, 27, 18, 12);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (213, 18, 12, 8);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (214, 27, 18, 12);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (215, 21, 14, 9);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (216, 26, 17, 11);
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES (217, 26, 17, 11);

-- --------------
-- Unit abilities
-- --------------

-- Ada-Lorana: phaser
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (100, 41);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (101, 41);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (102, 41);

-- Asterian guard: poison blade
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (103, 43);

-- Asterian jack: fragile, poison blade
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (104, 20);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (104, 43);

-- Asterian striker: fragile blade
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (105, 20);

-- Kalyshi jack: backstab, shove
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (106, 6);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (106, 62);

-- Kalyshi striker: jump
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (107, 28);

-- Convicts: explosive collar
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (108, 18);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (109, 18);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (110, 18);

-- Convict guard: threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (108, 75);

-- Crystallans: harmonics
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (111, 23);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (112, 23);

-- Forge father guard: steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (113, 68);

-- Brokkr: steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (116, 68);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (117, 68);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (118, 68);

-- Brokkr striker: grizzled
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (118, 22);

-- Hulk guard: mighty, steady, trail blazer
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (119, 33);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (119, 68);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (119, 78);

-- Hobgoblins: stench
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (120, 69);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (121, 69);

-- Human (female) jack: running interference
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (123, 60);

-- Judwan: pacifist, long arms, misdirect
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (128, 40);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (128, 31);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (128, 36);

-- Koris: spinner
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (129, 67);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (130, 67);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (131, 67);

-- Koris guard: gotcha
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (129, 21);

-- Koris jack: portal
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (130, 44);

-- Martians: ray gun
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (134, 52);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (135, 52);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (136, 52);

-- Nameless sticky guard: gotcha
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (137, 21);

-- Nameless hard guard: can't feel a thing, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (138, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (138, 68);

-- Nameless striker: a safe pair of hands
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (139, 3);

-- Rin guard: pummel
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (140, 47);

-- Gaelian jack: charge
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (141, 9);

-- Sorak jack: a safe pair of hands
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (142, 3);

-- Ralarat striker: jump, slippery customer
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (143, 28);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (143, 65);

-- Robots: quick change artist
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (144, 49);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (145, 49);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (146, 49);

-- Sphyr: tail
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (147, 72);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (148, 72);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (149, 72);

-- Teratons: teleport
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (150, 74);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (151, 74);

-- Tsudochan: push
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (152, 48);

-- Zees: runaround, duck & weave
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (155, 59);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (155, 16);

-- Z'zor: can't feel a thing
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (156, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (157, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (158, 8);

-- Z'zor guard: steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (156, 68);

-- Other players, avaran treebeast: can't feel a thing, tongue
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (159, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (159, 76);

-- Other players, jetari brawler: can't feel a thing, grizzled
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (160, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (160, 22);

-- Other players, jetari thrower: 360 vision, a safe pair of hands
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (161, 1);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (161, 3);

-- Other players, nameless bloodsucker: poison blade, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (162, 43);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (162, 68);

-- Other players, pusk rampager: ram, resilient
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (163, 51);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (163, 54);

-- Other players, vlorox spinpede: can't feel a thing, rolling
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (164, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (164, 57);

-- Other players, yndij reaver: backflip, duck and weave, jump
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (165, 5);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (165, 16);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (165, 28);

-- Other players, zee buccaneer: duck and weave, runaround
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (166, 16);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (166, 59);

-- Giant, Alpha Simian: show off, stretch, threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (167, 63);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (167, 70);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (167, 75);

-- Giant, Barricade: comin' through, stretch, threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (168, 10);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (168, 70);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (168, 75);

-- Giant, Big Mech: can't feel a thing, show off, threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (169, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (169, 63);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (169, 75);

-- Giant, Chovar: mind control, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (170, 34);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (170, 68);

-- Giant, Iron Ancestor: can't feel a thing
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (171, 8);

-- Giant, Krastavor: steady, stretch, threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (172, 68);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (172, 70);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (172, 75);

-- Giant, Nameless Spawn: gotcha, threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (173, 21);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (173, 75);

-- Giant, Sann-gar:  threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (174, 75);

-- MVPs, Anne-Marie Helder: grizzled, prima donna
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (175, 22);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (175, 46);

-- MVPs, Asylum: backstab
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (176, 6);

-- MVPs, A'Teo Adysi: 360 vision, backflip, duck and weave, jump
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (177, 1);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (177, 5);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (177, 16);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (177, 28);

-- MVPs, 'Brickbat' Vognar: lucky, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (178, 32);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (178, 68);

-- MVPs, Brute Force: trail blazer
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (179, 78);

-- MVPs, Buzzcut: can't feel a thing, grizzled
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (180, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (180, 22);

-- MVPs, Crypt: harmonic, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (181, 23);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (181, 68);

-- MVPs, Dead Man Davitz: can't feel a thing, grizzled
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (182, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (182, 22);

-- MVPs, Dozer: teleport, threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (183, 74);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (183, 75);

-- MVPs, Drake: can't feel a thing, quick recovery, really lucky, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (184, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (184, 50);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (184, 53);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (184, 68);

-- MVPs, The Enforcer: backflip, jump
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (185, 5);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (185, 28);

-- MVPs, The Excavator: can't feel a thing, driller, grizzled, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (186, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (186, 14);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (186, 22);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (186, 68);

-- MVPs, Firewall: lucky, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (187, 32);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (187, 68);

-- MVPs, Galdo: 360 vision, quick recovery, stubborn
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (188, 1);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (188, 50);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (188, 71);

-- MVPs, Gorim Ironstone: grizzled, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (189, 22);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (189, 68);

-- MVPs, Grak: pile-driver, uncontrolled
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (190, 42);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (190, 80);

-- MVPs, Hector Weiss: a safe pair of hands, grizzled, running interference
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (191, 3);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (191, 22);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (191, 60);

-- MVPs, Irsala: alert, gotcha, steady, toxic
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (192, 4);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (192, 21);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (192, 68);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (192, 79);

-- MVPs, John Doe: gotcha
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (193, 21);

-- MVPs, Jonathan 'Gabe' Gabriel: show off
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (194, 63);

-- MVPs, Kailasa: backstab
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (195, 6);

-- MVPs, Kryphos: crowd puller, gotcha, spinner, portal master
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (196, 11);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (196, 21);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (196, 67);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (196, 45);

-- MVPs, 'Lucky' Logan: really lucky
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (197, 53);

-- MVPs, Ludwig: can't feel a thing, jump
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (198, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (198, 28);

-- MVPs, Lyra the Fixer: backstab, jump, stretch
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (199, 6);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (199, 28);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (199, 70);

-- MVPs, Mee-Kel Judwan: 360 vision, can't feel a thing, long arms, misdirect, pacifist
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (200, 1);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (200, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (200, 31);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (200, 40);

-- MVPs, Mellisandra: poison blade, stretch
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (201, 43);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (201, 70);

-- MVPs, M'zei Kein: 360 vision, grizzled, push
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (202, 1);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (202, 22);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (202, 48);

-- MVPs, Nightshade: poison blade
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (203, 43);

-- MVPs, Number 88: jump, mind like water
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (204, 28);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (204, 35);

-- MVPs, Phantasm: phaser
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (205, 41);

-- MVPs, The Praetorian: a safe pair of hands, can't feel a thing
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (206, 3);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (206, 8);

-- MVPs, Reek Rolat: can't feel a thing
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (207, 8);

-- MVPs, Rico Van Dien: jump, show off
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (208, 28);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (208, 63);

-- MVPs, Riller: show off
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (209, 63);

-- MVPs, Schnorkel: can't feel a thing, fan favourite, klutz, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (210, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (210, 19);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (210, 30);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (210, 68);

-- MVPs, Slippery Joe: a safe pair of hands, jump
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (211, 3);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (211, 28);

-- MVPs, Thunder Chris: 360 vision, even the odds, grizzled, threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (212, 1);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (212, 17);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (212, 22);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (212, 75);

-- MVPs, Tycho Brahe: threatening
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (213, 75);

-- MVPs, The Veteran: duck and weave, grizzled, quick recovery
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (214, 16);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (214, 22);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (214, 50);

-- MVPs, Wildcard: even the odds
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (215, 17);

-- MVPs, Wyn Greth'zky: alert, duck and weave
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (216, 4);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (216, 16);

-- MVPs, Yurik Yurikson: 360 vision, can't feel a thing, quick recovery, steady
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (217, 1);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (217, 8);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (217, 50);
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES (217, 68);

-- ---------------
-- Unit affinities
-- ---------------

-- Ada-Lorana: proud
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (100, 18);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (101, 18);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (102, 18);

-- Ada-Lorana guard: guard
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (100, 9);

-- Ada-Lorana jack: jack
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (101, 12);

-- Ada-Lorana striker: striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (102, 22);

-- Asterian: cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (103, 5);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (104, 5);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (105, 5);

-- Asterian guard: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (103, 25);

-- Asterian jack: asterian
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (104, 2);

-- Asterian striker: striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (104, 22);

-- Kalyshi: asterian
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (106, 2);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (107, 2);

-- Kalyshi jack: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (106, 25);

-- Kalyshi striker: big picture
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (107, 3);

-- Convicts: convict
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (108, 4);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (109, 4);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (110, 4);

-- Convict guard: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (108, 25);

-- Convict jack: greedy
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (109, 8);

-- Convict striker: cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (110, 5);

-- Crystallans: proud
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (111, 18);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (112, 18);

-- Crystallan guard: guard
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (111, 9);

-- Crystallan jack: alien
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (111, 1);

-- Forge fathers: forge father
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (113, 7);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (114, 7);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (115, 7);

-- Forge father guard: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (113, 25);

-- Forge father jack: dreadball
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (114, 6);

-- Forge father striker: striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (114, 22);

-- Brokkrs: forge father
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (116, 7);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (117, 7);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (118, 7);

-- Brokkr guard: guard
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (116, 9);

-- Brokkr jack: worker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (117, 27);

-- Brokkr striker: cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (118, 5);

-- Hobgoblin hulk guard: psycho, vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (119, 19);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (119, 25);

-- Hobgoblin: outcast
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (120, 19);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (121, 19);

-- Hobgoblin jack: greedy
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (120, 8);

-- Hobgoblin striker: cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (121, 5);

-- Human (male): dreadball
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (122, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (123, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (124, 6);

-- Human (male) guard: guard
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (122, 9);

-- Human (male) jack: jack
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (123, 12);

-- Human (male) striker: striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (124, 22);

-- Human (female): dreadball
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (125, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (126, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (127, 6);

-- Human (female) guard: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (125, 25);

-- Human (female) jack: cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (126, 5);

-- Human (female) striker: striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (127, 22);

-- Judwan: proud, striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (128, 18);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (128, 22);

-- Koris guard: hunter, vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (129, 10);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (129, 25);

-- Koris jack: alien, tech guy
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (130, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (130, 23);

-- Koris jack: cunning, tech guy
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (131, 5);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (131, 23);

-- Marauder guard: guard, psycho
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (132, 9);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (132, 19);

-- Marauder jack: outcast, worker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (133, 15);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (133, 27);

-- Martians: vicious, weird science, alien
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (134, 25);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (134, 26);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (134, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (135, 25);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (135, 26);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (135, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (136, 25);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (136, 26);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (136, 1);

-- Nameless: alien
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (137, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (138, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (139, 1);

-- Nameless sticky guard: cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (137, 5);

-- Nameless hard guard: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (138, 25);

-- Nameless striker: striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (139, 22);

-- Rebs: rebel
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (140, 20);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (141, 20);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (142, 20);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (143, 20);

-- Reb rin guard: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (140, 25);

-- Reb gaelian jack: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (141, 15);

-- Reb sorak jack: alien
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (142, 1);

-- Reb raralat striker: cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (143, 5);

-- Robots: mr roboto, tech guys
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (144, 14);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (144, 23);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (145, 14);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (145, 23);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (146, 14);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (146, 23);

-- Sphyr: dreadball
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (147, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (148, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (149, 6);

-- Sphyr guard: hunter
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (147, 10);

-- Sphyr jack: proud
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (148, 18);

-- Sphyr striker: alien
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (148, 1);

-- Teraton: alien
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (150, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (151, 1);

-- Teraton guard: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (150, 25);

-- Teraton jack: proud
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (151, 18);

-- Tsudochan: alien, weird science
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (152, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (152, 26);

-- Veer-myn: outcast
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (153, 15);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (154, 15);

-- Veer-myn guard: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (153, 25);

-- Veer-myn striker: striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (154, 22);

-- Zees: pirate, cunning, weird science
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (155, 16);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (155, 5);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (155, 26);

-- Z'zor: insectoid
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (156, 11);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (157, 11);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (158, 11);

-- Z'zor guard: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (156, 25);

-- Z'zor jack: worker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (157, 27);

-- Z'zor jack: cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (158, 5);

-- Other players, avaran treebeast: hunter, plant
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (159, 10);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (159, 17);

-- Other players, jetari brawler: dreadball, guard, mr roboto
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (160, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (160, 9);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (160, 14);

-- Other players, jetari thrower: dreadball, mr roboto, striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (161, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (161, 14);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (161, 22);

-- Other players, nameless bloodsucker: alien, insectoid, vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (162, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (162, 11);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (162, 25);

-- Other players, pusk rampager: hunter, psycho
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (163, 10);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (163, 19);

-- Other players, vlorox spinpede: alien, reluctant
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (164, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (164, 21);

-- Other players, yndij reaver: alien, rebel, striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (165, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (164, 20);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (164, 22);

-- Other players, zee buccaneer: cunning, pirate
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (166, 5);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (166, 16);

-- Giant, Alpha Simian: alien, hunter, reluctant
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (167, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (167, 10);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (167, 21);

-- Giant, Barricade: mr roboto, tech guys, vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (168, 14);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (168, 23);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (168, 25);

-- Giant, Big Mech: mr roboto, reluctant, weird science
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (169, 14);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (169, 21);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (169, 26);

-- Giant, Chovar: alien, outcast, reluctant
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (170, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (170, 15);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (170, 21);

-- Giant, Iron Ancestor: forge father, vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (171, 7);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (171, 25);

-- Giant, Krastavor: insectoid, mr roboto
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (172, 11);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (172, 14);

-- Giant, Nameless Spawn: alien, hunter, outcast
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (173, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (173, 10);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (173, 15);

-- Giant, Sann-gar: cunning, hunter, outcast
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (174, 5);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (174, 10);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (174, 15);

-- MVPs, Anne-Marie Helder: striker, worker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (175, 22);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (175, 27);

-- MVPs, Asylum: convict, vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (176, 4);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (176, 25);

-- MVPs, A'Teo Adysi: proud, hunter
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (177, 18);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (177, 10);

-- MVPs, 'Brickbat' Vognar: pirate, convict
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (178, 16);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (178, 4);

-- MVPs, Brute Force: mr roboto, rebel
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (179, 14);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (179, 20);

-- MVPs, Buzzcut: vicious, psycho
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (180, 25);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (180, 19);

-- MVPs, Crypt: vicious, proud
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (181, 25);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (181, 18);

-- MVPs, Dead Man Davitz: vat brothers, weird science
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (182, 24);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (182, 26);

-- MVPs, Dozer: vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (183, 25);

-- MVPs, Drake: dreadball, tech guys
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (184, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (184, 23);

-- MVPs, The Enforcer: vicious, guard
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (185, 25);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (185, 9);

-- MVPs, The Excavator: forge father, worker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (186, 7);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (186, 27);

-- MVPs, Firewall: machine mind, tech guys
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (187, 13);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (187, 23);

-- MVPs, Galdo: rebel, weird science
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (188, 20);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (188, 26);

-- MVPs, Gorim Ironstone: forge father, worker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (189, 7);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (189, 27);

-- MVPs, Grak: psycho, guard
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (190, 19);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (190, 9);

-- MVPs, Hector Weiss: dreadball, jack
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (191, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (191, 12);

-- MVPs, Irsala: alien, cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (192, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (192, 5);

-- MVPs, John Doe: alien, guard
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (193, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (193, 9);

-- MVPs, Jonathan 'Gabe' Gabriel: dreadball, cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (194, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (194, 5);

-- MVPs, Kailasa: asterian, big picture
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (195, 2);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (195, 3);

-- MVPs, Kryphos: alien, jack
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (196, 1);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (196, 12);

-- MVPs, 'Lucky' Logan: jack, cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (197, 12);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (197, 5);

-- MVPs, Ludwig: insectoid, alien
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (198, 11);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (198, 1);

-- MVPs, Lyra the Fixer: convict, cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (199, 4);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (199, 5);

-- MVPs, Mee-Kel Judwan: outcast, big picture, proud
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (200, 15);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (200, 3);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (200, 18);

-- MVPs, Mellisandra: asterian, vicious
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (201, 2);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (201, 25);

-- MVPs, M'Zei Kein: vicious, cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (202, 25);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (202, 5);

-- MVPs, Nightshade: proud, psycho
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (203, 18);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (203, 19);

-- MVPs, Number 88: vat brothers, outcast
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (204, 24);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (204, 15);

-- MVPs, Phantasm: big picture, outcast
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (205, 3);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (205, 15);

-- MVPs, The Praetorian: asterian, striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (206, 2);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (206, 22);

-- MVPs, Reek Rolat: hunter, psycho
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (207, 19);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (207, 10);

-- MVPs, Riller: weird science, cunning
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (208, 26);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (208, 5);

-- MVPs, Schornkel: proud, alien
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (209, 18);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (209, 1);

-- MVPs, Slippery Joe: cunning, striker
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (210, 5);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (210, 22);

-- MVPs, Thunder Chris: dreadball, jack
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (211, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (211, 12);

-- MVPs, Tycho Brahe: dreadball, psycho
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (212, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (212, 19);

-- MVPs, The Veteran: dreadball, jack
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (213, 6);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (213, 12);

-- MVPs, Wildcard: asterian, jack, big picture
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (214, 2);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (214, 12);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (214, 3);

-- MVPs, Wyn Greth'zki: machine-mind, striker, dreadball
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (215, 13);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (215, 22);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (215, 6);

-- MVPs, Yurik Yurikson: forge father, guard
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (216, 7);
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES (216, 9);

-- ---------------------
-- Unit hated affinities
-- ---------------------

-- Crystallans: hates forge fathers
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (111, 7);
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (112, 7);

-- Giant, Alpha Simian: hates dreadball
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (167, 6);

-- MVPs, Dozer: hates striker
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (183, 22);

-- MVPs, The Excavator: hates asterian
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (186, 2);

-- MVPs, Mellisandra: hates proud
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (201, 18);

-- MVPs, Nightshade: hates asterian
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (203, 2);

-- MVPs, The Praetorian: hates mr roboto
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (206, 14);

-- MVPs, Wyn Greth'zki: hates tech guys
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES (215, 23);

-- -------------------------
-- Affinities availabilities
-- -------------------------

-- Sponsor affinities groups
INSERT INTO AFFINITY_SETS (id, name, rank_increase) VALUES (1, 'A', true);
INSERT INTO AFFINITY_SETS (id, name, rank_increase) VALUES (2, 'B', true);
INSERT INTO AFFINITY_SETS (id, name, rank_increase) VALUES (3, 'C', false);
INSERT INTO AFFINITY_SETS (id, name, rank_increase) VALUES (4, 'D', true);
INSERT INTO AFFINITY_SETS (id, name, rank_increase) VALUES (5, 'E', false);

-- Group A affinities: alien, cunning, plant, reluctant, striker
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (1, 1);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (1, 5);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (1, 17);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (1, 21);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (1, 22);

-- Group B affinities: dreadball, big picture, psycho, rebel, worker
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (2, 6);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (2, 3);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (2, 19);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (2, 20);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (2, 27);

-- Group C affinities: asterian, convict, forge father, guard, tech guys, vat brothers
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (3, 2);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (3, 4);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (3, 7);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (3, 9);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (3, 23);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (3, 24);

-- Group D affinities: insectoid, jack, mr roboto, proud, vicious
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (4, 11);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (4, 12);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (4, 14);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (4, 18);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (4, 25);

-- Group E affinities: greedy, hunter, machine mind, outcast, pirate, weird science
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (5, 8);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (5, 10);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (5, 13);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (5, 15);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (5, 16);
INSERT INTO AFFINITY_OPTIONS (sponsor_affinity_ava_id, affinity_id) VALUES (5, 26);
