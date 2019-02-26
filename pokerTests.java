import java.util.*;

//3 of a kind
public class ThreeOfAKindCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new ThreeOfAKindChecker();
	}
	
	@Test
	public void handShouldBeRankedAsThreeOfAKind() {
		for (CardValue value : CardValue.values()) {
			//The differents Values:
			CardValue firstDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			CardValue secondDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent)).findAny().get();
			Card other = new Card(CardSuit.HEARTS, firstDifferent);
			Card secondOther = new Card(CardSuit.CLUBS, secondDifferent);
			
			Card first = new Card(CardSuit.HEARTS, value);
			Card second = new Card(CardSuit.SPADES, value);
			Card third = new Card(CardSuit.DIAMONDS, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, third, other, secondOther));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsThreeOfAKind() {
		for (CardValue value : CardValue.values()) {
			//The differents Values:
			CardValue firstDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			CardValue secondDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent)).findAny().get();
			CardValue thirdDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent) && !v.equals(secondDifferent)).findAny().get();
			Card other = new Card(CardSuit.HEARTS, firstDifferent);
			Card secondOther = new Card(CardSuit.CLUBS, secondDifferent);
			Card thirdOther = new Card(CardSuit.SPADES, thirdDifferent);
			
			Card first = new Card(CardSuit.HEARTS, value);
			Card second = new Card(CardSuit.SPADES, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, other, secondOther, thirdOther));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertFalse(matches);
		}
	}
	
}





/* checks for high card:

public class HighCardCheckerTest {
	
	private RankChecker checker;
	
	@Before
	public void before() {
		this.checker = new HighCardChecker();
	}
	
	@Test
	public void handShouldBeRankedAsHighCard() {
		for (CardValue value : CardValue.values()) {
			//The different Values:
			CardValue firstDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			CardValue secondDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent)).findAny().get();
			CardValue thirdDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent) && !v.equals(secondDifferent)).findAny().get();
			CardValue fourthDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent) && !v.equals(secondDifferent) && !v.equals(thirdDifferent) && Math.abs((v.getValue() - thirdDifferent.getValue())) > 2).findAny().get();
			
			Card first = new Card(CardSuit.HEARTS, firstDifferent);
			Card second = new Card(CardSuit.CLUBS, secondDifferent);
			Card third = new Card(CardSuit.HEARTS, thirdDifferent);
			Card fourth = new Card(CardSuit.DIAMONDS, fourthDifferent);
			Card fifth = new Card(CardSuit.DIAMONDS, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(first, second, third, fourth, fifth));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertTrue(matches);
		}
	}
	
	@Test
	public void handShouldNotBeRankedAsHighCard() {
		for (CardValue value : CardValue.values()) {
			//The different Values:
			CardValue firstDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value)).findAny().get();
			CardValue secondDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent)).findAny().get();
			CardValue thirdDifferent = Arrays.asList(CardValue.values()).stream().filter(v -> !v.equals(value) && !v.equals(firstDifferent) && !v.equals(secondDifferent)).findAny().get();
			Card firstOfPair = new Card(CardSuit.HEARTS, firstDifferent);
			Card secondOfPair = new Card(CardSuit.CLUBS, firstDifferent);
			
			Card firstOther = new Card(CardSuit.HEARTS, secondDifferent);
			Card secondOther = new Card(CardSuit.DIAMONDS, thirdDifferent);
			Card thirdOther = new Card(CardSuit.DIAMONDS, value);
			
			Set<Card> set = new HashSet<>(Arrays.asList(firstOfPair, secondOfPair, firstOther, secondOther, thirdOther));
			Cards cards = new Cards(set);
	
			boolean matches = checker.matches(cards);
			
			Assert.assertFalse(matches);
		}
	}
	
}

/* checks the fulll house

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


