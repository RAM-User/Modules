package com.chapter15;

public class HoldItem<T> {
    T item;

    public HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}

class Colored2<T extends HasColor> extends HoldItem<T> {
    public Colored2(T item) {
        super(item);
    }

    java.awt.Color color() {
        return item.getColor();
    }
}
