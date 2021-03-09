package pomPages.todoLy;

import controles.Button;
import controles.TextBox;
import org.openqa.selenium.By;

public class LeftSection {
    //---------CREAR
    public Button addNewProjectButton = new Button(By.xpath("//td[contains(.,'Add New Project') and @class='ProjItemContent']"));
    public Button addButton = new Button(By.xpath("//input[@id='NewProjNameButton']"));
    public TextBox nameProjectTextBox = new TextBox(By.xpath("//input[@id='NewProjNameInput']"));

    //-----ACTUALIZAR
     public Button selectProject = new Button(By.xpath("//li[last()]//td[@class='ProjItemContent']"));
     public Button options= new Button(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']"));
     public Button selectEditButton = new Button(By.xpath("//ul[@id='projectContextMenu']//a[contains(.,'Edit')]"));
     public TextBox editNameProject = new TextBox(By.id("ItemEditTextbox"));
     public Button saveNewName = new Button(By.xpath("//li//div[@id='ProjectEditDiv']/*[@id=\"ItemEditSubmit\"]"));

     //--------ELIMINA
    public Button selectDeleteButton = new Button(By.xpath("//ul[@id='projectContextMenu']//a[contains(.,'Delete')]"));



    public LeftSection() {


    }
}
