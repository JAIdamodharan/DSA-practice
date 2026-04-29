public class KAryHeap {

    int[] heap;
    int size;
    int k;

    public KAryHeap(int capacity, int k) {
        heap = new int[capacity];
        size = 0;
        this.k = k;
    }

    int parent(int i) {
        return (i - 1) / k;
    }

    int child(int i, int j) {
        return k * i + j; // j = 1 to k
    }

    void insert(int val) {
        heap[size] = val;
        int i = size;
        size++;

        // Heapify up
        while (i > 0 && heap[parent(i)] < heap[i]) {
            int temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = parent(i);
        }
    }

    int extractMax() {
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);
        return root;
    }

    void heapify(int i) {
        int largest = i;

        for (int j = 1; j <= k; j++) {
            int childIndex = child(i, j);

            if (childIndex < size && heap[childIndex] > heap[largest]) {
                largest = childIndex;
            }
        }

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            heapify(largest);
        }
    }

    void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        KAryHeap heap = new KAryHeap(20, 3); // k = 3

        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);

        System.out.print("Heap: ");
        heap.printHeap();

        System.out.println("Extract Max: " + heap.extractMax());

        System.out.print("After Extraction: ");
        heap.printHeap();
    }
}