package Task7___24_11_2017.searchService.model;

import java.util.ArrayList;

public class Word {
    public static ArrayList<String> stringPool = new ArrayList<>();

    private int valueIndex;
    private int freq;

    public Word(String value, int freq) {
        setValue(value);
        this.freq = freq;
    }

    public Word(String value) {
        this(value, 1);
    }

    public String getValue() {
        return stringPool.get(valueIndex);
    }

    private void setValue(String value) {
        this.valueIndex = stringPool.indexOf(value);
        if (valueIndex == -1){
            stringPool.add(value);
            this.valueIndex = stringPool.indexOf(value);
        }
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public void meetAgain(){
        setFreq(getFreq()+1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        return valueIndex == word.valueIndex;
    }

    @Override
    public int hashCode() {
        return valueIndex;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + getValue() + '\'' +
                ", freq=" + freq +
                '}';
    }
}
