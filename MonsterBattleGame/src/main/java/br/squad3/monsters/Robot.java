package br.squad3.monsters;

import br.squad3.monsters.interfaces.Monster;

public class Robot extends Monster {
    private boolean isOverloaded = false;

    public Robot() {
        super(110, 18);
    }

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
        setDefenseBoost(getDefenseBoost() + 4);
    }

    @Override
    public void useSpecialAbility(Monster target) {
        System.out.println("Robô ativa sua habilidade especial: Sobrecarga!");
        isOverloaded = true;
    }
}

