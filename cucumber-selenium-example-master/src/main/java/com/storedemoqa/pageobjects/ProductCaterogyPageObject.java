package com.storedemoqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCaterogyPageObject {
  WebDriver driver;
  WebDriverWait wait;
  PageFooter pageFooter;

  public ProductCaterogyPageObject(final WebDriver driver, final WebDriverWait wait, final PageFooter pageFooter) {
    this.driver = driver;
    this.wait = wait;
    PageFactory.initElements(driver, this);
    this.pageFooter = pageFooter;
  }

  @FindBy(xpath = ".//a[text()='Magic Mouse']")
  WebElement magicMouse;
  @FindBy(xpath = ".//input[@value='Add To Cart'][@type='submit']")
  WebElement addToCard;
  @FindBy(xpath = ".//a[text()='Go to Checkout']")
  WebElement goToCheckoutCart;

  public void verifyPageLoaded() {
    wait.until(ExpectedConditions.visibilityOf(magicMouse));
    wait.until(ExpectedConditions.visibilityOf(addToCard));
  }

  public CheckOutPageObject goToCheckOutPage() {
    CheckOutPageObject checkoutPageObject = new CheckOutPageObject(driver, wait);
    addToCard.click();
    wait.until(ExpectedConditions.visibilityOf(goToCheckoutCart));
    goToCheckoutCart.click();
    return checkoutPageObject;
  }

}
