package org.example.pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_homePage {

    //create constructor
    public P03_homePage(){  PageFactory.initElements(Hooks.driver, this);}
    //use findby
    @FindBy(id = "customerCurrency")
    public WebElement Currency;

    //located price
    @FindBy(css = "span[class=\"price actual-price\"]")
    public List< WebElement>  priceList; //6 item

//located search
    @FindBy(css = "input[id=\"small-searchterms\"]")
    public WebElement SearchInput;

    //locate botton search
    @FindBy(css ="button[type=\"submit\"]" )
    public WebElement SeachButton;
    @FindBy(css="h2[class=\"product-title\"]")
    public List<WebElement> details;

    @FindBy(css = "div[class=\"picture\"]")
    public WebElement picture;

    @FindBy(css = "div[class=\"sku\"] span[class=\"value\"]")
    public WebElement ksuList;

    @FindBy(css = "ul[class=\"top-menu notmobile\"] a[href=\"/electronics\"]")
    public WebElement category;
    @FindBy(css = "ul[class=\"sublist first-level\"] a[href=\"/camera-photo\"]")
    public WebElement subCat;
    @FindBy(css = "div[class=\"page-title\"] h1")
    public WebElement subCatTitle;

    @FindBy(css = "a[href=\"https://demo.nopcommerce.com/\"]")
    public WebElement homeSlider;

    @FindBy(css = "a[style=\"display: block;\"]")
    public WebElement homeSlider2;

    @FindBy(css="a[href=\"http://www.facebook.com/nopCommerce\"]")
    public WebElement FbIcon;
    @FindBy(css = "a[href=\"https://twitter.com/nopCommerce\"]")
    public WebElement twitterIcon;
    @FindBy(css = "a[href=\"/news/rss/1\"]")
    public WebElement rssIcon;
    @FindBy(css = "a[href=\"http://www.youtube.com/user/nopCommerce\"]")
    public WebElement youtubeIcon;
    @FindBy(css = "div[data-productid=\"18\"] button[class=\"button-2 add-to-wishlist-button\"]")
    public WebElement htcBtn;


    @FindBy(css = "div[class=\"bar-notification success\"]")
    public WebElement sucMsg;

    @FindBy(css = "div[class=\"header-links\"] a[href=\"/wishlist\"]")
    public WebElement wishlistLink;
    @FindBy(css = "input[class=\"qty-input\"]")
    public WebElement productQaulity;



}
