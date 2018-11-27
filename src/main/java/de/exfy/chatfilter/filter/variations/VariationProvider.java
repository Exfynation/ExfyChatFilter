package de.exfy.chatfilter.filter.variations;

import java.util.Collection;

public interface VariationProvider {
    Collection<Variation> provideVariations(String string);
}
