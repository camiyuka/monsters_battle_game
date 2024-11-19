package br.squad3.memento;

import java.util.ArrayList;
import java.util.List;

public record GameMemento(List<MonsterMemento> monsterStates) {
    public GameMemento(List<MonsterMemento> monsterStates) {
        this.monsterStates = new ArrayList<>(monsterStates);
    }
}