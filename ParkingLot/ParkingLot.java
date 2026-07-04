public class ParkingLot {
    private List<ParkingFloor> floors;

    public Ticket parkVehicle(Vehicle vehicle) {
        // 1. Find floor/spot strategy
        // 2. Validate availability
        // 3. Mark as occupied
        // 4. Generate Ticket
    }

    public void exitVehicle(Ticket ticket) {
        // 1. Free the slot
        // 2. Calculate payment
    }
    
    // Requirement Methods
    public List<String> getRegistrationNumbersByColor(String color) { ... }
    public List<Integer> getSlotNumbersByColor(String color) { ... }
}