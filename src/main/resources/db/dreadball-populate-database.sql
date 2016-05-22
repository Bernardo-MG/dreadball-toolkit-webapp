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
--                ABILITIES
-- ****************************************

INSERT INTO abilities (id, name) VALUES (1, '360_vision');
INSERT INTO abilities (id, name) VALUES (2, 'adaptable');
INSERT INTO abilities (id, name) VALUES (3, 'a_safe_pair_of_hands');
INSERT INTO abilities (id, name) VALUES (4, 'alert');
INSERT INTO abilities (id, name) VALUES (5, 'backflip');
INSERT INTO abilities (id, name) VALUES (6, 'backstab');
INSERT INTO abilities (id, name) VALUES (7, 'blood_money');
INSERT INTO abilities (id, name) VALUES (8, 'cant_feel_a_thing');
INSERT INTO abilities (id, name) VALUES (9, 'charge');
INSERT INTO abilities (id, name) VALUES (10, 'comin_through');
INSERT INTO abilities (id, name) VALUES (11, 'crowd_puller');
INSERT INTO abilities (id, name) VALUES (12, 'dirty_tricks');
INSERT INTO abilities (id, name) VALUES (13, 'does_this_hurt');
INSERT INTO abilities (id, name) VALUES (14, 'driller');
INSERT INTO abilities (id, name) VALUES (16, 'duck_and_weave');
INSERT INTO abilities (id, name) VALUES (17, 'even_the_odds');
INSERT INTO abilities (id, name) VALUES (18, 'explosive_collar');
INSERT INTO abilities (id, name) VALUES (19, 'fan_favourite');
INSERT INTO abilities (id, name) VALUES (20, 'fragile');
INSERT INTO abilities (id, name) VALUES (21, 'gotcha');
INSERT INTO abilities (id, name) VALUES (22, 'grizzled');
INSERT INTO abilities (id, name) VALUES (23, 'harmonics');
INSERT INTO abilities (id, name) VALUES (24, 'heal');
INSERT INTO abilities (id, name) VALUES (25, 'illegal');
INSERT INTO abilities (id, name) VALUES (26, 'illegal_modifications');
INSERT INTO abilities (id, name) VALUES (27, 'it_wasnt_me');
INSERT INTO abilities (id, name) VALUES (28, 'jump');
INSERT INTO abilities (id, name) VALUES (29, 'keeper');
INSERT INTO abilities (id, name) VALUES (30, 'klutz');
INSERT INTO abilities (id, name) VALUES (31, 'long_arms');
INSERT INTO abilities (id, name) VALUES (32, 'lucky');
INSERT INTO abilities (id, name) VALUES (33, 'mighty');
INSERT INTO abilities (id, name) VALUES (34, 'mind_control');
INSERT INTO abilities (id, name) VALUES (35, 'mind_like_water');
INSERT INTO abilities (id, name) VALUES (36, 'misdirect');
INSERT INTO abilities (id, name) VALUES (37, 'mutant_native');
INSERT INTO abilities (id, name) VALUES (38, 'nemesis');
INSERT INTO abilities (id, name) VALUES (39, 'one_mind');
INSERT INTO abilities (id, name) VALUES (40, 'pacifist');
INSERT INTO abilities (id, name) VALUES (41, 'phaser');
INSERT INTO abilities (id, name) VALUES (42, 'pile_driver');
INSERT INTO abilities (id, name) VALUES (43, 'poison_blade');
INSERT INTO abilities (id, name) VALUES (44, 'portal');
INSERT INTO abilities (id, name) VALUES (45, 'portal_master');
INSERT INTO abilities (id, name) VALUES (46, 'prima_donna');
INSERT INTO abilities (id, name) VALUES (47, 'pummel');
INSERT INTO abilities (id, name) VALUES (48, 'push');
INSERT INTO abilities (id, name) VALUES (49, 'quick_change_artist');
INSERT INTO abilities (id, name) VALUES (50, 'quick_recovery');
INSERT INTO abilities (id, name) VALUES (51, 'ram');
INSERT INTO abilities (id, name) VALUES (52, 'ray_gun');
INSERT INTO abilities (id, name) VALUES (53, 'really_lucky');
INSERT INTO abilities (id, name) VALUES (54, 'resilient');
INSERT INTO abilities (id, name) VALUES (55, 'resources');
INSERT INTO abilities (id, name) VALUES (56, 'roll');
INSERT INTO abilities (id, name) VALUES (57, 'rolling');
INSERT INTO abilities (id, name) VALUES (58, 'rule_of_law');
INSERT INTO abilities (id, name) VALUES (59, 'runaround');
INSERT INTO abilities (id, name) VALUES (60, 'running_interference');
INSERT INTO abilities (id, name) VALUES (61, 'shock_collar');
INSERT INTO abilities (id, name) VALUES (62, 'shove');
INSERT INTO abilities (id, name) VALUES (63, 'show_off');
INSERT INTO abilities (id, name) VALUES (64, 'slide');
INSERT INTO abilities (id, name) VALUES (65, 'slippery_customer');
INSERT INTO abilities (id, name) VALUES (66, 'snack');
INSERT INTO abilities (id, name) VALUES (67, 'spinner');
INSERT INTO abilities (id, name) VALUES (68, 'steady');
INSERT INTO abilities (id, name) VALUES (69, 'stench');
INSERT INTO abilities (id, name) VALUES (70, 'stretch');
INSERT INTO abilities (id, name) VALUES (71, 'stubborn');
INSERT INTO abilities (id, name) VALUES (72, 'tail');
INSERT INTO abilities (id, name) VALUES (73, 'taking_a_dive');
INSERT INTO abilities (id, name) VALUES (74, 'teleport');
INSERT INTO abilities (id, name) VALUES (75, 'threatening');
INSERT INTO abilities (id, name) VALUES (76, 'tongue');
INSERT INTO abilities (id, name) VALUES (77, 'toxic_immunity');
INSERT INTO abilities (id, name) VALUES (78, 'trail_blazer');
INSERT INTO abilities (id, name) VALUES (79, 'toxic');
INSERT INTO abilities (id, name) VALUES (80, 'uncontrolled');
INSERT INTO abilities (id, name) VALUES (81, 'vigour');

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

