import java.util.ArrayList;
import java.util.List;

public class HeapifyDown {

    public static void heapifyDown(List<Integer> list, int parentIndex) {
        int size = list.size();
        while (true) {
            int leftChild = 2 * parentIndex + 1;
            int rightChild = 2 * parentIndex + 2;
            int largest = parentIndex;

            if (leftChild < size && list.get(leftChild) > list.get(largest)) {
                largest = leftChild;
            }

            if (rightChild < size && list.get(rightChild) > list.get(largest)) {
                largest = rightChild;
            }

            if (largest == parentIndex) {
                break;
            }

            swap(list, largest, parentIndex);
            parentIndex = largest;
        }
    }

    public static void swap(List<Integer> list, int childIndex, int parentIndex) {
        int temp = list.get(childIndex);
        list.set(childIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list);
        heapifyDown(list, 0);
        System.out.println(list);
    }
}