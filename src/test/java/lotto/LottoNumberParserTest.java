package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberParserTest {

    @Test
    @DisplayName("쉼표로 구분된 숫자 문자열을 Integer 리스트로 파싱한다.")
    public void parseLottoNumbersSuccessTest() {
        String input = "1, 2, 3, 4, 5, 6";

        List<Integer> result = LottoNumberParser.parseLottoNumbers(input);

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열이 포함되면 예외를 반환한다.")
    public void parseLottoNumbersFailTest() {
        String input = "1, 2, abc, 4, 5, 6";

        NumberFormatException exception = assertThrows(NumberFormatException.class,
            () -> LottoNumberParser.parseLottoNumbers(input));
        assertThat(exception.getMessage()).isEqualTo("숫자가 아닙니다.");
    }

    @Test
    @DisplayName("보너스 번호 문자열을 Integer로 파싱한다.")
    public void parseBonusNumberSuccessTest() {
        String input = "7";

        Integer result = LottoNumberParser.parseBonusNumber(input);

        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("숫자가 아닌 보너스 번호는 예외를 반환한다.")
    public void parseBonusNumberFailTest() {
        String input = "abc";

        NumberFormatException exception = assertThrows(NumberFormatException.class,
            () -> LottoNumberParser.parseBonusNumber(input));
        assertThat(exception.getMessage()).isEqualTo("숫자가 아닙니다.");
    }

    @Test
    @DisplayName("숫자 문자열은 검증을 통과한다.")
    public void validateNumberStringSuccessTest() {
        assertDoesNotThrow(() -> LottoNumberParser.validateNumberString("42"));
    }

    @Test
    @DisplayName("숫자가 아닌 문자열은 예외를 반환한다.")
    public void validateNumberStringFailTest() {
        NumberFormatException exception = assertThrows(NumberFormatException.class,
            () -> LottoNumberParser.validateNumberString("abc"));
        assertThat(exception.getMessage()).isEqualTo("숫자가 아닙니다.");
    }
}
