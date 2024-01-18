package taxcalc.models;

public class TaxItem {
    private int amount;
    private String currency;

    public TaxItem(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }
}
