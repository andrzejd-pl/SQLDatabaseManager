package com.dybowski_andrzej.Models;

import com.dybowski_andrzej.Views.View;

import java.util.List;

public abstract class Model {
    protected List<View> observers;


    public Model(List<View> observers) {
        this.observers = observers;
    }


}
