package br.squad3.memento;

import java.util.Stack;

public class GameStateCaretaker {
    private Stack<GameMemento> gameHistory = new Stack<>();

    public void saveState(GameMemento memento) {
        gameHistory.push(memento);
    }

    public GameMemento loadState() {
        if (!gameHistory.isEmpty()) {
            return gameHistory.pop();
        }
        return null;
    }
}
