package jokenpo;

import java.util.Random;
import java.util.Scanner;

public class vsComputador {
	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		Random gerador = new Random();
		int numeroUsuario;
		int escolhaComputador;
		int pontosUsuario = 0;
		int pontosComputador = 0;

		for (int i = 0; i < 5; i++) {
			numeroUsuario = leitor.nextInt();
			escolhaComputador = gerador.nextInt(3) + 1;

			// imprimi escolha do computador
			switch (escolhaComputador) {
			case 1:
				System.out.println("Computador escolheu papel");
				break;

			case 2:
				System.out.println("Computador escolheu tesoura");
				break;

			case 3:
				System.out.println("Computador escolheu Pedra");
				break;
			}

			// verifica escolha
			if (numeroUsuario == escolhaComputador) {
				System.out.println("Empate!");
				System.out.println("Usuario: " + pontosUsuario + " Computador " + pontosComputador);
			} else if ((numeroUsuario - escolhaComputador) == -1 || (numeroUsuario - escolhaComputador) == 2) {
				pontosUsuario++;
				System.out.println("Usuario: " + pontosUsuario + " Computador " + pontosComputador);
			} else {
				System.out.println("Computador Venceu!");
				pontosComputador++;
				System.out.println("Usuario: " + pontosUsuario + " Computador " + pontosComputador);
			}

		}
			if (pontosUsuario > pontosComputador) {
				System.out.println("Usuário venceu partida!");
	
			} else if (pontosComputador > pontosUsuario) {
				System.out.println("Computador venceu a partida!");
			} else {
				System.out.println("Partida empatada!");
			}
	}
}
