package br.squad3.monsters;

import br.squad3.monsters.interfaces.Monster;

public class Zombie implements Monster {
    private int health = 120;
    private int attackPower = 15;
    private int defense = 5;

    @Override
    public void attack(Monster target) {
        System.out.println("Zumbi ataca com mordidas infectadas!");
        target.setHealth(target.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println("Zumbi se defende, reduzindo o próximo dano!");
        defense += 3;
    }

    @Override
    public void useSpecialAbility(Monster target) {
        System.out.println("Zumbi usa sua habilidade especial: Regeneração!");
        int healAmount = 20;
        this.health += healAmount;
        System.out.println("Zumbi recupera " + healAmount + " pontos de vida!");
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }
}
