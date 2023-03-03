package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////\n" +
                "////////////////////////////////////////\n" +
                "VNESITE IME IN PRIIMEK NEKEGA NBA IGRALCA\n" +
                "////////////////////////////////////////\n" +
                "////////////////////////////////////////\n");

        Scanner scan = new Scanner(System.in);
        String playerName = scan.nextLine();
        System.out.println("////////////////////////////////////////\n" +
                "////////////////////////////////////////\n" +
                "NE DOTIKAJTE SE BRSKALNIK JE AVTOMATIZIRAN, DA DELUJE SAM\n" +
                "////////////////////////////////////////\n" +
                " ////////////////////////////////////////\n ");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\blaze\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.nba.com/stats");
        try {
            WebElement searchInput = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div/div[1]/section[5]/div[1]/div/label/input"));
            searchInput.sendKeys(playerName);
            WebElement thePlayer = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div/div[1]/section[5]/div[1]/div/div/ul/li[1]"));

            WebElement playerLink = thePlayer.findElement(By.tagName("a"));
            String hrefValue = playerLink.getAttribute("href");
            System.out.println(hrefValue);


            driver.get(hrefValue + "?PerMode=Per40");
            String xpath = "/html/body/div[1]/div[2]/div[2]/section/div[4]/section[3]/div/div[2]/div[3]/table";
            WebElement table = driver.findElement(By.xpath(xpath));
            WebElement tbody = table.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/section/div[4]/section[3]/div/div[2]/div[3]/table/tbody"));

            List<WebElement> rows = tbody.findElements(By.tagName("tr"));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                WebElement seasonYear = cells.get(0);
                WebElement ThreePoints = cells.get(9);
                System.out.println(seasonYear.getText() + "   " + ThreePoints.getText());
            }
        } catch (Exception sad) {
            System.out.println("NAPAKA probajte se enkrat");
        } finally {
            driver.quit();
        }

    }
}


