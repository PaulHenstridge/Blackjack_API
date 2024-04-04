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

		
		Session session = new Session();

		session.playRound();
		SpringApplication.run(BlackjackApplication.class, args);
	}

}
