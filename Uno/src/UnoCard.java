import java.util.Random;

public class UnoCard {
	public String color;
	public int value;
	private Random rand;
	private String face;

	public UnoCard(int v, String c) {
		value = v;
		color = c;
	}

	public UnoCard() {
		rand = new Random();
		value = rand.nextInt(28); // 108 cards in a standard Uno deck. Can be reduced to 27 (disregarding colors)
		// Assigning value
		if (value >= 14)
			value -= 14;

		rand = new Random();
		switch (rand.nextInt(4)) {
		case 0:
			color = "Red";
			break;
		case 1:
			color = "Green";
			break;
		case 2:
			color = "Blue";
			break;
		case 3:
			color = "Yellow";
			break;
		}
		// If the card is a wild card
		if (value >= 13)
			color = "none";
	}

	public String getCard() {

		face = "[";
		if (color != "none") {
			face += this.color + " ";
		}

		switch (this.value) {
		default:
			face += String.valueOf(this.value);
			break;
		case 10:
			face += "Skip";
			break;
		case 11:
			face += "Reverse";
			break;
		case 12:
			face += "Draw 2";
			break;
		case 13:
			face += "Wild";
			break;
		case 14:
			face += "Wild Draw 4";
			break;
		}
		face += "]";
		return face;
	}

	public boolean canPlace(UnoCard o, String c) {
		if (this.color == c)
			return true;
		else if (this.value == o.value)
			return true;
		else if (this.color == "none") // for wild cards
			return true;
		return false;
	}
}
