package ru.job4j.condition;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)gi
 * @version $Id$
 * @since 0.1
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question, v.
     * @return Ответ.
     */
    public String v = "Это ставит меня в тупик. Спросите другой вопрос.";
    public String answer(String question) {
        if (question.equals("Привет, Бот.")) {
       v = "Привет, умник.";
        }
        if (question.equals(("Пока."))) {
             v = "До скорой встречи.";
        }

        return v;
    }

}
