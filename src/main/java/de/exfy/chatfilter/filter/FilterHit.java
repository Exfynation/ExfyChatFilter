package de.exfy.chatfilter.filter;

public class FilterHit {
    private int start;
    private int length;

    public FilterHit(int start, int length) {
        this.start = start;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getStart() {
        return start;
    }
}
