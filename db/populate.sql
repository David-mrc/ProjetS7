insert into ACTORS values ('Daniel', 'Radcliffe');
insert into ACTORS values ('Emma', 'Watson');
insert into ACTORS values ('Rupert', 'Grint');
insert into ACTORS values ('Viggo', 'Mortensen');
insert into ACTORS values ('Orlando', 'Bloom');
insert into ACTORS values ('Ian', 'Mckellen');
insert into ACTORS values ('Zoe', 'Saldana');
insert into ACTORS values ('Sam', 'Worthington');
insert into ACTORS values ('Sigourney', 'Weaver');
insert into ACTORS values ('Al', 'Pacino');
insert into ACTORS values ('Marlon', 'Brando');
insert into ACTORS values ('Robert', 'De Niro');
insert into ACTORS values ('Christian', 'Clavier');
insert into ACTORS values ('Marie-Anne', 'Chazel');
insert into ACTORS values ('Thierry', 'Lhermitte');
insert into ACTORS values ('Jude', 'Law');
insert into ACTORS values ('Willem', 'Dafoe');
insert into ACTORS values ('Don', 'McKellar');

insert into MOVIES_BASE values (1, 'Le Seigneur des anneaux', 'Peter', 'Jackson');
insert into MOVIES_BASE values (2, 'Harry Potter', 'Chris', 'Columbus');
insert into MOVIES_BASE values (3, 'Avatar', 'James', 'Cameron');
insert into MOVIES_BASE values (4, 'Le Parrain', 'Francis', 'Coppola');
insert into MOVIES_BASE values (5, 'Le père Noël est une ordure', 'Jean-Marie', 'Poiré');
insert into MOVIES_BASE values (6, 'eXistenZ', 'David', 'Cronenberg');

insert into ACTORSMOVIES values ('Daniel', 'Radcliffe', 2);
insert into ACTORSMOVIES values ('Emma', 'Watson', 2);
insert into ACTORSMOVIES values ('Rupert', 'Grint', 2);
insert into ACTORSMOVIES values ('Viggo', 'Mortensen', 1);
insert into ACTORSMOVIES values ('Orlando', 'Bloom', 1);
insert into ACTORSMOVIES values ('Ian', 'Mckellen', 1);
insert into ACTORSMOVIES values ('Zoe', 'Saldana',3);
insert into ACTORSMOVIES values ('Sam', 'Worthington',3);
insert into ACTORSMOVIES values ('Sigourney', 'Weaver',3);
insert into ACTORSMOVIES values ('Al', 'Pacino',4);
insert into ACTORSMOVIES values ('Marlon', 'Brando',4);
insert into ACTORSMOVIES values ('Robert', 'De Niro',4);
insert into ACTORSMOVIES values ('Christian', 'Clavier',5);
insert into ACTORSMOVIES values ('Marie-Anne', 'Chazel',5);
insert into ACTORSMOVIES values ('Thierry', 'Lhermitte',5);
insert into ACTORSMOVIES values ('Jude', 'Law',6);
insert into ACTORSMOVIES values ('Willem', 'Dafoe',6);
insert into ACTORSMOVIES values ('Don', 'McKellar',6);

insert into USERS_BASE values (1, 'Francois', 'Lefrancais', 'Rue de la France', 1);
insert into USERS_BASE values (2, 'Gerard', 'Lebreton', 'Rue de Bretagne', 0);

insert into CREDITCARDS values (1234567812345678, 'Gerard Lebreton', 123, TO_DATE('01/25', 'MM/YY'), 2);

insert into SUBSCRIPTIONCARDS values (1, 20.0, 1);

insert into CATEGORIES values ('Fantastique');
insert into CATEGORIES values ('Magie');
insert into CATEGORIES values ('Fantasy');
insert into CATEGORIES values ('Action');
insert into CATEGORIES values ('Drame');
insert into CATEGORIES values ('Comedie');
insert into CATEGORIES values ('Horreur');

insert into CATEGORIESRESTRICTIONS values (1, 'Fantastique');

insert into MOVIESCATEGORIES values (1, 'Fantasy');
insert into MOVIESCATEGORIES values (2, 'Fantastique');
insert into MOVIESCATEGORIES values (2, 'Magie');
insert into MOVIESCATEGORIES values (3,'Action');
insert into MOVIESCATEGORIES values (4,'Drame');
insert into MOVIESCATEGORIES values (5,'Comedie');
insert into MOVIESCATEGORIES values (6,'Horreur');

insert into SUPPORTS_BASE values (1, 'BluRay', 1, 0, NULL, 1);
insert into SUPPORTS_BASE values (2, 'QRCode', NULL, NULL, 'https://www.cybervideo.com/le-seigneur-des-anneaux', 1);
insert into SUPPORTS_BASE values (3, 'BluRay', 0, 0, NULL, 2);
insert into SUPPORTS_BASE values (4, 'QRCode', NULL, NULL,'https://www.cybervideo.com/harry-potter', 2);
insert into SUPPORTS_BASE values (5, 'BluRay', 0, 0, NULL, 3);
insert into SUPPORTS_BASE values (6, 'QRCode', NULL, NULL,'https://www.cybervideo.com/Avatar', 3);
insert into SUPPORTS_BASE values (7, 'BluRay', 0, 0, NULL, 4);
insert into SUPPORTS_BASE values (8, 'QRCode', NULL, NULL,'https://www.cybervideo.com/Le-Parrain', 4);
insert into SUPPORTS_BASE values (9, 'BluRay', 0, 0, NULL, 5);
insert into SUPPORTS_BASE values (10, 'QRCode', NULL, NULL,'https://www.cybervideo.com/Le-père-Noël-est-une-ordure', 5);
insert into SUPPORTS_BASE values (11, 'BluRay', 0, 0, NULL, 6);
insert into SUPPORTS_BASE values (12, 'QRCode', NULL, NULL,'https://www.cybervideo.com/eXistenZ', 6);

insert into RENTALS values (1, (TO_DATE('2022/12/05','yyyy/mm/dd')),
                            TO_DATE('2022/12/10','yyyy/mm/dd'), 20.0, 1, 1, NULL, 1);
insert into RENTALS values (2, (TO_DATE('2022/12/11','yyyy/mm/dd')),
                            TO_DATE('2022/09/21','yyyy/mm/dd'), 50.0, 2, 1, 1234567812345678, NULL);
insert into RENTALS values (3, (TO_DATE('2022/12/09 19:00','yyyy/mm/dd hh24:mi')),
                            TO_DATE('2022/12/10 07:00','yyyy/mm/dd hh24:mi'), 40.0, 1, 4, NULL, 1);
