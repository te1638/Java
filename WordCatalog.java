import java.util.*;

public class WordCatalog implements Catalog {
    private List<String> wordCatalog;


    public WordCatalog() {
        this.wordCatalog = new ArrayList<>();
    }

    @Override
    public void add(Object name) {
        wordCatalog.add(String.valueOf(name));
    }

    @Override
    public void printUnique() {
        Map<String, Integer> letters = new HashMap<>();
        for (int i = 0; i < wordCatalog.size(); i++) {
            String word = wordCatalog.get(i);
            if (!letters.containsKey(word)) {
                letters.put(word, 1);
            } else {
                letters.put(word, letters.get(word) + 1);
            }
        }

        for (Map.Entry<String, Integer> c : letters.entrySet()) {

            System.out.println(String.format("\nCлово: %s\nПовторений : %s", c.getKey(), c.getValue()));
        }
    }
}
