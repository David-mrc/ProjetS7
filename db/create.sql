CREATE TABLE Actors(
    firstName VARCHAR2(50),
    lastName VARCHAR2(50),
    CONSTRAINT Actors_PK PRIMARY KEY (firstName, lastName)
);

CREATE TABLE Movies(
    movieID INTEGER,
    title VARCHAR2(50) NOT NULL,
    directorFirstName VARCHAR2(50) NOT NULL,
    directorLastName VARCHAR2(50) NOT NULL,
    CONSTRAINT Movies_PK PRIMARY KEY (movieID),
    CONSTRAINT movieID_CK CHECK (movieID >= 0)
);

CREATE TABLE ActorsMovies(
    firstName VARCHAR2(50),
    lastName VARCHAR2(50),
    movieID INTEGER,
    CONSTRAINT ActorsMovies_PK PRIMARY KEY (firstName, lastName, movieID),
    CONSTRAINT ActorsMovies_name_FK FOREIGN KEY (firstName, lastName) REFERENCES Actors(firstName, lastName),
    CONSTRAINT ActorsMovies_movieID_FK FOREIGN KEY (movieID) REFERENCES Movies(movieID)
);

CREATE TABLE Categories(
    categoryName VARCHAR2(50),
    CONSTRAINT Categories_PK PRIMARY KEY (categoryName)
);

CREATE TABLE MoviesCategories(
    movieID INTEGER,
    categoryName VARCHAR2(50),
    CONSTRAINT MoviesCategories_PK PRIMARY KEY (movieID, categoryName),
    CONSTRAINT MoviesCategories_movieID_FK FOREIGN KEY (movieID) REFERENCES Movies(movieID),
    CONSTRAINT MoviesCategories_categoryName_FK FOREIGN KEY (categoryName) REFERENCES Categories(categoryName)
);

CREATE TABLE Supports(
    supportID INTEGER,
    supportType VARCHAR2(50) NOT NULL,
    damagedDisk INTEGER,
    lostDisk INTEGER,
    streamAddress VARCHAR2(50),
    movieID INTEGER NOT NULL,
    CONSTRAINT Supports_PK PRIMARY KEY (supportID),
    CONSTRAINT supportID_CK CHECK (supportID >= 0),
    CONSTRAINT supportType_CK CHECK (
        (supportType = 'BluRay' AND damagedDisk IS NOT NULL AND lostDisk IS NOT NULL AND streamAddress IS NULL) OR
        (supportType = 'QRCode' AND damagedDisk IS NULL AND lostDisk IS NULL AND streamAddress IS NOT NULL)),
    CONSTRAINT damagedDisk_CK CHECK (damagedDisk = 0 OR damagedDisk = 1),
    CONSTRAINT lostDisk_CK CHECK (lostDisk = 0 OR lostDisk = 1),
    CONSTRAINT Supports_movieID_FK FOREIGN KEY (movieID) REFERENCES Movies(movieID)
);

CREATE TABLE Users(
    userID INTEGER,
    firstName VARCHAR2(50) NOT NULL,
    lastName VARCHAR2(50) NOT NULL,
    address VARCHAR2(50) NOT NULL,
    subscriber INTEGER NOT NULL,
    CONSTRAINT userID_PK PRIMARY KEY (userID),
    CONSTRAINT userID_CK CHECK (userID >= 0),
    CONSTRAINT subscriber_CK CHECK (subscriber = 0 OR subscriber = 1)
);

