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

INSERT INTO AFFINITY_GROUPS (id, name) VALUES
   (1, 'alien'),
   (2, 'asterian'),
   (3, 'big_picture'),
   (4, 'convict'),
   (5, 'cunning'),
   (6, 'dreadball'),
   (7, 'forge_father'),
   (8, 'greedy'),
   (9, 'guard'),
   (10, 'hunter'),
   (11, 'insectoid'),
   (12, 'jack'),
   (13, 'machine_mind'),
   (14, 'mr_roboto'),
   (15, 'outcast'),
   (16, 'pirate'),
   (17, 'plant'),
   (18, 'proud'),
   (19, 'psycho'),
   (20, 'rebel'),
   (21, 'reluctant'),
   (22, 'striker'),
   (23, 'tech_guys'),
   (24, 'vat_brothers'),
   (25, 'vicious'),
   (26, 'weird_science'),
   (27, 'worker');

-- ****************************************
--                 UNITS
-- ****************************************


-- ---------
-- DBX players
-- ---------

-- Ada-Lorana
INSERT INTO PLAYERS (id, player_type, name, template_name, armor, movement, skill, speed, strength, role, giant, mvp) VALUES
   (100, 'affinity', 'ada_lorana_guard',        'ada_lorana_guard_affinity',        4, 5, 4, 3, 4, 'GUARD',    false, false),
   (101, 'affinity', 'ada_lorana_jack',         'ada_lorana_jack_affinity',         5, 5, 4, 3, 4, 'JACK',     false, false),
   (102, 'affinity', 'ada_lorana_striker',      'ada_lorana_striker_affinity',      5, 5, 4, 3, 4, 'STRIKER',  false, false),

-- Asterians
   (103, 'affinity', 'asterian_guard',          'asterian_guard_affinity',          4, 6, 4, 3, 5, 'GUARD',    false, false),
   (104, 'affinity', 'asterian_jack',           'asterian_jack_affinity',           5, 6, 4, 3, 5, 'JACK',     false, false),
   (105, 'affinity', 'asterian_striker',        'asterian_striker_affinity',        5, 6, 4, 3, 5, 'STRIKER',  false, false),

-- Kalyshi
   (106, 'affinity', 'kalyshi_jack',            'kalyshi_jack_affinity',            5, 6, 4, 3, 5, 'JACK',     false, false),
   (107, 'affinity', 'kalyshi_striker',         'kalyshi_striker_affinity',         5, 6, 4, 3, 5, 'STRIKER',  false, false),

-- Convicts
   (108, 'affinity', 'convict_guard',           'convict_guard_affinity',           4, 5, 5, 4, 3, 'GUARD',    false, false),
   (109, 'affinity', 'convict_jack',            'convict_jack_affinity',            5, 5, 5, 4, 4, 'JACK',     false, false),
   (110, 'affinity', 'convict_striker',         'convict_striker_affinity',         6, 5, 4, 4, 4, 'STRIKER',  false, false),

-- Crystallans
   (111, 'affinity', 'crystallan_guard',        'crystallan_guard_affinity',        4, 4, 5, 3, 5, 'GUARD',    false, false),
   (112, 'affinity', 'crystallan_jack',         'crystallan_jack_affinity',         5, 4, 5, 3, 5, 'JACK',     false, false),

-- Forge fathers
   (113, 'affinity', 'forge_father_guard',      'forge_father_guard_affinity',      4, 4, 4, 5, 3, 'GUARD',    false, false),
   (114, 'affinity', 'forge_father_jack',       'forge_father_jack_affinity',       4, 4, 4, 5, 3, 'JACK',     false, false),
   (115, 'affinity', 'forge_father_striker',    'forge_father_striker_affinity',    5, 4, 4, 5, 3, 'STRIKER',  false, false),

-- Brokkr
   (116, 'affinity', 'brokr_guard',             'brokr_guard_affinity',             4, 4, 4, 5, 3, 'GUARD',    false, false),
   (117, 'affinity', 'brokr_jack',              'brokr_jack_affinity',              5, 4, 4, 5, 3, 'JACK',     false, false),
   (118, 'affinity', 'brokr_striker',           'brokr_striker_affinity',           5, 4, 4, 5, 3, 'STRIKER',  false, false),

-- Hobgoblins
   (119, 'affinity', 'hulk_guard',              'hulk_guard_affinity',              4, 5, 5, 5, 3, 'GUARD',    false, false),
   (120, 'affinity', 'hobgoblin_jack',          'hobgoblin_jack_affinity',          5, 5, 5, 4, 4, 'JACK',     false, false),
   (121, 'affinity', 'hobgoblin_striker',       'hobgoblin_striker_affinity',       5, 5, 5, 4, 4, 'STRIKER',  false, false),

-- Humans (male)
   (122, 'affinity', 'human_male_guard',        'human_male_guard_affinity',        4, 5, 4, 4, 4, 'GUARD',    false, false),
   (123, 'affinity', 'human_male_jack',         'human_male_jack_affinity',         5, 5, 4, 4, 4, 'JACK',     false, false),
   (124, 'affinity', 'human_male_striker',      'human_male_striker_affinity',      5, 5, 4, 4, 4, 'STRIKER',  false, false),

-- Humans (female)
   (125, 'affinity', 'human_female_guard',      'human_female_guard_affinity',      4, 5, 4, 4, 4, 'GUARD',    false, false),
   (126, 'affinity', 'human_female_jack',       'human_female_jack_affinity',       5, 5, 4, 4, 4, 'JACK',     false, false),
   (127, 'affinity', 'human_female_striker',    'human_female_striker_affinity',    5, 5, 4, 4, 4, 'STRIKER',  false, false),

-- Judwan
   (128, 'affinity', 'judwan_striker',          'judwan_striker_affinity',          5, 6, 4, 4, 5, 'STRIKER',  false, false),

