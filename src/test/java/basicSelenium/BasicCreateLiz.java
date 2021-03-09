package basicSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BasicCreateLiz {
    ChromeDriver driver;

    @Before
    public void before(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromeDriver/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void loginTodoLy() throws InterruptedException {
        String myPrject="UpdateProject";

        driver.get("http://todo.ly/");

        //------ LOGIN ------
        //1) Click Login Button
        driver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        //2) Set Email
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("liz@email.com");
        //3) Set Password
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxPassword']")).sendKeys("123456");
        //4) Click Login Button
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$ButtonLogin']")).click();

        // *) Verificar si estoy logueado
        Assert.assertTrue("Error, nose pudo hacer login",driver.findElement(By.xpath("//a[contains(.,'Logout')]")).isDisplayed());

        //-------- ADD NUEVO PROYECTO-----------------------

        //5) Click Add New Project
        driver.findElement(By.xpath("//td[contains(.,'Add New Project') and @class='ProjItemContent']")).click();
        //6) Set NombrProject
        // limpiar la caja de texto
        //driver.findElement(By.xpath("//input[@id='NewProjNameInput']")).clear();
        driver.findElement(By.xpath("//input[@id='NewProjNameInput']")).sendKeys(myPrject);
        //7) Click Add button
        driver.findElement(By.xpath("//input[@id='NewProjNameButton']")).click();
        //*) //verificacion del nuevo project
        Thread.sleep(3000);
        String expectedResult=myPrject;
        String actualResult=driver.findElement(By.xpath("//div[@id='CurrentProjectTitle']")).getText();

        Assert.assertEquals("El projecto no fue creado",expectedResult,actualResult);

        // ------------ ACTUALIZACION -------------------------------

        // click en el projecto que hemos creado

        driver.findElement(By.xpath("//li[last()]//td[contains(.,'"+myPrject+"') and @class='ProjItemContent']")).click();

        // click en el dropdown button
        driver.findElement(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']")).click();
        // click edit button
        driver.findElement(By.xpath("//ul[@id='projectContextMenu']//a[contains(.,'Edit')]")).click();
        // set nombre projecto actualizado

        driver.findElement(By.id("ItemEditTextbox")).clear();
        driver.findElement(By.id("ItemEditTextbox")).sendKeys("LizUpdate");
        // click save button

        driver.findElement(By.xpath("//li//div[@id='ProjectEditDiv']/*[@id=\"ItemEditSubmit\"]")).click();
        // verification
        Thread.sleep(3000);
        expectedResult="LizUpdate";
        actualResult=driver.findElement(By.xpath("//div[@id='CurrentProjectTitle']")).getText();

        Assert.assertEquals("El projecto no fue actualizado",expectedResult,actualResult);


        //---------------ELIMINA--------------

        //selecciona el proyecto
        driver.findElement(By.xpath("//div[@id='ItemId_3896989']")).click();
        //eleccion en el bloque
        driver.findElement(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']")).click();
        // boton de eliminar
        // 1. driver.findElement(By.xpath("//ul[@id='projectContextMenu']//a[@href='#delete']")).click();
        driver.findElement(By.xpath("//ul[@id='projectContextMenu']//a[@id='ProjShareMenuDel']")).click();
        // acepta eliminar el proyecto
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        alert.accept();














    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
