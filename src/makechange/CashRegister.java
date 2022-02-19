package makechange;

import java.util.Scanner;

public class CashRegister{
	
  public static void main(String[] args){
	  	
		Scanner kb = new Scanner(System.in);
    
    //The user is prompted asking for the price of the item.
    System.out.println("Enter price of the item:");
    double priceOfIteam = kb.nextDouble();

    //The user is then prompted asking how much money was tendered by the customer.
    System.out.println("Enter the amount tendered by the customer:");
    double pricePaid = kb.nextDouble();
    
    
    //Display an appropriate message if the customer provided too little money or the exact amount.
    if(priceOfIteam == pricePaid){
    	System.out.print("No Change necessary");
    }else if(priceOfIteam > pricePaid) {
    	System.err.println("You need to pay more than that!!");
    }
    else if(pricePaid>priceOfIteam){
    	giveChange(pricePaid, priceOfIteam);
    }
    //If the amount tendered is more than the cost of the item, 
    //display the number of bills and coins that should be given to the customer.
  
    
    
    kb.close();
    }

private static void giveChange(double pricePaid, double priceOfIteam) {
	
	
	
	
}

  
  }