-- Koris
   (129, 'affinity', 'koris_guard',             'koris_guard_affinity',             4, 4, 4, 4, 4, 'GUARD',    false, false),
   (130, 'affinity', 'koris_jack',              'koris_jack_affinity',              5, 4, 4, 4, 4, 'JACK',     false, false),
   (131, 'affinity', 'koris_striker',           'koris_striker_affinity',           5, 4, 4, 4, 4, 'STRIKER',  false, false),

-- Marauders
   (132, 'affinity', 'marauder_guard',          'marauder_guard_affinity',          4, 5, 5, 4, 3, 'GUARD',    false, false),
   (133, 'affinity', 'marauder_jack',           'marauder_jack_affinity',           5, 5, 4, 3, 5, 'STRIKER',  false, false),

-- Martians
   (134, 'affinity', 'martian_guard',           'martian_guard_affinity',           4, 5, 5, 4, 4, 'GUARD',    false, false),
   (135, 'affinity', 'martian_jack',            'martian_jack_affinity',            5, 5, 5, 4, 4, 'JACK',     false, false),
   (136, 'affinity', 'martian_striker',         'martian_striker_affinity',         5, 5, 5, 4, 4, 'STRIKER',  false, false),

-- Nameless
   (137, 'affinity', 'nameless_guard_sticky',   'nameless_guard_sticky_affinity',   4, 4, 5, 4, 4, 'GUARD',    false, false),
   (138, 'affinity', 'nameless_guard_hard',     'nameless_guard_hard_affinity',     4, 5, 4, 5, 3, 'GUARD',    false, false),
   (139, 'affinity', 'nameless_striker',        'nameless_striker_affinity',        5, 6, 4, 4, 4, 'STRIKER',  false, false),

-- Rebs
   (140, 'affinity', 'rin_guard',               'rin_guard_affinity',               4, 5, 5, 4, 4, 'GUARD',    false, false),
   (141, 'affinity', 'gaelian_jack',            'gaelian_jack_affinity',            5, 7, 4, 4, 4, 'JACK',     false, false),
   (142, 'affinity', 'sorak_jack',              'sorak_jack_affinity',              5, 5, 4, 3, 4, 'JACK',     false, false),
   (143, 'affinity', 'ralarat_striker',         'ralarat_striker_affinity',         5, 6, 3, 4, 5, 'STRIKER',  false, false),

-- Robots
   (144, 'affinity', 'robot_guard',             'robot_guard_affinity',             4, 5, 4, 5, 3, 'GUARD',    false, false),
   (145, 'affinity', 'robot_jack',              'robot_jack_affinity',              4, 6, 4, 4, 4, 'JACK',     false, false),
   (146, 'affinity', 'robot_striker',           'robot_striker_affinity',           5, 5, 4, 3, 5, 'STRIKER',  false, false),

-- Sphyr
   (147, 'affinity', 'sphyr_guard',             'sphyr_guard_affinity',             4, 6, 4, 4, 4, 'GUARD',    false, false),
   (148, 'affinity', 'sphyr_jack',              'sphyr_jack_affinity',              5, 6, 4, 4, 4, 'JACK',     false, false),
   (149, 'affinity', 'sphyr_striker',           'sphyr_striker_affinity',           5, 6, 4, 4, 4, 'STRIKER',  false, false),

-- Teratons
   (150, 'affinity', 'teraton_guard',           'teraton_guard_affinity',           4, 5, 4, 5, 3, 'GUARD',    false, false),
   (151, 'affinity', 'teraton_jack',            'teraton_jack_affinity',            4, 5, 4, 5, 3, 'JACK',     false, false),

-- Tsudochan
   (152, 'affinity', 'tsudochan_jack',          'tsudochan_jack_affinity',          5, 5, 4, 4, 5, 'JACK',     false, false),

-- Veer-Myn
   (153, 'affinity', 'veer_myn_guard',          'veer_myn_guard_affinity',          4, 6, 5, 3, 4, 'GUARD',    false, false),
   (154, 'affinity', 'veer_myn_striker',        'veer_myn_striker_affinity',        5, 6, 5, 3, 4, 'STRIKER',  false, false),

-- Zees
   (155, 'affinity', 'zee_jack',                'zee_jack_affinity',                5, 5, 5, 3, 5, 'JACK',     false, false),

-- Z'zor
   (156, 'affinity', 'zzor_guard',              'zzor_guard_affinity',              4, 5, 5, 4, 3, 'GUARD',    false, false),
   (157, 'affinity', 'zzor_jack',               'zzor_jack_affinity',               5, 5, 4, 4, 4, 'JACK',     false, false),
   (158, 'affinity', 'zzor_striker',            'zzor_striker_affinity',            5, 6, 5, 4, 4, 'STRIKER',  false, false),

-- Other players
   (159, 'affinity', 'avaran_treebeast',        'avaran_treebeast_affinity',        4, 3, 4, 5, 3, 'JACK',     false, false),
   (160, 'affinity', 'jetari_brawler',          'jetari_brawler_affinity',          3, 4, 5, 4, 3, 'GUARD',    false, false),
   (161, 'affinity', 'jetari_thrower',          'jetari_thrower_affinity',          4, 5, 3, 4, 5, 'STRIKER',  false, false),
   (162, 'affinity', 'nameless_bloodsucker',    'nameless_bloodsucker_affinity',    4, 6, 5, 3, 4, 'JACK',     false, false),
   (163, 'affinity', 'pusk_rampager',           'pusk_rampager_affinity',           4, 4, 4, 6, 4, 'GUARD',    false, false),
   (164, 'affinity', 'vlorox_spinpede',         'vlorox_spinpede_affinity',         4, 4, 4, 5, 3, 'STRIKER',  false, false),
   (165, 'affinity', 'yndij_reaver',            'yndij_reaver_affinity',            5, 6, 4, 3, 4, 'STRIKER',  false, false),
   (166, 'affinity', 'zee_buccaneer',           'zee_buccaneer_affinity',           5, 5, 5, 3, 5, 'JACK',     false, false),

