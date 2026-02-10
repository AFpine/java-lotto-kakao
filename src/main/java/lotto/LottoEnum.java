package lotto;

public enum LottoEnum {
    FIFTH("3개 일치", 5_000),
    FOURTH("4개 일치",50_000),
    THIRD("5개 일치",1_500_000),
    SECOND("5개 일치, 보너스 볼 일치",30_000_000),
    FIRST("6개 일치",2_000_000_000);

    private final String description;
    private final long value;

    LottoEnum(String description, long value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public long getValue() {
        return this.value;
    }
}
