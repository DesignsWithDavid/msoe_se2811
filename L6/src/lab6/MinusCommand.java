package lab6;

public class MinusCommand extends CalculatorCommand {

    private String originalDisplay;
    private String originalAccumulator;

    public MinusCommand(Calculator c) {
        super(c);
        originalDisplay = c.getDisplay();
        originalAccumulator = c.getAccumulator();
    }

    public void execute() {
        calculator.minus();
    }

    public void unexecute() {
        calculator.plus();
        calculator.setDisplay(originalDisplay);
        calculator.setAccumulator(originalAccumulator);
        calculator.setReadyForNewNumber(true);
    }
}
