Feature: Task

  	Scenario: Update Billing Information
    Given I am on the Dashboard page
    When Select the User menu item from the sidebar
		When Navigate to the Account submenu item
		When Open the Billing tab
		When Update the billing name to Deja Brady.
		When Change the payment method to the card ending in 1234
		Then Confirm that the billing name and payment method have been updated correctly
		Then Close the driver
		
		Scenario: Search Order
		Given I am on the Dashboard page
		When Select the Order menu item from the sidebar
		When Navigate to the List submenu item
		When Perform a search for the query cor
		Then Verify that only one row appears, displaying the user as Cortez Herring
		Then Close the driver

		Scenario: Filter Jobs
		Given I am on the Dashboard page
		When Select the Job menu item from the sidebar
		When Navigate to the Job List submenu item
		When Open the Filters panel to reveal the sidebar
		When Select the On Demand employment types from the filters
		When Dismiss the right sidebar
		Then Ensure that only jobs with On Demand employment type are displayed
		Then Close the driver

		Scenario: Send Chat Message
		Given I am on the Dashboard page
		When Select the chat with Deja Brady
		When Send the message
		Then Confirm that the message has been sent successfully
		Then Close the driver

		Scenario: Delete Files
		Given I am on the Dashboard page
		When Select the File Manager menu item from the sidebar
		When Select all items listed
		When Initiate the delete action and confirm the deletion
		Then Ensure that all selected items are successfully deleted
		Then Close the driver