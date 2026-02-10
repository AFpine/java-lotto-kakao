package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WinningLottoTest {

    @Test
    @DisplayName("입력받은 숫자 6개를 포함한 한 장의 로또를 생성한다.")
    public void manualWinningLottoTest() {
        WinningLotto lotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        assertNotNull(lotto);
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);    // 로또의 lottoNumbers 사이즈가 6인지 검증
    }

    @Test
    @DisplayName("입력받은 숫자 6개와 보너스 번호를 포함한 한 장의 로또를 생성한다.")
    public void manualBonusTest() {
        WinningLotto lotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        lotto.createBonusNumber("7");

        assertNotNull(lotto);
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
        assertThat(lotto.getBonusNumber().getNumber()).isEqualTo(7);
        // 로또의 lottoNumbers 사이즈가 6인지 검증하고 보너스 숫자가 생성되었는지
    }


    @Test
    @DisplayName("5개의 숫자만 입력받으면 예외 처리한다.")
    public void manualWinningLottoFailSizeTest() {
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> new WinningLotto("1, 2, 3, 4, 6"));
        assertThat(runtimeException.getMessage()).isEqualTo("6개의 숫자를 입력해야 합니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 값을 입력받으면 예외 처리한다.")
    public void manualWinningLottoFailNotNumberTest() {
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> new WinningLotto("1, 2, 3, c, 5b, 6a"));
        assertThat(runtimeException.getMessage()).isEqualTo("숫자가 아닙니다.");
    }

    @Test
    @DisplayName("1-45 범위를 벗어난 숫자를 입력받으면 예외 처리한다.")
    public void manualWinningLottoFailRangeTest() {
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> new WinningLotto("1, 2, 3, 4, 100, 45"));
        assertThat(runtimeException.getMessage()).isEqualTo("범위를 벗어난 숫자입니다.");
    }

    @Test
    @DisplayName("중복된 숫자를 입력받으면 예외 처리한다.")
    public void manualWinningLottoFailDistinctTest() {
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> new WinningLotto("1, 2, 3, 4, 5, 5"));
        assertThat(runtimeException.getMessage()).isEqualTo("중복된 숫자입니다.");
    }

    @Test
    @DisplayName("입력받은 숫자 6개를 포함한 한 장의 로또를 생성한다.")
    public void manualWinningLottoFailDistinctBonusTest() {
        WinningLotto lotto = new WinningLotto("1, 2, 3, 4, 5, 6");

        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class, () -> lotto.createBonusNumber("5"));
        assertThat(runtimeException.getMessage()).isEqualTo("중복된 숫자입니다.");
    }

}
