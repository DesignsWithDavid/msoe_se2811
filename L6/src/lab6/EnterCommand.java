package lab6;

public class EnterCommand extends CalculatorCommand {

    private String originalAccumulator;

    public EnterCommand(Calculator c) {
        super(c);
        originalAccumulator = c.getAccumulator();
    }

    public void execute() {
        calculator.enter();
    }

    public void unexecute() {
        calculator.setAccumulator(originalAccumulator);
        calculator.setReadyForNewNumber(true);
    }
}
