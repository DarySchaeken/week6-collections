package be.pxl.collections.opdracht1;

public class Card {
	private Color color;
	private Value value;

	public Card(Color color, Value value) {
		this.color = color;
		this.value = value;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.getColor().toString().substring(0,1).toUpperCase() + this.getValue().toString().substring(0,1).toUpperCase();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (color != other.color)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	public int compareTo(Card otherCard){
		if(this.getColor().getOrder() > otherCard.getColor().getOrder()){
			return 1;
		} else if(this.getColor().getOrder() == otherCard.getColor().getOrder()) {
			if(this.getValue().getOrder() > otherCard.getColor().getOrder()){
				return 1;
			} else if ((this.getValue().getOrder() < otherCard.getColor().getOrder())){
				return -1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
	}

}
