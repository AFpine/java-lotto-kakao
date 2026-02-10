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

    @Test
    @DisplayName("정답 로또와 구매한 로또 하나를 비교하여 결과 Enum을 반환한다.")
    public void getOneLottoResultTest() {
        lottoGame.createWinningLotto("1, 2, 3, 4, 5, 6", "7");
        Lotto lotto1 = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("1, 2, 3, 4, 5, 7");
        Lotto lotto3 = new Lotto("1, 2, 3, 4, 5, 8");
        Lotto lotto4 = new Lotto("1, 2, 3, 4, 9, 8");
        Lotto lotto5 = new Lotto("1, 2, 3, 10, 9, 8");

        assertThat(lottoGame.getOneLottoResult(lotto1)).isEqualTo(LottoEnum.FIRST);
        assertThat(lottoGame.getOneLottoResult(lotto2)).isEqualTo(LottoEnum.SECOND);
        assertThat(lottoGame.getOneLottoResult(lotto3)).isEqualTo(LottoEnum.THIRD);
        assertThat(lottoGame.getOneLottoResult(lotto4)).isEqualTo(LottoEnum.FOURTH);
        assertThat(lottoGame.getOneLottoResult(lotto5)).isEqualTo(LottoEnum.FIFTH);
    }

    @Test
    @DisplayName("당첨 결과를 입력하면 당첨금 총액을 반환한다.")
    public void getLottoSumTest() {
        lottoGame.purchaseLotto(2);
        lottoGame.getLottoList().get(0).setLottoEnum(LottoEnum.FIRST);
        lottoGame.getLottoList().get(1).setLottoEnum(LottoEnum.THIRD);

        assertThat(lottoGame.getLottoSum()).isEqualTo(2_001_500_000);
    }

    @Test
    @DisplayName("당첨 금액과 구매 수량을 넣으면 수익률을 반환한다.")
    public void getRateOfReturn() {
        int winning = 1_500_000;       // 당첨금 150만원
        lottoGame.purchaseLotto(3); // 로또 3장 구매

        assertThat(lottoGame.getRateOfReturn(winning)).isEqualTo(500.0);
    }

    @Test
    @DisplayName("당첨 금액과 구매 수량을 넣으면 수익률을 반환한다. (예시 데이터와 동일)")
    public void getRateOfReturn1() {
        int winning = 5_000;       // 당첨금 150만원
        lottoGame.purchaseLotto(14); // 로또 3장 구매

        assertThat(lottoGame.getRateOfReturn(winning)).isEqualTo(0.35);
    }
}
