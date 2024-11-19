package br.squad3.monsters.interfaces;

import br.squad3.CombatAction.interfaces.CombatAction;
import br.squad3.memento.MonsterMemento;
import br.squad3.observer.interfaces.GameObserver;
import br.squad3.observer.interfaces.GameSubject;

import java.util.ArrayList;
import java.util.List;

public abstract class Monster implements GameSubject {
    protected int health;
    protected int attackPower;
    protected int defenseBoost;
    protected CombatAction combatAction;
    private List<GameObserver> observers = new ArrayList<>();

    public Monster(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
        this.defenseBoost = 0;
    }

    public void performCombatAction(Monster target) {
        combatAction.execute(this, target);
        notifyObservers(this.getClass().getSimpleName() + " realizou uma ação de combate contra " + target.getClass().getSimpleName());
    }

    public void setCombatAction(CombatAction combatAction) {
        this.combatAction = combatAction;
    }

    public CombatAction getCombatAction() {
        return combatAction;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        notifyObservers(this.getClass().getSimpleName() + " agora tem " + health + " pontos de vida.");
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public void setDefenseBoost(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }

    public abstract void attack(Monster target);
    public abstract void defend();
    public abstract void useSpecialAbility(Monster target);

    // Implementação do GameSubject
    @Override
    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (GameObserver observer : observers) {
            observer.update(message);
        }
    }

    public MonsterMemento saveState() {
        return new MonsterMemento(health, attackPower, defenseBoost);
    }

    public void restoreState(MonsterMemento memento) {
        this.health = memento.getHealth();
        this.attackPower = memento.getAttackPower();
        this.defenseBoost = memento.getDefenseBoost();
        notifyObservers(this.getClass().getSimpleName() + " restaurou seu estado.");
    }
}