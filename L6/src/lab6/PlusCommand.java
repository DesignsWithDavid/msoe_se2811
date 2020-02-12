package lab6;

public class PlusCommand extends CalculatorCommand {

    private String originalAccumulator;
    private String originalDisplay;

    public PlusCommand(Calculator c) {
        super(c);
        originalDisplay = c.getDisplay();
        originalAccumulator = c.getAccumulator();
    }

    public void execute() {
        calculator.plus();
    }

    public void unexecute() {
        calculator.minus();
        calculator.setDisplay(originalDisplay);
        calculator.setAccumulator(originalAccumulator);
        calculator.setReadyForNewNumber(true);
    }

}
