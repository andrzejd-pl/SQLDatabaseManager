package com.dybowski_andrzej.Controllers;

import Models.Model;

import javax.swing.text.View;
import java.util.List;

public class Controller {
    private List<Model> models;
    private List<View> views;

    public void addMode(Model model) {
        this.models.add(model);
    }

    public void addView(View view) {
        this.views.add(view);
    }

    public void viewTables() {

    }

    public void selectAllFromTable() {

    }

    public void selectFromTable() {

    }

    public void insertToTable() {

    }

    public void createNewTable() {

    }

    public void dropTable() {

    }
}
