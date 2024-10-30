package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	public static void main(String[] args) {
		
		//instance of chromedriver
		WebDriver driver = new ChromeDriver();
		//Implicite wait - Tells Selenium t0 wait for 5 seconds to get all the elements loaded 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//navigate to jqueryui.com
		driver.get("https://jqueryui.com/droppable/");
		//maximize the brow
		driver.manage().window().maximize();
		// Switch to iframe that contains the drag and drop elements
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		//to find the source element 
		WebElement src = driver.findElement(By.cssSelector("div#draggable"));
		// to find the destination element
		WebElement dest = driver.findElement(By.cssSelector("div#droppable"));
		// To perform drag and drop the element use actions
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
		 // Verify the drop by checking the background color of the target element
        String backgroundColor = dest.getCssValue("background-color");
        System.out.println("Background color of target element after drop: " + backgroundColor);

        // Check if the background color has changed to the expected color after drop
        if (backgroundColor.equals("rgba(255, 250, 144, 1)") || backgroundColor.equals("rgb(238, 77, 77)")) {
            System.out.println("Drag and drop action successful: Target element's background color changed.");
        } else {
            System.out.println("Drag and drop action failed: Target element's background color did not change.");
        }

        // Verify the text of the target element
        String targetText = dest.getText();
        System.out.println("Text of target element after drop: " + targetText);

        if (targetText.equals("Dropped!")) {
            System.out.println("Drag and drop action successful: Target element's text changed to 'Dropped!'.");
        } else {
            System.out.println("Drag and drop action failed: Target element's text did not change to 'Dropped!'.");
        }

		
		
	}

}
