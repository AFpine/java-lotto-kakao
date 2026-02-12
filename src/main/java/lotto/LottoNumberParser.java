package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberParser {
    public static List<Integer> parseLottoNumbers(String input) {
        List<Integer> parsedNumberList = new ArrayList<>();
        String[] strings = input.split(", ");

        for (String s : strings) {
            validateNumberString(s);
            parsedNumberList.add(Integer.parseInt(s));
        }
        return parsedNumberList;
    }

    public static Integer parseBonusNumber(String input) {
        validateNumberString(input);
        return Integer.parseInt(input);
    }

    public static void validateNumberString(String substring) {
        if (!substring.matches("^[0-9]*$")) throw new NumberFormatException("숫자가 아닙니다.");
    }
}
