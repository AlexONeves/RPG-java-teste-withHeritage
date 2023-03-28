/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpgproject;

import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class Jogo {

    private Player player;
    private Player player2;
    private Boolean Ronda;

    public Jogo(Player player, Player player2) {
        this.player = player;
        this.player2 = player2;
        this.Ronda = true;
    }

    public void ComeçarJogo() {

        Scanner sc = new Scanner(System.in);
        int option = 0;
        System.out.println("Iniciou um jogo com a personagem " + player.getNome() + " Hp - " + player.getHP() + " Ataque - " + player.getAttack());

        do {
            System.out.print("Escolha uma das opções: \n"
                    + "1 - ATACAR OS OUTROS Ó FILHO\n"
                    + "2 - Ver status dos jogadores\n"
                    + "3 - Sair do Jogo\n");

            System.out.println("Opção: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    Player.verJogadores();
                    System.out.println("Selecione a vitima :)");
                    System.out.println("Opção :");
                    sc.nextLine();
                    String Nome = sc.nextLine();
                    Player JogadorSelecionado = null;

                    for (Player p : Player.allPlayers) {
                        if (p.getNome().equals(Nome)) {
                            JogadorSelecionado = p;
                            break;
                        }
                    }

                    if (JogadorSelecionado != null) {
                        if (JogadorSelecionado.getNome().equals(player.getNome())) {
                            System.out.println("NÃO PODES ATACAR A TI MESMO OH BURRO");
                        } else {
                            if (player instanceof Mago) {
                                System.out.print("Escolha uma das opções: \n"
                                        + "1 - Ataque Normal\n"
                                        + "2 - Ataque especial\n");

                                System.out.println("Opção: ");
                                int AtaqueOption = sc.nextInt();

                                switch (AtaqueOption) {
                                    case 1:
                                        System.out.println("Você atacou o jogador: " + JogadorSelecionado.getNome());
                                        int NewHP = JogadorSelecionado.getHP() - player.getAttack();
                                        JogadorSelecionado.setHP(NewHP);
                                        System.out.println(JogadorSelecionado.getNome() + " ficou com " + JogadorSelecionado.getHP() + " de vida.");
                                        break;
                                    case 2:
                                        System.out.println("Você atacou o jogador " + JogadorSelecionado.getNome() + " com o seu ataque especial!!!!!");
                                        int NewHPSpecial = JogadorSelecionado.getHP() - ((Mago) player).getSpecial();
                                        JogadorSelecionado.setHP(NewHPSpecial);
                                        System.out.println(JogadorSelecionado.getNome() + " ficou com " + JogadorSelecionado.getHP() + " de vida.");
                                        break;
                                }
                            } else if (player instanceof GajoOP) {
                                System.out.print("Escolha uma das opções: \n"
                                        + "1 - Ataque Normal\n"
                                        + "2 - Ataque OP\n");

                                System.out.println("Opção: ");
                                int AtaqueOption = sc.nextInt();

                                switch (AtaqueOption) {
                                    case 1:
                                        System.out.println("Você atacou o jogador: " + JogadorSelecionado.getNome());
                                        int NewHP = JogadorSelecionado.getHP() - player.getAttack();
                                        JogadorSelecionado.setHP(NewHP);
                                        System.out.println(JogadorSelecionado.getNome() + " ficou com " + JogadorSelecionado.getHP() + " de vida.");
                                        break;
                                    case 2:
                                        System.out.println("Você atacou o jogador " + JogadorSelecionado.getNome() + " com o seu ataque especial!!!!!");
                                        int NewHPSpecial = JogadorSelecionado.getHP() - ((GajoOP) player).getSpecial();
                                        JogadorSelecionado.setHP(NewHPSpecial);
                                        System.out.println(JogadorSelecionado.getNome() + " ficou com " + JogadorSelecionado.getHP() + " de vida.");
                                        break;
                                }

                            } else {
                                System.out.println("Você atacou o jogador: " + JogadorSelecionado.getNome());
                                int NewHP = JogadorSelecionado.getHP() - player.getAttack();
                                JogadorSelecionado.setHP(NewHP);
                                System.out.println(JogadorSelecionado.getNome() + " ficou com " + JogadorSelecionado.getHP() + " de vida.");
                            }

                        }

                    } else {
                        System.out.println("Jogador não encontrado.");
                    }

                    break;
                case 2:
                    Player.verStatus();
                    break;
                case 3:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("WRONG!");
                    break;
            }
        } while (option != 3);
    }

}