-- Giants
   (167, 'affinity', 'alpha_simian',            'alpha_simian_affinity',            5, 5, 4, 3, 4, 'JACK',     true, false),
   (168, 'affinity', 'barricade',               'barricade_affinity',               4, 6, 5, 3, 4, 'GUARD',    true, false),
   (169, 'affinity', 'big_mech',                'big_mech_affinity',                4, 5, 4, 4, 3, 'JACK',     true, false),
   (170, 'affinity', 'chovar',                  'chovar_affinity',                  5, 6, 4, 5, 5, 'JACK',     true, false),
   (171, 'affinity', 'iron_ancestor',           'iron_ancestor_affinity',           5, 6, 4, 5, 5, 'KEEPER',   true, false),
   (172, 'affinity', 'krastavor',               'krastavor_affinity',               4, 6, 4, 3, 4, 'JACK',     true, false),
   (173, 'affinity', 'nameless_spawn',          'nameless_spawn_affinity',          4, 5, 5, 3, 4, 'GUARD',    true, false),
   (174, 'affinity', 'sann_gar', '              sann_gar_affinity',                 4, 5, 5, 4, 3, 'KEEPER',   true, false),

-- MVPs
   (175, 'affinity', 'anne_marie_helder',       'anne_marie_helder_affinity',       4, 5, 5, 4, 3, 'GUARD',    false, true),
   (176, 'affinity', 'asylum',                  'asylum_affinity',                  4, 6, 5, 3, 4, 'GUARD',    false, true),
   (177, 'affinity', 'ateo_adysi',              'ateo_adysi_affinity',              5, 6, 5, 4, 3, 'STRIKER',  false, true),
   (178, 'affinity', 'brickbat_vognar',         'brickbat_vognar_affinity',         4, 5, 5, 4, 3, 'GUARD',    false, true),
   (179, 'affinity', 'brute_force',             'brute_force_affinity',             4, 5, 5, 4, 3, 'GUARD',    false, true),
   (180, 'affinity', 'buzzcut',                 'buzzcut_affinity',                 4, 6, 5, 4, 2, 'GUARD',    false, true),
   (181, 'affinity', 'crypt',                   'crypt_affinity',                   4, 4, 5, 4, 2, 'GUARD',    false, true),
   (182, 'affinity', 'dead_man_davitz',         'dead_man_davitz_affinity',         4, 5, 6, 5, 3, 'GUARD',    false, true),
   (183, 'affinity', 'dozer',                   'dozer_affinity',                   4, 4, 4, 5, 3, 'GUARD',    true,  true),
   (184, 'affinity', 'drake',                   'drake_affinity',                   4, 5, 5, 4, 3, 'GUARD',    false, true),
   (185, 'affinity', 'the_enforcer',            'the_enforcer_affinity',            4, 7, 4, 3, 3, 'GUARD',    false, true),
   (186, 'affinity', 'the_excavator',           'the_excavator_affinity',           4, 4, 6, 5, 3, 'GUARD',    false, true),
   (187, 'affinity', 'firewall',                'firewall_affinity',                3, 5, 4, 5, 3, 'KEEPER',   false, true),
   (188, 'affinity', 'galdo',                   'galdo_affinity',                   4, 6, 4, 4, 4, 'JACK',     false, true),
   (189, 'affinity', 'gorim_ironstone',         'gorim_ironstone_affinity',         5, 5, 4, 4, 3, 'STRIKER',  false, true),
   (190, 'affinity', 'grak',                    'grak_affinity',                    4, 5, 6, 4, 3, 'GUARD',    false, true),
   (191, 'affinity', 'hector_weiss',            'hector_weiss_affinity',            4, 4, 3, 4, 4, 'JACK',     false, true),
   (192, 'affinity', 'irsala',                  'irsala_affinity',                  4, 5, 4, 3, 4, 'JACK',     false, true),
   (193, 'affinity', 'john_doe',                'john_doe_affinity',                4, 4, 5, 4, 3, 'GUARD',    false, true),
   (194, 'affinity', 'jonathan_gabe_gabriel',   'jonathan_gabe_gabriel_affinity',   4, 5, 4, 4, 3, 'JACK',     false, true),
   (195, 'affinity', 'kailasa',                 'kailasa_affinity',                 4, 6, 4, 3, 4, 'GUARD',    false, true),
   (196, 'affinity', 'kryphos',                 'kryphos_affinity',                 4, 5, 3, 3, 4, 'JACK',     false, true),
   (197, 'affinity', 'lucky_logan',             'lucky_logan_affinity',             4, 6, 3, 3, 4, 'JACK',     false, true),
   (198, 'affinity', 'ludwig',                  'ludwig_affinity',                  4, 6, 4, 3, 4, 'JACK',     false, true),
   (199, 'affinity', 'lyra_the_fixer',          'lyra_the_fixer_affinity',          4, 6, 5, 3, 4, 'JACK',     false, true),
   (200, 'affinity', 'mee_kel_judwan',          'mee_kel_judwan_affinity',          5, 6, 3, 3, 5, 'STRIKER',  false, true),
   (201, 'affinity', 'mellisandra',             'mellisandra_affinity',             4, 5, 4, 3, 4, 'JACK',     false, true),
   (202, 'affinity', 'mzei_kein',               'mzei_kein_affinity',               4, 5, 5, 4, 4, 'GUARD',    false, true),
   (203, 'affinity', 'nightshade',              'nightshade_affinity',              5, 6, 4, 3, 4, 'STRIKER',  false, true),
   (204, 'affinity', 'number_88',               'number_88_affinity',               4, 8, 4, 2, 4, 'JACK',     false, true),
   (205, 'affinity', 'phantasm',                'phantasm_affinity',                4, 6, 4, 3, 3, 'JACK',     false, true),
   (206, 'affinity', 'the_praetorian',          'the_praetorian_affinity',          5, 6, 3, 4, 4, 'STRIKER',  false, true),
   (207, 'affinity', 'reek_rolat',              'reek_rolat_affinity',              4, 5, 6, 3, 3, 'GUARD',    false, true),
   (208, 'affinity', 'rico_van_dien',           'rico_van_dien_affinity',           5, 6, 3, 4, 4, 'STRIKER',  false, true),
   (209, 'affinity', 'riller',                  'riller_affinity',                  4, 5, 4, 3, 4, 'JACK',     false, true),
   (210, 'affinity', 'schnorkel',               'schnorkel_affinity',               4, 4, 5, 4, 4, 'GUARD',    false, true),
   (211, 'affinity', 'slippery_joe',            'slippery_joe_affinity',            5, 5, 4, 3, 5, 'STRIKER',  false, true),
   (212, 'affinity', 'thunder_chris',           'thunder_chris_affinity',           4, 6, 4, 3, 3, 'JACK',     false, true),
   (213, 'affinity', 'tycho_brahe',             'tycho_brahe_affinity',             4, 6, 4, 3, 4, 'JACK',     false, true),
   (214, 'affinity', 'the_veteran',             'the_veteran_affinity',             5, 5, 4, 3, 4, 'JACK',     false, true),
   (215, 'affinity', 'wildcard',                'wildcard_affinity',                4, 6, 4, 3, 4, 'JACK',     false, true),
   (216, 'affinity', 'wyn_grethzki',            'wyn_grethzki_affinity',            5, 5, 3, 4, 5, 'STRIKER',  false, true),
   (217, 'affinity', 'yurik_yurikson',          'yurik_yurikson_affinity',          4, 4, 4, 5, 3, 'GUARD',    false, true);

