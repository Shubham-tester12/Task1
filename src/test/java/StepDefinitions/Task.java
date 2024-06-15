package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Task {

    WebDriver driver;  
    private WebDriverWait wait;


    @Given("I am on the Dashboard page")
    public void i_am_on_the_login_page() {        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
        driver.get("https://minimals.cc/");
        driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
        WebElement loginButton = driver.findElement(By.xpath("(//button[normalize-space()='Sign in'])[1]"));        
        loginButton.click();
      
    }
    
    @When("Select the User menu item from the sidebar")
    public void select_the_user_menu_item_from_the_sidebar() {
    	driver.findElement(By.xpath("//div[@aria-label='User']")).click();
    }

    @When("Navigate to the Account submenu item")
    public void navigate_to_the_account_submenu_item() {
    	driver.findElement(By.xpath("//span[contains(text(),'Account')]")).click();
    }

    @When("Open the Billing tab")
    public void open_the_billing_tab() {
    	driver.findElement(By.xpath("//button[normalize-space()='Billing']")).click();
    }

    @When("Update the billing name to Deja Brady.")
    public void update_the_billing_name_to_deja_brady() {
    	driver.findElement(By.xpath("//button[normalize-space()='Jayvion Simon']")).click();
    	driver.findElement(By.xpath("//h6[normalize-space()='Deja Brady']")).click();
    }

    @When("Change the payment method to the card ending in {int}")
    public void change_the_payment_method_to_the_card_ending_in(Integer int1) {
    	driver.findElement(By.cssSelector("div:nth-child(5) div:nth-child(2) button:nth-child(1)")).click();
    	driver.findElement(By.cssSelector("body > div:nth-child(20) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > h6:nth-child(2)")).click();
    }

    @Then("Confirm that the billing name and payment method have been updated correctly")
    public void confirm_that_the_billing_name_and_payment_method_have_been_updated_correctly() {
    	 String billingName = driver.findElement(By.xpath("//button[normalize-space()='Deja Brady']")).getText();      
    	 String paymentMethod = driver.findElement(By.xpath("//button[normalize-space()='**** **** **** 1234']")).getText();
         
                  
         if (!billingName.equals("Deja Brady")) {
             throw new AssertionError("Billing name update failed");
         }
         
         if (!paymentMethod.equals("**** **** **** 1234")) {
             throw new AssertionError("Payment method update failed");
         }
         
    }
    
    @When("Select the Order menu item from the sidebar")
    public void select_the_order_menu_item_from_the_sidebar() {
    	driver.findElement(By.xpath("//div[@aria-label='Order']")).click();
    }

    @When("Navigate to the List submenu item")
    public void navigate_to_the_list_submenu_item() {
    	driver.findElement(By.xpath("//div[@data-group='Order']//span[@class='mnl__nav__item__title MuiBox-root css-0'][normalize-space()='List']")).click();
    }

    @When("Perform a search for the query cor")
    public void perform_a_search_for_the_query_cor() {
    	driver.findElement(By.cssSelector("body > div:nth-child(19) > div:nth-child(2) > main:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > input:nth-child(2)")).sendKeys("cor");
    }

    @Then("Verify that only one row appears, displaying the user as Cortez Herring")
    public void verify_that_only_one_row_appears_displaying_the_user_as_cortez_herring() {
    	List<WebElement> rows = driver.findElements(By.cssSelector(".MuiTableRow-root.MuiTableRow-hover.css-1goe4p7"));
    
                
        if (rows.size() != 1) {
            throw new AssertionError("Expected only one row, but found: " + rows.size());
        }
       
      
    }
    
    @When("Select the Job menu item from the sidebar")
    public void select_the_job_menu_item_from_the_sidebar() {
    	driver.findElement(By.xpath("//div[@aria-label='Job']")).click();
    }
    
    
    @When("Navigate to the Job List submenu item")
    public void navigate_to_job_list_submenu_item() {
    	driver.findElement(By.xpath("//span[contains(text(),'List')]")).click();
    }
    
    @When("Open the Filters panel to reveal the sidebar")
    public void open_the_filters_panel_to_reveal_the_sidebar() {
    	driver.findElement(By.xpath("//button[normalize-space()='Filters']")).click();    
    }

    @When("Select the On Demand employment types from the filters")
    public void select_the_on_demand_employment_types_from_the_filters() {
    	driver.findElement(By.xpath("//div[@class='MuiStack-root css-1i43dhb']//div[1]//label[3]//span[1]//input[1]")).click();           
    }

    @When("Dismiss the right sidebar")
    public void dismiss_the_right_sidebar() {
    	driver.findElement(By.xpath("//div[@role='presentation']//button[2]//*[name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='path' and contains(@fill,'currentCol')]")).click();    
    }

    @Then("Ensure that only jobs with On Demand employment type are displayed")
    public void ensure_that_only_jobs_with_on_demand_employment_type_are_displayed() {
        // Find all job elements
        List<WebElement> jobs = driver.findElements(By.cssSelector(".MuiStack-root.css-1lnouhj"));

        if (jobs.size() != 4) {
            throw new AssertionError("Expected all jobs to be 'On Demand', but found discrepancies.");
        } 
    }

	@When("Select the chat with Deja Brady")
	public void select_the_chat_with_deja_brady() {
    	driver.findElement(By.xpath("//span[contains(text(),'Chat')]")).click();
    	driver.findElement(By.xpath("//span[normalize-space()='Deja Brady']")).click();
	}
	
	@When("Send the message")
	public void send_the_message() {
		// Add a pause using Thread.sleep() with try-catch block
	    try {
	        Thread.sleep(5000); // Example: Pause for 3 seconds
	    } catch (InterruptedException e) {
	        e.printStackTrace(); // Handle the exception as needed
	    }
		WebElement msg = driver.findElement(By.xpath("//input[@id='chat-message-input']"));
		msg.sendKeys("Hello, how are you?");
		msg.sendKeys(Keys.ENTER);
	}
	
	@Then("Confirm that the message has been sent successfully")
    public void confirm_that_the_message_has_been_sent_successfully() {
		WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(text(),'Hello, how are you?')]"));
        assertTrue(confirmationMessage.isDisplayed());	
	    
	    }
    
	@When("Select the File Manager menu item from the sidebar")
	public void select_the_file_manager_menu_item_from_the_sidebar() {
		driver.findElement(By.xpath("//a[@aria-label='File manager']")).click();	    
	}

	@When("Select all items listed")
	public void select_all_items_listed() {
		driver.findElement(By.xpath("//input[@name='select-all-rows']")).click();
	}

	@When("Initiate the delete action and confirm the deletion")
	public void initiate_the_delete_action_and_confirm_the_deletion() {
		driver.findElement(By.xpath("//button[@aria-label='Delete']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
	}

	@Then("Ensure that all selected items are successfully deleted")
	public void ensure_that_all_selected_items_are_successfully_deleted() {		
		WebElement text = driver.findElement(By.cssSelector(".MuiTypography-root.MuiTypography-h6.css-15g15zb"));     
		assertTrue(text.isDisplayed());	       	
	}
    
	@Then("Close the driver")
	public void driver_close() {		
		driver.close();
        	
	}
    
    
}
