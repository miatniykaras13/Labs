package Lab_8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main1
{
    public static void main(String[] args) {
        String text = """
                (Дом) (Река) (snow) (Red) (дуб) (пень)       цвет (дождь) (мир).
                """;
        Pattern pattern = Pattern.compile("\\(([а-яЁёА-ЯA-Za-z]{1,5})\\)", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные слова в строке:");
        while (matcher.find()) {
            System.out.print(matcher.group(1) + " ");
        }

    }
}
