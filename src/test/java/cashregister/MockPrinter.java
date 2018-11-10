package cashregister;

import static org.assertj.core.api.Assertions.assertThat;

public class MockPrinter extends Printer {
    private boolean hasBeenCalled = false;
    private String actualPrintArg;

    @Override
    public void print(String printThis) {
        hasBeenCalled = true;
        actualPrintArg = printThis;
    }

    public void verifyPrintHasBeenCalled() {
        assertThat(hasBeenCalled)
                .as("Expect print has been called, but never.")
                .isTrue();
    }

    public void verifyPrintHasBeenCalledWith(String expectedPrintArg) {
        assertThat(expectedPrintArg).isEqualTo(actualPrintArg);
    }
}
