package com.gildedrose.strategy;

import com.gildedrose.Item;
import com.gildedrose.strategy.base.UpdateStrategy;

public class BackstagePassesUpdateStrategy extends UpdateStrategy {

    private static final int BACKSTAGE_ITEM_SELL_IN_DAY_FIRST_THRESHOLD = 11;
    private static final int BACKSTAGE_ITEM_SELL_IN_DAY_SECOND_THRESHOLD = 6;

    @Override
    public void updateItem(Item item) {
        increaseItemQualityIfNotMax(item);

        if (item.sellIn < BACKSTAGE_ITEM_SELL_IN_DAY_FIRST_THRESHOLD) {
            increaseItemQualityIfNotMax(item);
        }

        if (item.sellIn < BACKSTAGE_ITEM_SELL_IN_DAY_SECOND_THRESHOLD) {
            increaseItemQualityIfNotMax(item);
        }

        decreaseItemSellIn(item);

        if (item.sellIn < LAST_DAY_TO_SELL_IN_ITEM) {
            setItemQualityToMin(item);
        }
    }
}
