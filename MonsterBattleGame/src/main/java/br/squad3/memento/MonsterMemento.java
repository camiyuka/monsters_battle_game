package br.squad3.memento;

public class MonsterMemento {
    private final int health;
    private final int attackPower;
    private final int defenseBoost;

    public MonsterMemento(int health, int attackPower, int defenseBoost) {
        this.health = health;
        this.attackPower = attackPower;
        this.defenseBoost = defenseBoost;
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
