package playwriiteBasic;

import com.microsoft.playwright.*;

public class ShadowDomConcept {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://books-pwakit.appspot.com");
//          Page -- DOM --> Shadow DOM --> elements
//          Page -- DOM --> iFrame --> Shadow DOM --> elements

            page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Book");
            String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
            System.out.println(text);

            page.navigate("https://selectorshub.com/xpath-practice-page/");
//          page.frameLocator("#pact").locator("div#userName #pizza").fill("Ginger Masala");
            page.locator("div#userName #pizza").fill("Ginger Masala");

        }
    }
}
