package de.exfy.chatfilter.filter;

import de.exfy.chatfilter.filter.variations.VariationManager;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class FilterManager {
    public static final FilterManager INSTANCE = new FilterManager();

    public final VariationManager variationManager = new VariationManager();

    private Set<Filter> filters = new HashSet<>();

    private FilterManager() {
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public Collection<FilterHit> scan(String msg) {
        Set<FilterHit> hits = new HashSet<>();

        for (Filter filter : filters) {
            hits.addAll(filter.scan(msg));
        }

        return hits;
    }
}
