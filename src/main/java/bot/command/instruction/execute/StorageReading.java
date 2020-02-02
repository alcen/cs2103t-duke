package bot.command.instruction.execute;

import bot.Storage;
import bot.Ui;

/**
 * An interface that represents Instructions that
 * need to read from the Storage
 */
public interface StorageReading<T> {
    /**
     * Reads the store and sends a message to the UI,
     * given the application's storage and UI objects
     *
     * @param store The Storage to read
     * @param ui The Ui to display messages to
     */
    void readStore(Storage<T> store, Ui ui);
}