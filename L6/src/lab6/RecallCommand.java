package lab6;

public class RecallCommand extends CalculatorCommand {

    private String originalDisplay;
    private String originalAccumulator;

    public RecallCommand(Calculator c) {
        super(c);
        originalAccumulator = c.getAccumulator();
        originalDisplay = c.getDisplay();
    }

    public void execute() {
        calculator.recallFromMemory();
    }

    public void unexecute() {
        calculator.setAccumulator(originalAccumulator);
        calculator.setDisplay(originalDisplay);
        calculator.setReadyForNewNumber(true);
    }
}