-- --------------
-- Affinity players
-- --------------

-- Ada-Lorana
INSERT INTO AFFINITY_PLAYERS (id, stranger_cost, ally_cost, friend_cost) VALUES
   (100, 23, 15, 10),
   (101, 18, 12, 8),
   (102, 23, 15, 10),

-- Asterians
   (103, 15, 10, 7),
   (104, 15, 10, 7),
   (105, 20, 13, 8),

-- Kalyshi
   (106, 17, 11, 7),
   (107, 23, 15, 10),

-- Convicts
   (108, 23, 15, 10),
   (109, 9, 6, 4),
   (110, 12, 8, 5),

-- Crystallans
   (111, 18, 12, 8),
   (112, 15, 10, 7),

-- Forge fathers
   (113, 20, 13, 8),
   (114, 14, 9, 6),
   (115, 14, 9, 6),

-- Brokkr
   (116, 21, 14, 10),
   (117, 14, 9, 6),
   (118, 12, 8, 6),

-- Hobgoblins
   (119, 30, 20, 13),
   (120, 14, 9, 6),
   (121, 17, 11, 8),

-- Humans (male)
   (122, 15, 10, 7),
   (123, 12, 8, 6),
   (124, 15, 10, 7),

-- Humans (female)
   (125, 15, 10, 7),
   (126, 14, 9, 6),
   (127, 15, 10, 7),

-- Judwan
   (128, 23, 15, 10),

-- Koris
   (129, 18, 12, 8),
   (130, 17, 11, 8),
   (131, 17, 11, 8),

-- Marauders
   (132, 20, 13, 8),
   (133, 14, 9, 6),

-- Martians
   (134, 15, 10, 7),
   (135, 12, 8, 6),
   (136, 15, 10, 7),

-- Nameless
   (137, 14, 9, 6),
   (138, 23, 15, 10),
   (139, 20, 13, 8),

-- Rebs
   (140, 18, 12, 8),
   (141, 20, 13, 9),
   (142, 15, 10, 7),
   (143, 23, 15, 10),

-- Robots
   (144, 21, 14, 9),
   (145, 21, 14, 9),
   (146, 21, 14, 9),

-- Sphyr
   (147, 18, 12, 8),
   (148, 14, 9, 6),
   (149, 18, 12, 8),

-- Teratons
   (150, 23, 15, 10),
   (151, 15, 10, 7),

-- Tsudochan
   (152, 15, 10, 7),

-- Veer-Myn
   (153, 18, 12, 8),
   (154, 17, 11, 8),

-- Zees
   (155, 11, 7, 5),

-- Z'zor
   (156, 26, 17, 12),
   (157, 14, 9, 6),
   (158, 17, 11, 8),

-- Other players
   (159, 14, 9, 6),
   (160, 24, 16, 11),
   (161, 21, 14, 9),
   (162, 18, 12, 8),
   (163, 18, 12, 8),
   (164, 17, 11, 7),
   (165, 24, 16, 11),
   (166, 11, 7, 5),

-- Giants
   (167, 45, 30, 20),
   (168, 41, 27, 18),
   (169, 44, 29, 19),
   (170, 35, 23, 15),
   (171, 48, 32, 21),
   (172, 41, 27, 18),
   (173, 48, 32, 21),
   (174, 44, 29, 19),

