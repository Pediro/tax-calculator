package taxcalc;

import org.junit.jupiter.api.Test;

import java.util.List;

import taxcalc.models.TaxItem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaxCalcTest {
    TaxCalc taxCalc = new TaxCalc(10);
    

    @Test
    public void canCalculateTax() throws Exception {        
        List<TaxItem> taxReport = List.of(
            new TaxItem(40, "GBP"),
            new TaxItem(50, "GBP"),
            new TaxItem(60, "GBP")
        );

        TaxItem netAmount = taxCalc.getNetAmount(taxReport);
        assertEquals(135, netAmount.getAmount());
    }

    @Test
    public void cannotSumDifferentCurrencies() throws Exception {
        try {
            List<TaxItem> taxReport = List.of(
                new TaxItem(4, "GBP"),
                new TaxItem(5, "USD")
            );

            taxCalc.getNetAmount(taxReport);
            fail("didn't throw");
        } catch (Exception e) {

        }
    }
}