package cashregister;

public class StubPurchase extends Purchase {

    private String stubAsStringResult;

    public StubPurchase(String stubAsStringResult) {
        super(null);
        this.stubAsStringResult = stubAsStringResult;
    }

    @Override
    public String asString() {
        return stubAsStringResult;
    }
}
