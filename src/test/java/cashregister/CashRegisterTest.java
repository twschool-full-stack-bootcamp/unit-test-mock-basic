package cashregister;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase() {
        Purchase purchase = new Purchase(new Item[]{});

        MockPrinter printer = new MockPrinter();
        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        printer.verifyPrintHasBeenCalled();
    }

    @Test
    public void should_print_the_stub_purchase() {
        StubPurchase purchase = new StubPurchase("expected result");

        MockPrinter printer = new MockPrinter();
        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        printer.verifyPrintHasBeenCalledWith("expected result");
    }

    @Test
    public void should_verify_with_mockito() {
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("expected result");

        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        verify(printer).print("expected result");
    }

}
