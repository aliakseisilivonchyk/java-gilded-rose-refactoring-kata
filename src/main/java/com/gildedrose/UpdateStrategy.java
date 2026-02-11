package com.gildedrose;

public class UpdateStrategy {

    protected static final int MAX_ITEM_QUALITY = 50;
    protected static final int MIN_ITEM_QUALITY = 0;
    protected static final int LAST_DAY_TO_SELL_IN_ITEM = 0;

    public void updateItem(Item item) {
        decreaseItemQualityIfNotMin(item);
        decreaseItemSellIn(item);

        if (item.sellIn < LAST_DAY_TO_SELL_IN_ITEM) {
            decreaseItemQualityIfNotMin(item);
        }
    }

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
