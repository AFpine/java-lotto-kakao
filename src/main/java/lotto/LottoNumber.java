package lotto;

import java.util.Objects;

public class LottoNumber {
    private final int number;
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final LottoNumber[] CACHE = new LottoNumber[MAX + 1];

    static {
        for (int i = MIN; i <= MAX; i++) {
            CACHE[i] = new LottoNumber(i);
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        LottoNumberValidator.validateRange(number);
        return CACHE[number];
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}
