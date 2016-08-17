import java.util.Scanner;

public class Driver {

	public static double bet;
	public static double money;
	public static BlackJack bj;

	@SuppressWarnings("resource")
	public Driver() {
		System.out.println("HOW TO PLAY:");
		System.out.println("Type h to hit");
		System.out.println("Type s to stand");
		System.out.println("Type d to double down");
		System.out.println("Enter your starting money amount:");
		Scanner sc = new Scanner(System.in);
		money = sc.nextDouble();
	}

	@SuppressWarnings("resource")
	public void hand() {
		bj = new BlackJack();
		System.out.println("You have " + money + " dollars");
		System.out.println("Enter your bet:");
		Scanner sc = new Scanner(System.in);
		bet = sc.nextDouble();

		if (bj.playerBlackJack() && !(bj.dealerBlackJack())) {
			printPlayerHand();
			printDealerHand();
			money = money + (bet * 1.5);
			System.out.println("BlackJack, You Win!");
		} else if (!(bj.playerBlackJack()) && bj.dealerBlackJack()) {
			printPlayerHand();
			printDealerHand();
			money = money - bet;
			System.out.println("Dealer had BlackJack, You Lose!");
		} else if (bj.playerBlackJack() && bj.dealerBlackJack()) {
			printPlayerHand();
			printDealerHand();
			System.out.println("Push");
		} else {
			startingOutput();

			Scanner sh = new Scanner(System.in);
			char ch = sh.next().charAt(0);
			if (ch == 's') {
				stand();
			} else if (ch == 'h') {
				char z = 'h';

				System.out.println("HIT");
				do {
					bj.playerHit();
					printPlayerHand();
					if (bj.playerHandValue() < 22){
					Scanner ht = new Scanner(System.in);
					z = sh.next().charAt(0);
					}
					else {
						z = 'n';
						System.out.println("You Bust!");
						if (win()) {
							money = money + bet;
							System.out.println("You Win! You have " + money + " dollars");

						} else {
							money = money - bet;
							System.out.println("You Lose! You have " + money + " dollars");
						}
					}
				} while (z == 'h');

				if (z == 's') {
					stand();
				}
			} else if (ch == 'd') {
				System.out.println("DOUBLE DOWN");
				bet = bet * 2;

				bj.playerHit();
				printPlayerHand();
				bj.addFaceDown();
				System.out.println("-------------------------------");
				System.out.println(
						"Dealer flips over a " + bj.dealerfacedown.toString() + " and has " + bj.dealerHandValue());
				System.out.println("-------------------------------");
				if (underCheck()) {
					dealerUnder();
				}

				if (win()) {
					money = money + bet;
					System.out.println("You Win! You have " + money + " dollars");

				} else {
					money = money - bet;
					System.out.println("You Lose! You have " + money + " dollars");
				}
			}
		}
	}

	public void stand() {
		System.out.println("-------------------------------");
		System.out.println("STAND");
		bj.addFaceDown();
		System.out.println("-------------------------------");
		System.out.println("Dealer flips over a " + bj.dealerfacedown.toString() + " and has " + bj.dealerHandValue());
		System.out.println("-------------------------------");
		if (underCheck()) {
			dealerUnder();
		}

		if (win()) {
			money = money + bet;
			System.out.println("You Win! You have " + money + " dollars");

		} else {
			money = money - bet;
			System.out.println("You Lose! You have " + money + " dollars");
		}
	}

	public void printPlayerHand() {
		System.out.println("-------------------------------");
		System.out.println("PLAYER:");
		System.out.println(bj.playerhand.toString());
		System.out.println(bj.playerHandValue());
	}

	public boolean underCheck() {
		if (bj.dealerHandValue() < 17) {
			return true;
		} else {
			return false;
		}
	}

	public void dealerUnder() {
		while (bj.dealerHandValue() < 17) {
			System.out.println("Dealer Hits");
			bj.dealerHit();
			System.out.println(bj.dealerhand.toString());
			System.out.println(bj.dealerHandValue());
			System.out.println("-------------------------------");
		}
	}

	public boolean win() {
		if ((bj.dealerHandValue() > 21) || (bj.playerHandValue() > bj.dealerHandValue()) && bj.playerHandValue() < 22) {
			return true;
		}
		return false;
	}

	public void printDealerHand() {
		System.out.println("-------------------------------");
		System.out.println("DEALER:");
		bj.addFaceDown();
		bj.dealerfacedown.value = 0;
		System.out.println(bj.dealerhand.toString());
		System.out.println(bj.dealerHandValue());
	}

	public void startingOutput() {
		printPlayerHand();
		System.out.println("DEALER:");
		System.out.println(bj.dealerhand.toString());
		System.out.println(bj.dealerHandValue());
	}

	public static void main(String[] args) {
		Driver d = new Driver();
		d.hand();
		char x;

		System.out.println("Type 'y' if you would like to play again:");
		Scanner sc = new Scanner(System.in);
		x = sc.next().charAt(0);
		int k = 0;
		if (x == 'y') {
			while (x == 'y') {
				if (k > 0) {
					System.out.println("Type 'y' if you would like to play again:");
					@SuppressWarnings("resource")
					Scanner sx = new Scanner(System.in);
					x = sx.next().charAt(0);
					if (x != 'y') {
						System.out.println("You leave with " + money + " dollars");
						System.out.println("PROGRAM CLOSED");
						System.exit(0);
					}
				}
				k++;
				d.hand();
			}
			sc.close();
		}
		System.out.println("You leave with " + money + " dollars");
		System.out.println("PROGRAM CLOSED");
		System.exit(0);
	}

}
