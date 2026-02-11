package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또를 추가하면 목록에 저장한다.")
    public void addLottoTest() {
        Lottos lottos = new Lottos();

        lottos.add(new Lotto());
        lottos.add(new Lotto());

        assertThat(lottos.getLottoList()).hasSize(2);
    }

    @Test
    @DisplayName("당첨 로또를 기준으로 모든 로또 결과를 계산한다.")
    public void setAllLottoResultTest() {
        Lottos lottos = new Lottos();
        Lotto firstRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto thirdRankLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", "7");

        lottos.add(firstRankLotto);
        lottos.add(thirdRankLotto);
        lottos.setAllLottoResult(winningLotto);

        assertThat(firstRankLotto.getLottoEnum()).isEqualTo(LottoEnum.FIRST);
        assertThat(thirdRankLotto.getLottoEnum()).isEqualTo(LottoEnum.THIRD);
    }
}
