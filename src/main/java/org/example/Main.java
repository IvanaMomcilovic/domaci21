package org.example;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*Automatizovati navodjenje na sajtu https://automationexercise.com. Otici na pocetnu stranu, kliknuti
    na "Signup / Login", unesite u polja za "New User Signup!" pomocu faker-a - ime i email. Kliknuti dugme Signup.
Pored neophodnih polja na Signup ekranu uneti i date of birth, cekirati Title i
"Receive special offers from our partners!". Country staviti na "Canada".
Docekace vas ekran Account created, kliknuti "Continue". Vratice vas na pocetnu stranicu.
Za kraj kliknuti Delete Account, opet kliknuti Continue.

Waitere po potrebi dodavati.
*/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\IVANA\\KURS\\drajverZaSelenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com");
        Faker faker = new Faker();
        driver.manage().window().maximize();

        WebElement signUpLogIn = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLogIn.click();

        WebElement ime = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        ime.sendKeys(faker.name().firstName());

        WebElement mejl = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        mejl.sendKeys(faker.internet().emailAddress());


        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signUpButton.click();

        WebElement title = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
        title.click();


        WebElement day = driver.findElement(By.id("days"));
        day.click();

        WebElement brojDan = driver.findElement(By.xpath(" //*[@id=\"days\"]/option[30]"));
        brojDan.click();

        WebElement month = driver.findElement(By.id("months"));
        month.click();

        WebElement brojMesec = driver.findElement(By.xpath("//*[@id=\"months\"]/option[10]"));
        brojMesec.click();

        WebElement year = driver.findElement(By.id("years"));
        year.click();

        WebElement brojGodina = driver.findElement(By.xpath("//*[@id=\"years\"]/option[50]"));
        brojGodina.click();

        WebElement receive = driver.findElement(By.id("optin"));
        receive.click();
        Thread.sleep(5000);

        WebElement country = driver.findElement(By.xpath(" //*[@id=\"country\"]/option[3]"));
        country.click();

//Ne doceka me Account created, pa nemam ni Continue i ne mogu dalje da uradim :-( a do sada bas lepo radi

        driver.quit();
    }
}