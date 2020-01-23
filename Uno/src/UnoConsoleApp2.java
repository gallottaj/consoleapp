import java.util.ArrayList;
import java.util.Scanner;

public class UnoConsoleApp2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ArrayList<UnoCard> playerone = new ArrayList<UnoCard>();
		ArrayList<UnoCard> playertwo = new ArrayList<UnoCard>();
		ArrayList<UnoCard> playerthree = new ArrayList<UnoCard>();
		Scanner input;
		int cardIndex;
		int winner = 0;
		UnoCard drawpileCard;
		String currentColor;

		initializeGame: while (true) {
			playerone.clear();
			playertwo.clear();
			playerthree.clear();
			drawpileCard = new UnoCard();
			currentColor = drawpileCard.color;
			draw(7, playerone);
			draw(7, playertwo);
			draw(7, playerthree);
			System.out.println("The current card is: " + drawpileCard.getCard());

			for (boolean playerOnesTurn = true; winner == 0;) {
				cardIndex = 0;

				// player one's turn

				if (playerOnesTurn) {

					System.out.println("Player One, You're Up! " + String.valueOf(playertwo.size()) + " cards left!"
							+ ((playertwo.size() == 1) ? "...Uno!" : ""));
					// Finding a card to place
					for (cardIndex = 0; cardIndex < playertwo.size(); cardIndex++) {
						if (((UnoCard) playertwo.get(cardIndex)).canPlace(drawpileCard, currentColor)) // Searching for
																										// playable
																										// cards
							break;
					}

					if (cardIndex == playerone.size()) {
						System.out.println("I've got nothing! Drawing cards...");
						draw(1, playerone);
					} else {
						drawpileCard = (UnoCard) playerone.get(cardIndex);
						playerone.remove(cardIndex);
						currentColor = drawpileCard.color;
						System.out.println("Player One Chooses" + drawpileCard.getCard() + "!");
						System.out.println("You're Up Player Two!");
						playerOnesTurn = false;

						// Must do as part of each turn because topCard can stay the same through a
						// round
						if (drawpileCard.value >= 10) {
							playerOnesTurn = true; // Skipping turn

							switch (drawpileCard.value) {
							case 12: // Draw 2
								System.out.println("Drawing 2 cards for you...");
								draw(2, playerone);
								break;

							case 13:
							case 14: // Wild cards
								do // Picking a random color that's not none
								{
									currentColor = new UnoCard().color;
								} while (currentColor == "none");

								System.out.println("New color is " + currentColor);
								if (drawpileCard.value == 14) // Wild draw 4
								{
									System.out.println("Drawing 4 cards for you...");
									draw(4, playerone);
								}

							}
						}

						// PLAYER TWO

						boolean playerTwosTurn = true;
						if (playerTwosTurn)
							;
						{
							System.out.println("Player Two Has" + " " + String.valueOf(playertwo.size())
									+ " cards left!" + ((playertwo.size() == 1) ? "...Uno!" : ""));
							// Finding a card to place
							for (cardIndex = 0; cardIndex < playertwo.size(); cardIndex++) {
								if (((UnoCard) playertwo.get(cardIndex)).canPlace(drawpileCard, currentColor)) // Searching
																												// for
																												// playable
																												// cards
									break;
							}

							if (cardIndex == playertwo.size()) {
								System.out.println("I've got nothing! Drawing cards...");
								draw(1, playertwo);
							} else {
								drawpileCard = (UnoCard) playertwo.get(cardIndex);
								playertwo.remove(cardIndex);
								currentColor = drawpileCard.color;
								System.out.println("Player Two Chooses" + drawpileCard.getCard() + "!");
								System.out.println("You're Up Player Three!");
								playerOnesTurn = false;

								// Must do as part of each turn because topCard can stay the same through a
								// round
								if (drawpileCard.value >= 10) {
									playerOnesTurn = true; // Skipping turn

									switch (drawpileCard.value) {
									case 12: // Draw 2
										System.out.println("Drawing 2 cards for you...");
										draw(2, playerone);
										break;

									case 13:
									case 14: // Wild cards
										do // Picking a random color that's not none
										{
											currentColor = new UnoCard().color;
										} while (currentColor == "none");

										System.out.println("New color is " + currentColor);
										if (drawpileCard.value == 14) // Wild draw 4
										{
											System.out.println("Drawing 4 cards for you...");
											draw(4, playerone);
										}

									}
								}
							}

						}

					}

				}
			}
		}

	}

	// detect a winner

//		if (winner == 1)
//			System.out.println("player one wins");
//		else
//			System.out.println("player two wins");
//	}

	public static void draw(int cards, ArrayList<UnoCard> deck) {
		for (int i = 0; i < cards; i++)
			deck.add(new UnoCard());
	}
}
