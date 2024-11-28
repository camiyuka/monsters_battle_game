package br.squad3.monsters;

import br.squad3.monsters.interfaces.Monster;

public class Zombie extends Monster {

    public Zombie() {
        super(120, 15);
    }

    @Override
    public void attack(Monster target) {
        System.out.println("Zumbi ataca com mordidas infectadas!");
        target.setHealth(target.getHealth() - attackPower);
    }

    @Override
    public void defend() {
        System.out.println("Zumbi se defende, reduzindo o próximo dano!");
        setDefenseBoost(getDefenseBoost() + 3);
    }

    @Override
    public void useSpecialAbility(Monster target) {
        System.out.println("Zumbi usa sua habilidade especial: Regeneração!");
        int healAmount = 20;
        setHealth(getHealth() + healAmount);
        System.out.println("Zumbi recupera " + healAmount + " pontos de vida!");
    }
}


