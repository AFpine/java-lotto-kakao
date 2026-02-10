package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void add(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public void setAllLottoResult(WinningLotto winningLotto) {
        for (Lotto lotto : lottoList) {
            lotto.setOneLottoResult(winningLotto);
        }
    }
}
