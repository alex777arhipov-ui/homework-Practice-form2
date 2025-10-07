import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("429515336988");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--006:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);");
        $("[for='hobbies-checkbox-1']").shouldBe(visible).click();
        $("[for='hobbies-checkbox-2']").shouldBe(visible).click();
        $("[for='hobbies-checkbox-3']").shouldBe(visible).click();
        $("#uploadPicture").uploadFromClasspath("images/12.png");
        $("#currentAddress").setValue("24, street of the Weaving Factory");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();
        $(".modal-content").should(appear);
        $$(".modal-content .table tbody tr td:first-child")
                .shouldHave(exactTexts(
                        "Student Name",
                        "Student Email",
                        "Gender",
                        "Mobile",
                        "Date of Birth",
                        "Subjects",
                        "Hobbies",
                        "Picture",
                        "Address",
                        "State and City"
                ));








    }
}