public class BasicJavaTest {
    
    public static void main(String[] args) {
        int[] arr1 = {1,5,10,-2};
        int[] arr2 = {1,3,5,7,9,13};
        int[] arr3 = {-1,-3,-5,-7};
        int[] arr4 = {1,5,10,7,-2};
        int[] arr5 = {1,3,4,9};
        int y = 3;
        BasicJava.OneTo255();
        BasicJava.Odd1to255();
        BasicJava.Sum();
        BasicJava.IterateArray();
        BasicJava.FindMax(arr3);
        BasicJava.GetAverage(arr3);
        BasicJava.OddArray();
        BasicJava.GreaterThanY(arr4, y);
        BasicJava.SquareTheValues(arr1);
        BasicJava.EliminateNegatives(arr3);
        BasicJava.MaxMinAverage(arr4);
        BasicJava.ShiftingTheValues(arr2);
    }
}
