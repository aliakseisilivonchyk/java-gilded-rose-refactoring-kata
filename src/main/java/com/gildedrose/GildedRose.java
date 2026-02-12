package com.gildedrose;

import com.gildedrose.strategy.*;
import com.gildedrose.strategy.base.UpdateStrategy;

import java.util.HashMap;
import java.util.Map;

class GildedRose {

    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured";

    Item[] items;

    private final Map<String, UpdateStrategy> updateStrategies;
    private final UpdateStrategy defaultUpdateStrategy;

    public GildedRose(Item[] items) {
        this.items = items;

        updateStrategies = new HashMap<>();
        updateStrategies.put(SULFURAS_HAND_OF_RAGNAROS, new SulfurasUpdateStrategy());
        updateStrategies.put(AGED_BRIE, new AgedBrieUpdateStrategy());
        updateStrategies.put(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, new BackstagePassesUpdateStrategy());
        updateStrategies.put(CONJURED, new ConjuredUpdateStrategy());

        defaultUpdateStrategy = new DefaultUpdateStrategy();
    }

    public void updateQuality() {
        for (Item item : items) {
            updateStrategies.getOrDefault(item.name, defaultUpdateStrategy).updateItem(item);
        }
    }
}
