package be.pxl.collections.opdracht1;

import java.util.TreeSet;

public class Hand {
	private TreeSet<Card> cards;

	public Hand() {
		cards = new TreeSet<Card>((c1, c2) -> c1.compareTo(c2));
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public String showHand() {
		return cards.stream().map(c -> c.toString()).reduce("", (accumulator, element) -> accumulator + element);
	}

	public boolean hasColor(Color color) {
		return cards.stream().filter(c -> c.getColor() == color).count() >= 1;
	}

}
