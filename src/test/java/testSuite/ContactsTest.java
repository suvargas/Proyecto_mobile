package testSuite;

import activities.contactos.AddContactScreen;
import activities.contactos.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class ContactsTest {

    MainScreen mainScreen = new MainScreen();
    AddContactScreen addTaskScreen = new AddContactScreen();

    @Test
    public void createNewTaskTest(){
        String title="AAPROYECTO"+new Date().getTime();
        mainScreen.addButton.click();
        addTaskScreen.titleTxtBox.setText(title);
        addTaskScreen.noteTxtBox.setText("UCB");
        addTaskScreen.empresaTxtBox.setText("60129607");
        addTaskScreen.saveButton.click();
        Assertions.assertTrue(mainScreen.getTaskName(title).isControlDisplayed(),
                "ERROR no existe el contacto");
    }

    @AfterEach
    public void closeApp(){
        Session.getSession().closeSession();
    }


}
