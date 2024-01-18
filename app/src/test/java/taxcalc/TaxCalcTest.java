package taxcalc;

import org.junit.jupiter.api.Test;

import java.util.List;

import taxcalc.models.FinancialRecord;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaxCalcTest {
    TaxCalc taxCalc = new TaxCalc(10);
    

    @Test
    public void canCalculateTax() throws Exception {        
        List<FinancialRecord> taxReport = List.of(
            new FinancialRecord(40, "GBP"),
            new FinancialRecord(50, "GBP"),
            new FinancialRecord(60, "GBP")
        );

        FinancialRecord netAmount = taxCalc.getNetAmount(taxReport);
        assertEquals(135, netAmount.getAmount());
    }

    @Test
    public void cannotSumDifferentCurrencies() throws Exception {
        try {
            List<FinancialRecord> taxReport = List.of(
                new FinancialRecord(4, "GBP"),
                new FinancialRecord(5, "USD")
            );

            taxCalc.getNetAmount(taxReport);
            fail("didn't throw");
        } catch (Exception e) {

        }
    }
}