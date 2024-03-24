package com.paulhenstridge.blackjack;

import com.paulhenstridge.blackjack.model.GameDeck;
import com.paulhenstridge.blackjack.model.Player;
import com.paulhenstridge.blackjack.model.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {

		Player bob = new Player("Bob");
		Player jim = new Player("Jim");
		GameDeck deck = new GameDeck(2);

		List<Player> players = new ArrayList<>();
		players.add(bob);
		players.add(jim);

		deck = new GameDeck(2);
		Session session = new Session(deck, players);

		session.playRound();
		SpringApplication.run(BlackjackApplication.class, args);
	}

}