CREATE TABLE CreditCards(
    cardNumber NUMBER,
    holder VARCHAR2(50) NOT NULL,
    CCV INTEGER NOT NULL,
    expiryDate DATE NOT NULL,
    userID INTEGER NOT NULL,
    CONSTRAINT CreditCards PRIMARY KEY (cardNumber),
    CONSTRAINT cardNumber_CK CHECK (cardNumber >= 0 AND cardNumber < 10000000000000000),
    CONSTRAINT CCV_CK CHECK (CCV >= 0 AND CCV < 1000),
    CONSTRAINT CreditCards_userID_FK FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE SubscriptionCards(
    cardID INTEGER,
    balance FLOAT NOT NULL,
    userID INTEGER NOT NULL,
    CONSTRAINT SubscriptionCards PRIMARY KEY (cardID),
    CONSTRAINT cardID_CK CHECK (cardID >= 0),
    CONSTRAINT SubscriptionCards_userID_FK FOREIGN KEY (userID) REFERENCES Users(userID)
);

CREATE TABLE CategoriesRestrictions(
    cardID INTEGER,
    categoryName VARCHAR2(50) NOT NULL,
    CONSTRAINT CategoriesRestrictions_PK PRIMARY KEY (cardID, categoryName),
    CONSTRAINT CategoriesRestrictions_cardID_FK FOREIGN KEY (cardID) REFERENCES SubscriptionCards(cardID),
    CONSTRAINT CategoriesRestrictions_categoryName_FK FOREIGN KEY (categoryName) REFERENCES Categories(categoryName)
);

CREATE TABLE Rentals(
    rentalID INTEGER,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    price FLOAT NOT NULL,
    userID INTEGER NOT NULL,
    supportID INTEGER NOT NULL,
    cardNumber INTEGER,
    cardID INTEGER,
    CONSTRAINT Rentals_PK PRIMARY KEY (rentalID),
    CONSTRAINT rentalID_CK CHECK (rentalID >= 0),
    CONSTRAINT price_CK CHECK (price >= 0),
    CONSTRAINT card_CK CHECK ((cardNumber IS NULL AND cardID IS NOT NULL) OR
                              (cardNumber IS NOT NULL AND cardID IS NULL)),
    CONSTRAINT Rentals_userID_FK FOREIGN KEY (userID) REFERENCES Users(userID),
    CONSTRAINT Rentals_supportID_FK FOREIGN KEY (supportID) REFERENCES Supports(supportID),
    CONSTRAINT Rentals_cardNumber_FK FOREIGN KEY (cardNumber) REFERENCES CreditCards(cardNumber),
    CONSTRAINT Rentals_cardID_FK FOREIGN KEY (cardID) REFERENCES SubscriptionCards(cardID)
);

-- CREATE VIEW Supports AS
--     WITH TotalRentals AS (
--         SELECT supportID, COUNT(rentalID) AS totalRentals
--         FROM Rentals
--         GROUP BY supportID
--     ), WeekRentals AS (
--         SELECT supportID, COUNT(rentalID) AS weekRentals
--         FROM Rentals
--         WHERE to_number(startDate) >= (SELECT to_number(to_char(systimestamp,'yyyymmdd')) - 604800 FROM dual)
--         GROUP BY supportID
--     ), MonthRentals AS (
--         SELECT supportID, COUNT(rentalID) AS monthRentals
--         FROM Rentals
--         WHERE to_number(startDate) >= (SELECT to_number(to_char(systimestamp, 'yyyymmdd')) - 2592000 FROM dual)
--         GROUP BY supportID
--     ), Unavailable AS (
--         SELECT supportID, 0 AS available
--         FROM Rentals
--         WHERE to_number(endDate) > (SELECT to_number(to_char(systimestamp, 'yyyymmdd')) FROM dual)
--     ), Available AS (
--         SELECT supportID, available
--         FROM Unavailable
--         UNION
--         SELECT supportID, 1 AS available
--         FROM Supports
--         WHERE supportID NOT IN (SELECT supportID FROM Unavailable)
--     )
--     SELECT supportID, supportType, damagedDisk, lostDisk, streamAddress, movieID,
--            available, totalRentals, weekRentals, monthRentals
--     FROM Supports
--         JOIN Available USING (supportID)
--         JOIN TotalRentals USING (supportID)
--         JOIN WeekRentals USING (supportID)
--         JOIN MonthRentals USING (supportID)
-- ;
--
-- CREATE VIEW Movies AS
--     WITH TotalRentals AS (
--         SELECT movieID, SUM(totalRentals) AS totalRentals
--         FROM Supports
--         GROUP BY movieID
--     ), WeekRentals AS (
--         SELECT movieID, SUM(weekRentals) AS weekRentals
--         FROM Supports
--         GROUP BY movieID
--     ), MonthRentals AS (
--         SELECT movieID, SUM(monthRentals) AS monthRentals
--         FROM Supports
--         GROUP BY movieID
--     )
--     SELECT movieID, title, directorFirstName, directorLastName, totalRentals, weekRentals, monthRentals
--     FROM Movies
--         JOIN TotalRentals USING (movieID)
--         JOIN WeekRentals USING (movieID)
--         JOIN MonthRentals USING (movieID)
-- ;
--
-- CREATE VIEW USERS AS
--     WITH TotalRentals AS (
--         SELECT userID, COUNT(rentalID) AS totalRentals
--         FROM Rentals
--         GROUP BY userID
--     ), WeekRentals AS (
--         SELECT userID, COUNT(rentalID) AS weekRentals
--         FROM Rentals
--         WHERE to_number(startDate) >= (SELECT to_number(to_char(systimestamp,'yyyymmdd')) - 604800 FROM dual)
--         GROUP BY userID
--     ), MonthRentals AS (
--         SELECT userID, COUNT(rentalID) AS monthRentals
--         FROM Rentals
--         WHERE to_number(startDate) >= (SELECT to_number(to_char(systimestamp, 'yyyymmdd')) - 2592000 FROM dual)
--         GROUP BY userID
--     )
--     SELECT userID, firstName, lastName, address, subscriber, totalRentals, weekRentals, monthRentals
--     FROM Users
--         JOIN TotalRentals USING (userID)
--         JOIN WeekRentals USING (userID)
--         JOIN MonthRentals USING (userID)
-- ;
