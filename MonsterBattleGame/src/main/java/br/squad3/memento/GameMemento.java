package br.squad3.memento;

import java.util.ArrayList;
import java.util.List;

public class GameMemento {
    private final List<MonsterMemento> monsterStates;
    private final int player1Score;
    private final int player2Score;

    public GameMemento(List<MonsterMemento> monsterStates, int player1Score, int player2Score) {
        this.monsterStates = monsterStates;
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    public List<MonsterMemento> getMonsterStates() {
        return monsterStates;
    }
}