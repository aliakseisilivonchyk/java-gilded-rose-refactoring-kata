package com.gildedrose.strategy;

import com.gildedrose.Item;
import com.gildedrose.strategy.base.UpdateStrategy;

public class DefaultUpdateStrategy extends UpdateStrategy {

    @Override
    public void updateItem(Item item) {
        decreaseItemQualityIfNotMin(item);
        decreaseItemSellIn(item);

        if (item.sellIn < LAST_DAY_TO_SELL_IN_ITEM) {
            decreaseItemQualityIfNotMin(item);
        }
    }
}
