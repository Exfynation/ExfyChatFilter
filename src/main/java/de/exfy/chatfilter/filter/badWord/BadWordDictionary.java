package de.exfy.chatfilter.filter.badWord;

import org.apache.commons.collections4.trie.PatriciaTrie;

import java.util.*;

public class BadWordDictionary {
    private PatriciaTrie<Set<String>> badwordDict = new PatriciaTrie<>();
    private Set<String> emptySet = Collections.emptySet();

    public void addWord(String word, String... exceptions) {
        if (exceptions.length == 0) {
            badwordDict.put(word, emptySet);
        } else {
            badwordDict.put(word, new HashSet<>(Arrays.asList(exceptions)));
        }
    }

    public boolean isBadWordPrefix(String prefix) {
        return !badwordDict.prefixMap(prefix).isEmpty();
    }

    public boolean isBadWord(String word) {
        return badwordDict.containsKey(word);
    }

    public Collection<String> getExceptions(String word) {
        return badwordDict.get(word);
    }
}
