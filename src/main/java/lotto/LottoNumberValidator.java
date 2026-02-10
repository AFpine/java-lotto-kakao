package lotto;

import java.util.List;

public class LottoNumberValidator {

    public static void validateSize(String[] strings) {
        if(strings.length != 6) throw new RuntimeException("6개의 숫자를 입력해야 합니다.");
    }

    public static void validateString(String substring) {
        if (!substring.matches("^[0-9]*$")) throw new RuntimeException("숫자가 아닙니다.");
    }

    public static void validateRange(Integer number) {
        if (number < 1 || number > 45) throw new RuntimeException("범위를 벗어난 숫자입니다.");
    }

    public static void validateDistinctNumber(List<LottoNumber> lottoNumberList, Integer number) {
        if(lottoNumberList.contains(new LottoNumber(number))) throw new RuntimeException("중복된 숫자입니다.");
    }
}
