package pomPages.todoLy;

import controles.Label;
import org.openqa.selenium.By;

public class CenterSection {
    public Label projectNameLabel= new Label(By.xpath("//div[@id='CurrentProjectTitle']"));
    public CenterSection(){}
}
