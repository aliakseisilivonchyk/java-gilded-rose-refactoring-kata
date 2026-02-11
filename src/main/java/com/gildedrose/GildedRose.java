package com.gildedrose;

class GildedRose {
    private static final int MAX_ITEM_QUALITY = 50;
    private static final int MIN_ITEM_QUALITY = 0;
    private static final int LAST_DAY_TO_SELL_IN_ITEM = 0;
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    private static final String CONJURED = "Conjured";
    private static final int BACKSTAGE_ITEM_SELL_IN_DAY_FIRST_THRESHOLD = 11;
    private static final int BACKSTAGE_ITEM_SELL_IN_DAY_SECOND_THRESHOLD = 6;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private static void updateItemQuality(Item item) {
        switch (item.name) {
            case SULFURAS_HAND_OF_RAGNAROS:
                return;
            case AGED_BRIE:
                increaseItemQualityIfNotMax(item);
                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                increaseItemQualityIfNotMax(item);

                if (item.sellIn < BACKSTAGE_ITEM_SELL_IN_DAY_FIRST_THRESHOLD) {
                    increaseItemQualityIfNotMax(item);
                }

                if (item.sellIn < BACKSTAGE_ITEM_SELL_IN_DAY_SECOND_THRESHOLD) {
                    increaseItemQualityIfNotMax(item);
                }
                break;
            case CONJURED:
                decreaseItemQualityIfNotMin(item);
                decreaseItemQualityIfNotMin(item);
                break;
            default:
                decreaseItemQualityIfNotMin(item);
                break;
        }

        decreaseItemSellIn(item);

        if (item.sellIn < LAST_DAY_TO_SELL_IN_ITEM) {
            switch (item.name) {
                case AGED_BRIE:
                    increaseItemQualityIfNotMax(item);
                    break;
                case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                    setItemQualityToMin(item);
                    break;
                case CONJURED:
                    decreaseItemQualityIfNotMin(item);
                    decreaseItemQualityIfNotMin(item);
                    break;
                default:
                    decreaseItemQualityIfNotMin(item);
                    break;
            }
        }
    }

    private static void increaseItemQualityIfNotMax(Item item) {
        if (item.quality < MAX_ITEM_QUALITY) {
            item.quality++;
        }
    }

    private static void decreaseItemQualityIfNotMin(Item item) {
        if (item.quality > MIN_ITEM_QUALITY) {
            item.quality--;
        }
    }

    private static void setItemQualityToMin(Item item) {
        item.quality = MIN_ITEM_QUALITY;
    }

    private static void decreaseItemSellIn(Item item) {
        item.sellIn--;
    }
}
