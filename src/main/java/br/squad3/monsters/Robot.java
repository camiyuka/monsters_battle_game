package br.squad3.monsters;

import br.squad3.monsters.interfaces.Monster;

public class Robot implements Monster {
    private int health = 110;
    private int attackPower = 18;
    private int defense = 8;
    private boolean isOverloaded = false;

    @Override
    public void attack(Monster target) {
        int effectiveAttack = isOverloaded ? attackPower + 10 : attackPower;
        System.out.println("Robô ataca com punhos de metal!");
        target.setHealth(target.getHealth() - effectiveAttack);
        isOverloaded = false;
    }

    @Override
    public void defend() {
        System.out.println("Robô se defende com armadura reforçada!");
        defense += 4;
    }

    @Override
    public void useSpecialAbility(Monster target) {
        System.out.println("Robô ativa sua habilidade especial: Sobrecarga!");
        isOverloaded = true;
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
