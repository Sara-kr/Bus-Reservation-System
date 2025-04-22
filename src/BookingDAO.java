import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException {
        String query = "select count(passenger_name) from booking where bus_no=? and travel_date=?";
        Connection con = DBconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        pst.setInt(1,busNo);
        pst.setDate(2,sqldate);
        ResultSet rs = pst.executeQuery();

        rs.next();
        return rs.getInt(1);
    }
    public void addBooking(BookingBus bookingBus) throws SQLException {
        String query = "insert into booking values(?,?,?)";
        Connection con = DBconnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqldate = new java.sql.Date(bookingBus.date.getTime());
        pst.setString(1, bookingBus.passengerName);
        pst.setInt(2,bookingBus.busNo);
        pst.setDate(3,sqldate);

        pst.executeUpdate();
    }
}
