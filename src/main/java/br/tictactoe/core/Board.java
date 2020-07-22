package br.tictactoe.core;

import br.tictactoe.UI.UI;

public class Board {

	private char[][] matrix;

	public Board() {
		this.matrix = new char[3][3];
		this.clear();
	}

	private void clear() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.matrix[i][j] = ' ';
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				UI.print(String.valueOf(" " + matrix[i][j]));

				if (j != 2) {
					UI.print(" |");
				}
			}
			UI.println("");
			if (i != 2) {
				UI.print("-----------");
			}
			UI.println("");
		}
	}

	public void inputMove(String move, Player player) throws InvalidMoveException {
		int i, j;

		String[] tokens = move.split(",");

		i = Integer.parseInt(tokens[0]);
		j = Integer.parseInt(tokens[1]);

		if (isEmpty(i, j)) {
			this.matrix[i][j] = player.getSymbol();
		} else {
			throw new InvalidMoveException("A jogada não pode ser realizada nessa posição");
		}

	}

	public boolean isEmpty(int i, int j) {
		return this.matrix[i][j] == ' ';
	}

}
