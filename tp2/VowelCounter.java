
package tp2;

import java.util.Scanner;

public class VowelCounter {
    String word;

    VowelCounter(String word) {
        this.word = word;
    }

    int count() {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = scanner.next();
        scanner.close();

        VowelCounter vc = new VowelCounter(word);
        System.out.println("Number of vowels in \"" + word + "\" = " + vc.count());
    }
}
