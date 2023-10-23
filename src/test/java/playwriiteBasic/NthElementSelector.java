package playwriiteBasic;

import com.microsoft.playwright.*;

public class NthElementSelector {
    public static void main(String[] args) {
//            12 N-th element selector
        try(Playwright playwright = Playwright.create()){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(true));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.orangehrm.com/en/contact-sales/");
            String lastElText = page.locator("div.footer-main-section li a >> nth=-1").textContent();
            System.out.println(lastElText);

            String firstElText = page.locator("div.footer-main-section li a >> nth=0").textContent();
            System.out.println(lastElText);

        }
    }
}
