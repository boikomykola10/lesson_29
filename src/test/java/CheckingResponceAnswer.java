import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckingResponceAnswer {

    @Test
    public void checkingResponse() throws IOException {
        open("https://rozetka.com.ua/");
        WebElement sidebarMenu = $(By.xpath("//a[@class='menu-categories__link']"));
        String link = sidebarMenu.getAttribute("href");
        checkingResp(link);
    }
    public void checkingResp(String linksOnThePage) throws IOException {
        URL url = new URL(linksOnThePage);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        int responseCode = http.getResponseCode();
        System.out.println(responseCode);
        if (responseCode != 200) {
            Assert.fail("The status code is not 200!");
        }
    }
}
