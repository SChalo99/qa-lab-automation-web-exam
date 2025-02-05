package com.nttdata.stepsdefinitions;


import com.nttdata.steps.StoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class StoreStepDefs {
    private WebDriver driver;

    @Dado("estoy en la página de la tienda")
    public void estoyEnLaPaginaDeLaTienda(){
        driver= getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion");
        screenShot();
    }

    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String arg0, String arg1) {
        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.setUserText(arg0);
        storeSteps.setUserPassword(arg1);
        storeSteps.login();
        Assert.assertEquals("Gonzalo Garma",storeSteps.getUserLoged());
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String category, String subcategory) {
        StoreSteps storeSteps = new StoreSteps(driver);
        String cat = storeSteps.navigateCloth();
        Assert.assertEquals(cat,category.toUpperCase());
        screenShot();
        String subC = storeSteps.navigateMen();
        Assert.assertEquals(subC,subcategory.toUpperCase());
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int quantity) {
        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.clickProduct();
        storeSteps.addQuantity(quantity);
        storeSteps.addToCart();
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        StoreSteps storeSteps = new StoreSteps(driver);
        Assert.assertTrue(storeSteps.validateModal());
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        StoreSteps storeSteps = new StoreSteps(driver);
        double productPrice = storeSteps.getProductPrice();
        double quantity = storeSteps.getQuantity();
        double taxes = storeSteps.getTaxes();
        double total = storeSteps.getTotalPrice();
        double calculatedTotal = (productPrice*quantity)+taxes;
        Assert.assertEquals(total,calculatedTotal,2);
        screenShot();
    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        StoreSteps storeSteps = new StoreSteps(driver);
        storeSteps.toCheckout();
        screenShot();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        StoreSteps storeSteps = new StoreSteps(driver);
        String title = storeSteps.validateTitleCheckout();
        Assert.assertEquals("CARRITO",title);
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        StoreSteps storeSteps = new StoreSteps(driver);
        double productPrice = storeSteps.getPriceCheckout();
        double taxes = storeSteps.getTaxCheckout();
        double total = storeSteps.getTotalPriceCheckout();
        double calculatedTotal = productPrice+taxes;
        Assert.assertEquals(total, calculatedTotal,2);
        screenShot();
    }
}
