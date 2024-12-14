package katas.exercises;

public class WordCounter {

    /**
     * Counts the number of words in a given sentence.
     *
     * @param sentence the input string (a sentence)
     * @return the number of words in the sentence
     */
    public static int countWords(String sentence) {
        if(sentence.isEmpty() || sentence == null) return 0;
        sentence = sentence.trim();
        String[] arr = sentence.split(" ");
        return arr.length;
    }

    public static void main(String[] args) {
        String sentence = "This is a sample sentence for counting words.";
        int wordCount = countWords(sentence);
        System.out.println(wordCount);
    }
}

