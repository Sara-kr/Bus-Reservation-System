
import java.sql.SQLException;
import java.util.Scanner;

    public class BusMain {

        public static void main(String[] args) throws SQLException {

            BusDAO busDAO = new BusDAO();
            busDAO.displayBusInfo();

            int UserOpt = 1;
            Scanner sc = new Scanner(System.in);
            while (UserOpt==1){
                System.out.println("Enter 1 to Book \nEnter 2 to Exit");
                UserOpt = sc.nextInt();
                if (UserOpt==1){
                    BookingBus bookingBus = new BookingBus();
                    if(bookingBus.isAvailable()){
                        BookingDAO bookingdao = new BookingDAO();
                        bookingdao.addBooking(bookingBus);
                        System.out.println("your booking is Confirmed");
                    }
                    else {
                        System.out.println("Sorry try another bus or another date");
                    }
                }

            }
        }
    }

