package lop.flaslampin;

public class Battery {
    private int energy;

    public Battery () {
        this.energy=10;
    }

    public int getEnergy () {
        return energy;
    }

    public void setEnergy (int energy) {
        this.energy = energy;
    }
    public void decreaseEnergy(){
        this.setEnergy(energy-=2);
    }
}
