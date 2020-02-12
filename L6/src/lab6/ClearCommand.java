package lab6;

public class ClearCommand extends CalculatorCommand {

    private String originalDisplay;
    private String originalAccumulator;
    private String originalMemory;

    public ClearCommand(Calculator c) {
        super(c);
        originalAccumulator = c.getAccumulator();
        originalDisplay = c.getDisplay();
        originalMemory = c.getMemory();
    }

    public void execute() {
        calculator.clear();
    }

    public void unexecute() {
        calculator.setDisplay(originalDisplay);
        calculator.setAccumulator(originalAccumulator);
        calculator.setMemory(originalMemory);
        calculator.setReadyForNewNumber(true);
    }
}
