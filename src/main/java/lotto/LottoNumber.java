package lotto;

import java.util.Objects;

public class LottoNumber {
    private final int number;

    public int getNumber() {
        return number;
    }

    public LottoNumber(int number) {
        this.number = number;
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
