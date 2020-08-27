package lop.flaslampin;

public class TestFlashLamp {
    public static void main (String[] args) {
        Battery battery=new Battery();
        FlashLamp flashLamp=new FlashLamp();
        flashLamp.setBattery(battery);
        for(int i=1;i<=10;i++){
            flashLamp.turnOn();
            battery.decreaseEnergy();
            flashLamp.turnOff();
        }
        if(battery.getEnergy()>=0)
            System.out.println("Energy = "+battery.getEnergy());
        else System.out.println("Energy = 0");
    }
}
