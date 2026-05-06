package com.paralaltest.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParalelTest {
    WebDriver driver;
    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser){
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("geçersiz tarayıcı");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void amazonTest(){
        String baseUrl = "https://www.amazon.com.tr/";
        driver.get(baseUrl); // amazon.com'a giriş
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")); //search bar elementini bulma
        aramaKutusu.sendKeys("selenium"); // search bar'a kelime yazdırma
        aramaKutusu.submit(); // enter tuşu
    }
    @AfterClass
    public void teardown(){driver.quit();}
}
