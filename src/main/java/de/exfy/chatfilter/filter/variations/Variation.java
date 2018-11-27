package de.exfy.chatfilter.filter.variations;

public class Variation {
    private int position;
    private int length;
    private int spaces;
    private String newText;

    public Variation(int position, int length, int spaces, String newText) {
        this.position = position;
        this.length = length;
        this.spaces = spaces;
        this.newText = newText;
    }

    public int getPosition() {
        return position;
    }

    public int getLength() {
        return length;
    }

    public int getSpaces() {
        return spaces;
    }

    public String getNewText() {
        return newText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variation variation = (Variation) o;

        if (position != variation.position) return false;
        if (length != variation.length) return false;
        return !(newText != null ? !newText.equals(variation.newText) : variation.newText != null);

    }

    @Override
    public int hashCode() {
        int result = position;
        result = 31 * result + length;
        result = 31 * result + (newText != null ? newText.hashCode() : 0);
        return result;
    }
}
