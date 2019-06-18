package org.mazz.restrowaiter.Util;

import java.math.BigDecimal;
import java.math.MathContext;
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


    public static String convertCurrencyWithRoundOff(String  amount, String countryCurrency) {

        Double amountValue;
        if(!amount.isEmpty()&& amount.length()>0){
            amountValue=new Double(amount);
        }else{
            amountValue=new Double(0);
        }
      Double rountOffValue=Double.valueOf(Math.round(amountValue));

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
        format.setCurrency(Currency.getInstance(countryCurrency));
        String result = format.format(rountOffValue);


        return result ;
    }


    public static BigDecimal removeDecimal(BigDecimal inputNumer){
        return  inputNumer.setScale(0,BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal roundOffWith2Decimal(BigDecimal inputNumer){

        MathContext m = new MathContext(4); // 4 precision

        // b1 is rounded using m
        return  inputNumer.round(m);

    }

    public static String totalRoundOff(BigDecimal inputNumer){

       String result= ""+Math.round(Float.parseFloat(""+inputNumer));

        // b1 is rounded using m
        return  result;

    }


}