-- Humans (male)
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (1, 'human_male_guard', 10, 4, 5, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (2, 'human_male_jack', 8, 4, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (3, 'human_male_striker', 10, 5, 5, 4, 4, 4, 'STRIKER', false);

-- Orx/Goblins
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (4, 'orx_guard', 13, 4, 5, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (5, 'goblin_jack', 9, 4, 5, 4, 3, 5, 'STRIKER', false);

-- Veer-Myn
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (6, 'veer-myn_guard', 12, 4, 6, 5, 3, 4, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (7, 'veer-myn_striker', 11, 5, 6, 5, 3, 4, 'STRIKER', false);

-- Forge fathers
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (8, 'forge_father_guard', 13, 4, 4, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (9, 'forge_father_jack', 9, 4, 4, 4, 5, 3, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (10, 'forge_father_striker', 9, 5, 4, 4, 5, 3, 'STRIKER', false);

-- Robots
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (11, 'robot_guard', 0, 4, 5, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (12, 'robot_jack', 14, 4, 6, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (13, 'robot_striker', 0, 5, 5, 4, 3, 5, 'STRIKER', false);

-- Z'zor
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (14, 'zzor_guard', 17, 4, 5, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (15, 'zzor_jack', 9, 4, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (16, 'zzor_striker', 11, 5, 6, 5, 4, 4, 'STRIKER', false);

-- Judwan
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (17, 'judwan_striker', 15, 5, 6, 5, 4, 4, 'STRIKER', false);

-- Humans (female)
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (18, 'human_female_guard', 10, 4, 5, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (19, 'human_female_jack', 9, 4, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (20, 'human_female_striker', 10, 5, 5, 4, 4, 4, 'STRIKER', false);

-- Asterians
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (21, 'asterian_guard', 10, 4, 6, 4, 3, 5, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (22, 'asterian_jack', 10, 4, 6, 4, 3, 5, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (23, 'asterian_striker', 13, 5, 6, 4, 3, 5, 'STRIKER', false);

-- Nameless
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (24, 'nameless_guard_sticky', 9, 4, 4, 5, 4, 4, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (25, 'nameless_guard_hard', 15, 4, 5, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (26, 'nameless_striker', 13, 5, 6, 4, 4, 4, 'STRIKER', false);

-- Teratons
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (27, 'teraton_guard', 15, 4, 5, 4, 5, 3, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (28, 'teraton_jack', 15, 4, 5, 4, 5, 3, 'JACK', false);

-- Zees
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (29, 'zee_jack', 9, 4, 5, 5, 3, 5, 'JACK', false);

-- Sphyr
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (30, 'sphyr_guard', 12, 4, 6, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (31, 'sphyr_jack', 9, 4, 6, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (32, 'sphyr_striker', 12, 5, 6, 4, 4, 4, 'STRIKER', false);

-- Brokkr
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (33, 'brokr_guard', 12, 4, 4, 4, 4, 5, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (34, 'brokr_jack', 9, 4, 4, 4, 4, 5, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (35, 'brokr_striker', 9, 5, 4, 4, 4, 5, 'STRIKER', false);

-- Rebs
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (36, 'rin_guard', 12, 4, 5, 5, 4, 4, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (37, 'gaelian_jack', 13, 4, 7, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (38, 'sorak_jack', 10, 4, 5, 4, 4, 3, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (39, 'ralarat_striker', 15, 5, 6, 5, 3, 4, 'STRIKER', false);

-- Hobgoblins
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (40, 'hulk_guard', 20, 4, 5, 5, 5, 3, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (41, 'hobgoblin_jack', 9, 4, 5, 5, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (42, 'hobgoblin_striker', 11, 5, 5, 5, 4, 4, 'STRIKER', false);

-- Martians
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (43, 'martian_guard', 10, 4, 6, 5, 4, 4, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (44, 'martian_jack', 9, 4, 6, 5, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (45, 'martian_striker', 10, 5, 6, 5, 4, 4, 'STRIKER', false);

-- Convicts
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (46, 'convict_guard', 16, 4, 5, 5, 4, 3, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (47, 'convict_jack', 9, 4, 5, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (48, 'convict_striker', 11, 5, 5, 4, 4, 4, 'STRIKER', false);

-- Kalyshi
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (49, 'kalyshi_jack', 11, 4, 6, 4, 3, 5, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (50, 'kalyshi_striker', 14, 5, 6, 4, 3, 5, 'STRIKER', false);

-- Crystallans
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (51, 'crystallan_guard', 12, 4, 4, 4, 4, 5, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (52, 'crystallan_jack', 10, 4, 4, 4, 4, 5, 'JACK', false);

-- Tsudochan
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (53, 'tsudochan_jack', 10, 4, 5, 4, 4, 4, 'JACK', false);

-- Koris
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (54, 'koris_guard', 12, 4, 4, 4, 4, 4, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (55, 'koris_jack', 11, 4, 4, 4, 4, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (56, 'koris_striker', 11, 5, 4, 4, 4, 4, 'STRIKER', false);

-- Ada-Lorana
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (57, 'ada-lorana_guard', 15, 4, 5, 4, 3, 4, 'GUARD', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (58, 'ada-lorana_jack', 12, 4, 5, 4, 3, 4, 'JACK', false);
INSERT INTO units (id, template_name, cost, armor, movement, skill, speed, strength, position, giant)
	VALUES (59, 'ada-lorana_striker', 15, 5, 5, 4, 3, 4, 'STRIKER', false);

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
