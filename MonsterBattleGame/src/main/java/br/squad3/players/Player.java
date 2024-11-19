package br.squad3.players;

import br.squad3.monsters.enums.MonsterType;
import br.squad3.monsters.factory.MonsterFactory;
import br.squad3.monsters.interfaces.Monster;
import br.squad3.observer.interfaces.GameObserver;

public class Player implements GameObserver {
    private String name;
    private Monster monster;
    private int score;

    public Player(String name, MonsterType monsterType) {
        this.name = name;
        this.monster = MonsterFactory.createMonster(monsterType);
    }

    @Override
    public void update(String message) {
        System.out.println(name + " recebeu notificação: " + message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
