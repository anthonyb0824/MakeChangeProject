package makechange;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		boolean buySomthing = true;
		
		while(buySomthing==true) {
			// The user is prompted asking for the price of the item.
			System.out.println("Enter price of the item:");
			double priceOfIteam = (kb.nextDouble()) * 100;
			System.err.println(priceOfIteam);

			// The user is then prompted asking how much money was tendered by the customer.
			System.out.println("Enter the amount tendered by the customer:");
			double pricePaid = (kb.nextDouble()) * 100;
			

			// Display an appropriate message if the customer provided too little money or
			// the exact amount.
			if (priceOfIteam == pricePaid) {
				System.out.print("No Change necessary");
			} else if (priceOfIteam > pricePaid) {
				System.err.println("You need to pay more than that!!");
				continue;
			} else if (pricePaid > priceOfIteam) {
				giveChange(pricePaid, priceOfIteam);
			}
			// If the amount tendered is more than the cost of the item,
			// display the number of bills and coins that should be given to the customer.
			System.out.print("Would you like to buy somthing else? (Y/N)");
			String anwser = (kb.next()).toLowerCase();
			
			switch(anwser) {
			case "yes":
			case "sure":
			case "y":
				buySomthing = true;
				break;
			case "no":
			case "n":
			case "nope":
				buySomthing = false;
				break;
			default:
				System.err.println("Get out of my store!!");
				buySomthing = false;
			}
		}
		
		kb.close();
	}

	private static void giveChange(double pricePaid, double priceOfIteam) {
		// get change due
		double changeDue = pricePaid - priceOfIteam;
		// System.err.println(changeDue);
		// 1 ten dollar bill, 1 five dollar bill, 1 one dollar bill, 1 quarter, 1 dime,
		// 1 nickel, 1 penny.

		int tenB = 0;
		int fiveB = 0;
		int oneB = 0;
		int q = 0;
		int d = 0;
		int n = 0;
		int p = 0;

		while (changeDue != 0) {

			// check $10
			if (changeDue >= 1000.) {
				tenB++;
				changeDue = changeDue - 1000.0;

			} // check fives
			else if (changeDue >= 500.0) {
				// System.err.println("5.0\n");
				fiveB++;
				changeDue = changeDue - 500;
				// System.err.println(changeDue);
			} // check ones
			else if (changeDue >= 100.0) {
				// System.err.println("1.0\n");
				oneB++;
				changeDue = changeDue - 100;
			} // check .25
			else if (changeDue >= 25) {
				// System.err.println(".25\n");
				q++;
				changeDue = changeDue - 25;
			} // check .10
			else if (changeDue >= 10) {
				// System.err.println(".10\n");
				d++;
				changeDue = changeDue - 10;
			} // check .05
			else if (changeDue >= 5) {
				// System.err.println(".05\n");
				n++;
				changeDue = changeDue - 5;
			} // check .01
			else if (changeDue >= 1) {
				// System.err.println(".01\n");
				p++;
				changeDue = changeDue - 1;
			}

		}

		printChange(pricePaid, priceOfIteam, tenB, fiveB, oneB, q, d, n, p);

		// depending on how much change there is will determine which sysout it will
		// get.
		// System.err.println(changeDue);
		// System.out.println("\n Amount: "+ priceOfIteam +" , Tendered:" + pricePaid
		// +", Result:" + tenB+" ten Dollar bills, "+fiveB +" five dollar bills, "+ oneB
		// +" one dollar bill, "+q +" quarter ,"+ d + " dimes, "+n +" nickel, " +p+"
		// pennies.");

		// System.out.print("Amount: " + priceOfIteam / 100 + ", Tendered: " + pricePaid
		// / 100 + " Results: ");

	}

	private static void printChange(double pricePaid, double priceOfIteam, int tenB, int fiveB, int oneB, int q, int d,
			int n, int p) {
		String text = "";
		text = "Amount: " + priceOfIteam / 100 + ", Tendered: " + pricePaid / 100 + ", ";

		if (tenB == 1) {
			text += tenB + " Ten dollar bill, ";
		}
		if (fiveB > 0) {
			text += fiveB + " Five dollar bill, ";
		}

		if (oneB == 1) {
			text += oneB + " One dollar bill, ";
		}
		if (oneB > 1) {
			text += oneB + " One dollar bills, ";
		}

		if (q == 1) {
			text += q + " quarter, ";
		}
		if (q > 1) {
			text += q + " quarters, ";
		}

		if (d == 1) {
			text += d + " dime, ";
		}
		if (d > 1) {
			text += d + " dimes, ";
		}

		if (n == 1) {
			text += n + " nickel, ";
		}
		if (n > 1) {
			text += n + " nickels, ";
		}
		if (p == 1) {
			text += p + " penny.";
		}
		if (p > 1) {
			text += p + " pennies.\n";
		}

		if (text.endsWith(", ")) {
			text = text.trim();
			text = text.substring(0, text.length() - 1);
			text += ".\n";
		}

		System.out.print(text);

	}

}