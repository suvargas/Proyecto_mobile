package activities.contactos;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button addButton = new Button(By.id("com.google.android.contacts:id/floating_action_button"));

    public Label getTaskName(String name){
        Label nameTask = new Label((By.id("com.google.android.contacts:id/large_title")));
        return nameTask;
    }
}