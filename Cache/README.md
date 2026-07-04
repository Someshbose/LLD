# Cache Design

LRU Eviction Policy (Strategy Pattern)
The Thread-Safe Storage Layer & Eviction layer
LFU Eviction policy (Strategy Pattern) with thread safety


## Core Domain Models

To ensure the design adheres to the Open-Closed Principle (OCP) and Single Responsibility Principle (SRP), we break the system into distinct interfaces:
Cache: The central manager that orchestrates the storage and eviction policy.
Storage: An interface responsible for the actual key-value mapping (e.g., HashMap).
EvictionPolicy: An interface defining the strategy for tracking and removing keys (e.g., LRU, LFU, FIFO).
DoublyLinkedListNode: The underlying data structure used by the LRU policy to maintain access order in $O(1)$ time.


