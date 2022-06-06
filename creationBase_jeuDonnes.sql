drop table if exists TYPE_ACTEUR;
drop table if exists ACTEUR;
drop table if exists REGION_ACADEMIQUE;
drop table if exists ACADEMIE;
drop table if exists TYPE_RESSOURCE;
drop table if exists RESSOURCE;
drop table if exists THEMATIQUE;
drop table if exists DISCIPLINE;
drop table if exists USAGE;

create table TYPE_ACTEUR
 (    ID_TYPE_ACT  decimal(4,0),
      NOM_TYPE_ACT varchar(150)
 );

create table ACTEUR
 (    ID_ACT      decimal(4,0),
      NOM_ACT     varchar(20),
      PRENOM_ACT  varchar(30),
      NUM_ACT     decimal(4,0),
      RUE_ACT     varchar(20),
      CP_ACT      decimal(5,0),
      VILLE_ACT   varchar(20),
      MAIL_ACT    varchar(30),
      TEL_ACT     decimal(10,0),
      ID_TYPE_ACT decimal(4,0)
 );

create table REGION_ACADEMIQUE
 (    ID_REG_ACA  decimal(4,0),
      NOM_REG_ACA varchar(50)
       );

create table ACADEMIE
 (    CODE_ACA   varchar(2),
      NOM_ACA    varchar(30),
      ID_REG_ACA decimal(4,0)
 );

create table TYPE_RESSOURCE
 (    ID_TYPE_RES  decimal(4,0),
      NOM_TYPE_RES varchar(50)
 );

create table RESSOURCE
 (    ID_RES      decimal(4,0),
      ID_TYPE_RES decimal(4,0),
      LIEN_RES    varchar(200)
 );

create table THEMATIQUE
 (    ID_THEMA  decimal(4,0),
      NOM_THEMA varchar(50)
 );

create table DISCIPLINE
 (    ID_DISC  decimal(4,0),
      NOM_DISC varchar(30)
 );

create table USAGE
 (    ID_USAGE    decimal(4,0),
      NOM_USAGE   varchar(200),
      DESCRIPTION varchar(300),
      ID_DISC     decimal(4,0),
      ID_THEMA    decimal(4,0),
      NIVEAU      varchar(15),
      CODE_ACA    varchar(2),
      ID_RES      decimal(4,0),
      ID_ACT      decimal(4,0)
 );

insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (0, 'IAN HG Caen, membre du réseau ludus');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (1, 'Chargé de mission DANE');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (2, 'Enseignant chercheur');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (3, 'Groupe de travail de l’académie de Toulouse (IAN + IA-IPR)');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (4, 'IAN Nancy-Metz');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (5, 'Collectif d''enseignants');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (6, 'Enseignants de l''académie');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (7, 'Pôle de compétences en ecogest');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (8, 'Professeur d''anglais en lycée');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (9, 'Professeur d''anglais');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (10, 'Groupe TraAM');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (11, 'Professeur de maths');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (12, 'Groupe de reflexion académique autour du jeu');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (13, 'Professeur de maths au collège');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (14, 'Groupe GT TraAM et IAN');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (15, 'Formateurs groupe lycée');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (16, 'Dane Créteil');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (17, 'TraAM');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (18, 'IAN PC Grenoble');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (19, 'Groupe de travail de l’académie de Clermont (IAN + IA-IPR)');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (20, 'GEP HG Versailles');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (21, 'Dane Paris');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (22, 'GEP documentation Versailles');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (23, 'Dane Nancy-Metz');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (24, 'Non précisé');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (25, 'IAN LV Rouen');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (26, 'Groupe de travail GéoImages');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (27, 'Fondateur de l''application');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (28, 'Professeur de SVT');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (29, 'Groupe de professeurs de SVT de l''académie');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (30, 'IAN et pôle de compétences numériques');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (31, 'Association');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (32, 'Organisme public');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (33, 'Professeure d''histoire-géographie');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (34, 'Académie et CLEMI Versailles');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (35, 'Professeures d’espagnol de l’académie de Créteil.');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (36, 'Professeurs de LVE du cycle 3 au cycle terminal.');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (37, 'IA-IPR référente et le pôle de compétences de physique-chimie');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (38, 'Professeurs de philosophie de l''académie de Toulouse');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (39, 'IAN philosophie de l''académie');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (40, 'Professeur de LV');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (41, 'Professeur d''HG');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (42, 'Enseignants HG de l''académie');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (43, 'Groupe de professeurs');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (44, 'Présidente du colloque');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (45, 'Collectif d''enseignants du premier degré, du second degré (collège, lycée général, technologique, lycée professionnel, chercheurs');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (46, 'Association');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (47, 'Association EMC Partageons -Collectif d''enseignants volontaires');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (48, 'Groupe TraAM');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (49, 'Rectorat et professeurs');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (50, 'Dispositif collaboratif d''enseignants');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (51, 'Enseignants');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (52, 'Enseignants');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (53, 'Professeurs Arts plastiques');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (54, 'Groupe de recherche numérique en arts plastiques');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (55, 'CASNAV');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (56, 'Projet académique');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (57, '3 IAN lettres');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (58, 'Professeurs d''EPS');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (59, 'Association');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (60, 'Collectif d’enseignants');
insert into TYPE_ACTEUR (ID_TYPE_ACT, NOM_TYPE_ACT) values (61, 'Enseignant');

insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (62, 'SESTIER', 'Denis', 0);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (63, 'BROU', 'William', 1);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (64, 'VINCENT', 'Romain', 2);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (65, 'GOURIO', 'Perrine', 3);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (66, 'DENEUVE', 'Florence', 4);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (67, 'QUENE', 'Christelle', 5);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (68, 'NADAM', 'Patrice', 6);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (69, 'FENAERT', 'Mélanie', 7);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (70, 'FRANC', 'Sébastien', 8);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (71, 'ROLLO', 'Charlie', 9);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (72, 'CARRERE', 'Brigitte', 10);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (73, 'AUCLAIR', 'Christophe', 11);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (74, 'LEMOINE', 'Nicolas', 12);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (75, 'MICHAUD', 'Cyril', 13);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (76, 'TROUILLOT', 'Éric', 14);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (77, 'ROQUES', 'Sarah', 15);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (78, 'BESSET', 'Remy', 16);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (79, 'MAHIDDINE', 'Anne-Sophie', 17);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (80, 'OGUER', 'Julian', 18);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (81, 'DUPONT', 'Anne-Lise', 19);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (82, 'JAN', 'Caroline', 20);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (83, 'BRUN', 'Daniela', 21);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (84, 'BOUCHER', 'Bruno', 22);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (85, 'GUERRE', 'Laurent', 23);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (86, 'HAQUET', 'Laurence', 24);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (87, 'CHARDINE', 'Marc-Aurélien', 25);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (88, 'COSENTINO', 'Philippe', 26);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (89, 'DELORME', 'Ludovic', 27);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (90, 'TRATNJEK', 'Bénédicte', 28);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (91, 'KITTEN', 'Sabine', 29);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (92, 'CORTÈS', 'Celine', 30);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (93, 'IBANEZ', 'Imma', 31);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (94, 'PALLIER', 'Delphine', 32);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (95, 'BIDEUX', 'Christine', 33);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (96, 'MARTY', 'Pierre', 34);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (97, 'ÉLIE', 'François', 35);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (98, 'GAUBE', 'Nicolas', 36);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (99, 'NALLET', 'Johann', 37);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (100, 'FONSA', 'Frank', 38);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (101, 'FARDEL', 'Eric', 39);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (102, 'SIMON', 'Jeff', 40);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (103, 'OGIER', 'Guillaume', 41);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (104, 'DURIETZ', 'Sébastien', 42);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (105, 'MANODRITTA', 'Sébastien', 43);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (106, 'GAITA-KINACI', 'Cathia', 44);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (107, 'CORTAY', 'Carole', 45);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (108, 'GILGER', 'Christophe', 46);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (109, 'BONNEFOY-CUDRAZ', 'Élodie', 47);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (110, 'EYMERY', 'Arnaud', 48);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (111, 'ROLLIN', 'Matthieu', 49);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (112, 'CHERVIER', 'Clément', 50);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (113, 'DIRSON', 'Gautier', 51);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (114, 'FAUQUEMBERGUE', 'Thomas', 52);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (115, 'HARLEAUX', 'Cécile', 53);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (116, 'HOTIN', 'Nicolas', 54);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (117, 'MARCEL', 'Jacques', 55);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (118, 'QUILLARD', 'François', 56);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (119, 'FUMEY', 'Julien', 57);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (120, 'ANDRÉE-MOROIS', 'Gaelle', 58);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (121, 'MASSARD', 'Cécile', 59);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (122, 'BIHAN', 'Alice', 60);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (123, 'PÉCOUT', 'Gilles', 61);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (124, 'DEVIN', 'Grégory', 0);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (125, 'MISTRORIGO', 'Cyril', 1);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (126, 'VIGUIER', 'Lionel', 2);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (127, 'FONTANY', 'François', 3);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (128, 'DARTOIS', 'Yannick', 4);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (129, 'DEJEAN', 'Mattieu', 5);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (130, 'TIXIER', 'Julien', 6);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (131, 'SALLET', 'Philippe', 7);
insert into ACTEUR (ID_ACT, NOM_ACT, PRENOM_ACT, ID_TYPE_ACT) values (132, 'NAVAMUEL', 'Fidel', 8);

insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (133, 'Région académique Auvergne-Rhône-Alpes');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (134, 'Région académique Bourgogne-Franche-Comté');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (135, 'Région académique Bretagne');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (136, 'Région académique Centre-Val de Loire');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (137, 'Région académique Corse');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (138, 'Région académique Grand Est');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (139, 'Région académique Guadeloupe');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (140, 'Région académique Guyane');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (141, 'Région académique Hauts-de-France');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (142, 'Région académique Île-de-France');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (143, 'Région académique Martinique');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (144, 'Région académique Normandie');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (145, 'Région académique Nouvelle-Aquitaine');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (146, 'Région académique Occitanie');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (147, 'Région académique Pays de la Loire');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (148, 'Région académique Provence-Alpes-Côte d''Azur');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (149, 'Région académique La Réunion');
insert into REGION_ACADEMIQUE (ID_REG_ACA, NOM_REG_ACA) values (150, 'Région académique Mayotte');

insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('MY', 'Académie de Mayotte', 150);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('BE', 'Académie de Besançon', 134);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('BO', 'Académie de Bordeau', 145);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('CL', 'Académie de Clermont-Ferrand', 133);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('DI', 'Académie de Dijon', 134);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('GR', 'Académie de Grenoble', 133);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('GU', 'Académie de la Guadeloupe', 139);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('GA', 'Académie de la Guyane', 140);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('MA', 'Académie de la Martinique', 143);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('RE', 'Académie de la Réunion', 149);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('LI', 'Académie de Limoges', 145);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('LY', 'Académie de Lyon', 133);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('PO', 'Académie de Poitiers', 145);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('AI', 'Académie d''Aix-Marseille', 148);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('AM', 'Académie d''Amiens', 141);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('OR', 'Académie d''Orléans-Tours', 136);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('CO', 'Académie de Corse', 137);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('LL', 'Académie de Lille', 141);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('NM', 'Académie de Nancy-Metz', 138);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('NA', 'Académie de Nantes', 147);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('NI', 'Académie de Nice', 148);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('NO', 'Académie de Normandie', 144);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('RI', 'Académie de Reims', 138);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('RN', 'Académie de Rennes', 135);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('ST', 'Académie de Strasbourg', 138);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('CR', 'Académie de Créteil', 142);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('MO', 'Académie de Montpellier', 146);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('PA', 'Académie de Paris', 142);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('TO', 'Académie de Toulouse', 146);
insert into ACADEMIE (CODE_ACA, NOM_ACA, ID_REG_ACA) values ('VE', 'Académie de Versailles', 142);

insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (151, 'Blog');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (152, 'Chaîne YouYube');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (153, 'Jeux numériques');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (154, 'Escape games');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (155, 'Divers');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (156, 'Défi codage');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (157, 'Tutoriels');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (158, 'Application');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (159, 'Site Internet');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (160, 'Festival');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (161, 'Association');
insert into TYPE_RESSOURCE (ID_TYPE_RES, NOM_TYPE_RES) values (162, 'Scénarios pédagogiques');

insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (163, 151, 'http://www.lepetitjournaldesprofs.com/reseauludus/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (164, 152, 'https://www.youtube.com/channel/UCRThjUeXnxL_BKUhqJv5XBg');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (165, 153, 'http://jeuvideohistoire.com/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (166, 154, 'https://disciplines.ac-toulouse.fr/hgemc/travailler-avec-les-series-americans-et-space-force-pour-etudier-les-fondements-et-les');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (167, 155, 'http://www4.ac-nancy-metz.fr/physique/peda_inversee.php#game');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (168, 156, 'https://www.cquesne-escapegame.com/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (169, 157, 'https://scape.enepe.fr/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (170, 158, 'http://cdi.ac-dijon.fr/spip.php?rubrique56');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (171, 159, 'http://eco-gestion.spip.ac-rouen.fr/?-Jeux-d-evasion-Escape-games-');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (172, 160, 'http://interlangues.discipline.ac-lille.fr/actu-interlangues/flanders-lane-2');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (173, 161, 'https://itsenglishoclock.com/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (174, 162, 'https://www.pedagogie.ac-nice.fr/portail-de-langues/index.php/ressources-interlangues/traam');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (175, 151, 'http://mathematiques.ac-dijon.fr/spip.php?article196');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (176, 152, 'http://maths.ac-creteil.fr/spip.php?article231');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (177, 153, 'https://blog.mathador.fr/eric-trouillot/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (178, 154, 'https://physique-chimie.enseigne.ac-lyon.fr/spip/spip.php?rubrique418');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (179, 155, 'https://phychim.ac-versailles.fr/spip.php?article1069');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (180, 156, 'https://www.ac-paris.fr/portail/jcms/p1_1885031/formation-groupe-lycee-mars-avril-2019-prise-en-main-du-langage-python?cid=p1_106394&portal=piapp1_59010');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (181, 157, 'https://dane.ac-creteil.fr/?article781');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (182, 158, 'https://view.genial.ly/5a37c924aa1a1a0e0cf220dd');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (183, 159, 'http://ses.spip.ac-rouen.fr/IMG/pdf/synthese.pdf');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (184, 160, 'http://www.ac-grenoble.fr/disciplines/spc/articles.php?lng=fr&pg=133');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (185, 161, 'http://www.ac-clermont.fr/disciplines/index.php?id=13700');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (186, 162, 'https://histoire.ac-versailles.fr/spip.php?rubrique320');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (187, 151, 'https://www.ac-paris.fr/portail/jcms/p2_2043013/enseignement-a-distance-avec-le-numerique-modele-sap-d');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (188, 152, 'https://documentation.ac-versailles.fr/spip.php?article567');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (189, 153, 'https://dane.ac-nancy-metz.fr/tutoriels-video-brne/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (190, 154, 'https://svt.ac-versailles.fr/spip.php?article1130');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (191, 155, 'http://anglais.spip.ac-rouen.fr/spip.php?article665');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (192, 156, 'https://geoimage.cnes.fr/fr');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (193, 157, 'http://mirage.ticedu.fr/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (194, 158, 'https://www.pedagogie.ac-nice.fr/svt/productions/tectoglob3d/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (195, 159, 'http://svt.discipline.ac-lille.fr/ressources/traams/realite-augmentee-en-sciences-experimentales/mettre-en-oeuvre-la-realite-virtuelle-et-augmentee-en-classe');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (196, 160, 'https://lithotheque.ac-montpellier.fr/geoduc');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (197, 161, 'http://svt.ac-creteil.fr/?Apports-de-la-Realite-virtuelle-et-de-la-Realite-Augmentee-en-SVT-au-college');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (198, 162, 'https://view.genial.ly/5c8f5f6b6f346c7226375a22');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (199, 151, 'http://www.ac-clermont.fr/disciplines/index.php?id=11069');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (200, 152, 'https://miragedys.ticedu.fr/page.html');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (201, 153, 'https://www.cartablefantastique.fr/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (202, 154, 'https://eduscol.education.fr/svt/enseigner/ressources-et-usages-numeriques/travaux-academiques-mutualises-traam/traam-2017-2018.html#c9681');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (203, 155, 'https://www.inshea.fr/fr/ressource/liste-des-fiches-sdadv-multi-filtre');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (204, 156, 'https://enseigner-la-geographie.jimdofree.com/2020/09/14/faire-r%C3%A9investir-le-vocabulaire-de-la-g%C3%A9ographie-scolaire-aux-%C3%A9l%C3%A8ves-allophones/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (205, 157, 'http://hist-geo.spip.ac-rouen.fr/spip.php?rubrique565');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (206, 158, 'http://www.education-aux-medias.ac-versailles.fr');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (207, 159, 'https://dane.ac-nancy-metz.fr/education-au-numerique/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (208, 160, 'https://dane.ac-creteil.fr/spip.php?page=article&id_article=751');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (209, 161, 'https://twictlingua.wordpress.com/home/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (210, 162, 'http://www.ac-clermont.fr/actualite/spoc-physique-chimie-et-numerique-2020-06-12/?tx_ttnews%5BbackPid%5D=3200');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (211, 151, 'https://disciplines.ac-toulouse.fr/philosophie/numerique/philonum-base-de-donnees-collaborative-d-outils-numeriques-et-de-retours-d-experience-de');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (212, 152, 'https://philo-labo.fr/accueil/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (213, 153, 'https://linktr.ee/a_happy_teacher_true_story');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (214, 154, 'https://www.youtube.com/channel/UC8pCnomr8VIuW8x6wHXsYxA/videos');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (215, 155, 'http://www.education-aux-medias.ac-versailles.fr');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (216, 156, 'https://histoire.ac-versailles.fr/spip.php?rubrique284');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (217, 157, 'https://www.ac-orleans-tours.fr/pedagogie/hg_ec/enseigner/enseigner_autrement/webradio_des_rendez_vous_de_lhistoire_a_blois/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (218, 158, 'https://eduscol.education.fr/ses/animation/aam/traam-2018-2019/traam-2018-2019-bilan');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (219, 159, 'http://e-teachers.fr/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (220, 160, 'Site en construction');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (221, 161, 'https://patchworkfr.com/ptchwork/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (222, 162, 'https://www.mathsenvie.fr/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (223, 151, 'https://www.emcpartageons.org/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (224, 152, ' https://www.pedagogie.ac-aix-marseille.fr/jcms/c_10880672/fr/ludification-les-traam-de-l-academie-d-aix-marseille-st2s-biotechnologies-et-lpro');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (225, 153, 'https://www.pedagogie.ac-aix-marseille.fr/jcms/c_10880668/fr/pedagogie-actives-et-differenciees-les-traams-academiques');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (226, 154, 'http://ww2.ac-poitiers.fr/biochimie/spip.php?article409');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (227, 155, 'https://www.interactik.fr/portail/web');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (228, 156, 'https://www.twictee.org/twictee/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (229, 157, 'https://view.genial.ly/5e531be12049210fb2c0e8fd/presentation-quotichess-synthese');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (230, 158, 'https://twittenrimes.com/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (231, 159, 'https://pedagogie.ac-montpellier.fr/propositions-pedagogiques-en-arts-plastiques-pendant-le-confinement-2020');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (232, 160, 'https://www.ac-orleans-tours.fr/pedagogie/arts_plastiques/ressources/enseignement_a_distance/propositions_et_mise_en_partage_de_sequences/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (233, 161, 'https://view.genial.ly/5c3f2a07a4eaa03097dcca2c');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (234, 162, 'https://www.ac-paris.fr/portail/jcms/p2_2298853/le-numerique-en-fls-bilans-perspectives-ouverture-d-un-magistere');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (235, 151, 'https://www.ac-paris.fr/portail/jcms/p2_1877871/accueil');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (236, 152, 'https://lettres-modernes.discip.ac-caen.fr/spip.php?article773');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (237, 153, 'http://epsbox.free.fr/#page-content');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (238, 154, 'https://www.aeeps.org/search?keyword=numerique');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (239, 155, 'https://www.tablettesetsurvetements.fr/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (240, 156, 'https://eps.ac-versailles.fr/spip.php?article138');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (241, 157, 'http://sante-social.ac-amiens.fr/257-ressources-pedagogiques-numeriques.html');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (242, 158, 'http://hg.ac-besancon.fr/category/moochgb/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (243, 159, 'http://www.semperludens.fr/');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (244, 160, 'https://www.hispaformation.com');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (245, 161, 'https://outilstice.com');
insert into RESSOURCE (ID_RES, ID_TYPE_RES, LIEN_RES) values (246, 162, 'https://ladigitale.dev/');

insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (247, 'Ludification');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (248, 'Programmation / codage');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (249, 'Enseigner à distance');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (250, 'S’exercer / s’entraîner');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (251, 'Réalité virtuelle');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (252, 'Différenciation');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (253, 'École inclusive');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (254, 'Réseaux sociaux');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (255, 'Formation aux outils numériques en distanciel');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (256, 'Webradio');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (257, 'Évaluation');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (258, 'Travail entre pairs');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (259, 'Classe inversée');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (300, 'Création numérique');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (301, 'EMI citoyenneté numérique');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (302, 'Expression orale/podcast');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (303, 'Hybridation');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (304, 'Pédagogie de projet');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (305, 'Tiers lab');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (306, 'TNE');
insert into THEMATIQUE (ID_THEMA, NOM_THEMA) values (307, 'Travail collaboratif/mutualisation');

insert into DISCIPLINE (ID_DISC, NOM_DISC) values (260, 'Toutes disciplines');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (261, 'Histoire-géographie');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (262, 'Physique-chimie');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (263, 'Documentation');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (264, 'Economie et gestion');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (265, 'Langues vivantes');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (266, 'Mathématiques');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (267, 'SES');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (268, 'SVT');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (269, 'Philosophie');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (270, 'Biotechnologies-STMS');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (271, 'Lettres');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (272, 'Arts plastiques');
insert into DISCIPLINE (ID_DISC, NOM_DISC) values (273, 'EPS');

insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (274, 'Réseau Ludus', 'À dominante HG mais ouvert sur les autres disciplines', 260, 247, 'Tous niveaux', 'MY', 163, 62);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (275, 'Enseigner avec les séries TV', 'Perinne Gourio est IAN HG de l''académie', 261, 247, 'Second degré', 'BE', 164, 63);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (276, 'Escape games en EMI', 'Page qui regroupe des liens  vers une dizaine de jeux.', 263, 247, 'Second degré', 'BO', 165, 64);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (277, 'Applications Académiques', 'Ensemble d’applications développées par un enseignant, disponibles dans tous les stores (tablettes et ordi). Très prisée de la communauté des profs de maths. Gratuit.', 266, 247, 'Second degré', 'CL', 166, 65);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (278, 'Initiation au langage Python', 'Production de tutoriels vidéo pour la prise en main de Python ', 262, 248, 'Second degré', 'DI', 167, 66);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (279, 'Des « escape games » en ligne pour stimuler la curiosité des élèves et favoriser les apprentissages en classe de Seconde', 'En complément, bilan des TraAM : https://view.genial.ly/5ebe55008e243b0d5a32be9d', 267, 247, 'Second degré', 'GR', 168, 67);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (280, 'Enseignement à distance avec le numérique | modèle SAP@d', '', 260, 249, 'Tous niveaux', 'GU', 169, 68);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (281, 'Mettre à disposition des élèves des ressources et leur en faire créer  grâce à Glide', '', 265, 250, 'Second degré', 'GA', 170, 69);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (282, 'Mettre en oeuvre la réalité virtuelle et augmentée en classe', '', 268, 251, 'Second degré', 'MA', 171, 70);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (283, 'Différenciation', '', 261, 252, 'Premier degré', 'RE', 172, 71);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (284, 'Documents adaptés pour déficients visuels', '', 260, 253, 'Tous niveaux', 'LI', 173, 72);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (285, 'Education au numérique : #aucalmesurleweb', '', 264, 254, 'Tous niveaux', 'LI', 174, 73);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (286, 'PhiloNum', 'Base de données collaborative qui recense et classe les outils numériques qu’utilisent les professeurs de philosophie selon leurs intérêts pédagogiques.', 269, 257, 'Second degré', 'PO', 175, 74);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (287, 'Portail de l''éducation aux médias de l''académie de Versailles', 'Voir notamment les rubriques « WebTV WebRadio » ', 260, 256, 'Second degré', 'AI', 176, 75);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (288, 'E-teachers', 'E-teachers est une émission bi-mensuelle diffusée en podcast Audio et Vidéo qui parle éducation, numérique, innovation et expérimentation', 260, 255, 'Premier degré', 'AM', 177, 76);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (289, 'EMC, partageons !', 'Dispositif inclusif, interactif, collaboratif et formatif en Enseignement Moral et Civique (EMC), créé par des enseignants pour des enseignants. Compte Twitter : @EMCpartageons', 261, 258, 'Tous niveaux', 'OR', 178, 77);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (290, 'Interactik', 'Site pour favoriser le partage et le travail collaboratif entre enseignants pour se former et produire des ressources en coopérant.', 260, 258, 'Second degré', 'CO', 179, 78);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (291, 'Propositions et mise en partage de séquences', 'Ressources enseignement à distance : Propositions académiques de pistes, fiches, séquences, concours, défis.', 272, 259, 'Second degré', 'LL', 180, 79);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (292, 'Le Réseau des Lettres', 'Projet pour renouveler les pratiques de lecture et les modalités de réception des œuvres par delà les murs de la classe et les frontières académiques.', 271, 258, 'Premier degré', 'NM', 181, 80);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (293, 'EPSilon', 'Application EPS Versailles pour créer des parcours', 273, 252, 'Second degré', 'NA', 182, 81);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (294, 'La Digitale', 'Des outils numériques libres pour les enseignants', 270, 255, 'Tous niveaux', 'NI', 183, 82);

insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (350, 'La Digitale 1', 'Des outils numériques libres pour les enseignants', 270, 300, 'Tous niveaux', 'VE', 183, 82);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (351, 'La Digitale 2', 'Des outils numériques libres pour les enseignants', 270, 301, 'Tous niveaux', 'LY', 183, 82);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (352, 'La Digitale 3', 'Des outils numériques libres pour les enseignants', 270, 302, 'Tous niveaux', 'GR', 183, 82);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (353, 'La Digitale 4', 'Des outils numériques libres pour les enseignants', 270, 303, 'Tous niveaux', 'LL', 183, 82);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (354, 'La Digitale 5', 'Des outils numériques libres pour les enseignants', 270, 304, 'Tous niveaux', 'ST', 183, 82);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (355, 'La Digitale 6', 'Des outils numériques libres pour les enseignants', 270, 305, 'Tous niveaux', 'MO', 183, 82);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (356, 'La Digitale 7', 'Des outils numériques libres pour les enseignants', 270, 306, 'Tous niveaux', 'NO', 183, 82);
insert into USAGE (ID_USAGE, NOM_USAGE, DESCRIPTION, ID_DISC, ID_THEMA, NIVEAU, CODE_ACA, ID_RES, ID_ACT) values (357, 'La Digitale 8', 'Des outils numériques libres pour les enseignants', 270, 307, 'Tous niveaux', 'NI', 183, 82);
