package ua.lviv.ai.oop_labs.second.model;

import org.springframework.data.domain.Sort;

public enum SortBy {

    ID(true, true),
    NAME(true, true),
    VALUE(true, false),
    VOLTAGE(true, false),
    PRODUCER(true, true),
    TYPE(true, false),
    PRICE(true, true),
    AMOUNT(true, false);

    boolean goodForElements;
    boolean goodForKits;

    SortBy(boolean goodForElements, boolean goodForKits) {
        this.goodForElements = goodForElements;
        this.goodForKits = goodForKits;
    }

    public Sort getSort() {
        if (this == AMOUNT)
            return Sort.by(Sort.Direction.DESC, this.name().toLowerCase());

        return Sort.by(Sort.Direction.ASC, this.name().toLowerCase());
    }

    public boolean isGoodForElements() {
        return goodForElements;
    }

    public boolean isGoodForKits() {
        return goodForKits;
    }
}
