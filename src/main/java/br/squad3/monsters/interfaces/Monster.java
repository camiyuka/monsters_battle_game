package br.squad3.monsters.interfaces;

public interface Monster {
    void attack(Monster target);
    void defend();
    void useSpecialAbility(Monster target);
    int getHealth();
    void setHealth(int health);
}