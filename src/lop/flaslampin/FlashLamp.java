package lop.flaslampin;

public class FlashLamp {
    private boolean status;
    private Battery battery;

    public FlashLamp () {
        this.status=false;
        this.battery=null;
    }

    public boolean isStatus () {
        return status;
    }

    public void setStatus (boolean status) {
        this.status = status;
    }

    public int getBatteryInfo () {
        return battery.getEnergy();
    }

    public void setBattery (Battery battery) {
        this.battery = battery;
    }

    public void turnOn(){
        this.setStatus(true);
        if(this.status==true&&battery.getEnergy()>0) System.out.println("FlashLamp on!");
        else turnOff();
    }

    public void turnOff () {
        this.setStatus(false);
        System.out.println("FlashLamp off!");
    }
}
