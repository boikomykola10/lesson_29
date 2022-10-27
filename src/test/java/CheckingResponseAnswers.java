import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class CheckingResponseAnswers {
    @Test
    public void checkingResponse() throws IOException {
        open("https://rozetka.com.ua/");
        ElementsCollection sidebarLinks = $$(By.xpath("//a[@class='menu-categories__link']"));

        // інший варіант вирішення задачі
        /*ArrayList<String> myList = new ArrayList<>();
        for (SelenideElement element: sidebarLinks) {
            String link = element.getAttribute("href");
            myList.add(link);
            for (String i: myList) {
                checkingResp(i);
        }*/
        for (SelenideElement myElement: sidebarLinks) {
            String link = myElement.getAttribute("href");
            checkingResp(link);
        }
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
