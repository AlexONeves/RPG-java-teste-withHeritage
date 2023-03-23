/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.rpgproject;

import java.util.Scanner;

class menu {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            System.out.print("Escolha uma das opções: \n"
                    + "1 - Criar Personagens\n"
                    + "2 - Começar Jogo\n"
                    + "3 - Editar Jogador\n"
                    + "4 - Ver Jogadores\n"
                    + "5 - Exit\n");

            System.out.println("Opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:

                    System.out.println("Quantos jogadores?");
                    int NumDeJogadores = scanner.nextInt();
                    Player.criarJogador(NumDeJogadores);
                    break;
                case 2:
                    if (Player.allPlayers.isEmpty()) {
                        System.out.println("Não existem jogadores para começar o jogo!!!");
                    } else {
                        System.out.println("Lista de Personagens: ");
                        Player.verJogadores();
                        System.out.println("Selecione a sua personagem: ");
                        scanner.nextLine(); // Corrigir erro de passar por cima
                        String Name = scanner.nextLine();

                        Player JogadorSelecionado = null;

                        for (Player p : Player.allPlayers) {
                            if (p.getNome().equals(Name)) {
                                JogadorSelecionado = p;
                                break;
                            }
                        }

                        if (JogadorSelecionado != null) {
                            System.out.println("Você selecionou o jogador: " + JogadorSelecionado.getNome());
                            Jogo novoJogo = new Jogo(JogadorSelecionado);
                            novoJogo.ComeçarJogo();
                        } else {
                            System.out.println("Jogador não encontrado.");
                        }
                    }

                    break;
                case 3:
                    if (Player.allPlayers.isEmpty()) {
                        System.out.println("Não existem jogadores para editar!!!");
                    } else {
                        Player.EditarJogadorOpt();
                    }

                    break;
                case 4:
                    Player.verJogadores();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Wrong");
                    break;
            }
        } while (option != 5);
    }
}

public class RPGProject {

    public static void main(String[] args) {
        menu.run();
    }
}
