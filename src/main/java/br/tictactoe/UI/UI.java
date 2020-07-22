package br.tictactoe.UI;

import java.util.Scanner;

public class UI {

	public static void print(String text) {
		System.out.print(text);
	}

	public static void println(String text) {
		System.out.println(text);
	}

	public static String readString() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	public static int readInt() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	public static void printGameTitle() {
		UI.println("*********************");
		UI.println("    TIC TAC TOE!!    ");
		UI.println("*********************");
		UI.println("");
	}

}
