package br.squad3.monsters.factory;

import br.squad3.monsters.Robot;
import br.squad3.monsters.Zombie;
import br.squad3.monsters.Dragon;
import br.squad3.monsters.enums.MonsterType;
import br.squad3.monsters.interfaces.Monster;

public class MonsterFactory {
    public static Monster createMonster(MonsterType monsterType) {
        return switch (monsterType) {
            case DRAGON -> new Dragon();
            case ZOMBIE -> new Zombie();
            case ROBOT -> new Robot();
            default -> throw new IllegalArgumentException("Tipo de monstro desconhecido: " + monsterType);
        };
    }
}