package org.mazz.restrowaiter.Util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NumberUtil {

    public static String convertCurreny(String  amount, String countryCurrency) {

        Double amountValue;
if(!amount.isEmpty()&& amount.length()>0){
    amountValue=new Double(amount);
}else{
    amountValue=new Double(0);
}
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        format.setCurrency(Currency.getInstance(countryCurrency));
        String result = format.format(amountValue);

        return result;
    }

}
