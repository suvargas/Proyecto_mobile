package activities.contactos;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class AddContactScreen {
    // click nombre
    public TextBox titleTxtBox = new TextBox(By.xpath("//android.widget.EditText[@text='Nombre']"));
    // click apellido
    public TextBox noteTxtBox = new TextBox(By.xpath("//android.widget.EditText[@text='Apellido']"));
    //click empresa
    public TextBox empresaTxtBox = new TextBox(By.xpath("//android.widget.EditText[@text='Empresa']"));
    // click guardar
    public Button saveButton = new Button(By.id("com.google.android.contacts:id/toolbar_button"));

}