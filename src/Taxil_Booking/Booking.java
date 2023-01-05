package Taxil_Booking;

public class Booking
{
    public int id;
    public char pick_point;
    public char drop_point;
    public int pick_time;
    public int drop_time;
    public int money;
    public Booking(int id,char pick_point,char drop_point,int pick_time,int drop_time,int money)
    {
        this.id=id;
        this.pick_point =pick_point;
        this.drop_point = drop_point;
        this.pick_time = pick_time;
        this.drop_time = drop_time;
        this.money = money;
    }

}
