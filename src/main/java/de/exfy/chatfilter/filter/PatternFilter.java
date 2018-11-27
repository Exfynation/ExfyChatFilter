package de.exfy.chatfilter.filter;

import de.exfy.chatfilter.filter.variations.Variation;

import java.util.*;

public abstract class PatternFilter implements Filter {
    @Override
    public Collection<FilterHit> scan(String msg) {
        Set<FilterProgress> progressList = new HashSet<>();

        List<FilterHit> results = new LinkedList<>();

        Collection<Variation> variations = FilterManager.INSTANCE.variationManager.getVariations(msg);

        checkString(msg, progressList, results, variations);

        return results;
    }

    private void checkString(String msg, Set<FilterProgress> progressList, List<FilterHit> results, Collection<Variation> variations) {
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) == ' ') {
                for (FilterProgress wp : progressList) {
                    wp.deltaLength += 1;
                }
                continue;
            }

            String newString = msg.substring(i, i+1);
            String complete = msg.substring(0, i+1);
            progressList.add(new FilterProgress(i));

            Set<Variation> thisVars = new HashSet<>();
            Set<Variation> affectingVars = new HashSet<>();
            for (Variation v : variations) {
                if (v.getPosition() + v.getLength() + v.getSpaces() - 1 == i) {
                    thisVars.add(v);
                } else if (v.getPosition() <= i && v.getPosition() + v.getLength() + v.getSpaces() - 1 > i) {
                    affectingVars.add(v);
                }
            }

            Set<FilterProgress> newList = new HashSet<>();

            for (FilterProgress wp : progressList) {
                wp.currentText += newString;

                for (Variation var : thisVars) {
                    if (wp.currentText.length() - var.getLength() < 0) {
                        continue;
                    }

                    FilterProgress fp = new FilterProgress(wp.index);
                    fp.deltaLength = var.getLength() - var.getNewText().length() + wp.deltaLength;
                    try {
                        fp.currentText = wp.currentText.substring(0, wp.currentText.length() - var.getLength()) + var.getNewText();
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                    newList.add(fp);
                }
            }

            progressList.addAll(newList);

            results.addAll(checkWords(progressList, complete, affectingVars));
        }
    }

    private Collection<FilterHit> checkWords(Set<FilterProgress> progressList, String complete, Set<Variation> affectingVars) {
        List<FilterHit> hits = new LinkedList<>();

        outer:
        for (Iterator<FilterProgress> iterator = progressList.iterator(); iterator.hasNext(); ) {
            FilterProgress wp = iterator.next();
            boolean isUsefulRoute = couldBeBadWordPrefix(wp.currentText);

            if (!isUsefulRoute) {
                boolean foundUseful = false;
                for (Variation var : affectingVars) {
                    int endIndex = var.getPosition() - wp.index - wp.deltaLength;
                    if (endIndex < 0) {
                        continue;
                    }

                    String before = wp.currentText.substring(0, endIndex);
                    if (couldBeBadWordPrefix(before)) {
                        foundUseful = true;
                    }
                }

                if (!foundUseful) {
                    // this route is lost
                    iterator.remove();
                    continue;
                }
            }

            if (isBadWord(wp.currentText)) {
                // hit
                Collection<String> whitelist = getExceptions(wp.currentText);
                for (String white : whitelist) {
                    int whiteIndex = white.indexOf(wp.currentText);
                    int whiteMessageIndex = wp.index - whiteIndex;
                    if (whiteMessageIndex >= 0 &&
                            whiteMessageIndex + white.length() + wp.deltaLength <= complete.length() &&

                            complete.substring(whiteMessageIndex,
                                    whiteMessageIndex + white.length() + wp.deltaLength)
                                    .replace(" ", "").equals(white)) {
                        // white word!
                        continue outer;
                    }
                }

                // bad word!
                hits.add(new FilterHit(wp.index, wp.currentText.length() + wp.deltaLength));
            }
        }

        return hits;
    }

    protected abstract boolean couldBeBadWordPrefix(String text);

    protected abstract boolean isBadWord(String text);

    protected abstract Collection<String> getExceptions(String text);

    private static class FilterProgress {
        private String currentText = "";
        private int index;
        private int deltaLength;

        private FilterProgress(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            FilterProgress that = (FilterProgress) o;

            if (index != that.index) return false;
            if (deltaLength != that.deltaLength) return false;
            return !(currentText != null ? !currentText.equals(that.currentText) : that.currentText != null);

        }

        @Override
        public int hashCode() {
            int result = currentText != null ? currentText.hashCode() : 0;
            result = 31 * result + index;
            result = 31 * result + deltaLength;
            return result;
        }
    }
}
