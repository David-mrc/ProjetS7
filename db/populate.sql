



insert into MOVIES_BASE values (1,'Le Seigneur des anneaux', 'Peter', 'Jackson' );
insert into MOVIES_BASE values (2,'Harry Potter', 'Chris', 'Columbus');

insert into ACTORS values ('Daniel', 'Radcliffe');
insert into ACTORS values ('Emma','Watson');
insert into ACTORS values ('Rupert', 'Grint');
insert into ACTORS values ('Viggo', 'Mortensen');
insert into ACTORS values ('Orlando','Bloom');
insert into ACTORS values ('Ian', 'Mckellen');

insert into ACTORSMOVIES values ('Daniel', 'Radcliffe',2 );
insert into ACTORSMOVIES values ('Emma','Watson',2 );
insert into ACTORSMOVIES values ('Rupert', 'Grint',2 );
insert into ACTORSMOVIES values ('Viggo', 'Mortensen',1 );
insert into ACTORSMOVIES values ('Orlando','Bloom',1 );
insert into ACTORSMOVIES values ('Ian', 'Mckellen',1 );

insert into USERS_BASE values (1, 'Francois', 'Lefrancais','Rue de la France',1 );
insert into USERS_BASE values (2, 'Gerard','Lebreton', 'Rue de Bretagne', 1);
insert into USERS_BASE values (3, 'Catherine','DeMedicis', 'Rue de New York', 0);
insert into USERS_BASE values (4, 'Jean','Dalembert', 'Rue de New York', 0);

insert into CREDITCARDS values (1,'Francois Lefrancais', 111, TO_DATE('2023/01/01','yyyy/mm/dd'), 1);
insert into CREDITCARDS values (2,'Gerard Lebreton', 222, TO_DATE('2025/01/01','yyyy/mm/dd'), 2);
insert into CREDITCARDS values (3,'Catherine DeMedicis', 333, TO_DATE('2023/01/01','yyyy/mm/dd'), 3);
insert into CREDITCARDS values (4,'Jean Dalembert', 444, TO_DATE('2024/01/01','yyyy/mm/dd'), 4);

insert into SUBSCRIPTIONCARDS values (1, 20.0, 1);
insert into SUBSCRIPTIONCARDS values (2, 5.0, 2);

insert into CATEGORIES values ('Fantastique');
insert into CATEGORIES values ('Magie');
insert into CATEGORIES values ('Fantaisie');

insert into CATEGORIESRESTRICTIONS values (2, 'Fantastique' );

insert into MOVIESCATEGORIES values (1, 'Fantaisie');
insert into MOVIESCATEGORIES values (2, 'Fantastique');

insert into SUPPORTS_BASE values (1, 'physical',0,0,'Pas d adresse',1);
insert into SUPPORTS_BASE values (2, 'dematerialised',0,0,'adresse de : Le Seigneur des anneaux',1);
insert into SUPPORTS_BASE values (3, 'physical',0,0,'Pas d adresse',2);
insert into SUPPORTS_BASE values (4, 'dematerialised',0,0,'adresse de : Harry Potter',2);

insert into RENTALS values (1,TO_DATE('2022/12/05','yyyy/mm/dd'), TO_DATE('2022/12/15','yyyy/mm/dd'), 5.0, 1, 1, 1, 1);
insert into RENTALS values (2,TO_DATE('2022/09/01','yyyy/mm/dd'), TO_DATE('2022/09/11','yyyy/mm/dd'), 5.0, 2, 1, 2, 2);
insert into RENTALS values (3,TO_DATE('2022/12/09','yyyy/mm/dd'), TO_DATE('2022/12/19','yyyy/mm/dd'), 5.0, 1, 4, 1, 1);
insert into RENTALS values (4,TO_DATE('2021/05/18','yyyy/mm/dd'), TO_DATE('2021/05/28','yyyy/mm/dd'), 10.0, 3, 2, 3, 0);
insert into RENTALS values (5,TO_DATE('2022/01/22','yyyy/mm/dd'), TO_DATE('2022/02/01','yyyy/mm/dd'), 10.0, 4, 3, 4, 0);

