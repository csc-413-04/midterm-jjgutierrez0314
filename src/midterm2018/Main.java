package midterm2018;

import com.google.gson.*;

import java.io.BufferedReader;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        String question1and2 = "GET /add?a=3&b=4 HTTP/1.1\n"
                + "Host: localhost:1298\n"
                + "Connection: keep-alive\n"
                + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36\n"
                + "Accept: image/webp,image/apng,image/*,*/*;q=0.8\n"
                + "Referer: http://localhost:1298/\n"
                + "Accept-Encoding: gzip, deflate, br\n"
                + "Accept-Language: en-US,en;q=0.9,es;q=0.8\n";

        String question3 = "{\n"
                + "    “task” : “inc”,\n"
                + "    “num” : 3\n"
                + "}\n";

        String question4and5 = "To opt out, you’ll need to enter the Settings menu by clicking the three vertical dots, all the way in the upper right corner of the browser. From there, you’ll need to enter the Advanced settings at the very bottom and find the “Allow Chrome sign in” toggle, then turn it to off. Doing so lets you sign into Google services like Gmail and Maps without signing into the Chrome browser itself.";


        System.out.println(question1and2);
        System.out.println(question3);
        System.out.println(question4and5);

        // print each answer at the end

        // Question 1
        // Return the Host

        System.out.println(returnHost((question1and2)));

        // Question 2
        // return sum of a and b

        System.out.println("Sum of a + b = " + returnSum(question1and2));


        // Question 3
        // convert to java object, increment num, convert back to json and return

        System.out.println(returnJson(question3));

        // Question 4
        // return unique words

        System.out.println("The amount of unique words is: " + getDistinctWordCount(hashTheWords(question4and5)));


        // Question 5
        // return 2nd most common word

        System.out.println("Common Word is : " + commonWord(findCommonWord(question4and5)));
    }

    public static String returnHost(String string) {
        String host;
        String[] split = string.split("\n");
        host = split[1];

        return host;
    }

    public static int returnSum(String string) {
        String[] temp1, temp2;
        int a, b;
        String a1, b1;
        String[] split = string.split(" ");
        split = split[1].split("\\?"); //splitting /add?a=3&b=4 into add and a=3&b=4
        split = split[1].split("&"); //split a=3&b=4 into a=3, b=4
        temp1 = split[0].split("=");
        temp2 = split[1].split("=");
        a1 = temp1[1];
        b1 = temp2[1];
        a = Integer.parseInt(a1);
        b = Integer.parseInt(b1);

        return a + b;
    }

    public static String[] returnJson(String string) {
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject obj = jsonParser.parse(string).getAsJsonObject();

        String[] strings;
        strings = gson.fromJson(obj.get("num"), String[].class);

        return null;
    }

    /*
        public static HashMap<String, Integer> hashTheWords(String string) {
            Scanner scan = new Scanner(string);
            HashMap<String, Integer> listOfWords = new HashMap<String, Integer>();
            while (scan.hasNext()) {
                String word = scan.next();
                int countWord = 0;
                if (!listOfWords.containsKey(word)) {
                    if(!word.equals("to")) {
                        listOfWords.put(word, 1);
                    }
                } else {
                    countWord = listOfWords.get(word) + 1;
                    listOfWords.remove(word);
                    listOfWords.put(word, countWord);
                }
            }
            return listOfWords;

        }
        */
    public static HashMap<String, Integer> hashTheWords(String string) {
        Scanner scan = new Scanner(string);
        HashMap<String, Integer> listOfWords = new HashMap<>();

        while (scan.hasNext()) {
            String word = scan.next();
            int countWord = 0;
            if (!listOfWords.containsKey(word)) {
                if (!word.equals("to")) {
                    listOfWords.put(word, 1);
                }
            } else {
                countWord = listOfWords.get(word) + 1;
                listOfWords.remove(word);
                listOfWords.put(word, countWord);
            }

        }
        return listOfWords;

    }

    public static HashMap<String, Integer> findCommonWord(String string) {
        Scanner scan = new Scanner(string);
        HashMap<String, Integer> commonWord = new HashMap<>();

        while (scan.hasNext()) {
            String word = scan.next();
            if (commonWord.containsKey(word)){
                commonWord.put(word, commonWord.get(word) + 1);
            } else{
                commonWord.put(word, 1);
            }
        }
        return commonWord;
    }

    public static int getDistinctWordCount(HashMap<String, Integer> list) {
        return list.size();
    }

    public static int commonWord (HashMap<String, Integer> list) {
        return list.get(40);
    }

}
