package com.gildedrose;

public class AgedBrieUpdateStrategy extends UpdateStrategy {

    @Override
    public void updateItem(Item item) {
        increaseItemQualityIfNotMax(item);
        decreaseItemSellIn(item);

        if (item.sellIn < LAST_DAY_TO_SELL_IN_ITEM) {
            increaseItemQualityIfNotMax(item);
        }
    }
}