-- MVPs
   (175, 21, 14, 9),
   (176, 21, 14, 9),
   (177, 27, 18, 12),
   (178, 23, 15, 10),
   (179, 18, 12, 8),
   (180, 26, 17, 11),
   (181, 21, 14, 9),
   (182, 18, 12, 8),
   (183, 44, 29, 19),
   (184, 27, 18, 12),
   (185, 23, 15, 10),
   (186, 21, 14, 9),
   (187, 23, 15, 10),
   (188, 14, 9, 6),
   (189, 18, 12, 8),
   (190, 23, 15, 10),
   (191, 21, 14, 9),
   (192, 18, 12, 8),
   (193, 18, 12, 8),
   (194, 18, 12, 8),
   (195, 18, 12, 8),
   (196, 35, 23, 15),
   (197, 18, 12, 8),
   (198, 23, 15, 10),
   (199, 17, 11, 7),
   (200, 27, 18, 12),
   (201, 26, 17, 11),
   (202, 21, 14, 9),
   (203, 18, 12, 8),
   (204, 18, 12, 8),
   (205, 26, 17, 11),
   (206, 26, 17, 11),
   (207, 21, 14, 9),
   (208, 27, 18, 12),
   (209, 23, 15, 10),
   (210, 9, 6, 4),
   (211, 17, 11, 7),
   (212, 27, 18, 12),
   (213, 18, 12, 8),
   (214, 27, 18, 12),
   (215, 21, 14, 9),
   (216, 26, 17, 11),
   (217, 26, 17, 11);

-- --------------
-- Unit abilities
-- --------------

-- Ada-Lorana: phaser
INSERT INTO PLAYER_ABILITIES (player_id, ability_id) VALUES
   (100, 41),
   (101, 41),
   (102, 41),

-- Asterian guard: poison blade
   (103, 43),

-- Asterian jack: fragile, poison blade
   (104, 20),
   (104, 43),

-- Asterian striker: fragile blade
   (105, 20),

-- Kalyshi jack: backstab, shove
   (106, 6),
   (106, 62),

-- Kalyshi striker: jump
   (107, 28),

-- Convicts: explosive collar
   (108, 18),
   (109, 18),
   (110, 18),

-- Convict guard: threatening
   (108, 75),

-- Crystallans: harmonics
   (111, 23),
   (112, 23),

-- Forge father guard: steady
   (113, 68),

-- Brokkr: steady
   (116, 68),
   (117, 68),
   (118, 68),

-- Brokkr striker: grizzled
   (118, 22),

-- Hulk guard: mighty, steady, trail blazer
   (119, 33),
   (119, 68),
   (119, 78),

-- Hobgoblins: stench
   (120, 69),
   (121, 69),

-- Human (female) jack: running interference
   (123, 60),

-- Judwan: pacifist, long arms, misdirect
   (128, 40),
   (128, 31),
   (128, 36),

-- Koris: spinner
   (129, 67),
   (130, 67),
   (131, 67),

-- Koris guard: gotcha
   (129, 21),

-- Koris jack: portal
   (130, 44),

-- Martians: ray gun
   (134, 52),
   (135, 52),
   (136, 52),

-- Nameless sticky guard: gotcha
   (137, 21),

-- Nameless hard guard: can't feel a thing, steady
   (138, 8),
   (138, 68),

-- Nameless striker: a safe pair of hands
   (139, 3),

-- Rin guard: pummel
   (140, 47),

-- Gaelian jack: charge
   (141, 9),

-- Sorak jack: a safe pair of hands
   (142, 3),

-- Ralarat striker: jump, slippery customer
   (143, 28),
   (143, 65),

-- Robots: quick change artist
   (144, 49),
   (145, 49),
   (146, 49),

-- Sphyr: tail
   (147, 72),
   (148, 72),
   (149, 72),

-- Teratons: teleport
   (150, 74),
   (151, 74),

-- Tsudochan: push
   (152, 48),

-- Zees: runaround, duck & weave
   (155, 59),
   (155, 16),

-- Z'zor: can't feel a thing
   (156, 8),
   (157, 8),
   (158, 8),

-- Z'zor guard: steady
   (156, 68),

-- Other players, avaran treebeast: can't feel a thing, tongue
   (159, 8),
   (159, 76),

-- Other players, jetari brawler: can't feel a thing, grizzled
   (160, 8),
   (160, 22),

-- Other players, jetari thrower: 360 vision, a safe pair of hands
   (161, 1),
   (161, 3),

-- Other players, nameless bloodsucker: poison blade, steady
   (162, 43),
   (162, 68),

-- Other players, pusk rampager: ram, resilient
   (163, 51),
   (163, 54),

-- Other players, vlorox spinpede: can't feel a thing, rolling
   (164, 8),
   (164, 57),

-- Other players, yndij reaver: backflip, duck and weave, jump
   (165, 5),
   (165, 16),
   (165, 28),

-- Other players, zee buccaneer: duck and weave, runaround
   (166, 16),
   (166, 59),

-- Giant, Alpha Simian: show off, stretch, threatening
   (167, 63),
   (167, 70),
   (167, 75),

-- Giant, Barricade: comin' through, stretch, threatening
   (168, 10),
   (168, 70),
   (168, 75),

-- Giant, Big Mech: can't feel a thing, show off, threatening
   (169, 8),
   (169, 63),
   (169, 75),

-- Giant, Chovar: mind control, steady
   (170, 34),
   (170, 68),

-- Giant, Iron Ancestor: can't feel a thing
   (171, 8),

-- Giant, Krastavor: steady, stretch, threatening
   (172, 68),
   (172, 70),
   (172, 75),

-- Giant, Nameless Spawn: gotcha, threatening
   (173, 21),
   (173, 75),

-- Giant, Sann-gar:  threatening
   (174, 75),

-- MVPs, Anne-Marie Helder: grizzled, prima donna
   (175, 22),
   (175, 46),

-- MVPs, Asylum: backstab
   (176, 6),

-- MVPs, A'Teo Adysi: 360 vision, backflip, duck and weave, jump
   (177, 1),
   (177, 5),
   (177, 16),
   (177, 28),

-- MVPs, 'Brickbat' Vognar: lucky, steady
   (178, 32),
   (178, 68),

