package br.squad3.memento;

import br.squad3.monsters.enums.MonsterType;

public class MonsterMemento {
    private final MonsterType monsterType;
    private final int health;
    private final int attackPower;
    private final int defenseBoost;

    public MonsterMemento(MonsterType monsterType, int health, int attackPower, int defenseBoost) {
        this.health = health;
        this.monsterType = monsterType;
        this.attackPower = attackPower;
        this.defenseBoost = defenseBoost;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }
}
