package br.squad3.CombatAction;

import br.squad3.monsters.interfaces.Monster;

public interface CombatAction {
    void execute(Monster attacker, Monster defender);
}
