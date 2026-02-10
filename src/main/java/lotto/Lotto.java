package lotto;

import java.util.*;

public class Lotto {
    // automatic
    private List<LottoNumber> lottoNumbers;
    private LottoEnum lottoEnum;

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public Lotto() {
        // 유효한 랜덤 숫자 6개를 생성
        this.lottoNumbers = generateValidRandomNumbers();
    }

    public Lotto(String input) {
        this.lottoNumbers = parseLottoNumbers(input);
    }

    public LottoEnum getLottoEnum() {
        return this.lottoEnum;
    }

    public void setLottoEnum(LottoEnum lottoEnum) {
        this.lottoEnum = lottoEnum;
    }

    private List<LottoNumber> generateValidRandomNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }
        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }

    // 테스트를 위한 메서드
    private List<LottoNumber> parseLottoNumbers(String input) {
        List<LottoNumber> numbers = new ArrayList<>();

        Set<Integer> usedNumber = new HashSet<>();

        String[] strings = input.split(", ");
        isValidSize(strings);
        for (String s : strings) {
            numbers.add(new LottoNumber(isDistinctNumber(usedNumber, isValidRange(isValidString(s)))));
        }

        return numbers;
    }

    private void isValidSize(String[] strings) {
        if(strings.length != 6) throw new RuntimeException("6개의 숫자를 입력해야 합니다.");
    }

    private Integer isValidString(String substring) {
        if (!substring.matches("^[0-9]*$")) throw new RuntimeException("숫자가 아닙니다.");
        return Integer.parseInt(substring);
    }

    private Integer isValidRange(Integer number) {
        if (number < 1 || number > 45) throw new RuntimeException("범위를 벗어난 숫자입니다.");
        return number;
    }

    private Integer isDistinctNumber(Set<Integer> usedNumber, Integer number) {
        if(usedNumber.contains(number)) throw new RuntimeException("중복된 숫자입니다.");
        usedNumber.add(number);
        return number;
    }

}
