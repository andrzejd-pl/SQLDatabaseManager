package com.dybowski_andrzej.Mock;

import com.dybowski_andrzej.Models.Model;
import com.dybowski_andrzej.Models.QueryModel;
import com.dybowski_andrzej.Views.View;

public class ViewMock extends View {
    public ViewMock(QueryModel model) {
        super(model);
    }

    @Override
    public void setModel(Model model) {
    }

    @Override
    public void deleteModel() {
    }

    @Override
    public void show() {
    }

    @Override
    public void update() {
    }
}