-- MVPs, Brute Force: trail blazer
   (179, 78),

-- MVPs, Buzzcut: can't feel a thing, grizzled
   (180, 8),
   (180, 22),

-- MVPs, Crypt: harmonic, steady
   (181, 23),
   (181, 68),

-- MVPs, Dead Man Davitz: can't feel a thing, grizzled
   (182, 8),
   (182, 22),

-- MVPs, Dozer: teleport, threatening
   (183, 74),
   (183, 75),

-- MVPs, Drake: can't feel a thing, quick recovery, really lucky, steady
   (184, 8),
   (184, 50),
   (184, 53),
   (184, 68),

-- MVPs, The Enforcer: backflip, jump
   (185, 5),
   (185, 28),

-- MVPs, The Excavator: can't feel a thing, driller, grizzled, steady
   (186, 8),
   (186, 14),
   (186, 22),
   (186, 68),

-- MVPs, Firewall: lucky, steady
   (187, 32),
   (187, 68),

-- MVPs, Galdo: 360 vision, quick recovery, stubborn
   (188, 1),
   (188, 50),
   (188, 71),

-- MVPs, Gorim Ironstone: grizzled, steady
   (189, 22),
   (189, 68),

-- MVPs, Grak: pile-driver, uncontrolled
   (190, 42),
   (190, 80),

-- MVPs, Hector Weiss: a safe pair of hands, grizzled, running interference
   (191, 3),
   (191, 22),
   (191, 60),

-- MVPs, Irsala: alert, gotcha, steady, toxic
   (192, 4),
   (192, 21),
   (192, 68),
   (192, 79),

-- MVPs, John Doe: gotcha
   (193, 21),

-- MVPs, Jonathan 'Gabe' Gabriel: show off
   (194, 63),

-- MVPs, Kailasa: backstab
   (195, 6),

-- MVPs, Kryphos: crowd puller, gotcha, spinner, portal master
   (196, 11),
   (196, 21),
   (196, 67),
   (196, 45),

-- MVPs, 'Lucky' Logan: really lucky
   (197, 53),

-- MVPs, Ludwig: can't feel a thing, jump
   (198, 8),
   (198, 28),

-- MVPs, Lyra the Fixer: backstab, jump, stretch
   (199, 6),
   (199, 28),
   (199, 70),

-- MVPs, Mee-Kel Judwan: 360 vision, can't feel a thing, long arms, misdirect, pacifist
   (200, 1),
   (200, 8),
   (200, 31),
   (200, 40),

-- MVPs, Mellisandra: poison blade, stretch
   (201, 43),
   (201, 70),

-- MVPs, M'zei Kein: 360 vision, grizzled, push
   (202, 1),
   (202, 22),
   (202, 48),

-- MVPs, Nightshade: poison blade
   (203, 43),

-- MVPs, Number 88: jump, mind like water
   (204, 28),
   (204, 35),

-- MVPs, Phantasm: phaser
   (205, 41),

-- MVPs, The Praetorian: a safe pair of hands, can't feel a thing
   (206, 3),
   (206, 8),

-- MVPs, Reek Rolat: can't feel a thing
   (207, 8),

-- MVPs, Rico Van Dien: jump, show off
   (208, 28),
   (208, 63),

-- MVPs, Riller: show off
   (209, 63),

-- MVPs, Schnorkel: can't feel a thing, fan favourite, klutz, steady
   (210, 8),
   (210, 19),
   (210, 30),
   (210, 68),

-- MVPs, Slippery Joe: a safe pair of hands, jump
   (211, 3),
   (211, 28),

-- MVPs, Thunder Chris: 360 vision, even the odds, grizzled, threatening
   (212, 1),
   (212, 17),
   (212, 22),
   (212, 75),

-- MVPs, Tycho Brahe: threatening
   (213, 75),

-- MVPs, The Veteran: duck and weave, grizzled, quick recovery
   (214, 16),
   (214, 22),
   (214, 50),

-- MVPs, Wildcard: even the odds
   (215, 17),

-- MVPs, Wyn Greth'zky: alert, duck and weave
   (216, 4),
   (216, 16),

-- MVPs, Yurik Yurikson: 360 vision, can't feel a thing, quick recovery, steady
   (217, 1),
   (217, 8),
   (217, 50),
   (217, 68);

-- ---------------
-- Unit affinities
-- ---------------

-- Ada-Lorana: proud
INSERT INTO PLAYER_AFFINITIES (player_id, affinity_id) VALUES
   (100, 18),
   (101, 18),
   (102, 18),

-- Ada-Lorana guard: guard
   (100, 9),

-- Ada-Lorana jack: jack
   (101, 12),

-- Ada-Lorana striker: striker
   (102, 22),

-- Asterian: cunning
   (103, 5),
   (104, 5),
   (105, 5),

-- Asterian guard: vicious
   (103, 25),

-- Asterian jack: asterian
   (104, 2),

-- Asterian striker: striker
   (104, 22),

-- Kalyshi: asterian
   (106, 2),
   (107, 2),

-- Kalyshi jack: vicious
   (106, 25),

-- Kalyshi striker: big picture
   (107, 3),

-- Convicts: convict
   (108, 4),
   (109, 4),
   (110, 4),

-- Convict guard: vicious
   (108, 25),

-- Convict jack: greedy
   (109, 8),

-- Convict striker: cunning
   (110, 5),

-- Crystallans: proud
   (111, 18),
   (112, 18),

-- Crystallan guard: guard
   (111, 9),

-- Crystallan jack: alien
   (111, 1),

-- Forge fathers: forge father
   (113, 7),
   (114, 7),
   (115, 7),

-- Forge father guard: vicious
   (113, 25),

-- Forge father jack: dreadball
   (114, 6),

