package br.squad3.factory;

import br.squad3.monsters.Robot;
import br.squad3.monsters.Zombie;
import br.squad3.monsters.Dragon;
import br.squad3.monsters.interfaces.Monster;

public class MonsterFactory {
    public static Monster createMonster(String type) {
        if ("Dragon".equals(type)) {
            return new Dragon();
        } else if ("Zombie".equals(type)) {
            return new Zombie();
        } else if ("Robot".equals(type)) {
            return new Robot();
        } else {
            throw new IllegalArgumentException("Tipo de monstro desconhecido");
        }
    }
}