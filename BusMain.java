package BusReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class BusMain {
    static ArrayList<BusInfo> buses = new ArrayList<>();
    static ArrayList<BookingBus> bookingBuses = new ArrayList<>();

    public void addBuses(){
        buses.add(new BusInfo(1,"Madurai-Chennai",true,2));
        buses.add(new BusInfo(2,"Madurai-Coimbatore",false,50));
        buses.add(new BusInfo(3,"Madurai-Erode",true,45));
    }

    public String getBus(int no){
        BusInfo busInfo = buses.get(no-1);
        return busInfo.GetBus();
    }
    public static void main(String[] args) {
        new BusMain().addBuses();


        int UserOpt = 1;


        for (BusInfo b : buses){
            b.display();
        }
        Scanner sc = new Scanner(System.in);
        while (UserOpt==1){
            System.out.println("Enter 1 to Book \nEnter 2 to Exit");
            UserOpt = sc.nextInt();
            if (UserOpt==1){
                BookingBus booking = new BookingBus();
                if(booking.isAvailable(bookingBuses,buses)){
                    bookingBuses.add(booking);
                    System.out.println("your booking is Confirmed");
                    booking.details();
                }
                else {
                    System.out.println("Sorry try another bus or another date");
                }
            }

        }
    }
}

