package dao;

import dao.DAO;
import fc.Movie;
import fc.Rental;
import fc.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAORentals extends DAO<Rental> {


    protected DAORentals(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Rental obj) throws SQLException {
        try( PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO RENTALS VALUES (RENTALID = ? , STARTDATE = ? , ENDDATE = ? , PRICE = ?, " +
                        "USERID = ?, SUPPORTID = ?, CARDNUMBER = ?, CARDID = ?) ")) {
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setDate(2, obj.getStartDate());
            preparedStatement.setDate(3, obj.getEndDate());
            preparedStatement.setFloat(4, obj.getPrice());
            preparedStatement.setInt(5, obj.getUserid());
            preparedStatement.setInt(6,obj.getSupportid());
            preparedStatement.setInt(7,obj.getCardnumber());
            preparedStatement.setInt(8,obj.getCardID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Rental read(Object obj) throws SQLException {
        Rental rental = null;
        //Vérifaction obj de type int ?
        try (PreparedStatement Rentals = conn.prepareStatement(
                "SELECT STARTDATE,ENDDATE,PRICE,USERID,SUPPORTID,CARDNUMBER,CARDID FROM RENTALS WHERE RENTALID = ?");)
        {
            Rentals.setInt(1, (Integer) obj);
            ResultSet RentalResult = Rentals.executeQuery();

            rental = new Rental();
            rental.setId((Integer) obj );
            if (RentalResult.next()) {
                rental.setStartDate(RentalResult.getDate(1));
                rental.setEndDate(RentalResult.getDate(2));
                rental.setPrice(RentalResult.getFloat(3));
                rental.setUserid(RentalResult.getInt(4));
                rental.setSupportid(RentalResult.getInt(5));
                rental.setCardnumber(RentalResult.getInt(6));
                rental.setCardID(RentalResult.getInt(7));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rental;
    }

    @Override
    public boolean update(Rental obj) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Rental obj) throws SQLException {
        try (PreparedStatement User = conn.prepareStatement(
                "DELETE FROM RENTALS WHERE RENTALID = ?");)
        {
            User.setInt(obj.getId(),1);
            return User.executeUpdate() > 0;
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return false;
    }
}
