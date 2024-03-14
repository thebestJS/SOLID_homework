class Fueler {
    public void reFuel(Vehicle vc) {
        int remain = vc.getRemainingFuel();
        int remainMax = vc.getMaxFuel() - vc.getRemainingFuel();
        vc.setRemainingFuel(remainMax - remain);
    }
}

public class Vehicle {
    private final int maxFuel;
    private int remainingFuel;

    public Vehicle(final int maxFuel) {
        this.maxFuel = maxFuel;
        remainingFuel = maxFuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public int getRemainingFuel() {
        return remainingFuel;
    }

    public void setRemainingFuel(final int remainingFuel) {
        this.remainingFuel = remainingFuel;
    }

    public void accelerate() {
        remainingFuel--;
    }
}