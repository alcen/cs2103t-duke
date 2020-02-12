package bot.command.instruction.concrete;

import bot.Storage;
import bot.Ui;

import bot.command.Command;
import bot.command.instruction.execute.StorageReading;
import bot.command.instruction.parse.OneWordInstruction;

import bot.task.Task;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListInstruction extends OneWordInstruction
        implements StorageReading<Task> {

    public ListInstruction(Command... commands) {
        super(commands);
    }

    @Override
    public void readStore(Storage<Task> store, Ui ui) {
        // Prints out all the stored items,
        // in order which they were stored
        ui.showCustomMessage(IntStream.range(0, store.getSize())
                .mapToObj(i -> store.retrieve(i + 1))
                .collect(Collectors.joining("\n")));
    }
}
