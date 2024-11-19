package br.squad3.CombatAction;

import br.squad3.CombatAction.interfaces.CombatAction;
import br.squad3.monsters.interfaces.Monster;

public class SpecialAbilityAction implements CombatAction {
    @Override
    public void execute(Monster attacker, Monster defender) {
        int specialDamage = 40;
        System.out.println(attacker.getClass().getSimpleName() + " usa uma habilidade especial em " + defender.getClass().getSimpleName() + " causando " + specialDamage + " de dano!");

        int newHealth = defender.getHealth() - specialDamage;
        defender.setHealth(Math.max(newHealth, 0));

        System.out.println(defender.getClass().getSimpleName() + " agora tem " + defender.getHealth() + " de vida.");
    }
}
