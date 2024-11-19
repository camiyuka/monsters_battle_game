package br.squad3.observer;

public class ConsoleObserver implements GameObserver {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
