package lotto;

import static lotto.LottoNumberParser.parseLottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public List<Lotto> getLottoList() {
        return List.copyOf(lottoList);
    }

    public void add(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public void setAllLottoResult(WinningLotto winningLotto) {
        for (Lotto lotto : lottoList) {
            lotto.evaluateRank(winningLotto);
        }
    }

    // 로또 리스트들의 당첨금 총액 반환
    public long getLottoSum() {
        long sum = 0;
        for (Lotto lotto : lottoList) {
            sum += lotto.getLottoRankValue();
        }

        return sum;
    }

    // 수익률 반환
    public double getRateOfReturn(long sum) {
        double rate = (double) sum / (lottoList.size() * LottoPolicy.LOTTO_PRICE);
        // 100을 곱해서 반올림하고 다시 100.0으로 나눔
        return Math.floor(rate * 100) / 100.0;
    }

    // 특정 Enum(몇개 당첨인지) 개수 카운트
    public int countEnum(LottoRank lottoRank) {
        int count = 0;
        for (Lotto lotto : lottoList) {
            if(lotto.getLottoRank() == lottoRank) count ++;
        }

        return count;
    }

    public void purchaseOneManualLotto(String input) {
        this.add(new Lotto(parseLottoNumbers(input)));
    }

    public void purchaseLotto(int count) {
        for (int i = 0; i < count; i++) {
            this.add(new Lotto());
        }
    }
}
