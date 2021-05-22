public class PhoneTester {
    public static void main(String[] args) {
        Galaxy s9 = new Galaxy("S9", 99, "Verizon", "Ring Ring Ring!");
        IPhone iphoneTen = new IPhone("X", 100, "At&t", "Zing");

        s9.displayInfo();
        s9.getRingTone();
        iphoneTen.displayInfo();
        iphoneTen.getRingTone();      
    }    
}
