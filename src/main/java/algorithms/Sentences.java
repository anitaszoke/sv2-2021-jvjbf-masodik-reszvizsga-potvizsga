package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Sentences {
    private final List<String> sentences = new ArrayList<>();

    public List<String> getSentences() {
        return sentences;
    }

    public void addSentence(String s) {
        if (!endWithMark(s)) {
            throw new IllegalArgumentException("Sentence must end with ending mark!");
        } else if (!startWithCapital(s)) {
            throw new IllegalArgumentException("Sentence must start with capital!");

        } else sentences.add(s);
    }


    public String findLongestSentence() {
        if (sentenceIsEmpty(sentences)) {
            throw new IllegalStateException("List can't be empty!");
        }
        return longestSentence();
    }

    private boolean startWithCapital(String s) {
        return !s.equals(s.toLowerCase());
    }

    private boolean endWithMark(String s) {
        List<Character> marks = Arrays.asList('.', '!', '?');
        for (Character c : marks)
            if (s.endsWith(c.toString())) {
                return true;
            }
        return false;
    }

    private boolean sentenceIsEmpty(List<String> s) {
        if (s.isEmpty()) {
            return true;
        }
        return false;
    }

    private String longestSentence() {
        String maxLenght = sentences.get(1);
        for (String s : sentences) {
            if (s.length() > maxLenght.length()) {
                maxLenght = s;
            }
        }
        return maxLenght;
    }
}
