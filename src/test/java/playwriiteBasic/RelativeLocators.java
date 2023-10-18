package playwriiteBasic;

import com.microsoft.playwright.*;

public class RelativeLocators {
//    Selecting elements based on layout - Relative Locators
//    left of
//    right of
//    below
//    above
//    near
    static Page page;
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(true));
            BrowserContext context = browser.newContext();
            page = context.newPage();

            page.navigate("https://selectorshub.com/xpath-practice-page/");

//            page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();
            selectUser("Joe.Root");
            selectUser("Jasmine.Morgan");
//            page.waitForTimeout(3000);

//            String role = page.locator("td:right-of(:text('Joe.Root'))").first().textContent();
//            System.out.println(role);

            System.out.println(getUserRole("Jasmine.Morgan"));
            System.out.println(getUserRole("John.Smith"));
            System.out.println(getAboveUsername("Jasmine.Morgan"));
            System.out.println(getBelowUsername("Jasmine.Morgan"));
            System.out.println("|_____________________________________|");
            Locator nearElements = page.locator("td:near(:text('Joe.Root'))");
            nearElements.allInnerTexts().forEach(e -> System.out.println(e));
            System.out.println("|_____________________________________|");
            nearElements = page.locator("td:near(:text('Joe.Root'), 200)");
            nearElements.allInnerTexts().forEach(e -> System.out.println(e));
        }

    }
    public static void selectUser(String username){
        page.locator("input[type='checkbox']:left-of(:text('"+ username +"'))").first().click();
    }

    public static String getUserRole(String username){
        return page.locator("td:right-of(:text('"+ username +"'))").first().textContent();
    }

    public static String getAboveUsername(String username){
        return page.locator("a:above(:text('"+ username +"'))").first().textContent();
    }

    public static String getBelowUsername(String username){
        return page.locator("a:below(:text('"+ username +"'))").first().textContent();
    }
}
