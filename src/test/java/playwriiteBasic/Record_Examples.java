package playwriiteBasic;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Record_Examples {
    public static void main(String[] args) {
//        mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen demo.playwright.dev/todomvc"
//        ENV: PWDEBUG=1
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demoqa.com/");
            page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Forms$"))).first().click();
            page.getByText("Practice Form").click();
            page.getByPlaceholder("First Name").click();
            page.getByPlaceholder("First Name").fill("MD ");
            page.getByPlaceholder("Last Name").click();
            page.getByPlaceholder("Last Name").fill("Foysal");
            page.getByPlaceholder("name@example.com").click();
            page.getByPlaceholder("name@example.com").fill("test@test.com");
            page.getByText("Male", new Page.GetByTextOptions().setExact(true)).click();
            page.getByPlaceholder("Mobile Number").click();
            page.getByPlaceholder("Mobile Number").fill("985673939");
            page.locator("#dateOfBirthInput").click();
            page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^JanuaryFebruaryMarchAprilMayJuneJulyAugustSeptemberOctoberNovemberDecember$"))).getByRole(AriaRole.COMBOBOX).selectOption("7");
            page.getByRole(AriaRole.COMBOBOX).nth(1).selectOption("2006");
            page.getByLabel("Choose Monday, August 7th, 2006").click();
            page.locator(".subjects-auto-complete__value-container").click();
            page.locator("#subjectsInput").fill("a");
            page.getByText("Accounting", new Page.GetByTextOptions().setExact(true)).click();
            page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Accounting$"))).nth(1).click();
            page.locator("#subjectsInput").fill("a");
            page.getByText("Maths", new Page.GetByTextOptions().setExact(true)).click();
            page.getByText("Sports").click();
//            page.pause();
            page.getByLabel("Select picture").click();
            page.getByLabel("Select picture").setInputFiles(Paths.get("Screenshot 2023-10-03 at 8.59.02 PM.png"));
            page.getByPlaceholder("Current Address").click();
            page.getByPlaceholder("Current Address").fill("ads,adsfd");
        }
    }
}