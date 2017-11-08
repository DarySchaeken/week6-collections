package be.pxl.collections.opdracht1;

import java.util.LinkedHashSet;
import java.util.Random;

public class Deck {
	private LinkedHashSet<Card> deque;

	public Deck() {
		deque = new LinkedHashSet<Card>();
		Color[] colors = Color.values();
		Value[] values = Value.values();
		Random random = new Random();
		
		while(deque.size() != 52){
			deque.add(new Card(colors[random.nextInt(4)], values[random.nextInt(13)]));
		}
	}
	
	public int getDeckSize() {
		return deque.size();
	}
	
	public Card dealCard() {
		Card card = (Card) deque.toArray()[deque.size()-1];
		deque.remove(card);
		return card;
	}
	
	public String showDeck() {
		return deque.stream().map(c -> c.toString()).reduce("", (accumulator,element) -> accumulator + element);
	}

}
