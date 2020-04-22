package ua.lviv.ai.oop_labs.second.model;

import org.springframework.data.domain.Sort;

public enum SortElementsBy {

    ID,
    NAME,
    VALUE,
    VOLTAGE,
    PRODUCER,
    TYPE,
    PRICE,
    AMOUNT;

    public Sort getSort() {
        if (this == AMOUNT)
            return Sort.by(Sort.Direction.DESC, this.name().toLowerCase());

        return Sort.by(Sort.Direction.ASC, this.name().toLowerCase());
    }
}
