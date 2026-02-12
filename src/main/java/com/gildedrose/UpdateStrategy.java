package com.gildedrose;

public abstract class UpdateStrategy {

    protected static final int MAX_ITEM_QUALITY = 50;
    protected static final int MIN_ITEM_QUALITY = 0;
    protected static final int LAST_DAY_TO_SELL_IN_ITEM = 0;

    public abstract void updateItem(Item item);

    protected static void increaseItemQualityIfNotMax(Item item) {
        if (item.quality < MAX_ITEM_QUALITY) {
            item.quality++;
        }
    }

    protected static void decreaseItemQualityIfNotMin(Item item) {
        if (item.quality > MIN_ITEM_QUALITY) {
            item.quality--;
        }
    }

    protected static void setItemQualityToMin(Item item) {
        item.quality = MIN_ITEM_QUALITY;
    }

    protected static void decreaseItemSellIn(Item item) {
        item.sellIn--;
    }
}
