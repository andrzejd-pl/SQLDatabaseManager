package com.dybowski_andrzej.Views;

import com.dybowski_andrzej.Models.Model;

public abstract class View {
    private Model model;

    public View(Model model) {
        this.model = model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void deleteModel() {
        this.model = null;
    }

    public void show() {

    }

    public void update() {

    }

}
