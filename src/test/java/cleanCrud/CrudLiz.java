package cleanCrud;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import pomPages.todoLy.CenterSection;
import pomPages.todoLy.LeftSection;
import pomPages.todoLy.LoginModal;
import pomPages.todoLy.MainPage;
import singletonSession.Session;

public class CrudLiz {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    LeftSection leftSection= new LeftSection();
    CenterSection centerSection= new CenterSection();
    String user="liz@email.com";
    String pwd="123456";

    @Test
    public void verify_crudli_project_todoly() throws InterruptedException {
        //------LOGIN

        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user,pwd);

        //--------CREACION
        String name="LizNUEVO2";
        leftSection.addNewProjectButton.click();
        leftSection.nameProjectTextBox.set(name);
        leftSection.addButton.click();

        Thread.sleep(2000);
        Assert.assertEquals("ERROR !!Projecto No Creado",name, centerSection.projectNameLabel.getText());

        //-----ACTUALIZACION
        String nameUp = "Crud";
        leftSection.selectProject.click();
        leftSection.options.click();
        leftSection.selectEditButton.click();
        leftSection.editNameProject.clear();
        leftSection.editNameProject.set(nameUp);
        leftSection.saveNewName.click();

        Thread.sleep(2000);
        Assert.assertEquals("El proyecto no fue actualizado",nameUp,centerSection.projectNameLabel.getText());

        //ELIMINA PROYECTO
        //leftSection.selectProject.click();
        //leftSection.options.click();
        //leftSection.selectDeleteButton.click();
        //Session.getSession().getDriver().switchTo().alert().accept();

       // Thread.sleep(2000);
        //Assert.assertFalse("No borro el proyecto");

    }

    @After
    public void close(){
        Session.getSession().closeSession();
    }
}

