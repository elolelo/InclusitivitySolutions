import java.util.*;

public class Hand {
	public static void main(String[] args) {
	    	Scanner hand = new Scanner (System.in); 
	    	System.out.println("Enter your 5 cards in this format 'AH,AD,AS,AC,2S'");
	    	String hand_container = hand.nextLine();
	    	// THIS IS WHERE YOU WILL VALIDATE THE HAND;
	    	int length_hand = hand_container.length();
	    	
	    	
	    	if (hand_container.length() != 5) {
	    		System.out.println("You must have 5 card");
	    		System.exit(0);
	    	
	    	}
	    	
	    	else {
	    		
	    
	    }
	
	}
}
