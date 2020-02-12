package lab6;

public abstract class CalculatorCommand {
    protected Calculator calculator;

    public CalculatorCommand(Calculator c) {
        calculator = c;
    }

    /**
     * Perform operation on calculator.
     */
    public abstract void execute();

    /**
     * Restore calculator to the state before performing this operation.
     */
    public abstract void unexecute();

}
