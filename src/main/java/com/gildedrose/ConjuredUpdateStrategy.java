package com.gildedrose;

public class ConjuredUpdateStrategy extends UpdateStrategy {

    @Override
    public void updateItem(Item item) {
        decreaseItemQualityIfNotMin(item);
        decreaseItemQualityIfNotMin(item);

        decreaseItemSellIn(item);

        if (item.sellIn < LAST_DAY_TO_SELL_IN_ITEM) {
            decreaseItemQualityIfNotMin(item);
            decreaseItemQualityIfNotMin(item);
        }
    }
}
