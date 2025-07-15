package LinearSearch;

public class SearchWordInSentences {
    public static String searchWordInSentences(String[] sentences, String word) {
        String target = word.toLowerCase();
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(target)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is a popular programming language.",
            "Python is great for data science.",
            "Artificial Intelligence is the future.",
            "I love problem-solving challenges."
        };

        String wordToSearch = "data";
        String result = searchWordInSentences(sentences, wordToSearch);
        System.out.println("Result: " + result);
    }
}

