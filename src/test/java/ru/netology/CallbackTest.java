package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallbackTest {
    @Test
    public void shouldSendFormSuccess() {
        open("http://localhost:7777/");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("Екатерина Великая");
        form.$("[data-test-id=phone] input").setValue("+79998887654");
        form.$("[data-test-id=agreement]").click();
        form.$("button").click();
        String actual =  $("[data-test-id=order-success]").getText().trim();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        assertEquals(expected, actual);
    }
}
