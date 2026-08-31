import java.util.ArrayList;

public interface Command {
    void execute(ArrayList<String> arrayList) throws CommandNotCorrectException;
}
