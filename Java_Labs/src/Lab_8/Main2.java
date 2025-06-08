package Lab_8;

import java.util.regex.*;

public class Main2 {
    public static void main(String[] args) {
        String text = """
            Вот 1ысль, к1торой весь я предан,
            Итог 111, 1то ум скопил.
            1ишь тот, кем бой за жизнь изведан,
            Жизнь 1 свободу 1аслужил.
            """;

        Pattern pattern = Pattern.compile("\\b[А-Яа-яЁё][А-Яа-яЁё0-9]*\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String newWord = matcher.group().substring(0, 1).toUpperCase() + matcher.group().substring(1);
            matcher.appendReplacement(result, newWord);
        }
        matcher.appendTail(result);

        System.out.println("Преобразованный текст:");
        System.out.println(result);
    }
}
