package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListCustomerPage extends BasePage {

	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	
	// tbody/tr[1]/td[2]/a
	// tbody/tr[2]/td[2]/a
	// tbody/tr[3]/td[2]/a
	// tbody/tr[i]/td[2]/a
	// tbody/tr[1]/td[9]/button

	String beforeXpath = "//tbody/tr[";
	String afterXpath = "]/td[2]/a";
	String afterXpathDelete = "]/td[9]/button";

	public void validateInsertedNameAndDelete() {

		for (int i = 1; i <= 5; i++) {
			String actualName = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
//			System.out.println(actualName);
			if (actualName.contains(AddCustomerPage.getInsertedName())) {
				System.out.println("Name exist.");
				driver.findElement(By.xpath(beforeXpath + i + afterXpathDelete)).click();
			}
			break;
		}
	}

}
