package gui;

public class Application {

    private Button button;
    private CheckBox checkBox;

    public Application(UIFactory factory) {
         button = factory.createButton();
         checkBox = factory.createCheckBox();
    }

    public void paint(){
        button.paint();
        checkBox.paint();
    }
}
