public class ParkingSpot {
    private int id;
    private boolean isOccupied;
    private VehicleType type;
    private Vehicle parkedVehicle;
    
    public synchronized boolean park(Vehicle v) {
        if (isOccupied) return false;
        this.parkedVehicle = v;
        this.isOccupied = true;
        return true;
    }
}