import Taxil_Booking.Booking;
import Taxil_Booking.Customer;
import Taxil_Booking.Taxi;

import java.util.Scanner;

import static java.sql.Types.NULL;

public class Main
{
    static Taxi[] t = new Taxi[100];
    static Customer[] c = new Customer[100];
    static Booking[] b = new Booking[100];
    static Scanner sc = new Scanner(System.in);
    static int taxi_id =0;//VARIABLES MUST BE MEANINGFULLY
    static int cus_id =0;
    static int book_id =0;
    public static void taxi_creation(int taxi_id1)
    {
        System.out.println("Enter Driver's name: ");
        t[taxi_id1] = new Taxi(taxi_id1 +1,sc.next());
        System.out.println("Taxi was Created");
        taxi_id++;
    }
    public static void cus_creation(int cus_id1)
    {
        System.out.println("Enter your name: ");
        sc.nextLine();
        String name = sc.nextLine();
        c[cus_id1] = new Customer(cus_id1++,name);
        cus_id++;
        System.out.println("Customer was created");

    }
    public static void booking(int taxi_id1,int book_id1)
    {
        if(taxi_id1 > book_id1)//REVERSE DIRECTION NEED TO BE HANDLED
        {
            System.out.println("Enter your ID: ");
            int n = sc.nextInt();
            System.out.println("Welcome " + c[n - 1].Customer_name);
            System.out.println("Enter your pickup point");
            char pick = sc.next().charAt(0);
            System.out.println("Enter your dropping point");
            char drop = sc.next().charAt(0);
            System.out.println("Enter your pickup time");
            int time = sc.nextInt();
            int earn = ((((drop-pick)*15)-5)*10)+100;
            t[book_id1].setEarnings(earn);
            b[book_id1] = new Booking(book_id1++,pick,drop,time,time+(drop-pick),earn);
            System.out.println("Taxi-"+ book_id1 + " booked");
            t[book_id1 - 1].setCurrent_position(drop);
            t[book_id1 - 1].setFree_time(time+(drop-pick));
            book_id++;
        }
        else
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
            int count =0;
            char pos ='Z';
            int e = NULL;//NULL
            int a = 0;
            for (int l = 0; l < taxi_id1; l++)
            {
                if(time >= t[l].getFree_time())
                {
                    if(t[l].getCurrent_position()<pos)
                    {
                        pos = t[l].getCurrent_position();
                    }
                }
                else
                {
                    count++;
                }
            }
            if(count == taxi_id1)
            {
                System.out.println("All Taxi's are busy");
            }
            else
            {
                for (int l = 0; l < taxi_id1; l++)
                {
                    if(t[l].getCurrent_position() == pos)
                    {
                        if(e> t[l].getEarnings()||e==NULL)
                        {
                            e = t[l].getEarnings();
                            a = l;
                        }
                    }
                }//TAXIES CAN BE COME BACKWARD
                int earn = ((((drop-pick)*15)-5)*10)+100;
                b[book_id1] = new Booking(book_id1++,pick,drop,time,time+(drop-pick),earn);
                t[a].setEarnings(t[a].getEarnings() + earn);
                System.out.println("Taxi-"+(a+1)+ " booked");
                t[a].setCurrent_position(drop);
                t[a].setFree_time(time+(drop-pick));
                book_id++;
            }
        }
    }
    public static void display_the_earnings(int taxi_id1)
    {
        for (int l = 0; l < taxi_id1; l++)
        {
            System.out.println("Taxi - "+ t[l].getTaxi_number() +"\nDriver's name - "+ t[l].getDriver_name() +"\nTotal Earnings - "+ t[l].getEarnings());
            System.out.println("---------------------------------------------------");
        }
    }
    public static void  booking_details(int book_id1)
    {
        for (int l = 0; l < book_id1; l++)
        {
            System.out.println("Booking Id: "+b[l].id+"\nPick: "+b[l].pick_point+"\nDrop: "+b[l].drop_point+"\nPick_time: "+b[l].pick_time+"\nDrop_time: "+b[l].drop_time+"\nEarnings: "+b[l].money);
            System.out.println("-------------------------------------------------------------");
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
                    taxi_creation(taxi_id);
                    break;
                case 2:
                    cus_creation(cus_id);
                    break;
                case 3:
                    booking(taxi_id,book_id);
                    break;
                case 4:
                    display_the_earnings(taxi_id);
                    break;
                case 5:
                    booking_details(book_id);
                    break;
                case 6:
                    a=false;
                    break;
            }
        }
    }
}