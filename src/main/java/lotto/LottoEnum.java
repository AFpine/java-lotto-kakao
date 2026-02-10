package lotto;

public enum LottoEnum {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    OTHER(0);

    private final long value;

    LottoEnum(long value) {
        this.value = value;
    }
    public long getValue() {
        return this.value;
    }
}
