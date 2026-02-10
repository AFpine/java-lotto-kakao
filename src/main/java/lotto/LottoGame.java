package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    // 정답 로또
    private WinningLotto winningLotto;

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

    public void printLottoList() {
        for (Lotto lotto : lottoList) {
            lotto.printLottoNumbers();
        }
    }

    // 당첨 로또 생성
    public void createWinningLotto(String input, String bonus) {
        winningLotto = new WinningLotto(input);
        winningLotto.createBonusNumber(bonus);
    }

    // 하나의 로또의 결과 반환
    public LottoEnum getOneLottoResult(Lotto lotto) {
        int matchCount = 0;
        boolean bonusCount = false;
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            for (LottoNumber winningLottoNumber : winningLotto.getLottoNumbers()) {
                if(lottoNumber.getNumber() == winningLottoNumber.getNumber()) matchCount += 1;
            }
            if(winningLotto.getBonusNumber().getNumber() == lottoNumber.getNumber()) bonusCount = true;
        }

        // 로또에 enum 설정
        lotto.setLottoEnum(calculateLottoEnum(matchCount, bonusCount));
        return lotto.getLottoEnum();
    }

    // 로또의 결과 Enum 반환
    public LottoEnum calculateLottoEnum(int matchCount, boolean bonusCount) {
        if(matchCount == 6) return LottoEnum.FIRST;
        if(matchCount == 5 && bonusCount) return LottoEnum.SECOND;
        if(matchCount == 5) return LottoEnum.THIRD;
        if(matchCount == 4) return LottoEnum.FOURTH;
        if(matchCount == 3) return LottoEnum.FIFTH;
        return LottoEnum.OTHER;
    }

    // 로또 리스트들의 당첨금 총액 반환
    public int getLottoSum() {
        int sum = 0;
        for (Lotto lotto : lottoList) {
            sum += (int) lotto.getLottoEnum().getValue();
        }

        return sum;
    }

    // 수익률 반환
    public double getRateOfReturn(int sum) {
        double rate = (double) sum / (lottoList.size() * 1000);
        // 100을 곱해서 반올림하고 다시 100.0으로 나눔
        return Math.floor(rate * 100) / 100.0;
    }
}
