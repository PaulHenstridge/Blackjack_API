package com.paulhenstridge.blackjack;

import com.paulhenstridge.blackjack.model.GameDeck;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BlackjackApplicationTests {

	@Test
	public void TestCanGenerateDeck() {
		//Arrange
		GameDeck deck = new GameDeck(7);
		//Act
		deck.createGameDeck();
		//Assert
		assertTrue(deck.getCards().size() == deck.getNumberOfDecks()*52);

	}	@Test
	public void canDealACard() {
		//Arrange

		//Act

		//Assert

	}

	@Test
	public void canCalcHandValue() {
		//Arrange

		//Act

		//Assert

	}


}
