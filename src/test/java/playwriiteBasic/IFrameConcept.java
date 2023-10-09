package playwriiteBasic;

import com.microsoft.playwright.*;

public class IFrameConcept {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(true));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://rahulshettyacademy.com/AutomationPractice/");

            Locator course = page.frameLocator("iframe[name='iframe-name']").locator("a:has-text('Courses')");
            System.out.println(course.first().textContent());

            course = page.frame("iframe-name").locator("a:has-text('Courses')");
            System.out.println(course.first().textContent());



        }
    }
}
