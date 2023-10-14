package playwriiteBasic;

import com.microsoft.playwright.*;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VisibleElement {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(true));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://www.daraz.com.bd");
            List<String> allVisibleLinkText = page.locator("a:visible").allInnerTexts();
            allVisibleLinkText.forEach(text -> System.out.println(text));

            List<Locator> allVisibleLink = page.locator("a >> visible=true").all();
            for (Locator element: allVisibleLink ){
                System.out.println(element.getAttribute("href"));
            }

            int allVisibleImageTextCount = page.locator("xpath=//img >> visible=true").count();
            System.out.println(allVisibleImageTextCount);
        }
    }
}
