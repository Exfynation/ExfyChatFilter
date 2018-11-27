package de.exfy.chatfilter.filter;

import java.util.Collection;

public interface Filter {
    Collection<FilterHit> scan(String msg);
}
