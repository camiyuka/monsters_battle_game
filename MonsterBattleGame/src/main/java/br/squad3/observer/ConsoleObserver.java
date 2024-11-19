package br.squad3.observer;

import br.squad3.observer.interfaces.GameObserver;

public class ConsoleObserver implements GameObserver {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
