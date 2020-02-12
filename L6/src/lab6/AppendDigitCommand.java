package lab6;

public class AppendDigitCommand extends CalculatorCommand {
    private char c;
    private boolean originalNewNumber;
    private String originalDisplay;

    public AppendDigitCommand(Calculator calc, char c) {
        super(calc);
        this.c = c;
    }

    public void execute() {
        originalNewNumber = calculator.getNewNumber();
        originalDisplay = calculator.getDisplay();
        calculator.appendDigit(c);
    }

    public void unexecute() {
        calculator.setReadyForNewNumber(originalNewNumber);
        calculator.setDisplay(originalDisplay);
    }
}
