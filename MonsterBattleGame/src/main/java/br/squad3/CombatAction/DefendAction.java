package br.squad3.CombatAction;

import br.squad3.CombatAction.interfaces.CombatAction;
import br.squad3.monsters.interfaces.Monster;

public class DefendAction implements CombatAction {
    @Override
    public void execute(Monster attacker, Monster defender) {
        int defenseBoost = 5;
        System.out.println(defender.getClass().getSimpleName() + " se defende, reduzindo o dano em " + defenseBoost + " no próximo ataque.");

        defender.setDefenseBoost(defenseBoost);
    }
}
