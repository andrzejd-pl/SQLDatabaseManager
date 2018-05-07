package com.dybowski_andrzej.Models;

import com.dybowski_andrzej.Views.View;

import java.util.List;

public abstract class Model {
    private List<View> observers;
    private State state;

    public Model(List<View> observers) {
        this.observers = observers;
    }

    public void addObserver(View observer) {
        this.observers.add(observer);
    }

    public void deleteObserver(View observer) {
        int index = observers.indexOf(observer);
        if (index != -1) observers.remove(index);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void notifyObservers() {
        observers.forEach(View::update);
    }

}
