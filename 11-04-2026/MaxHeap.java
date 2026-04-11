import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private boolean hasLeft(int i) {
        return leftChild(i) < heap.size();
    }

    private boolean hasRight(int i) {
        return rightChild(i) < heap.size();
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(int val) {
        heap.add(val);
        heapifyUp(heap.size() - 1);
    }

    public void heapifyUp(int lastIndex) {
        while (lastIndex > 0) {
            int parent = parent(lastIndex);

            if (heap.get(lastIndex) > heap.get(parent)) {
                swap(lastIndex, parent);
                lastIndex = parent;
            } else {
                break;
            }
        }
    }

    public int peek() {
        if (heap.isEmpty()) {
            return -1;
        }
        return heap.get(0);
    }

    public int getMax() {
        int max = peek();
        if (max == -1) {
            return -1;
        }
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);

        heapifyDown(0);
        return max;
    }

    public void heapifyDown(int rootIndex) {
        while (true) {
            int left = leftChild(rootIndex);
            int right = rightChild(rootIndex);
            int largest = rootIndex;

            if (hasLeft(rootIndex) && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (hasRight(rootIndex) && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest == rootIndex) {
                break;
            }

            swap(rootIndex, largest);

            rootIndex = largest;
        }
    }

    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.printHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);
        heap.printHeap();

        System.out.println(heap.peek());
        System.out.println(heap.getMax());
        heap.printHeap();
    }
}
