package br.squad3;


import br.squad3.memento.GameMemento;
import br.squad3.memento.GameStateCaretaker;
import br.squad3.memento.MonsterMemento;
import br.squad3.monsters.Dragon;
import br.squad3.monsters.Robot;
import br.squad3.monsters.Zombie;
import br.squad3.monsters.enums.MonsterType;
import br.squad3.monsters.interfaces.Monster;
import br.squad3.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o modo de jogo: 1 - PvP, 2 - PvE");
        int mode = scanner.nextInt();

        Player player1 = new Player("Jogador 1", MonsterType.DRAGON);
        Player player2 = (mode == 1) ? new Player("Jogador 2", MonsterType.ROBOT) : new Player("Computador", MonsterType.ZOMBIE);

        player1.getMonster().addObserver(player1);
        player2.getMonster().addObserver(player2);

        boolean gameRunning = true;
        while (gameRunning) {
            System.out.println("Turno do Jogador 1: Escolha uma ação: 1 - Atacar, 2 - Defender, 3 - Habilidade Especial");
            int action = scanner.nextInt();
            switch (action) {
                case 1 -> player1.getMonster().attack(player2.getMonster());
                case 2 -> player1.getMonster().defend();
                case 3 -> player1.getMonster().useSpecialAbility(player2.getMonster());
            }
            if (player2.getMonster().getHealth() <= 0) {
                System.out.println("Jogador 1 venceu!");
                gameRunning = false;
                break;
            }

            if (mode == 1) {
                System.out.println("Turno do Jogador 2: Escolha uma ação: 1 - Atacar, 2 - Defender, 3 - Habilidade Especial");
                action = scanner.nextInt();
            } else {
                action = new Random().nextInt(3) + 1;
            }

            switch (action) {
                case 1 -> player2.getMonster().attack(player1.getMonster());
                case 2 -> player2.getMonster().defend();
                case 3 -> player2.getMonster().useSpecialAbility(player1.getMonster());
            }
            if (player1.getMonster().getHealth() <= 0) {
                System.out.println((mode == 1 ? "Jogador 2" : "Computador") + " venceu!");
                gameRunning = false;
            }
        }

        // Save the game state
        GameStateCaretaker caretaker = new GameStateCaretaker();
        List<MonsterMemento> monsterStates = new ArrayList<>();
        monsterStates.add(player1.getMonster().saveState());
        monsterStates.add(player2.getMonster().saveState());
        caretaker.saveState(new GameMemento(monsterStates));

        scanner.close();
    }
}