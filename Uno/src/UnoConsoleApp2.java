import java.util.ArrayList;
import java.util.Scanner;

public class UnoConsoleApp2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ArrayList<UnoCard> playerone = new ArrayList<UnoCard>();
		ArrayList<UnoCard> playertwo = new ArrayList<UnoCard>();
		ArrayList<UnoCard> playerthree = new ArrayList<UnoCard>();
		ArrayList<UnoCard> playerfour = new ArrayList<UnoCard>();

		Scanner input;
		int cardIndex;
		int winner = 0;
		int currentuser;
		UnoCard drawpileCard;
		String currentColor;

		initializeGame: while (true) {
			playerone.clear();
			playertwo.clear();
			playerthree.clear();
			playerfour.clear();
			drawpileCard = new UnoCard();
			currentColor = drawpileCard.color;
			draw(7, playerone);
			draw(7, playertwo);
			draw(7, playerthree);
			draw(7, playerfour);

			System.out.println("The current card is: " + drawpileCard.getCard());

			for (currentuser = 1; winner == 0;) {
				cardIndex = 0;

				// player one's turn

				if (currentuser == 1) {

					System.out.println("Player One, You're Up! " + String.valueOf(playertwo.size()) + " cards left!"
							+ ((playertwo.size() == 1) ? "...Uno!" : ""));
					// Finding a card to place
					for (cardIndex = 0; cardIndex < playerone.size(); cardIndex++) {
						if (((UnoCard) playerone.get(cardIndex)).canPlace(drawpileCard, currentColor)) // Searching for
																										// playable
																										// cards
							break;
					}

					if (cardIndex == playerone.size()) {
						System.out.println("I've got nothing!");
						draw(1, playerone);
					} else {
						drawpileCard = (UnoCard) playerone.get(cardIndex);
						playerone.remove(cardIndex);
						currentColor = drawpileCard.color;
						System.out.println("Player One Chooses" + drawpileCard.getCard() + "!");
						System.out.println("You're Up Player Two!");
						currentuser = 2;

						// Must do as part of each turn because topCard can stay the same through a
						// round
						if (drawpileCard.value >= 10) {
//							playerOnesTurn = false; // Skipping turn

							switch (drawpileCard.value) {
							case 12: // Draw 2
								System.out.println("Drawing 2 cards");
								draw(2, playerone);
								break;

							case 13:
							case 14: // Wild cards
								do // Picking a random color that's not none
								{
									currentColor = new UnoCard().color;
								} while (currentColor == "none");

								System.out.println("The new color is " + currentColor);
								if (drawpileCard.value == 14) // Wild draw 4
								{
									System.out.println("Drawing 4 cards");
									draw(4, playerone);
								}
							}
						}

						// PLAYER TWO

						if (currentuser == 2)

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
								System.out.println("I've got nothing!");
								draw(1, playertwo);
							} else {
								drawpileCard = (UnoCard) playertwo.get(cardIndex);
								playertwo.remove(cardIndex);
								currentColor = drawpileCard.color;
								System.out.println("Player Two Chooses" + drawpileCard.getCard() + "!");
								System.out.println("You're Up Player Three!");
								currentuser = 3;

								// Must do as part of each turn because topCard can stay the same through a
								// round
								if (drawpileCard.value >= 10) {
									currentuser = 3; // Skipping turn

									switch (drawpileCard.value) {
									case 12: // Draw 2
										System.out.println("Drawing 2 cards");
										draw(2, playertwo);
										break;

									case 13:
									case 14: // Wild cards
										do // Picking a random color that's not none
										{
											currentColor = new UnoCard().color;
										} while (currentColor == "none");

										System.out.println("The new color is " + currentColor);
										if (drawpileCard.value == 14) // Wild draw 4
										{
											System.out.println("Drawing 4 cards");
											draw(4, playertwo);
										}

									}
								}

								if (currentuser == 3)

								{
									System.out.println("Player Three Has" + " " + String.valueOf(playerthree.size())
											+ " cards left!" + ((playerthree.size() == 1) ? "...Uno!" : ""));
									// Finding a card to place
									for (cardIndex = 0; cardIndex < playerthree.size(); cardIndex++) {
										if (((UnoCard) playerthree.get(cardIndex)).canPlace(drawpileCard, currentColor)) // Searching
																															// for
																															// playable
																															// cards
											break;
									}

									if (cardIndex == playerthree.size()) {
										System.out.println("I've got nothing!");
										draw(1, playerthree);
									} else {
										drawpileCard = (UnoCard) playerthree.get(cardIndex);
										playerthree.remove(cardIndex);
										currentColor = drawpileCard.color;
										System.out.println("Player Three Chooses" + drawpileCard.getCard() + "!");
										System.out.println("You're Up Player four!");
										currentuser = 4;

										// Must do as part of each turn because topCard can stay the same through a
										// round
										if (drawpileCard.value >= 10) {
											currentuser = 4; // Skipping turn

											switch (drawpileCard.value) {
											case 12: // Draw 2
												System.out.println("Drawing 2 cards");
												draw(2, playerthree);
												break;

											case 13:
											case 14: // Wild cards
												do // Picking a random color that's not none
												{
													currentColor = new UnoCard().color;
												} while (currentColor == "none");

												System.out.println("The new color is " + currentColor);
												if (drawpileCard.value == 14) // Wild draw 4
												{
													System.out.println("Drawing 4 cards");
													draw(4, playerthree);
												}

											}

										}

										if (currentuser == 4) {

											System.out.println("Player Four, You're Up! "
													+ String.valueOf(playerfour.size()) + " cards left!"
													+ ((playerfour.size() == 1) ? "...Uno!" : ""));
											// Finding a card to place
											for (cardIndex = 0; cardIndex < playerfour.size(); cardIndex++) {
												if (((UnoCard) playerfour.get(cardIndex)).canPlace(drawpileCard,
														currentColor)) // Searching for
																		// playable
																		// cards
													break;
											}

											if (cardIndex == playerfour.size()) {
												System.out.println("I've got nothing!");
												draw(1, playerfour);
											} else {
												drawpileCard = (UnoCard) playerfour.get(cardIndex);
												playerone.remove(cardIndex);
												currentColor = drawpileCard.color;
												System.out
														.println("Player Four Chooses" + drawpileCard.getCard() + "!");
												currentuser = 1;

												// Must do as part of each turn because topCard can stay the same
												// through a
												// round
												if (drawpileCard.value >= 10) {

													switch (drawpileCard.value) {
													case 12: // Draw 2
														System.out.println("Drawing 2 cards");
														draw(2, playerfour);
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
															System.out.println("Drawing 4 cards");
															draw(4, playerfour);
														}
													}
												}
											}
											// If decks are empty
											if (playerone.size() == 0)
												winner = 1;
											if (playertwo.size() == 0)
												winner = 2;
											if (playerthree.size() == 0)
												winner = 3;
											if (playerfour.size() == 0)
												winner = 4;

											// detect a winner

											if (winner == 1)
												System.out.println("Player one wins!");
											if (winner == 2)
												System.out.println("player two wins!");
											if (winner == 3)
												System.out.println("Player three wins!");
											if (winner == 4)
												System.out.println("player four wins!");
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

	public static void draw(int cards, ArrayList<UnoCard> deck) {
		for (int i = 0; i < cards; i++)
			deck.add(new UnoCard());
	}
}