package enums;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public enum Locators {
    DASHBOARD(By.xpath("//h6[text()='Dashboard']"));

    private By by;

    Locators(By by) {
        this.by = by;
    }

    public SelenideElement getElement(){
        return $(by);
    }
}
