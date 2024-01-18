package taxcalc;

import java.util.List;

import java.util.HashSet;
import java.util.Set;

import taxcalc.exceptions.ArgumentException;
import taxcalc.models.FinancialRecord;

public class TaxCalc {

    private int percent;

    public TaxCalc(int percent) {
        this.percent = percent;
    }

    public FinancialRecord getNetAmount(List<FinancialRecord> taxReport) {
        
        if (hasMultipleCurrencies(taxReport)) {
            throw new ArgumentException("Cannot calculate net amount when multiple currencies are provided.");
        }

        int totalAmount = getAmountTotal(taxReport);
        Double taxAmount = totalAmount * (percent / 100d);
        FinancialRecord totalTax = new FinancialRecord(totalAmount - taxAmount.intValue(), taxReport.get(0).getCurrency());

        return totalTax;
    }

    private boolean hasMultipleCurrencies(List<FinancialRecord> taxReport) {
        Set<String> currencies = new HashSet<String>(); //HashSet only allows unique items in the list
        for (FinancialRecord item : taxReport) {
            currencies.add(item.getCurrency());

            // Early return, Don't loop through all the items if we already know there are multiple currencies
            if (currencies.size() > 1) { 
                return true;
            }
        }

        return currencies.size() > 1;
    }

    private int getAmountTotal(List<FinancialRecord> taxReport) {
        int total = 0;
        for (FinancialRecord item : taxReport) {
            total += item.getAmount();
        }

        return total;
    }
}