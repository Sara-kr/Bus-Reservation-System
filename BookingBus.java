package BusReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.lang.String;

public class BookingBus {
    String Name;
    int busNo;
    String busRoute;
    Date date;
    String formattedDate;

    BookingBus(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name");
        Name = sc.nextLine();
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

//        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
//        try {
//            date = dateformat.parse(InputDate);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
    }
    public boolean isAvailable(ArrayList<BookingBus> bookingBuses, ArrayList<BusInfo> buses){
            int capacity = 0;
            for (BusInfo bus:buses){
                if(busNo == bus.GetbusNo()){
                    capacity = bus.GetCap();
                }
            }
            int booked =0;
            for (BookingBus b : bookingBuses){
                if(b.busNo==busNo && b.date.equals(date)){
                    booked++;
                }
            }
            return booked<capacity?true:false;
    }
    public void details(){
        System.out.println("Name : " + Name +"\nBusno : " + busNo  + "\nBus Route :"+ new BusMain().getBus(busNo) + "\nDate : " + formattedDate);
    }
}
