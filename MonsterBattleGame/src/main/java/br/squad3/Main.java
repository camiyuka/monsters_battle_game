package br.squad3;

import br.squad3.memento.GameMemento;
import br.squad3.memento.GameStateCaretaker;
import br.squad3.memento.MonsterMemento;
import br.squad3.monsters.enums.MonsterType;
import br.squad3.monsters.interfaces.Monster;
import br.squad3.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Jogo de combate entre monstros.
 * Modos disponíveis: PvP (Player vs Player) ou PvE (Player vs Computador).
 * Cada jogador escolhe um monstro, e os turnos se alternam até que um monstro seja derrotado.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameStateCaretaker caretaker = new GameStateCaretaker();
        boolean gameRunning = true;

        System.out.println("=== Bem-vindo ao Combate de Monstros ===");
        System.out.println("Instruções do jogo:");
        System.out.println("1. Escolha um modo de jogo: PvP ou PvE.");
        System.out.println("2. Cada jogador escolhe um monstro para batalhar.");
        System.out.println("3. Durante o seu turno, escolha uma ação: Atacar, Defender ou Usar Habilidade Especial.");
        System.out.println("4. O jogo termina quando a vida de um dos monstros chega a zero.");
        System.out.println("========================================");

        while (gameRunning) {
            System.out.println("=== Menu Inicial ===");
            System.out.println("1. Novo Jogo");
            System.out.println("2. Carregar Jogo");
            System.out.println("3. Sair");
            System.out.println("====================");
            System.out.print("Escolha uma opção: ");
            int menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1 -> startNewGame(scanner, caretaker);
                case 2 -> loadGame(scanner, caretaker);
                case 3 -> {
                    System.out.println("Saindo do jogo. Até logo!");
                    gameRunning = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void startNewGame(Scanner scanner, GameStateCaretaker caretaker) {
        System.out.println("Escolha o modo de jogo: 1 - PvP, 2 - PvE");
        int mode = scanner.nextInt();

        Player player1 = new Player("Jogador 1", MonsterType.DRAGON);
        Player player2 = (mode == 1)
                ? new Player("Jogador 2", MonsterType.ROBOT)
                : new Player("Computador", MonsterType.ZOMBIE);

        player1.getMonster().addObserver(player1);
        player2.getMonster().addObserver(player2);

        boolean gameInProgress = true;

        while (gameInProgress) {
            System.out.println("Turno do Jogador 1: Escolha uma ação: 1 - Atacar, 2 - Defender, 3 - Habilidade Especial");
            int action = scanner.nextInt();

            switch (action) {
                case 1 -> {
                    player1.getMonster().attack(player2.getMonster());
                    awardPoints(player1, 10);
                }
                case 2 -> {
                    player1.getMonster().defend();
                    awardPoints(player1, 5);
                }
                case 3 -> {
                    player1.getMonster().useSpecialAbility(player2.getMonster());
                    awardPoints(player1, 15);
                }
                default -> System.out.println("Ação inválida. Tente novamente.");
            }

            if (player2.getMonster().getHealth() <= 0) {
                System.out.println("Jogador 1 venceu!");
                gameInProgress = false;
                break;
            }

            if (mode == 1) {
                System.out.println("Turno do Jogador 2: Escolha uma ação: 1 - Atacar, 2 - Defender, 3 - Habilidade Especial");
                action = scanner.nextInt();
            } else {
                action = new Random().nextInt(3) + 1;
            }

            switch (action) {
                case 1 -> {
                    player2.getMonster().attack(player1.getMonster());
                    awardPoints(player2, 10);
                }
                case 2 -> {
                    player2.getMonster().defend();
                    awardPoints(player2, 5);
                }
                case 3 -> {
                    player2.getMonster().useSpecialAbility(player1.getMonster());
                    awardPoints(player2, 15);
                }
                default -> System.out.println("Ação inválida. Tente novamente.");
            }

            if (player1.getMonster().getHealth() <= 0) {
                System.out.println((mode == 1 ? "Jogador 2" : "Computador") + " venceu!");
                gameInProgress = false;
            }
        }

        displayFinalScores(player1, player2);

        System.out.println("Deseja salvar o estado do jogo? (1 - Sim, 2 - Não)");
        int saveOption = scanner.nextInt();
        if (saveOption == 1) {
            List<MonsterMemento> monsterStates = new ArrayList<>();
            monsterStates.add(player1.getMonster().saveState());
            monsterStates.add(player2.getMonster().saveState());
            caretaker.saveState(new GameMemento(monsterStates, player1.getScore(), player2.getScore()));
            System.out.println("Jogo salvo com sucesso!");
        }
    }

    private static void loadGame(Scanner scanner, GameStateCaretaker caretaker) {
        GameMemento savedState = caretaker.loadState();
        if (savedState == null) {
            System.out.println("Nenhum jogo salvo encontrado.");
            return;
        }

        System.out.println("Carregando jogo salvo...");
        List<MonsterMemento> monsterStates = savedState.getMonsterStates();

        Monster monster1 = Monster.restoreMonsterFromMemento(monsterStates.get(0));
        Monster monster2 = Monster.restoreMonsterFromMemento(monsterStates.get(1));

        Player player1 = new Player("Jogador 1", monster1);
        Player player2 = new Player("Jogador 2", monster2);

        player1.getMonster().addObserver(player1);
        player2.getMonster().addObserver(player2);

        boolean gameInProgress = true;

        while (gameInProgress) {
            System.out.println("Turno do Jogador 1: Escolha uma ação: 1 - Atacar, 2 - Defender, 3 - Habilidade Especial");
            int action = scanner.nextInt();

            switch (action) {
                case 1 -> {
                    player1.getMonster().attack(player2.getMonster());
                    awardPoints(player1, 10);
                }
                case 2 -> {
                    player1.getMonster().defend();
                    awardPoints(player1, 5);
                }
                case 3 -> {
                    player1.getMonster().useSpecialAbility(player2.getMonster());
                    awardPoints(player1, 15);
                }
                default -> System.out.println("Ação inválida. Tente novamente.");
            }

            if (player2.getMonster().getHealth() <= 0) {
                System.out.println("Jogador 1 venceu!");
                gameInProgress = false;
                break;
            }

            System.out.println("Turno do Jogador 2: Escolha uma ação: 1 - Atacar, 2 - Defender, 3 - Habilidade Especial");
            action = scanner.nextInt();

            switch (action) {
                case 1 -> {
                    player2.getMonster().attack(player1.getMonster());
                    awardPoints(player2, 10);
                }
                case 2 -> {
                    player2.getMonster().defend();
                    awardPoints(player2, 5);
                }
                case 3 -> {
                    player2.getMonster().useSpecialAbility(player1.getMonster());
                    awardPoints(player2, 15);
                }
                default -> System.out.println("Ação inválida. Tente novamente.");
            }

            if (player1.getMonster().getHealth() <= 0) {
                System.out.println("Jogador 2 venceu!");
                gameInProgress = false;
            }
        }

        displayFinalScores(player1, player2);
    }

    private static void awardPoints(Player player, int points) {
        player.setScore(player.getScore() + points);
        System.out.println(player.getName() + " ganhou " + points + " pontos. Pontuação atual: " + player.getScore());
    }

    private static void displayFinalScores(Player player1, Player player2) {
        System.out.println("Pontuação Final:");
        System.out.println(player1.getName() + ": " + player1.getScore() + " pontos.");
        System.out.println(player2.getName() + ": " + player2.getScore() + " pontos.");
    }
}