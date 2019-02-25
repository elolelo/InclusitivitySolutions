public enum CardSuit {

	SPADES("S"),
	CLUBS("C"),
	HEARTS("H"),
	DIAMONDS("D");
	
	/*
	public static void main(String[] args) {
		System.out.println(java.util.Arrays.asList(CardSuit.values()));
		
	} */
	
	private final String symbol;

	private CardSuit(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
}

