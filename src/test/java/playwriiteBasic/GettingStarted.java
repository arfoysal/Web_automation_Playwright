package playwriiteBasic;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class GettingStarted {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://playwright.dev/");
            System.out.println("Title: " + page.title());

            System.out.println("URL: "+ page.url());
            browser.close();
            playwright.close();
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        }
    }

    @Test
    public void testStart(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch();
        Page page = browser.newPage();
        page.navigate("https://playwright.dev/");

    }
}