-- Forge father striker: striker
   (114, 22),

-- Brokkrs: forge father
   (116, 7),
   (117, 7),
   (118, 7),

-- Brokkr guard: guard
   (116, 9),

-- Brokkr jack: worker
   (117, 27),

-- Brokkr striker: cunning
   (118, 5),

-- Hobgoblin hulk guard: psycho, vicious
   (119, 19),
   (119, 25),

-- Hobgoblin: outcast
   (120, 19),
   (121, 19),

-- Hobgoblin jack: greedy
   (120, 8),

-- Hobgoblin striker: cunning
   (121, 5),

-- Human (male): dreadball
   (122, 6),
   (123, 6),
   (124, 6),

-- Human (male) guard: guard
   (122, 9),

-- Human (male) jack: jack
   (123, 12),

-- Human (male) striker: striker
   (124, 22),

-- Human (female): dreadball
   (125, 6),
   (126, 6),
   (127, 6),

-- Human (female) guard: vicious
   (125, 25),

-- Human (female) jack: cunning
   (126, 5),

-- Human (female) striker: striker
   (127, 22),

-- Judwan: proud, striker
   (128, 18),
   (128, 22),

-- Koris guard: hunter, vicious
   (129, 10),
   (129, 25),

-- Koris jack: alien, tech guy
   (130, 1),
   (130, 23),

-- Koris jack: cunning, tech guy
   (131, 5),
   (131, 23),

-- Marauder guard: guard, psycho
   (132, 9),
   (132, 19),

-- Marauder jack: outcast, worker
   (133, 15),
   (133, 27),

-- Martians: vicious, weird science, alien
   (134, 25),
   (134, 26),
   (134, 1),
   (135, 25),
   (135, 26),
   (135, 1),
   (136, 25),
   (136, 26),
   (136, 1),

-- Nameless: alien
   (137, 1),
   (138, 1),
   (139, 1),

-- Nameless sticky guard: cunning
   (137, 5),

-- Nameless hard guard: vicious
   (138, 25),

-- Nameless striker: striker
   (139, 22),

-- Rebs: rebel
   (140, 20),
   (141, 20),
   (142, 20),
   (143, 20),

-- Reb rin guard: vicious
   (140, 25),

-- Reb gaelian jack: vicious
   (141, 15),

-- Reb sorak jack: alien
   (142, 1),

-- Reb raralat striker: cunning
   (143, 5),

-- Robots: mr roboto, tech guys
   (144, 14),
   (144, 23),
   (145, 14),
   (145, 23),
   (146, 14),
   (146, 23),

-- Sphyr: dreadball
   (147, 6),
   (148, 6),
   (149, 6),

-- Sphyr guard: hunter
   (147, 10),

-- Sphyr jack: proud
   (148, 18),

-- Sphyr striker: alien
   (148, 1),

-- Teraton: alien
   (150, 1),
   (151, 1),

-- Teraton guard: vicious
   (150, 25),

-- Teraton jack: proud
   (151, 18),

-- Tsudochan: alien, weird science
   (152, 1),
   (152, 26),

-- Veer-myn: outcast
   (153, 15),
   (154, 15),

-- Veer-myn guard: vicious
   (153, 25),

-- Veer-myn striker: striker
   (154, 22),

-- Zees: pirate, cunning, weird science
   (155, 16),
   (155, 5),
   (155, 26),

-- Z'zor: insectoid
   (156, 11),
   (157, 11),
   (158, 11),

-- Z'zor guard: vicious
   (156, 25),

-- Z'zor jack: worker
   (157, 27),

-- Z'zor jack: cunning
   (158, 5),

-- Other players, avaran treebeast: hunter, plant
   (159, 10),
   (159, 17),

-- Other players, jetari brawler: dreadball, guard, mr roboto
   (160, 6),
   (160, 9),
   (160, 14),

-- Other players, jetari thrower: dreadball, mr roboto, striker
   (161, 6),
   (161, 14),
   (161, 22),

-- Other players, nameless bloodsucker: alien, insectoid, vicious
   (162, 1),
   (162, 11),
   (162, 25),

-- Other players, pusk rampager: hunter, psycho
   (163, 10),
   (163, 19),

-- Other players, vlorox spinpede: alien, reluctant
   (164, 1),
   (164, 21),

-- Other players, yndij reaver: alien, rebel, striker
   (165, 1),
   (164, 20),
   (164, 22),

-- Other players, zee buccaneer: cunning, pirate
   (166, 5),
   (166, 16),

-- Giant, Alpha Simian: alien, hunter, reluctant
   (167, 1),
   (167, 10),
   (167, 21),

-- Giant, Barricade: mr roboto, tech guys, vicious
   (168, 14),
   (168, 23),
   (168, 25),

-- Giant, Big Mech: mr roboto, reluctant, weird science
   (169, 14),
   (169, 21),
   (169, 26),

-- Giant, Chovar: alien, outcast, reluctant
   (170, 1),
   (170, 15),
   (170, 21),

-- Giant, Iron Ancestor: forge father, vicious
   (171, 7),
   (171, 25),

-- Giant, Krastavor: insectoid, mr roboto
   (172, 11),
   (172, 14),

-- Giant, Nameless Spawn: alien, hunter, outcast
   (173, 1),
   (173, 10),
   (173, 15),

-- Giant, Sann-gar: cunning, hunter, outcast
   (174, 5),
   (174, 10),
   (174, 15),

-- MVPs, Anne-Marie Helder: striker, worker
   (175, 22),
   (175, 27),

-- MVPs, Asylum: convict, vicious
   (176, 4),
   (176, 25),

-- MVPs, A'Teo Adysi: proud, hunter
   (177, 18),
   (177, 10),

-- MVPs, 'Brickbat' Vognar: pirate, convict
   (178, 16),
   (178, 4),

