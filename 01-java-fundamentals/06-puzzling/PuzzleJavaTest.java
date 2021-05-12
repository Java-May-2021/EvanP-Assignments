public class PuzzleJavaTest {
    public static void main(String[] args) {
        int[] arr1 = {3,5,1,2,7,9,8,13,25,32};
        String[] names = {"Nancy", "Jinchi", "Fujibayashi", "Momochi", "Ishikawa"};
        Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        
        PuzzleJava.GreaterThanSum(arr1);
        PuzzleJava.NameShuffle(names);
        PuzzleJava.Alphabet(alphabet);
        PuzzleJava.RandomArray(55, 100);
        PuzzleJava.RandomMaxMin(55, 100);
        PuzzleJava.RandomString();
        PuzzleJava.RandomStringArray();
    }
}