Max-Priority-Queue
===
This project features a comprehensive implementation of a max priority queue in Java. A max priority queue is a data structure that supports the efficient retrieval and removal of the maximum element, making it ideal for various applications such as job scheduling, simulation systems, and resource management.
Features
---
Efficient Operations: Supports efficient insertion, retrieval, and removal of the maximum element.
Heap-Based Implementation: Utilizes a binary heap (array-based) to maintain the max priority queue properties.
Java Implementation: Written in Java, making it easy to integrate with other Java-based projects and applications.
Dynamic Resizing: Automatically resizes the underlying array to accommodate the number of elements.
Implementation Details
---
Core Methods
insert(Type v): Adds a new key to the priority queue, maintaining the heap invariant.
delMax(): Removes and returns the maximum key.
max(): Returns the maximum key without removing it.
isEmpty(): Checks if the priority queue is empty.
size(): Returns the number of keys in the priority queue.
Private Helper Methods
swim(int k): Restores the heap invariant by swimming up.
sink(int k): Restores the heap invariant by sinking down.
exch(int i, int j): Exchanges the elements at indices i and j.
less(int i, int j): Checks if the element at index i is less than the element at index j.
resize(): Resizes the heap array when the capacity is reached.
