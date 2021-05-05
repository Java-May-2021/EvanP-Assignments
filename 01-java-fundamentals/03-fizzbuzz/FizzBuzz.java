import javax.naming.spi.DirStateFactory.Result;

public class FizzBuzz {
    public String fizzBuzz(int number) {
        if(number % 3 == 0){
            return "Fizz";
        } else if(number % 5 == 0){
            return "Buzz";
        } else if (number % 3 == 0 && number % 5 ==0){
            return "FizzBuzz";
        } else {
            return Integer.toString(number);
        }
    }

    public void FizzBuzzTest() {
        for (int i = 0; i <= 100; i++) {
            String result = fizzBuzz(i);
            System.out.println("Number: " + i + " - " + "Result: " + result);
        }
    }
}
