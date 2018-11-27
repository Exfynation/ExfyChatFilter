package de.exfy.chatfilter.filter.variations;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

public class LeetSpeakVariationProvider implements VariationProvider {
    public static final Logger log = Logger.getLogger(LeetSpeakVariationProvider.class.getName());
    private MultiMap<String, String> translationMap = new MultiValueMap<>();

    public LeetSpeakVariationProvider() {
        log.info("Reading and transforming leetspeak table...");
        Properties props = new Properties();

        try {
            props.load(getClass().getResourceAsStream("/leetSpeakTable.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String entry : props.stringPropertyNames()) {
            String valStr = props.getProperty(entry);
            entry = entry.toLowerCase();

            String[] parts = valStr.split(",");

            for (String part : parts) {
                part = part.trim().toLowerCase();

                translationMap.put(part, entry);
            }
        }

        System.out.println(translationMap);
    }

    @Override
    public Collection<Variation> provideVariations(String string) {
        Set<Variation> results = new HashSet<>();
        string = string.toLowerCase();
        String noSpaces = string.replace(" ", "");

        for (String key : translationMap.keySet()) {
            @SuppressWarnings("unchecked") Collection<String> values = (Collection<String>) translationMap.get(key);
            for (String value : values) {
                int index = -1;
                while ((index = noSpaces.indexOf(key, index+1)) != -1) {
                    int spaces = countSpaces(string, 0, index);

                    int spIndex = index + spaces;
                    results.add(new Variation(spIndex, key.length(), countSpaces(string, spIndex, spIndex + key.length()), value));
                }
            }
        }

        return results;
    }

    private int countSpaces(String string, int start, int target) {
        int count = 0;
        int index = start - 1;
        while ((index = string.indexOf(" ", index+1)) != -1 && index < target) {
            count++;
            target++;
        }

        return count;
    }
}
