package pomPages.todoLy;

import controles.Button;
import controles.Label;
import controles.TextBox;
import org.openqa.selenium.By;
import testClean.TestBaseTodoLy;

import java.lang.management.BufferPoolMXBean;

public class CenterSection {
    //PROYECTO
    public Label projectNameLabel= new Label(By.xpath("//div[@id='CurrentProjectTitle']"));

    //---ITEM
    //opcion 1.- public TextBox insertNameItem = new TextBox(By.xpath("//table[@class='AddItemTable']//textarea[@id='NewItemContentInput']"));
    public TextBox insertNameItem = new TextBox(By.xpath("//textarea[@id='NewItemContentInput']"));
    public Button addItem = new Button(By.xpath("//table[@class='AddItemTable']//input[@id='NewItemAddButton']"));

    public Button selectItem = new Button(By.xpath("//li[last()]//div[@class='ItemContentDiv']"));
    public TextBox editItem = new TextBox(By.xpath("//li[last()]//div[@id='ItemEditDiv']//textarea"));
    //public Button saveItem = new Button(By.xpath("//li[last()]//div[@id='ItemEditDiv']//img"));


///delete sirve
    //alguno en especifico por id
    //public Button selectItemDelete = new Button(By.xpath("//div[@id='ItemId_10845215']"));
    public Button selectItemDelete = new Button(By.xpath(" //li[last()]//div[@class='ItemIndicator']//img[@style='display: inline;']"));
    public Button delete = new Button(By.xpath("//ul[@id='itemContextMenu']//a[@href='#delete']"));


    public CenterSection(){}
}
