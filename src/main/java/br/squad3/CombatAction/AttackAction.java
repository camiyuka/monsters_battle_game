package br.squad3.CombatAction;

import br.squad3.monsters.interfaces.Monster;

public class AttackAction implements CombatAction {
    @Override
    public void execute(Monster attacker, Monster defender) {
        int damage = 20;
        System.out.println(attacker.getClass().getSimpleName() + " ataca " + defender.getClass().getSimpleName() + " causando " + damage + " de dano!");

        int newHealth = defender.getHealth() - damage;
        defender.setHealth(Math.max(newHealth, 0));

        System.out.println(defender.getClass().getSimpleName() + " agora tem " + defender.getHealth() + " de vida.");
    }

}

