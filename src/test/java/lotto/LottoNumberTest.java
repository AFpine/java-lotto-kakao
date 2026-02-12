package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {

    @Test
    @DisplayName("생성한 번호 값을 반환한다.")
    public void getNumberTest() {
        LottoNumber lottoNumber = LottoNumber.from(7);

        assertThat(lottoNumber.getNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("같은 번호는 동등하다.")
    public void equalsAndHashCodeTest() {
        LottoNumber first = LottoNumber.from(3);
        LottoNumber second = LottoNumber.from(3);

        assertThat(first).isEqualTo(second);
        assertThat(first.hashCode()).isEqualTo(second.hashCode());
    }

    @Test
    @DisplayName("다른 번호는 동등하지 않다.")
    public void notEqualsTest() {
        LottoNumber first = LottoNumber.from(3);
        LottoNumber second = LottoNumber.from(4);

        assertThat(first).isNotEqualTo(second);
    }

    @Test
    @DisplayName("1-45 범위 숫자는 생성에 성공한다.")
    public void validateRangeSuccessTest() {
        assertDoesNotThrow(() -> LottoNumber.from(1));
        assertDoesNotThrow(() -> LottoNumber.from(45));
    }

    @Test
    @DisplayName("범위를 벗어난 숫자는 예외를 반환한다.")
    public void validateRangeFailTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> LottoNumber.from(0));
        assertThat(exception.getMessage()).isEqualTo("범위를 벗어난 숫자입니다.");

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> LottoNumber.from(46));
        assertThat(exception2.getMessage()).isEqualTo("범위를 벗어난 숫자입니다.");
    }
}
