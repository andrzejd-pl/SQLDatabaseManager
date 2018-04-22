package Views;

import Models.Model;

public class View {
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
