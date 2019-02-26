import java.util.*;

// checks the fulll house

public class FullHouseCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new FullHouseChecker();
	}
	
	@Test
	public void handShouldBeRankedAsFullHouse() {
		for (CardValue value : CardValue.values()) {
			//The different Value:
			CardValue different = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			Card firstDifferent = new Card(CardSuit.HEARTS, different);
			Card secondDifferent = new Card(CardSuit.CLUBS, different);
			
			Card first = new Card(CardSuit.CLUBS, value);
			Card second = new Card(CardSuit.HEARTS, value);
			Card third = new Card(CardSuit.SPADES, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, third, firstDifferent, secondDifferent));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
}






/*checks the 4 of a kind
public class FourOfAKindCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new FourOfAKindChecker();
	}
	
	@Test
	public void handShouldBeRankedAsFourOfAKind() {
		for (CardValue value : CardValue.values()) {
			//The different Value:
			CardValue different = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			Card other = new Card(CardSuit.HEARTS, different);
			
			Card first = new Card(CardSuit.CLUBS, value);
			Card second = new Card(CardSuit.HEARTS, value);
			Card third = new Card(CardSuit.SPADES, value);
			Card fourth = new Card(CardSuit.DIAMONDS, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, third, fourth, other));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsFourOfAKind() {
		for (CardValue value : CardValue.values()) {
			//The different Value:
			CardValue different = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			Card other = new Card(CardSuit.HEARTS, different);
			Card first = new Card(CardSuit.CLUBS, different);
			
			Card second = new Card(CardSuit.HEARTS, value);
			Card third = new Card(CardSuit.SPADES, value);
			Card fourth = new Card(CardSuit.DIAMONDS, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, third, fourth, other));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertFalse(matches);
		}
	}
	
}

 this checks the flush class

public class FlushCheckerTest {
	
	private RankChecker checker;  
	
	@Before
	public void before() {
		this.checker = new FlushChecker();
	}
	
	@Test
	public void handShouldBeRankedAsFlush() {
		for (CardSuit suit : CardSuit.values()) {
			Card ten = new Card(suit, CardValue.TEN);
			Card nine = new Card(suit, CardValue.NINE);
			Card three = new Card(suit, CardValue.THREE);
			Card king = new Card(suit, CardValue.KING);
			Card four = new Card(suit, CardValue.FOUR);
			
			Set<Card> set = new HashSet<>(Arrays.asList(nine, three, king, four, ten));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsFlush() {
		for (CardSuit suit : CardSuit.values()) {
			//The different Suit:
			CardSuit different = Arrays.asList(CardSuit.values()).stream().filter(s -> !s.equals(suit)).findAny().get();
			Card ten = new Card(different, CardValue.TEN);

			Card nine = new Card(suit, CardValue.NINE);
			Card three = new Card(suit, CardValue.THREE);
			Card king = new Card(suit, CardValue.KING);
			Card four = new Card(suit, CardValue.FOUR);
			
			Set<Card> set = new HashSet<>(Arrays.asList(nine, three, king, four, ten));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertFalse(matches);
		}
	}
	
}

*/


