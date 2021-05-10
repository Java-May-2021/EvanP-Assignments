import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    public static void OneTo255() {
        for(int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }
    public static void Odd1to255() {
        for (int i = 1; i <=255; i ++){
            if(i%2 != 0){
                System.out.println(i);
            }
        }
    }
    public static void Sum() {
        int sum = 0;
        for(int i = 0; i <= 255; i++){
            sum = sum + i;
            System.out.println("New Number: " + i + "Sum: " + sum);
        }        
    }
    public static void IterateArray() {
        int[] myArray = {1,3,5,7,9,13};
        for(int i : myArray) {
            System.out.println(i);    
        }
    }
    public static void FindMax(int[] arr) {
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
    public static void GetAverage(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        System.out.println(sum/arr.length);
    }
    public static void OddArray() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 1; i <= 255; i++){
            if(i%2 != 0){
                arr.add(i);
            }            
        }
        System.out.println(arr);    
    }
    public static void GreaterThanY(int[] arr, int y) {
        int var = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > y){
                var++;
            }
        }
        System.out.println(var);
        
    }
    public static void SquareTheValues(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
        System.out.println(Arrays.toString(arr));        
    }
    public static void EliminateNegatives(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));        
    }
    public static void MaxMinAverage(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
            sum = sum + arr[i];
        }
        int avg = sum/arr.length;
        int[] newArray = {max, min, avg};
        System.out.println("Maximum: " + max + " Minimum: " + min + " Average: " + avg);
    }
    public static void ShiftingTheValues(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1]= 0;
        System.out.println(Arrays.toString(arr));        
    }
}