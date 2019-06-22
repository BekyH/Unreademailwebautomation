/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gmail;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 *
 * @author Beka
 */
public class Gmail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
// Create a new instance of the FireFox driver
WebDriver driver = new FirefoxDriver();
// Storing the Application Url in the String variable
String url = "http://gmail.com";
//Launch the localhost WebSite
driver.get(url);



driver.findElement(By.id("identifierId")).sendKeys("your email");
driver.findElement(By.id("identifierNext")).click();
WebDriverWait wait = new WebDriverWait(driver, 100);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
WebElement elementpwd = driver.findElement(By.xpath("//input[@type='password']"));
elementpwd.sendKeys("your password");
driver.findElement(By.id("passwordNext")).click();



  List<WebElement> unreademeil = driver.findElements(By.xpath("//*[@class='zF']"));
  StringBuilder unreademail = new StringBuilder();

   
for(WebElement msg:
        unreademeil){
    unreademail.append(msg.getText()).append(" ");
    unreademail.append("\n");

    
}
write(unreademail.toString());
driver.close();
    }
     private static void write(String content) {
        String fileNameToStoreunreademail = "C:\\Users\\Beka\\Desktop\\webscript\\unreademail.txt";

        try {
            Writer writer = new FileWriter(fileNameToStoreunreademail);
            writer.write(content);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
    }

//driver.close();// TODO code application logic here
    }
    

