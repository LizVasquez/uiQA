package ejercicioItem;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.CenterSection;
import pomPages.todoLy.LeftSection;
import pomPages.todoLy.LoginModal;
import pomPages.todoLy.MainPage;
import singletonSession.Session;

public class CrudItem {
    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    LeftSection leftSection= new LeftSection();
    CenterSection centerSection= new CenterSection();
    String user="liz@email.com";
    String pwd="123456";

    @Test
    public void verify_crudli_item_todoly() throws InterruptedException {
        //------LOGIN
        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);

        //----CREACION
        String newItem = "ejercicioDeClase";
        leftSection.select.click();
        centerSection.insertNameItem.set(newItem);
        centerSection.addItem.click();
        Thread.sleep(2000);
        Assert.assertEquals("ERROR!,ITEM NO CREADO",newItem,centerSection.selectItem.getText());

        //------ACTUALIZACION
       String itemUp = "updateItem";
        centerSection.selectItem.click();
        centerSection.editItem.clear();
        Thread.sleep(2000);
        centerSection.editItem.set(itemUp);

        //centerSection.saveItem.click();
        //Assert.assertEquals("ERROR,NO SE PUDO ACTUALIZAR EL ITEM",itemUp, centerSection.selectItem.getText());


        //ELIMINAR
        centerSection.selectItem.click();
        centerSection.selectItemDelete.click();
        centerSection.delete.click();
        Thread.sleep(2000);

    }

}

