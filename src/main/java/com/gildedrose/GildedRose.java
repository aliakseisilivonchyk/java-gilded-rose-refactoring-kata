package com.gildedrose;

class GildedRose {
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
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        if (item.name.equals("Aged Brie")) {
            increaseItemQualityIfNotMax(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseItemQualityIfNotMax(item);

            if (item.sellIn < 11) {
                increaseItemQualityIfNotMax(item);
            }

            if (item.sellIn < 6) {
                increaseItemQualityIfNotMax(item);
            }
        } else {
            decreaseItemQualityIfNotMin(item);
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseItemQualityIfNotMax(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                setItemQualityToMin(item);
            } else {
                decreaseItemQualityIfNotMin(item);
            }
        }
    }

    private static void increaseItemQualityIfNotMax(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private static void decreaseItemQualityIfNotMin(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private static void setItemQualityToMin(Item item) {
        item.quality = 0;
    }
}
