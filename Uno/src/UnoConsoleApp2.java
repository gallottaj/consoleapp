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

			for (int currentplayer = 1; winner == 0;) {
				cardIndex = 0;

				System.out.println("Player ONE, You're Up! " + String.valueOf(playerone.size()) + " cards left!"
						+ ((playerone.size() == 1) ? "...Uno!" : ""));
				// Finding a card to place
				for (cardIndex = 0; cardIndex < playerone.size(); cardIndex++) {
					if (((UnoCard) playerone.get(cardIndex)).canPlace(drawpileCard, currentColor)) // Searching for
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
					System.out.println("Player ONE Chooses" + drawpileCard.getCard() + "!");
					System.out.println("You're Up Player TWO!");
					currentplayer = 2;

					// Must do as part of each turn because topCard can stay the same through a
					// round
					if (drawpileCard.value >= 10) {
						currentplayer = 2;

						switch (drawpileCard.value) {
						case 12: // Draw 2
							System.out.println("Player ONE must draw 2 cards");
							draw(2, playerone);
							break;

						case 13:
						case 14: // Wild cards
							do // Picking a random color that's not none
							{
								currentColor = new UnoCard().color;
							} while (currentColor == "none");

							System.out.println("I choose " + currentColor);
							if (drawpileCard.value == 14) // Wild draw 4
							{
								System.out.println("Player ONE must draw 4 cards");
								draw(4, playerone);
							}
						}
					}
				}

				// PLAYER TWO

				for (currentplayer = 2; winner == 0;) {
					cardIndex = 0;

					{
						System.out.println("Player TWO Has" + " " + String.valueOf(playertwo.size()) + " cards left!"
								+ ((playertwo.size() == 1) ? "...Uno!" : ""));
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
							System.out.println("Player TWO Chooses" + drawpileCard.getCard() + "!");
							System.out.println("You're Up Player THREE!");
							currentplayer = 3;

							// Must do as part of each turn because topCard can stay the same through a
							// round
							if (drawpileCard.value >= 10) {
								currentplayer = 3;

								switch (drawpileCard.value) {
								case 12: // Draw 2
									System.out.println("Drawing 2 cards for you...");
									draw(2, playertwo);
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
										draw(4, playertwo);
									}

								}
							}

							// PLAYER THREE

							for (currentplayer = 3; winner == 0;) {
								cardIndex = 0;

								{
									System.out.println("Player THREE Has" + " " + String.valueOf(playerthree.size())
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
										System.out.println("I've got nothing! Drawing cards...");
										draw(1, playerthree);
									} else {
										drawpileCard = (UnoCard) playerthree.get(cardIndex);
										playerthree.remove(cardIndex);
										currentColor = drawpileCard.color;
										System.out.println("Player THREE Chooses" + drawpileCard.getCard() + "!");
										System.out.println("You're Up Player FOUR!");
										currentplayer = 4;

										// Must do as part of each turn because topCard can stay the same through a
										// round
										if (drawpileCard.value >= 10) {
											currentplayer = 4;

											switch (drawpileCard.value) {
											case 12: // Draw 2
												System.out.println("Drawing 2 cards for you...");
												draw(2, playerthree);
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
													draw(4, playerthree);
												}

											}
										}

										// PLAYER FOUR

										for (currentplayer = 4; winner == 0;) {
											cardIndex = 0;

											{
												System.out.println("Player FOUR Has" + " "
														+ String.valueOf(playerfour.size()) + " cards left!"
														+ ((playerfour.size() == 1) ? "...Uno!" : ""));
												// Finding a card to place
												for (cardIndex = 0; cardIndex < playerfour.size(); cardIndex++) {
													if (((UnoCard) playerfour.get(cardIndex)).canPlace(drawpileCard,
															currentColor)) // Searching
																			// for
																			// playable
																			// cards
														break;
												}

												if (cardIndex == playerfour.size()) {
													System.out.println("I've got nothing! Drawing cards...");
													draw(1, playerfour);
												} else {
													drawpileCard = (UnoCard) playerfour.get(cardIndex);
													playerfour.remove(cardIndex);
													currentColor = drawpileCard.color;
													System.out.println(
															"Player FOUR Chooses" + drawpileCard.getCard() + "!");
													System.out.println("You're Up Player ONE!");
													currentplayer = 1;

													// Must do as part of each turn because topCard can stay the same
													// through a
													// round
													if (drawpileCard.value >= 10) {
														currentplayer = 1;

														switch (drawpileCard.value) {
														case 12: // Draw 2
															System.out.println("Drawing 2 cards for you...");
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
																System.out.println("Drawing 4 cards for you...");
																draw(4, playerfour);
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
					}
				}
			}

			if (winner == 1)
				System.out.println("playerwins");
			else
				System.out.println("player two wins");

		}
	}

	public static void draw(int cards, ArrayList<UnoCard> deck) {
		for (int i = 0; i < cards; i++)
			deck.add(new UnoCard());
	}
}
