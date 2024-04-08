package com.paulhenstridge.blackjack;

import com.paulhenstridge.blackjack.model.GameDeck;
import com.paulhenstridge.blackjack.model.Player;
import com.paulhenstridge.blackjack.model.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BlackjackApplicationTests {
	private GameDeck deck;
	private Session session;

	@BeforeEach
	void setUp() {
		// Initialize your objects here
		Player bob = new Player("Bob");
		Player jim = new Player("Jim");
		deck = new GameDeck(2);

		List<Player> players = new ArrayList<>();
		players.add(bob);
		players.add(jim);

		deck = new GameDeck(2);
		session = new Session();
	}


	@Test
	public void TestCanGenerateDeck() {
		//Arrange
		GameDeck deck = new GameDeck(7);
		//Act
		deck.createGameDeck();
		//Assert
		assertTrue(deck.getCards().size() == deck.getNumberOfDecks()*52);

	}	@Test
	public void TestCanPlayARound() {
		//Arrange

		//Act
		session.playRound();
			//Assert
		assertTrue(session.getPrevRounds().size() == 1);
		}

	@Test
	public void canCalcHandValue() {
		//Arrange

		//Act

		//Assert

	}


}
