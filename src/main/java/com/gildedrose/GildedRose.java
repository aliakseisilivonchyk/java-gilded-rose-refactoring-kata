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
        switch (item.name) {
            case "Sulfuras, Hand of Ragnaros":
                return;
            case "Aged Brie":
                increaseItemQualityIfNotMax(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                increaseItemQualityIfNotMax(item);

                if (item.sellIn < 11) {
                    increaseItemQualityIfNotMax(item);
                }

                if (item.sellIn < 6) {
                    increaseItemQualityIfNotMax(item);
                }
                break;
            default:
                decreaseItemQualityIfNotMin(item);
                break;
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            switch (item.name) {
                case "Aged Brie":
                    increaseItemQualityIfNotMax(item);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    setItemQualityToMin(item);
                    break;
                default:
                    decreaseItemQualityIfNotMin(item);
                    break;
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
