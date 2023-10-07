package playwriiteBasic;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.nio.file.Paths;


public class TracerInspection {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://demo.nopcommerce.com/register");
            page.getByLabel("Male", new Page.GetByLabelOptions().setExact(true)).check();
            page.getByLabel("First name:").click();
            page.getByLabel("First name:").fill("MD");
            page.getByLabel("Last name:").click();
            page.getByLabel("Last name:").fill("Test");
            page.locator("select[name=\"DateOfBirthDay\"]").selectOption("2");
            page.locator("select[name=\"DateOfBirthMonth\"]").selectOption("11");
            page.locator("select[name=\"DateOfBirthYear\"]").selectOption("1940");
            page.getByLabel("Email:").click();
            page.getByLabel("Email:").fill("test@abc.com");
            page.getByText("Last name: *").click();
            page.getByLabel("Company name:").click();
            page.getByLabel("Company name:").fill("testabc.co");
            page.getByLabel("Newsletter:").uncheck();
            page.getByLabel("Password:", new Page.GetByLabelOptions().setExact(true)).click();
            page.getByLabel("Password:", new Page.GetByLabelOptions().setExact(true)).fill("test1234");
            page.getByLabel("Confirm password:").click();
            page.getByLabel("Confirm password:").fill("test1234");
//            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Register")).click();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));

            // open locally CLI or in your browser on trace.playwright.dev.
//            mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"


        }
    }
}