package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoTest {

    @Test
    @DisplayName("랜덤 숫자 6개를 포함한 한 장의 로또를 생성한다.")
    public void generateLottoTest() {
        Lotto lotto = new Lotto();

        assertNotNull(lotto);
        assertThat(lotto.getLottoNumbers().getLottoNumberList().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("매칭 수와 보너스 여부에 따라 당첨 등수를 반환한다.")
    public void calculateLottoEnumTest() {
        Lotto lotto = new Lotto();

        assertThat(lotto.calculateLottoEnum(6, false)).isEqualTo(LottoEnum.FIRST);
        assertThat(lotto.calculateLottoEnum(5, true)).isEqualTo(LottoEnum.SECOND);
        assertThat(lotto.calculateLottoEnum(5, false)).isEqualTo(LottoEnum.THIRD);
        assertThat(lotto.calculateLottoEnum(4, false)).isEqualTo(LottoEnum.FOURTH);
        assertThat(lotto.calculateLottoEnum(3, false)).isEqualTo(LottoEnum.FIFTH);
        assertThat(lotto.calculateLottoEnum(2, false)).isNull();
    }

}
