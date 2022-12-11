insert into ACTORS values ('Daniel', 'Radcliffe');
insert into ACTORS values ('Emma', 'Watson');
insert into ACTORS values ('Rupert', 'Grint');
insert into ACTORS values ('Viggo', 'Mortensen');
insert into ACTORS values ('Orlando', 'Bloom');
insert into ACTORS values ('Ian', 'Mckellen');

insert into MOVIES_BASE values (1, 'Le Seigneur des anneaux', 'Peter', 'Jackson');
insert into MOVIES_BASE values (2, 'Harry Potter', 'Chris', 'Columbus');

insert into ACTORSMOVIES values ('Daniel', 'Radcliffe', 2);
insert into ACTORSMOVIES values ('Emma', 'Watson', 2);
insert into ACTORSMOVIES values ('Rupert', 'Grint', 2);
insert into ACTORSMOVIES values ('Viggo', 'Mortensen', 1);
insert into ACTORSMOVIES values ('Orlando', 'Bloom', 1);
insert into ACTORSMOVIES values ('Ian', 'Mckellen', 1);

insert into USERS_BASE values (1, 'Francois', 'Lefrancais', 'Rue de la France', 1);
insert into USERS_BASE values (2, 'Gerard', 'Lebreton', 'Rue de Bretagne', 0);

insert into CREDITCARDS values (1234567812345678, 'Gerard Lebreton', 123, TO_DATE('01/25', 'MM/YY'), 2);

insert into SUBSCRIPTIONCARDS values (1, 20.0, 1);

insert into CATEGORIES values ('Fantastique');
insert into CATEGORIES values ('Magie');
insert into CATEGORIES values ('Fantasy');

insert into CATEGORIESRESTRICTIONS values (1, 'Fantastique');

insert into MOVIESCATEGORIES values (1, 'Fantasy');
insert into MOVIESCATEGORIES values (2, 'Fantastique');
insert into MOVIESCATEGORIES values (2, 'Magie');

insert into SUPPORTS_BASE values (1, 'BluRay', 1, 0, NULL, 1);
insert into SUPPORTS_BASE values (2, 'QRCode', NULL, NULL, 'https://www.cybervideo.com/le-seigneur-des-anneaux', 1);
insert into SUPPORTS_BASE values (3, 'BluRay', 0, 0, NULL, 2);
insert into SUPPORTS_BASE values (4, 'QRCode', NULL, NULL,'https://www.cybervideo.com/harry-potter', 2);

insert into RENTALS values (1, (TO_DATE('2022/12/05','yyyy/mm/dd')),
                            TO_DATE('2022/12/10','yyyy/mm/dd'), 20.0, 1, 1, NULL, 1);
insert into RENTALS values (2, (TO_DATE('2022/12/11','yyyy/mm/dd')),
                            TO_DATE('2022/09/21','yyyy/mm/dd'), 50.0, 2, 1, 1234567812345678, NULL);
insert into RENTALS values (3, (TO_DATE('2022/12/09 19:00','yyyy/mm/dd hh24:mi')),
                            TO_DATE('2022/12/10 07:00','yyyy/mm/dd hh24:mi'), 40.0, 1, 4, NULL, 1);
