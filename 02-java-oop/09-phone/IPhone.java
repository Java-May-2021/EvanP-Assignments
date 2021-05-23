public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String Ring() {
        System.out.println(this.getRingTone());
        return this.getRingTone();

    }
    @Override
    public String unlock() {
        return "Unlock using fingerprint";
        
    }
    @Override
    public void displayInfo() {
        System.out.println(this.versionNumber());
        System.out.println(this.batteryPercentage());
        System.out.println(this.carrier());
        System.out.println(this.ringtone());        
    }
    
}
