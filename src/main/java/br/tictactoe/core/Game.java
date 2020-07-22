package br.tictactoe.core;

import java.util.Random;

import br.tictactoe.UI.UI;
import br.tictactoe.main.Constants;

public class Game {
	private Player mainPlayer;
	private Player oponentPlayer;
	private Board board;
	private String move;
	private int round = 0;

	public void play() {

		UI.printGameTitle();

		mainPlayer = this.createPlayer();
		oponentPlayer = this.createOponent();
		board = this.createBoard();

		UI.println("");
		UI.println("Bem vindo ao jogo da velha " + mainPlayer.getName() + "!");

		UI.println("RODADA: " + this.round + 1);
		UI.println("");
		while (true) {
			try {
				move = this.inputMoveMainPlayer();
				board.inputMove(move, mainPlayer);
				board.printBoard();
				move = this.inputMoveOponentPlayer();
				board.inputMove(move, oponentPlayer);
				board.printBoard();
			} catch (InvalidMoveException e) {
				UI.println("[ERRO]: " + e.getMessage());
				continue;
			}
		}
	}

	private Player createPlayer() {
		String name;
		char symbol = Constants.getSymbol()[0];
		int comand;

		UI.print("Digite o nome do jogador: ");
		name = UI.readString();
		UI.println("[1] - Para escolher 'X'");
		UI.println("[2] - Para escolher 'O'");
		UI.print("Selecione um simbolo: ");
		comand = UI.readInt();

		switch (comand) {
		case 1:
			symbol = Constants.getSymbol()[0];
			break;
		case 2:
			symbol = Constants.getSymbol()[1];
			break;

		default:
			UI.println("Opção inválida! Tente novamente");
			break;
		}

		return new Player(name, symbol);

	}

	private Player createOponent() {
		if (this.mainPlayer.getSymbol() == Constants.getSymbol()[0]) {
			return new Player("Oponente", Constants.getSymbol()[1]);
		}

		return new Player("Oponente", Constants.getSymbol()[0]);
	}

	private Board createBoard() {
		return new Board();
	}

	private String inputMoveMainPlayer() {
		String move;

		UI.print(mainPlayer.getName() + " => Digite o movimento: ");
		move = UI.readString();
		UI.println("");
		return move;
	}

	private String inputMoveOponentPlayer() {
		String move;
		Random random = new Random();
		int i, j;

		UI.println(oponentPlayer.getName() + " => Selecionando o movimento..");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (true) {
			i = random.nextInt(3);
			j = random.nextInt(3);

			if (board.isEmpty(i, j)) {
				break;
			}
		}

		UI.println("");
		return move = String.valueOf(i) + "," + String.valueOf(j);
	}
}
