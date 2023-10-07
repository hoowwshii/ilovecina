import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class scrape {
    private static void checkSelectList(List<WebElement> select){
        if (!select.isEmpty()){
            select.get(0).click();
        } else {
            System.out.println("lol");
        }
    }
    public static void scraping(FirefoxDriver ao, String word) throws InterruptedException{
        List<WebElement> select = ao.findElements(By.className("btn-action"));
        checkSelectList(select);
        WebElement input = ao.findElement(By.id("word"));
        input.sendKeys(word);
        input.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement outer = ao.findElement(By.id("sen0"));
        WebElement Inner = outer.findElement(By.className("sm2_link"));
        String link = Inner.getAttribute("href");
        //hardcoded lol
        String substr = link.substring(34);
        download.downplease(link, "D:\\sekolah\\tik\\" + substr); // done banh please
    }
}
