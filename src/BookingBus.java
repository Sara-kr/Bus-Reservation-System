
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.lang.String;

public class BookingBus {
    String passengerName;
    int busNo;
    Date date;
    String formattedDate;

    BookingBus(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        passengerName = sc.nextLine();
        System.out.println("Bus no");
        busNo = sc.nextInt();
        int count =0;
        while(count==0) {
            System.out.println("enter your date in this format (dd-mm-yyyy) ");
            String InputDate = sc.next();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false); // Disable lenient parsing

            try {
                count++;
                // Parse the user input date string
                date = dateFormat.parse(InputDate);

                // Format the date
                formattedDate = dateFormat.format(date);

                // Print the formatted date
                System.out.println("Formatted Date: " + formattedDate);
            } catch (ParseException e) {
                // Handle the error
                count=0;
                System.out.println("Error: Invalid date format or value. Please enter the date in DD-MM-YYYY format.");
            }

        }

    }
    public boolean isAvailable() throws SQLException {
        BusDAO busDAO = new BusDAO();
        BookingDAO bookingdao = new BookingDAO();
        int capacity = busDAO.getCapacity(busNo);
        int booked =bookingdao.getBookedCount(busNo,date);
        return booked < capacity;
    }

}

