package br.squad3.players;

import br.squad3.factory.MonsterFactory;
import br.squad3.monsters.interfaces.Monster;

public class Player {
    private String name;
    private Monster monster;
    private int score;

    public Player(String name, String monsterType) {
        this.name = name;
        this.monster = MonsterFactory.createMonster(monsterType);
    }
}
