public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String Ring() {
        System.out.println(this.getRingTone());
        return this.getRingTone();

    }
    @Override
    public String unlock() {

        return "Unlock with your passcode";
    }

    @Override
    public void displayInfo() {
        System.out.println(this.getVersionNumber());
        System.out.println(this.getBatteryPercentage());
        System.out.println(this.getCarrier());
        System.out.println(this.getRingtone());
    }    
}
