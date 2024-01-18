package taxcalc.models;

public class FinancialRecord {
    private int amount;
    private String currency;

    public FinancialRecord(int amount, String currency) {
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
