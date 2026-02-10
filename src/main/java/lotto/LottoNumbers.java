package lotto;

import java.util.*;

public class LottoNumbers {

    private List<LottoNumber> lottoNumberList;

    public LottoNumbers() {
        generateRandomNumbers();    // 랜덤 6개 숫자 생성
        sortLottoNumberList();      // sorting
    }

    public List<LottoNumber> getLottoNumberList() {
        return lottoNumberList;
    }

    private void generateRandomNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }
        Collections.shuffle(numbers);

        this.lottoNumberList = numbers.subList(0, 6);
    }

    public void sortLottoNumberList() {
        this.lottoNumberList.sort(new Comparator<LottoNumber>() {
            @Override
            public int compare(LottoNumber o1, LottoNumber o2) {
                return Integer.compare(o1.getNumber(), o2.getNumber());
            }
        });
    }
}
