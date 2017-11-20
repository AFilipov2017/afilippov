package ru.job4j.condition;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)gi
 * @version $Id$
 * @since 0.1
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        if (question.equals("Привет, Бот.")) {
        return "Привет, умник.";
        }
        if (question.equals(("Пока."))) {
            return "До скорой встречи.";
        }
        return "Это ставит меня в тупик. Спросите другой вопрос.";
    }

}
