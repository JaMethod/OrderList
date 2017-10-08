import java.util.Iterator;
import java.util.LinkedList;

/**
 * Title: OrderedList
 *
 * This class contains the ordered linked list of integers.
 * All of the integers in ascending numerical.
 *
 * Author: JaMethod
 */
public class OrderedList {
    private LinkedList<Integer> list;

    public OrderedList() {
        list = new LinkedList<>();
    }

    /**
     * Adds the specified integer value to its appropriate place on the list.
     * @param value - specified integer.
     */
    public void add(int value) {
        list.add(value);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > value) {
                list.remove(list.size()-1);
                list.add(i, value);
                break;
            }
        }
    }

    /**
     * Removes the specified value from the list.
     * @param value - specified value.
     */
    public void remove(int value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                list.remove(i);
                break;
            }
        }
    }

    /**
     * Uses the iterator to print the contents of the list separated by commas.
     */
    public void list() {
        if (list.size() > 0) {
            Iterator<Integer> iterator = list.iterator();
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(iterator.next() + ", ");
            }
            System.out.print(iterator.next() + "\n");
        }
    }

    /**
     * Returns the largest difference between two neighboring items.
     * @return
     */
    public int maxgap() {
        int gap = 0;
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 1) > gap) {
                    gap = list.get(i) - list.get(i - 1);
                }
            }
        }
        return gap;
    }
}
