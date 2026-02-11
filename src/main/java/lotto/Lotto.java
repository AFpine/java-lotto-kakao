package lotto;

import java.util.*;

public class Lotto {
    // automatic
    private LottoNumbers lottoNumbers;
    private LottoEnum lottoEnum;

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public Lotto() {
        // 유효한 랜덤 숫자 6개를 생성
        this.lottoNumbers = new LottoNumbers();
    }

    // 테스트 용 직접 로또 번호 생성을 위한 생성자
    public Lotto(List<Integer> numberList) {
        this.lottoNumbers = new LottoNumbers(numberList);
    }

    public LottoEnum getLottoEnum() {
        return this.lottoEnum;
    }

    public void setLottoEnum(LottoEnum lottoEnum) {
        this.lottoEnum = lottoEnum;
    }

    // 구매한 로또 리스트 반환
    public List<Integer> getLottoNumbersAsList() {
        // 로또 번호(Integer)만 담긴 리스트로 변환
        return lottoNumbers.getLottoNumberList().stream()
                .map(LottoNumber::getNumber)
                .toList();
    }

    public void setOneLottoResult(WinningLotto winningLotto) {
        int matchCount = 0;
        boolean bonusCount = isContainBonusNumber(winningLotto.getBonusNumber().getNumber());

        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumberList()) {
            matchCount += isContainWinningNumber(lottoNumber, winningLotto);
        }

        this.lottoEnum = calculateLottoEnum(matchCount, bonusCount);
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return lottoNumbers.getLottoNumberList().contains(LottoNumber.from(bonusNumber));
    }

    public int isContainWinningNumber(LottoNumber lottoNumber, WinningLotto winningLotto) {

        if(winningLotto.getWinningLottoNumbers().getLottoNumberList().contains(lottoNumber)) return 1;
        return 0;
    }

    // 로또의 결과 Enum 반환
    public LottoEnum calculateLottoEnum(int matchCount, boolean bonusCount) {
        if(matchCount == 6) return LottoEnum.FIRST;
        if(matchCount == 5 && bonusCount) return LottoEnum.SECOND;
        if(matchCount == 5) return LottoEnum.THIRD;
        if(matchCount == 4) return LottoEnum.FOURTH;
        if(matchCount == 3) return LottoEnum.FIFTH;
        return null;
    }
}
