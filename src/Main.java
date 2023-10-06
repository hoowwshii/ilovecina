import java.lang.String;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main{
    public static List<WebElement> select;
    private static void checkSelectList(){
        if (!select.isEmpty()){
            select.get(0).click();
        } else {
            System.out.println("lol");
        }
    }
    public static String url = "https://www.purpleculture.net/dictionary-details";
    public static void main(String[] args) throws InterruptedException{
        setting.sets();
        // TODO: parse all the file
        //
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        FirefoxDriver ao = new FirefoxDriver(options);
        ao.get(url);
        select = ao.findElements(By.className("btn-action"));
        checkSelectList();
        WebElement input = ao.findElement(By.id("word"));
        input.sendKeys("你");
        input.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement outer = ao.findElement(By.id("sen0"));
        WebElement Inner = outer.findElement(By.className("sm2_link"));
        String link = Inner.getAttribute("href");

        String substr = link.substring(34);
        download.downplease(link, "E:\\LINUX\\" + substr); // done banh please


        // TODO multi download: copy from select or make a function out of it
         select = ao.findElements(By.className("btn-action"));
        checkSelectList();
         input = ao.findElement(By.id("word"));
        input.click();
        input.sendKeys("肏");
        input.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
         outer = ao.findElement(By.id("sen0"));
         Inner = outer.findElement(By.className("sm2_link"));
         link = Inner.getAttribute("href");
         substr = link.substring(34);
        download.downplease(link, "E:\\LINUX\\" + substr);
        ao.quit();
}
}
