CREATE OR REPLACE TRIGGER TR_MoviesCategories
    AFTER INSERT ON MoviesCategories
    DECLARE
        nbAbsent NUMBER;
    BEGIN
        SELECT COUNT(*) INTO nbAbsent
        FROM Movies
        WHERE movieID NOT IN (SELECT movieID FROM MoviesCategories);

        if nbAbsent != 0 then
            raise_application_error(-20001, 'Contrainte non respectée : MoviesCategories[movieID] = Movies_base[movieID]');
        end if;
    END;
/

CREATE OR REPLACE TRIGGER TR_bonus_monthRentals
    AFTER INSERT ON Rentals
    FOR EACH ROW
    DECLARE
        nbRentals NUMBER;
    BEGIN
        SELECT monthRentals INTO nbRentals
        FROM Users
        WHERE userID = :NEW.userID AND subscriber = 1;

        if nbRentals > 20 then
            UPDATE SubscriptionCards SET balance = balance + 10 WHERE userID = :NEW.userID;
        end if;
    END;
/
