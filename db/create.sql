-- DROP VIEW Movies;
DROP TABLE People;
DROP TABLE Movies_base;
DROP TABLE Actors;
DROP TABLE Directors;
DROP TABLE Categories;
DROP TABLE MovieCategories;
DROP TABLE Supports;
DROP TABLE Users;
DROP TABLE Rentals;
DROP TABLE Cards;
DROP TABLE CategorieRestrictions;

CREATE TABLE People(
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    CONSTRAINT People_PK PRIMARY KEY (firstName, lastName)
);

CREATE TABLE Movies_base(
    movieID INTEGER PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    releaseDate DATE NOT NULL,
    ageRestriction INTEGER NOT NULL,
    poster VARCHAR(50),
    CONSTRAINT movieID_CK CHECK (movieID >= 0),
    CONSTRAINT movieAgeRestriction_CK CHECK (ageRestriction >= 0)
);

CREATE TABLE Actors(
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    movieID INTEGER,
    CONSTRAINT Actors_PK PRIMARY KEY (firstName, lastName, movieID),
    CONSTRAINT Actors_People_FK FOREIGN KEY (firstName, lastName) REFERENCES People(firstName, lastName),
    CONSTRAINT Actors_Movies_FK FOREIGN KEY (movieID) REFERENCES Movies_base(movieID)
);

CREATE TABLE Directors(
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    movieID INTEGER,
    CONSTRAINT Directors_PK PRIMARY KEY (firstName, lastName, movieID),
    CONSTRAINT Directors_People_FK FOREIGN KEY (firstName, lastName) REFERENCES People(firstName, lastName),
    CONSTRAINT Directors_Movies_FK FOREIGN KEY (movieID) REFERENCES Movies_base(movieID)
);

CREATE TABLE Categories(
    category VARCHAR(50) PRIMARY KEY
);

CREATE TABLE MovieCategories(
    movieID INTEGER,
    category VARCHAR(50),
    CONSTRAINT MovieCategories_PK PRIMARY KEY (movieID, category),
    CONSTRAINT MovieCategories_Movies_FK FOREIGN KEY (movieID) REFERENCES Movies_base(movieID),
    CONSTRAINT MovieCategories_Categories_FK FOREIGN KEY (category) REFERENCES Categories(category)
);

CREATE TABLE Supports(
    supportID INTEGER PRIMARY KEY,
    supportType VARCHAR(50) NOT NULL,
    available INTEGER(1) NOT NULL,
    readableDisk INTEGER(1),
    lostDisk INTEGER(1),
    streamAddress VARCHAR(50),
    movieID INTEGER NOT NULL,
    CONSTRAINT supportID_CK CHECK (supportID >= 0),
    CONSTRAINT supportType_CK CHECK (supportType IN ('physical', 'dematerialised')),
    CONSTRAINT available_CK CHECK (available = 0 OR available = 1),
    CONSTRAINT readableDisk_CK CHECK (readableDisk = 0 OR readableDisk = 1),
    CONSTRAINT lostDisk_CK CHECK (lostDisk = 0 OR lostDisk = 1),
    CONSTRAINT Supports_Movies_FK FOREIGN KEY (movieID) REFERENCES Movies_base(movieID) -- TODO: Trigger
);

CREATE TABLE Users(
    userID INTEGER PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    birthDate DATE NOT NULL,
    subscriber INTEGER(1) NOT NULL,
    CONSTRAINT userID_CK CHECK (userID >= 0),
    CONSTRAINT subscriber_CK CHECK (subscriber = 0 OR subscriber = 1)
);

CREATE TABLE Rentals(
    rentalID INTEGER PRIMARY KEY,
    startDate DATE NOT NULL,
    endDate DATE,
    price FLOAT NOT NULL,
    userID INTEGER NOT NULL,
    supportID INTEGER NOT NULL,
--     CONSTRAINT Rentals_UC UNIQUE (startDate, supportID), TODO: Vérifier contraintes
    CONSTRAINT rentalID_CK CHECK (rentalID >= 0),
    CONSTRAINT price_CK CHECK (price >= 0),
    CONSTRAINT Rentals_Users_FK FOREIGN KEY (userID) REFERENCES Users(userID),
    CONSTRAINT Rentals_Supports_FK FOREIGN KEY (supportID) REFERENCES Supports(supportID)
);

CREATE TABLE Cards(
    cardID INTEGER PRIMARY KEY,
    balance FLOAT NOT NULL,
    ageRestriction INTEGER,
    userID INTEGER NOT NULL,
    CONSTRAINT cardID_CK CHECK (cardID >= 0),
    CONSTRAINT cardAgeRestriction CHECK (ageRestriction >= 0),
    CONSTRAINT Cards_Users_FK FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE CategorieRestrictions(
    cardID INTEGER,
    category VARCHAR(50),
    CONSTRAINT CategoriesRestrictions_PK PRIMARY KEY (cardID, category),
    CONSTRAINT CategoriesRestrictions_Cards_FK FOREIGN KEY (cardID) REFERENCES Cards(cardID),
    CONSTRAINT CategoriesRestrictions_Categories_FK FOREIGN KEY (category) REFERENCES Categories(category)
);

-- CREATE VIEW Movies AS -- TODO: Ajouter thisMonthRentals
--     WITH Total AS (
--         SELECT movieID, COUNT(rentalID) AS totalRentals
--         FROM Movies_base JOIN Rentals USING (movieID)
--         GROUP BY movieID
--     )
--     SELECT
--         movieID,
--         title,
--         releaseDate,
--         ageRestriction,
--         poster,
--         totalRentals,
--     FROM Movies_base JOIN Total USING (movieID)
-- );
