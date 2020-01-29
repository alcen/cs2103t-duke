package bot.loadsave;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A class that provides a concrete implementation
 * of a LoadAndSave, but does nothing
 *
 * @param <T> Type of objects to load and save
 */
public class DummyLoader<T> extends LoadAndSave<T> {
    public DummyLoader() {
        super();
    }

    /**
     * Dummy method to return an empty ArrayList
     *
     * @return An empty ArrayList
     */
    @Override
    public ArrayList<T> loadStored() {
        return new ArrayList<T>();
    }

    /**
     * Does absolutely nothing
     *
     * @param items A Collection of items to
     *              be "saved"
     */
    @Override
    public void saveToDisk(Collection<T> items) {
    }
}