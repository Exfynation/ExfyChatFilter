package de.exfy.chatfilter.filter.variations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class VariationManager {
    private Set<VariationProvider> variationProviders = new HashSet<>();

    public void addVariationProvider(VariationProvider provider) {
        variationProviders.add(provider);
    }

    public Collection<Variation> getVariations(String original) {
        Set<Variation> variations = new HashSet<>();

        for (VariationProvider provider : variationProviders) {
            variations.addAll(provider.provideVariations(original));
        }

        return variations;
    }
}
