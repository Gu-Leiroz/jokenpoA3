package jokenpo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class cliente {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 7778;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println(input.readLine());

            while (true) {
                System.out.println("Escolha: pedra, papel ou tesoura");
                String escolha = scanner.nextLine();
                output.println(escolha);

                String resultado = input.readLine();
                System.out.println(resultado);
                if (resultado.equals("Jogador 1 venceu!") || resultado.equals("Jogador 2 venceu!") || resultado.equals("Empate!")) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}