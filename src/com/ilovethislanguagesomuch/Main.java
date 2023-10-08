package com.ilovethislanguagesomuch;

import java.io.IOException;
import java.lang.String;
import java.io.FileWriter;
import com.google.common.base.Stopwatch;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main{
    public static ArrayList<String> item = new ArrayList<>();

    public static String url = "https://www.purpleculture.net/dictionary-details";
    public static void main(String[] args) throws IOException {
        setting.sets();
        parse.parser("C:\\Users\\hoshi\\IdeaProjects\\untitled\\src\\file.txt", item);
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        FirefoxDriver firefoxDriver = new FirefoxDriver(options);
        firefoxDriver.get(url);
        FileWriter writer;
        //writer = new FileWriter("C:\\Users\\hoshi\\IdeaProjects\\untitled\\src\\skippedlist.txt", true);
        ArrayList<String> skipped = new ArrayList<>();
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i<item.size();i++) {
            try {
                scrape.scraping(firefoxDriver, item.get(i));
            } catch (Exception e){
                skipped.add(item.get(i));
            }

        }
        stopwatch.stop();
        firefoxDriver.quit();
        long millis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        writer = new FileWriter("C:\\Users\\hoshi\\IdeaProjects\\untitled\\src\\skippedlist.txt");

        for(String x : skipped){
            writer.write(x + "\n");
        }
        writer.close();
        System.out.println(millis);
}
}
