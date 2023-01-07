package Taxil_Booking;

public class Taxi
{
    int Taxi_number;//getter and setter
    String Driver_name;
    char current_position='A';
    int earnings =0;
    int free_time =0;

    public Taxi(int Taxi_number,String Driver_name)
    {
        this.setTaxi_number(Taxi_number);
        this.setDriver_name(Driver_name);
    }

    public int getTaxi_number()
    {
        return Taxi_number;
    }

    public void setTaxi_number(int taxi_number)
    {
        Taxi_number = taxi_number;
    }

    public String getDriver_name() {return Driver_name;}

    public void setDriver_name(String driver_name) {Driver_name = driver_name;}

    public char getCurrent_position() {return current_position;}

    public void setCurrent_position(char current_position) {this.current_position = current_position;}

    public int getEarnings() {return earnings;}

    public void setEarnings(int earnings) {this.earnings = earnings;}

    public int getFree_time() {
        return free_time;
    }

    public void setFree_time(int free_time) {
        this.free_time = free_time;
    }
}
