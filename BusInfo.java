package BusReservation;

public class BusInfo {
   private int busNo;
   private String busRoute;
   private boolean Ac;
   private int Capacity;
   int count;

   BusInfo( int busNo , String busRoute,boolean Ac,int Capacity){
       this.busNo = busNo;
       this.busRoute = busRoute;
       this.Ac = Ac;
       this.Capacity = Capacity;
   }
    public int GetCap(){
       return Capacity;
   }

    public void SetCap(int cap){
        Capacity=cap;
    }
    public void SetbusNo(int busNo){
       this.busNo=busNo;
    }
    public int GetbusNo(){
       return busNo;
    }

    public boolean GetAc(){
        return Ac;
    }

    public void SetAc(boolean ac){
        Ac=ac;
    }
    public String GetBus(){
        return busRoute;
    }

    public void SetBus(String busRoute){
        this.busRoute =busRoute;
    }

    public void display(){
        System.out.println( "Bus No : " + busNo + " Bus Route: " + busRoute + " Ac : " + Ac + " Capacity : " + Capacity);
    }

}
