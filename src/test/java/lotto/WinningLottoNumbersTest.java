package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WinningLottoNumbersTest {

    @Test
    @DisplayName("입력한 6개 숫자로 당첨 번호를 생성한다.")
    public void createWinningNumbersTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(numbers);

        assertThat(winningLottoNumbers.getLottoNumberList().stream().map(LottoNumber::getNumber).toList())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("입력 개수가 6개가 아니면 예외를 반환한다.")
    public void createFailSizeTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> new WinningLottoNumbers(numbers));
        assertThat(exception.getMessage()).isEqualTo("6개의 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("범위를 벗어난 숫자를 입력하면 예외를 반환한다.")
    public void createFailRangeTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 46);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> new WinningLottoNumbers(numbers));
        assertThat(exception.getMessage()).isEqualTo("범위를 벗어난 숫자입니다.");
    }

    @Test
    @DisplayName("중복 숫자를 입력하면 예외를 반환한다.")
    public void createFailDistinctTest() {
        List<Integer> numbers = List.of(1, 2, 3, 3, 5, 6);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            () -> new WinningLottoNumbers(numbers));
        assertThat(exception.getMessage()).isEqualTo("로또에 중복된 숫자가 존재합니다.");
    }
}
