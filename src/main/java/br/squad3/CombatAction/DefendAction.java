package br.squad3.CombatAction;

import br.squad3.monsters.interfaces.Monster;

public class DefendAction implements CombatAction {
    @Override
    public void execute(Monster attacker, Monster defender) {
        int defenseBoost = 5;
        System.out.println(attacker.getClass().getSimpleName() + " se defende, aumentando a defesa em " + defenseBoost + " temporariamente.");
        attacker.setHealth(attacker.getHealth() + defenseBoost);
    }
}
