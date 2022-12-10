



insert into PEOPLE values ('Daniel', 'Radcliffe' );
insert into PEOPLE values ('Emma','Watson' );
insert into PEOPLE values ('Rupert', 'Grint' );
insert into PEOPLE values ('Viggo', 'Mortensen' );
insert into PEOPLE values ('Orlando','Bloom' );
insert into PEOPLE values ('Ian', 'Mckellen' );
insert into PEOPLE values ('Peter', 'Jackson');
insert into PEOPLE values ('Chris', 'Columbus');


insert into MOVIES_BASE values (1,'Le Seigneur des anneaux', (TO_DATE('2003/05/03', 'yyyy/mm/dd')), 14, 'image Le Seigneur des anneaux' );
insert into MOVIES_BASE values (2,'Harry Potter', (TO_DATE('2001/12/05', 'yyyy/mm/dd')), 10, 'image Harry Potter');

insert into ACTORS values ('Daniel', 'Radcliffe',2 );
insert into ACTORS values ('Emma','Watson',2 );
insert into ACTORS values ('Rupert', 'Grint',2 );
insert into ACTORS values ('Viggo', 'Mortensen',1 );
insert into ACTORS values ('Orlando','Bloom',1 );
insert into ACTORS values ('Ian', 'Mckellen',1 );

insert into DIRECTORS values ('Peter', 'Jackson', 1 );
insert into DIRECTORS values ('Chris', 'Columbus', 2 );

insert into USERS values (1,'Francois', 'Lefrancais','Rue de la France', TO_DATE('2010/01/05','yyyy/mm/dd') ,1 );
insert into USERS values (2, 'Gerard','Lebreton', 'Rue de Bretagne', TO_DATE('1987/07/21','yyyy/mm/dd'),0 );

insert into CARDS values (1, 20.0, 14, 1);
insert into CARDS values (2, 5.0, 0, 2);

insert into CATEGORIES values ('Fantastique');
insert into CATEGORIES values ('Magie');
insert into CATEGORIES values ('Fantaisie');

insert into CATEGORIERESTRICTIONS values (2, 'Fantastique' );

insert into MOVIECATEGORIES values (1, 'Fantaisie');
insert into MOVIECATEGORIES values (2, 'Fantastique');

insert into SUPPORTS values (1, 'physical',1,1,0,'Pas d adresse',1);
insert into SUPPORTS values (2, 'dematerialised',1,0,0,'adresse de : Le Seigneur des anneaux',1);
insert into SUPPORTS values (3, 'physical',0,0,0,'Pas d adresse',2);
insert into SUPPORTS values (4, 'dematerialised',1,0,0,'adresse de : Harry Potter',2);

insert into RENTALS values (1,TO_DATE('2022/12/05','yyyy/mm/dd'), TO_DATE('2022/12/15','yyyy/mm/dd'), 5.0, 1, 1);
insert into RENTALS values (2,TO_DATE('2022/12/01','yyyy/mm/dd'), TO_DATE('2022/09/11','yyyy/mm/dd'), 10.0, 2, 1);
insert into RENTALS values (3,TO_DATE('2022/12/09','yyyy/mm/dd'), TO_DATE('2022/12/19','yyyy/mm/dd'), 5.0, 1, 4);

