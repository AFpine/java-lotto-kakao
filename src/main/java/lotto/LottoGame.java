package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    // 정답 로또

    // 구매 로또 리스트
    private List<Lotto> lottoList;

    public LottoGame() {
        lottoList = new ArrayList<>();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    // 구매 가능한 갯수 반환
    public int calculateLottoCount(int money) {
        if(money < 1000) throw new RuntimeException("1000원 이상의 금액을 입력해야 합니다.");

        return money / 1000;
    }

    // 로또 구매
    public void purchaseLotto(int count) {
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
    }
}
