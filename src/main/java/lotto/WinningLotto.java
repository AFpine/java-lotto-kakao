package lotto;

import java.util.*;

public class WinningLotto {
    // manual
    private List<LottoNumber> lottoNumbers;
    private LottoNumber bonusNumber;
    private final Set<Integer> usedNumber = new HashSet<>();

    public WinningLotto() {
        // 유효한 랜덤 숫자 6개를 생성
        this.lottoNumbers = generateValidRandomNumbers();
    }

    public WinningLotto(String input) {
        this.lottoNumbers = parseLottoNumbers(input);
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }

    private List<LottoNumber> generateValidRandomNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            numbers.add(new LottoNumber(i));
        }
        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }

    private List<LottoNumber> parseLottoNumbers(String input) {
        List<LottoNumber> numbers = new ArrayList<>();

        String[] strings = input.split(", ");
        isValidSize(strings);
        for (String s : strings) {
            numbers.add(new LottoNumber(isDistinctNumber(isValidRange(isValidString(s)))));
        }

        return numbers;
    }

    public void createBonusNumber(String input) {
        Integer bonusInteger = Integer.parseInt(input);
        bonusNumber = new LottoNumber(isDistinctNumber(bonusInteger));
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

    private Integer isDistinctNumber(Integer number) {
        if(usedNumber.contains(number)) throw new RuntimeException("중복된 숫자입니다.");
        usedNumber.add(number);
        return number;
    }

}
