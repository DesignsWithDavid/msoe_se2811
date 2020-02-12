package lab6;

public class SaveCommand extends CalculatorCommand {

    private String originalDisplay;
    private String originalAccumulator;
    private String originalMemory;

    public SaveCommand(Calculator c) {
        super(c);
        originalDisplay = c.getDisplay();
        originalAccumulator = c.getAccumulator();
        originalMemory = c.getMemory();
    }

    public void execute() {
        calculator.saveToMemory();
    }

    public void unexecute() {
        calculator.setDisplay(originalDisplay);
        calculator.setAccumulator(originalAccumulator);
        calculator.setMemory(originalMemory);
        calculator.setReadyForNewNumber(true);
    }
}
