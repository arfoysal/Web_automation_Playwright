package playwriiteBasic;

import com.microsoft.playwright.*;

import java.util.List;

public class LocatorConcept {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(true));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://demo.nopcommerce.com/register");
            Locator loginButton = page.locator("text=Log in");
//            loginButton.hover();
//            loginButton.click();
//            loginButton.first().click();
//            loginButton.last().click();
//            Locator monthOptions = page.locator("select[name='DateOfBirthMonth'] option");
//            System.out.println(monthOptions.count());
//            for (int i=0; i<monthOptions.count(); i++){
//                System.out.println(monthOptions.nth(i).textContent());
//            }
//            System.out.println("___________________");
//            List<String> monthTextList = monthOptions.allTextContents();
//            for (String month : monthTextList){
//                System.out.println(month);
//            }
//            System.out.println("___________________");
//
//            monthTextList.forEach(text -> System.out.println(text));

//            4 Text selector
            Locator genderFemale = page.locator("text=Female");
            System.out.println(genderFemale.textContent());

            Locator details = page.locator("strong:has-text('Your Personal Details')");
            System.out.println(details.textContent());
//          parent child tagName.class
            details = page.locator("div.title strong:has-text('Your Personal Details')");
            System.out.println(details.textContent());

            details = page.locator("div strong:has-text('Your Personal Details')");
            System.out.println("Tag child: " + details.textContent());

            details = page.locator("'Your Personal Details'");
            System.out.println(details.textContent());
//            5 CSS selector
//            6 Selecting visible elements
//            7 Selecting elements that contain other elements
//            8 Selecting elements matching one of the conditions
//            9 Selecting elements in Shadow DOM
//            10 Selecting elements based on layout
//            11 XPath selectors
//            12 N-th element selector
//            13 React selectors
//            14 Vue selectors
//            15 id, data-testid, data-test-id, data-test selectors
//            16 Pick n-th match from the query result
//            17 Chaining selectors

        }
    }
}
