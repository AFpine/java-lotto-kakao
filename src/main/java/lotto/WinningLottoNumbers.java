package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumbers {

    private List<LottoNumber> lottoNumberList;


    // parsing은 parser가 맡아서 한다. 여기선 생성 + validation
    public WinningLottoNumbers(List<Integer> numbers) {
        validateSize(numbers);
        lottoNumberList = new ArrayList<>();

        for (Integer number : numbers) {
            validateDistinctNumber(lottoNumberList, number);
            lottoNumberList.add(LottoNumber.from(number));
        }
    }

    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }

    public void validateDistinctNumber(List<LottoNumber> lottoNumberList, Integer number) {
        if(lottoNumberList.contains(LottoNumber.from(number))) throw new IllegalArgumentException("로또에 중복된 숫자가 존재합니다.");
    }

    public void validateSize(List<Integer> numbers) {
        if(numbers.size() != 6) throw new IllegalArgumentException("6개의 숫자를 입력해야 합니다.");
    }
}
