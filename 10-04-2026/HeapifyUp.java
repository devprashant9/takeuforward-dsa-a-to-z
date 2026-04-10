import java.util.ArrayList;
import java.util.List;

public class HeapifyUp {

    public static void heapifyUp(List<Integer> list, int childIndex) {

        while (childIndex > 0) {
            int parentIndex = (childIndex - 1) / 2;

            if (list.get(parentIndex) < list.get(childIndex)) {
                swap(list, childIndex, parentIndex);
                childIndex = parentIndex;
            } else {
                break;
            }
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
        list.add(6);
        System.out.println(list);
        heapifyUp(list, list.size() - 1);
        System.out.println(list);
    }
}