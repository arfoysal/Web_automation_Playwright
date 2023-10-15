package playwriiteBasic;

import com.microsoft.playwright.*;

import java.util.List;

public class HasElements {

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
//      Selecting elements that contain other elements

//            page.navigate("https://www.orangehrm.com/en/contact-sales/");
//
//            Locator locator = page.locator("select#Form_getForm_Country:has(option[value='Zambia'])");
//            locator.allInnerTexts().forEach(e -> System.out.println(e));

            page.navigate("https://www.amazon.com");
            Locator loc = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
            loc.allInnerTexts().forEach(e -> System.out.println(e));

//          Selecting elements matching one of the conditions: comma separated css list  and xpath union
//            page.locator("span:has-text('login'), " +
//                    "span:has-text('Login'), " +
//                    "span:has-text('SignIn'), " +
//                    "span:has-text('signIn'), " +
//                    "span:has-text('Account & Lists')").click();

            page.locator("//span[text()='login'] | //span[text()='Login'] | //span[text()='SignIn'] | //span[text()='signIn'] | //span[text()='Account & Lists']").click();
        }
    }
}
