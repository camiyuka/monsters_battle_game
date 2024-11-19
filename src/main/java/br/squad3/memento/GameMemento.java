package br.squad3.memento;

import br.squad3.GameState;

public class GameMemento {
    private final GameState state;

    public GameMemento(GameState state) {
        this.state = new GameState(state);
    }

    public GameState getState() {
        return state;
    }
}
