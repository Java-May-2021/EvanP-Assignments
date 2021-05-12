import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {    
    public static void GreaterThanSum(int[] arr) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            if(arr[i] > 10){
                newArr.add(arr[i]);
            }
        }
        System.out.println("Sum is:" + sum + " Greater Than is:" + newArr);        
    }
    public static void NameShuffle(String[] arr) {
        ArrayList<String> newArr = new ArrayList<String>();
        ArrayList<String> newList = new ArrayList<String>();

        newArr.add("Nancy");
        newArr.add("Jinchi");
        newArr.add("Fujibayashi");
        newArr.add("Momochi");
        newArr.add("Ishikawa");

        Collections.shuffle(newArr);
        System.out.println(newArr);
        
        for(int i = 0; i < arr.length; i++){
            if(newArr.get(i).length() > 5){
                newList.add(newArr.get(i));
            }
        }
        System.out.println(newList);        
    }
    public static void Alphabet(Character[] arr) {
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(char ch = 'a'; ch <= 'z'; ++ch){
            alphabet.add(ch);
            System.out.println(ch);
        }
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        System.out.println(alphabet.get(25));
        System.out.println(alphabet.get(0));
        
        String vowels = "aeiou";
        int vowel = vowels.indexOf(alphabet.get(0));
        if(vowel > -1){
            System.out.println("It's a Vowel");
        }
    }
    public static void RandomArray(int lowerBound, int upperBound) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        int[] arr = new int[10];
        int offset = upperBound - lowerBound;
        Random r = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(offset) + lowerBound;
            intList.add(arr[i]);
        }
        System.out.println(intList);
    }
    public static void RandomMaxMin(int lowerBound, int upperBound) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        int[] arr = new int[10];
        int offset = upperBound - lowerBound;
        Random r = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(offset) + lowerBound;
            intList.add(arr[i]);
        }
        Collections.sort(intList);
        System.out.println(intList);
        System.out.println("Max number is: " + intList.get(9));
        System.out.println("Min number is: " + intList.get(0));
    }
    public static void RandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++){
            int index = r.nextInt(chars.length());
            char randomChar = chars.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println(randomString);
    }
    public static void RandomStringArray(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        String[] stringArray = new String[10];
        for(int j = 0; j < 10; j++){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 5; i++){
                int index = r.nextInt(chars.length());
                char randomChar = chars.charAt(index);
                sb.append(randomChar);
            }
        String randomString = sb.toString();
        stringArray[j] = randomString;
        }
        System.out.println(Arrays.toString(stringArray));
    }
}   
