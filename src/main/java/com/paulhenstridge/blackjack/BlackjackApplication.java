package com.paulhenstridge.blackjack;

import com.paulhenstridge.blackjack.model.GameDeck;
import com.paulhenstridge.blackjack.model.Player;
import com.paulhenstridge.blackjack.model.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlackjackApplication.class, args);
	}

}
