package ReviewTasks;
import java.util.Scanner;
public class MovieTicket {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int capacity= 5;
    	int amount = 0;
    	System.out.println("===Movie ticket Counter ====");
    	System.out.println("Choose Your Ticket : ");
    	System.out.println("Silver - 300 \nGold - 400 \nPlatinum -500");
    	while(capacity > 0) {
    		System.out.println("-------------------------------------------");
    		System.out.println("\nFor silver : press 1");
    		System.out.println("For Gold : press 2");
    		System.out.println("For Platinum : press 3");
    		int n = sc.nextInt();
    		switch(n) {
    		case 1:
    			System.out.println("Silver ticket Booked !");
    			amount +=300;
    		    break;
    		
    		case 2:
    			System.out.println("Gold ticket Booked !");
    			amount +=400;
    			break;
    		
    		case 3:
    			System.out.println("Platinum ticket Booked !");
    			amount +=500;
    			break;
    		case 4:
    			if(amount>300) {
    			System.out.println("Silver ticket Unbooked !");
    			amount -=300;}
    			else {
    				System.out.println("Can't Unbooked This Ticket !");
    			}
    			capacity+=2;
    			break;
    		case 5:
    			if(amount >400) {
    			System.out.println("Gold ticket Unbooked !");
    			amount -=400;
    			}
    			else {
    				System.out.println("Can't Unbooked This Ticket !");
    			}
    			capacity+=2;
    			break;
    			
    		case 6:
    			if(amount >500) {
    			System.out.println("Platinum ticket Booked !");
    			amount -=500;
    			}
    			else {
    				System.out.println("Can't Unbooked This Ticket !");
    			}
    			capacity+=2;
    			break;
    		
    		}
    		capacity--;
    		System.out.println("\nRemaining Capacity : "+capacity);
    		System.out.println("-----------------------------------------------");
    		System.out.println("For unbooked : \n For silver : press 4 \n For Gold : press 5 \n For Platinum : press 6");
    	}
    	
    	System.out.println("All Tickets are Already Booked !");
    	System.out.println("total earning Amount : "+ amount);
    }
}
