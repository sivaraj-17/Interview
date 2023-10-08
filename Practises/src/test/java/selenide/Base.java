package selenide;

import com.codeborne.selenide.*;
import enums.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Base {

    @Test
    public void selenide() {
        Configuration.browser = "firefox";
        open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        getWebDriver().manage().window().maximize();
        $(By.name("username")).setValue("Admin");
        $(By.name("password")).setValue("admin123");
        $(By.tagName("button")).click();
        SelenideElement getElement = null;
        try {
            Locators dashboard = Locators.DASHBOARD;
            getElement = (SelenideElement) dashboard.getClass().getMethod("getElement").invoke(dashboard);
        } catch (NoSuchMethodException e) {
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        getElement.shouldHave(Condition.text("Dashboard"));
        $x("//span[text()='Admin']").click();
        ElementsCollection selenideElements = $$x("//nav[@role='navigation']/ul/li//span");
        for (SelenideElement element : selenideElements
        ) {
            String text = element.getText();
            System.out.println(text
            );
        }
    }
}
