## Parking Lot design consideration

Concurrency: Use synchronized blocks or ReentrantLock when updating ParkingSpot status to ensure thread safety during simultaneous entries/exits.

Strategy Pattern: Implement a ParkingStrategy interface. This allows you to swap algorithms (e.g., "Nearest to Entry" vs. "Balanced Load across floors") without modifying the core ParkingLot class.

Scalability: Store mappings (Color to Registration, Registration to Slot) in HashMaps or ConcurrentHashMaps for $O(1)$ lookup time to meet the query requirements.

Error Handling: Implement custom exceptions (e.g., ParkingFullException, InvalidTicketException) rather than returning null or printing to the conso