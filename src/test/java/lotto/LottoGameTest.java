package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    public void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    @DisplayName("로또 구매 금액을 전달하면 구매할 수 있는 로또 장수를 반환한다.")
    public void calculateLottoCountTest() {
        Assertions.assertThat(lottoGame.calculateLottoCount(1500)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 구매 금액이 1000원 미만이면 예외를 반환한다.")
    public void calculateLottoCountExceptionTest() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> lottoGame.calculateLottoCount(500));
        assertThat(runtimeException.getMessage()).isEqualTo("1000원 이상의 금액을 입력해야 합니다.");
    }

    @Test
    @DisplayName("구매 가능 장수를 넣으면 그에 맞는 사이즈의 로또 리스트를 반환한다.")
    public void purchaseLottoTest() {
        lottoGame.purchaseLotto(3);

        assertThat(lottoGame.getLottoList().size()).isEqualTo(3);
    }
}
