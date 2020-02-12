package lab6;

public class TimesCommand extends CalculatorCommand {

    private String originalDisplay;
    private String originalAccumulator;

    public TimesCommand(Calculator c) {
        super(c);
        originalAccumulator = c.getAccumulator();
        originalDisplay = c.getDisplay();
    }

    public void execute() {
        calculator.times();
    }

    public void unexecute() {
        calculator.setDisplay(originalDisplay);
        calculator.setAccumulator(originalAccumulator);
        calculator.setReadyForNewNumber(true);
    }
}
