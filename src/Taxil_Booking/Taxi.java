package Taxil_Booking;

public class Taxi
{
    public int Taxi_number;
    public String Driver_name;
    public char current_position='A';
    public int earnings =0;

    public Taxi(int Taxi_number,String Driver_name)
    {
        this.Taxi_number = Taxi_number;
        this.Driver_name = Driver_name;
    }
}
