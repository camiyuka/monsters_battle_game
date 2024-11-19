package br.squad3.monsters;

import br.squad3.monsters.interfaces.Monster;

public class Dragon extends Monster {

    public Dragon() {
        super(100, 20);
    }

    @Override
    public void attack(Monster target) {
        System.out.println("Dragão ataca com suas garras afiadas!");
        target.setHealth(target.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println("Dragão se defende, aumentando sua resistência!");
        setDefenseBoost(getDefenseBoost() + 5);
    }

    @Override
    public void useSpecialAbility(Monster target) {
        System.out.println("Dragão usa sua habilidade especial: Sopro de Fogo!");
        int fireDamage = 30;
        target.setHealth(target.getHealth() - (attackPower + fireDamage));
    }
}