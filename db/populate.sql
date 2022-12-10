



insert into PEOPLE values ('Daniel', 'Radcliffe' );
insert into PEOPLE values ('Emma','Watson' );
insert into PEOPLE values ('Rupert', 'Grint' );
insert into PEOPLE values ('Viggo', 'Mortensen' );
insert into PEOPLE values ('Orlando','Bloom' );
insert into PEOPLE values ('Ian', 'Mckellen' );
insert into PEOPLE values ('Peter', 'Jackson');
insert into PEOPLE values ('Chris', 'Columbus');

insert into ACTORS values ('Daniel', 'Radcliffe',2 );
insert into ACTORS values ('Emma','Watson',2 );
insert into ACTORS values ('Rupert', 'Grint',2 );
insert into ACTORS values ('Viggo', 'Mortensen',1 );
insert into ACTORS values ('Orlando','Bloom',1 );
insert into ACTORS values ('Ian', 'Mckellen',1 );

insert into DIRECTORS values ('Peter', 'Jackson', 1 );
insert into DIRECTORS values ('Chris', 'Columbus', 2 );

insert into USERS values (1,'Francois', 'Lefrancais','Rue de la France', '2010/01/05',1 );
insert into USERS values (2, 'Gerard','Lebreton', 'Rue de Bretagne', '1987/07/21',0 );

insert into CARDS values (1, 20.0, 14, 1);
insert into CARDS values (2, 5.0, 0, 2);

insert into CATEGORIERESTRICTIONS values (2, 'Fantastique' );

insert into MOVIES_BASE values (1,'Le Seigneur des anneaux', '2001/12/19', 14, 'image Le Seigneur des anneaux' );
insert into MOVIES_BASE values (2,'Harry Potter', '2001/12/05', 10, 'image Harry Potter');

insert into CATEGORIES values ('Fantastique');
insert into CATEGORIES values ('Magie');
insert into CATEGORIES values ('Fantaisie');

insert into MOVIECATEGORIES values (1, 'Fantaisie');
insert into MOVIECATEGORIES values (2, 'Fantastique');

insert into SUPPORTS values (1, 'BluRay',1,1,0,'Pas d adresse',1);
insert into SUPPORTS values (2, 'QRCode',1,0,0,'adresse de : Le Seigneur des anneaux',1);
insert into SUPPORTS values (3, 'BluRay',0,0,0,'Pas d adresse',2);
insert into SUPPORTS values (4, 'QRCode',1,0,0,'adresse de : Harry Potter',2);

insert into RENTALS values (1,'2022/12/05', '2022/12/15', 5.0, 1, 1);
insert into RENTALS values (2,'2022/09/01', '2022/09/11', 10.0, 2, 1);
insert into RENTALS values (3,'2022/12/09', '2022/12/19', 5.0, 1, 4);

