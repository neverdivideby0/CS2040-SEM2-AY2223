import java.util.HashMap;
import java.util.Scanner;


public class t9spelling{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> wordToNum = new HashMap<>();
        wordToNum.put("a", "2");
        wordToNum.put("b", "22");
        wordToNum.put("c", "222");
        wordToNum.put("d", "3");
        wordToNum.put("e", "33");
        wordToNum.put("f", "333");
        wordToNum.put("g", "4");
        wordToNum.put("h", "44");
        wordToNum.put("i", "444");
        wordToNum.put("j", "5");
        wordToNum.put("k", "55");
        wordToNum.put("l", "555");
        wordToNum.put("m", "6");
        wordToNum.put("n", "66");
        wordToNum.put("o", "666");
        wordToNum.put("p", "7");
        wordToNum.put("q", "77");
        wordToNum.put("r", "777");
        wordToNum.put("s", "7777");
        wordToNum.put("t", "8");
        wordToNum.put("u", "88");
        wordToNum.put("v", "888");
        wordToNum.put("w", "9");
        wordToNum.put("x", "99");
        wordToNum.put("y", "999");
        wordToNum.put("z", "9999");
        wordToNum.put(" ", "0");
        
        int numOfCases = sc.nextInt();
        sc.nextLine();

        //each line
        for (int i = 1; i <= numOfCases; i++){
            String inputWord=sc.nextLine();
            String finalOutput = "";
            String prevKey = "";
            String prevOutput = "!";

            //each letter
            for (int j=0; j< inputWord.length(); j++){
                //returns char type convert to string
                String currentKey = Character.toString(inputWord.charAt(j));

                //get the value
                String currentOutputInString = wordToNum.get(currentKey);

                //if the first value of the output is the same as the previous one, add a space
                //eg 2 vs 22 vs 222
                if(prevOutput.charAt(prevOutput.length()-1) == currentOutputInString.charAt(0)){
                        finalOutput = finalOutput + " " + currentOutputInString ;
                } else {
                //append the value
                finalOutput = finalOutput + currentOutputInString;
                }
                //updating the previous with the current
                prevOutput += currentOutputInString;
            }
            System.out.println("Case #" + i + ": " + finalOutput);
        }
    }
}
