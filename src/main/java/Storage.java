import java.util.ArrayList;

/**
 * Class to handle stored items
 * within the bot, and mark them
 * as done
 */
public class Storage {
    private final ArrayList<String> storage = new ArrayList<String>();
    private final ArrayList<Boolean> done = new ArrayList<Boolean>();

    /**
     * Adds a String to the stored items
     *
     * @param toStore The String to be stored
     */
    public void store(String toStore) {
        this.storage.add(toStore);
        this.done.add(false);
    }

    /**
     * Prints out all the stored items,
     * in order which they were stored
     */
    public void readStorage() {
        int length = this.storage.size();
        for (int i = 0; i < length; i++) {
            System.out.println(retrieve(i + 1));
        }
    }

    /**
     * Marks a specific item on the list
     * as "done"
     *
     * @param index The index of the item,
     *              as it appears in the list
     */
    public void markAsDone(int index) {
        this.done.set(index - 1, true);
    }

    /**
     * Retrieves an entry from the stored
     * items (at index i)
     *
     * @param i Index of the item as it
     *          appears in the list
     * @return A String representing the
     *         item, its position on the list,
     *         and its "done" status
     */
    public String retrieve(int i) {
        return i + ". " + doneGet(i - 1)
                + " " + this.storage.get(i - 1);
    }

    /**
     * Checks the status of an item located
     * at a certain ArrayList index
     *
     * @param index The actual index of the item
     *              in the ArrayList
     * @return A String with a tick character
     *         or a cross character
     */
    private String doneGet(int index) {
        if (this.done.get(index)) {
            return "[✓]";
        } else {
            return "[✗]";
        }
    }
}