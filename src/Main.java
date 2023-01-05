import Taxil_Booking.Booking;
import Taxil_Booking.Customer;
import Taxil_Booking.Taxi;

import java.util.Scanner;

public class Main
{
    static Taxi[] t = new Taxi[100];
    static Customer[] c = new Customer[100];
    static Booking[] b = new Booking[100];
    static Scanner sc = new Scanner(System.in);
    static  int i=0;
    static int j=0;
    static int k=0;
    public static void taxi_creation()
    {
        System.out.println("Enter Driver's name: ");
        t[i] = new Taxi(i+1,sc.next());
        System.out.println("Taxi was Created");
        i++;
    }
    public static void cus_creation()
    {
        System.out.println("Enter your name: ");
        c[j] = new Customer(j++,sc.next());
        System.out.println("Customer was created");

    }
    public static void booking()
    {
        if(i>k)
        {
            System.out.println("Enter your ID: ");
            int n = sc.nextInt();
            System.out.println("Welcome " + c[n - 1].Customer_name);
            System.out.println("Enter your pickup point");
            char pick = sc.next().charAt(0);
            System.out.println("Enter your droping point");
            char drop = sc.next().charAt(0);
            System.out.println("Enter your pickup time");
            int time = sc.nextInt();
            int earn = ((((drop-pick)*15)-5)*10)+100;
            t[k].earnings = earn;
            b[k] = new Booking(k++,pick,drop,time,time+(drop-pick),earn);
            System.out.println("Taxi-"+k+ " booked");
            t[k-1].current_position = drop;
        }
        else
        {
            System.out.println("Enter your ID: ");
            int n = sc.nextInt();
            System.out.println("Welcome " + c[n - 1].Customer_name);
            System.out.println("Enter your pickup point");
            char pick = sc.next().charAt(0);
            int count =0;
            char pos ='Z';
            int e = 10000;
            int a = 0;
            for (int l = 0; l < i; l++)
            {
                if(pick >= t[l].current_position)
                {
                    if(pick<pos)
                    {
                        pos = pick;
                    }
                }
                else
                {
                    count++;
                }
            }
            if(count == i)
            {
                System.out.println("All Taxi's are busy");
            }
            else
            {
                for (int l = 0; l < i; l++)
                {
                    if(t[l].current_position == pos)
                    {
                        if(e>t[l].earnings)
                        {
                            e = t[l].earnings;
                            a = l;
                        }
                    }
                }
                System.out.println("Enter your droping point");
                char drop = sc.next().charAt(0);
                System.out.println("Enter your pickup time");
                int time = sc.nextInt();
                int earn = ((((drop-pick)*15)-5)*10)+100;
                b[k] = new Booking(k++,pick,drop,time,time+(drop-pick),earn);
                t[a].earnings += earn;
                System.out.println("Taxi-"+(a+1)+ " booked");
                t[a].current_position = drop;
            }
        }
    }
    public static void display_the_earnings()
    {
        for (int l = 0; l < i; l++)
        {
            System.out.println("Taxi - "+t[l].Taxi_number+"\nDriver's name - "+t[l].Driver_name+"\nTotal Earnings - "+t[l].earnings);
        }
    }
    public static void booking_details()
    {
        for (int l = 0; l < k; l++)
        {
            System.out.println("Booking Id: "+b[l].id+"\nPick: "+b[l].pick_point+"\nDrop: "+b[l].drop_point+"\nPick_time: "+b[l].pick_time+"\nDrop_time: "+b[l].drop_time+"\nEarnings: "+b[l].money);
        }
    }
    public static void main(String[] args)
    {
        boolean a = true;
        while(a)
        {
            System.out.println("Enter Your Choice" +
                    "\n1)Create Taxi" +
                    "\n2)Create Customer"+
                    "\n3)Booking"+
                    "\n4)Display the Taxi details"+
                    "\n5)Display the Booking details"+
                    "\n4)Exit");
            int n = sc.nextInt();
            switch(n)
            {
                case 1:
                    taxi_creation();
                    break;
                case 2:
                    cus_creation();
                    break;
                case 3:
                    booking();
                    break;
                case 4:
                    display_the_earnings();
                    break;
                case 5:
                    booking_details();
                case 6:
                    a=false;
                    break;
            }
        }
    }
}