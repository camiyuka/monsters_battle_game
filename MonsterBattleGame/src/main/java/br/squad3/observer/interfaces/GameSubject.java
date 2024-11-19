package br.squad3.observer.interfaces;

public interface GameSubject {
    void addObserver(GameObserver observer);
    void removeObserver(GameObserver observer);
    void notifyObservers(String message);
}
