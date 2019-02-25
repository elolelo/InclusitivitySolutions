/*
	import model.Cards;
	import java.util.List;
	import java.util.Map;
	import java.util.stream.Collectors;

	import model.Card;
	import model.CardValue;
	import model.Cards;
*/
public class Checkers {

	// this checks for a Flush
	protected class FlushChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		return cards.isAllOfTheSameSuit();
	}
	
	
	
	//This checks for the 4of a kind 
	protected class FourOfAKindChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		Map<CardValue, List<Card>> groupedByValue = cards.getCards().stream().collect(Collectors.groupingBy(Card::getValue));
		List<CardValue> values = cards.getCards().stream().map(Card::getValue).distinct().collect(Collectors.toList());
		
		return groupedByValue.size() == 2 
				&& 
				(groupedByValue.get(values.get(0)).size() == 1 && groupedByValue.get(values.get(1)).size() == 4)
				||
				(groupedByValue.get(values.get(0)).size() == 4 && groupedByValue.get(values.get(1)).size() == 1);
	}

}		

	// this checks for full house
	
	protected class FullHouseChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		Map<CardValue, List<Card>> groupedByValue = cards.getCards().stream().collect(Collectors.groupingBy(Card::getValue));
		List<CardValue> values = cards.getCards().stream().map(Card::getValue).distinct().collect(Collectors.toList());
		
		return groupedByValue.size() == 2 
				&& 
				(groupedByValue.get(values.get(0)).size() == 3 && groupedByValue.get(values.get(1)).size() == 2)
				||
				(groupedByValue.get(values.get(0)).size() == 2 && groupedByValue.get(values.get(1)).size() == 3);
	}

}

        //this checks for a high card:
        protected class HighCardChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		Map<CardValue, List<Card>> groupedByValue = cards.getCards().stream().collect(Collectors.groupingBy(Card::getValue));
		
		return !cards.isAllOfTheSameSuit() && !cards.isInAStraight() && groupedByValue.size() == 5;
	}

}
		// this checks for 1 pair:

	protected class OnePairChecker implements RankChecker {

		@Override
		public boolean matches(Cards cards) {
			Map<CardValue, List<Card>> groupedByValue = cards.getCards().stream().collect(Collectors.groupingBy(Card::getValue));
			List<CardValue> values = cards.getCards().stream().map(Card::getValue).distinct().collect(Collectors.toList());
			
			return groupedByValue.size() == 4 
					&& 
					(groupedByValue.get(values.get(0)).size() == 2 && groupedByValue.get(values.get(1)).size() == 1 && groupedByValue.get(values.get(2)).size() == 1 && groupedByValue.get(values.get(3)).size() == 1)
					||
					(groupedByValue.get(values.get(0)).size() == 1 && groupedByValue.get(values.get(1)).size() == 2 && groupedByValue.get(values.get(2)).size() == 1 && groupedByValue.get(values.get(3)).size() == 1)
					||
					(groupedByValue.get(values.get(0)).size() == 1 && groupedByValue.get(values.get(1)).size() == 1 && groupedByValue.get(values.get(2)).size() == 2 && groupedByValue.get(values.get(3)).size() == 1)
					||
					(groupedByValue.get(values.get(0)).size() == 1 && groupedByValue.get(values.get(1)).size() == 1 && groupedByValue.get(values.get(2)).size() == 1 && groupedByValue.get(values.get(3)).size() == 2);
		}

	}
	//checks for 2 pairs:
	public class TwoPairsChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		Map<CardValue, List<Card>> groupedByValue = cards.getCards().stream().collect(Collectors.groupingBy(Card::getValue));
		List<CardValue> values = cards.getCards().stream().map(Card::getValue).distinct().collect(Collectors.toList());
		
		return groupedByValue.size() == 3 
				&& 
				(groupedByValue.get(values.get(0)).size() == 2 && groupedByValue.get(values.get(1)).size() == 2 && groupedByValue.get(values.get(2)).size() == 1)
				||
				(groupedByValue.get(values.get(0)).size() == 2 && groupedByValue.get(values.get(1)).size() == 1 && groupedByValue.get(values.get(2)).size() == 2)
				||
				(groupedByValue.get(values.get(0)).size() == 1 && groupedByValue.get(values.get(1)).size() == 2 && groupedByValue.get(values.get(2)).size() == 2);
	}
	
	// 3 of  a kind
	protected class ThreeOfAKindChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		Map<CardValue, List<Card>> groupedByValue = cards.getCards().stream().collect(Collectors.groupingBy(Card::getValue));
		List<CardValue> values = cards.getCards().stream().map(Card::getValue).distinct().collect(Collectors.toList());
		
		return groupedByValue.size() == 3 
				&& 
				(groupedByValue.get(values.get(0)).size() == 3 && groupedByValue.get(values.get(1)).size() == 1 && groupedByValue.get(values.get(2)).size() == 1)
				||
				(groupedByValue.get(values.get(0)).size() == 1 && groupedByValue.get(values.get(1)).size() == 3 && groupedByValue.get(values.get(2)).size() == 1)
				||
				(groupedByValue.get(values.get(0)).size() == 1 && groupedByValue.get(values.get(1)).size() == 1 && groupedByValue.get(values.get(2)).size() == 3);
	}

}
	
	
	
	
	
	//straight
	protected class StraightChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		return cards.isInAStraight();
	}

}
	
	
	
	
	
	//straight-flush
	protected class StraightFlushChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		return cards.isAllOfTheSameSuit() && cards.isInAStraight();
	}

}
	
	
	
	
	//royal-flush
	protected class RoyalFlushChecker implements RankChecker {

	@Override
	public boolean matches(Cards cards) {
		return cards.isAllOfTheSameSuit() &&
				cards.contains(CardValue.ACE) &&
				cards.contains(CardValue.KING) &&
				cards.contains(CardValue.QUEEN) &&
				cards.contains(CardValue.JACK) &&
				cards.contains(CardValue.TEN);
	}


	
	
	
	
	

}

}

}