-- MVPs, Brute Force: mr roboto, rebel
   (179, 14),
   (179, 20),

-- MVPs, Buzzcut: vicious, psycho
   (180, 25),
   (180, 19),

-- MVPs, Crypt: vicious, proud
   (181, 25),
   (181, 18),

-- MVPs, Dead Man Davitz: vat brothers, weird science
   (182, 24),
   (182, 26),

-- MVPs, Dozer: vicious
   (183, 25),

-- MVPs, Drake: dreadball, tech guys
   (184, 6),
   (184, 23),

-- MVPs, The Enforcer: vicious, guard
   (185, 25),
   (185, 9),

-- MVPs, The Excavator: forge father, worker
   (186, 7),
   (186, 27),

-- MVPs, Firewall: machine mind, tech guys
   (187, 13),
   (187, 23),

-- MVPs, Galdo: rebel, weird science
   (188, 20),
   (188, 26),

-- MVPs, Gorim Ironstone: forge father, worker
   (189, 7),
   (189, 27),

-- MVPs, Grak: psycho, guard
   (190, 19),
   (190, 9),

-- MVPs, Hector Weiss: dreadball, jack
   (191, 6),
   (191, 12),

-- MVPs, Irsala: alien, cunning
   (192, 1),
   (192, 5),

-- MVPs, John Doe: alien, guard
   (193, 1),
   (193, 9),

-- MVPs, Jonathan 'Gabe' Gabriel: dreadball, cunning
   (194, 6),
   (194, 5),

-- MVPs, Kailasa: asterian, big picture
   (195, 2),
   (195, 3),

-- MVPs, Kryphos: alien, jack
   (196, 1),
   (196, 12),

-- MVPs, 'Lucky' Logan: jack, cunning
   (197, 12),
   (197, 5),

-- MVPs, Ludwig: insectoid, alien
   (198, 11),
   (198, 1),

-- MVPs, Lyra the Fixer: convict, cunning
   (199, 4),
   (199, 5),

-- MVPs, Mee-Kel Judwan: outcast, big picture, proud
   (200, 15),
   (200, 3),
   (200, 18),

-- MVPs, Mellisandra: asterian, vicious
   (201, 2),
   (201, 25),

-- MVPs, M'Zei Kein: vicious, cunning
   (202, 25),
   (202, 5),

-- MVPs, Nightshade: proud, psycho
   (203, 18),
   (203, 19),

-- MVPs, Number 88: vat brothers, outcast
   (204, 24),
   (204, 15),

-- MVPs, Phantasm: big picture, outcast
   (205, 3),
   (205, 15),

-- MVPs, The Praetorian: asterian, striker
   (206, 2),
   (206, 22),

-- MVPs, Reek Rolat: hunter, psycho
   (207, 19),
   (207, 10),

-- MVPs, Riller: weird science, cunning
   (208, 26),
   (208, 5),

-- MVPs, Schornkel: proud, alien
   (209, 18),
   (209, 1),

-- MVPs, Slippery Joe: cunning, striker
   (210, 5),
   (210, 22),

-- MVPs, Thunder Chris: dreadball, jack
   (211, 6),
   (211, 12),

-- MVPs, Tycho Brahe: dreadball, psycho
   (212, 6),
   (212, 19),

-- MVPs, The Veteran: dreadball, jack
   (213, 6),
   (213, 12),

-- MVPs, Wildcard: asterian, jack, big picture
   (214, 2),
   (214, 12),
   (214, 3),

-- MVPs, Wyn Greth'zki: machine-mind, striker, dreadball
   (215, 13),
   (215, 22),
   (215, 6),

-- MVPs, Yurik Yurikson: forge father, guard
   (216, 7),
   (216, 9);

-- ---------------------
-- Unit hated affinities
-- ---------------------

-- Crystallans: hates forge fathers
INSERT INTO PLAYER_HATED_AFFINITIES (player_id, affinity_id) VALUES
   (111, 7),
   (112, 7),

-- Giant, Alpha Simian: hates dreadball
   (167, 6),

-- MVPs, Dozer: hates striker
   (183, 22),

-- MVPs, The Excavator: hates asterian
   (186, 2),

-- MVPs, Mellisandra: hates proud
   (201, 18),

-- MVPs, Nightshade: hates asterian
   (203, 2),

-- MVPs, The Praetorian: hates mr roboto
   (206, 14),

-- MVPs, Wyn Greth'zki: hates tech guys
   (215, 23);

-- -------------------------
-- Affinities availabilities
-- -------------------------

-- Sponsor affinities groups
INSERT INTO AFFINITY_SETS (id, name, rank_increase) VALUES
   (1, 'A', true),
   (2, 'B', true),
   (3, 'C', false),
   (4, 'D', true),
   (5, 'E', false);

-- Group A affinities: alien, cunning, plant, reluctant, striker
INSERT INTO AFFINITY_OPTIONS (affinity_set_id, affinity_id) VALUES
   (1, 1),
   (1, 5),
   (1, 17),
   (1, 21),
   (1, 22),

-- Group B affinities: dreadball, big picture, psycho, rebel, worker
   (2, 6),
   (2, 3),
   (2, 19),
   (2, 20),
   (2, 27),

-- Group C affinities: asterian, convict, forge father, guard, tech guys, vat brothers
   (3, 2),
   (3, 4),
   (3, 7),
   (3, 9),
   (3, 23),
   (3, 24),

-- Group D affinities: insectoid, jack, mr roboto, proud, vicious
   (4, 11),
   (4, 12),
   (4, 14),
   (4, 18),
   (4, 25),

-- Group E affinities: greedy, hunter, machine mind, outcast, pirate, weird science
   (5, 8),
   (5, 10),
   (5, 13),
   (5, 15),
   (5, 16),
   (5, 26);
