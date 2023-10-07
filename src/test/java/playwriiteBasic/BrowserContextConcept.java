package playwriiteBasic;

import com.microsoft.playwright.*;

public class BrowserContextConcept {


    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            BrowserContext context1 = browser.newContext();
            Page page1 = context1.newPage();
            page1.navigate("https://playwright.dev/");
            System.out.println(page1.title());


            BrowserContext context2 = browser.newContext();
            Page page2 = context2.newPage();
            page2.navigate("https://demo.nopcommerce.com/register");
            System.out.println(page2.title());

            BrowserContext context3 = browser.newContext();
            Page page3 = context3.newPage();
            page3.navigate("https://google.com/");
            System.out.println(page3.title());


            page3.close();
            context3.close();

            page1.close();
            context1.close();

            page2.close();
            context2.close();

        }
    }
}
