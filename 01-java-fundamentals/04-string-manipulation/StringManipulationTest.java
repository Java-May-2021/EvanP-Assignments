public class StringManipulationTest {
    public static void main(String[] args) {
        StringManipulation manipulator = new StringManipulation();

        String str = manipulator.trimAndConcat("    Hello    ", "    World    ");
        System.out.println(str);

        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer x = manipulator.getIndexOrNull(word, subString);
        Integer y = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(a);
        System.out.println(b);

        String word2 = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word2);
    }
}
