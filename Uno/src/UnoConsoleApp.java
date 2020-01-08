import java.util.ArrayList;
import java.util.Scanner;

public class UnoConsoleApp {
	public static void main(String[] args) {
		ArrayList<UnoCard> playerone = new ArrayList<UnoCard>();
		ArrayList<UnoCard> playertwo = new ArrayList<UnoCard>();
		UnoCard drawpileCard;
		String currentColor;

		playerone.clear();
		playertwo.clear();
		drawpileCard = new UnoCard();
		currentColor = drawpileCard.color;
		draw(7, playerone);
		draw(7, playertwo);
		System.out.println("The card is:" + drawpileCard.getCard() + "\n");

		{
			// Player one's hand
			System.out.println("Displaying Player One's Hand:\n");
			for (int i = 0; i < playerone.size(); i++) {
				System.out.print(String.valueOf(i + 1) + ". " + ((UnoCard) playerone.get(i)).getCard() + "\n");

			}

		}
		{
			// Player two's hand
			System.out.println("\nDisplaying Player Two's Hand:\n");
			for (int i = 0; i < playertwo.size(); i++) {
				System.out.print(String.valueOf(i + 1) + ". " + ((UnoCard) playertwo.get(i)).getCard() + "\n");

			}

		}
	}

	// For drawing cards
	public static void draw(int cards, ArrayList<UnoCard> deck) {
		for (int i = 0; i < cards; i++)
			deck.add(new UnoCard());
	}
}