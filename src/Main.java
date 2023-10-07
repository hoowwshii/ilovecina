import java.io.FileNotFoundException;
import java.lang.String;

import com.google.common.base.Stopwatch;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main{
    public static ArrayList<String> item = new ArrayList<>();

    public static String url = "https://www.purpleculture.net/dictionary-details";
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        setting.sets();
        parse.parser("C:\\Users\\hoshi\\IdeaProjects\\untitled\\src\\file.txt", item);
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        FirefoxDriver firefoxDriver = new FirefoxDriver(options);
        firefoxDriver.get(url);
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i<item.size();i++) {
            scrape.scraping(firefoxDriver, item.get(i));
        }
        stopwatch.stop();
        firefoxDriver.quit();
        long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(millis);
}
}
