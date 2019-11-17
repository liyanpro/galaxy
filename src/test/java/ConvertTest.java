import org.junit.Assert;
import org.junit.Test;

import cloud.liyan.galaxy.controller.GalaxyController;
import cloud.liyan.galaxy.util.ArithmeticUtil;
import cloud.liyan.galaxy.util.enums.CommandEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-12 17:58
 */
public class ConvertTest {

    private static String roman1 = "XL";
    private static String roman2 = "VM";
    private static String roman3 = "DC";
    private static String roman4 = "XXXIX";
    private static String roman5 = "MCMXLIV";
    private static String roman6 = "C";
    private static String roman7 = "D";
    private static String roman8 = "M";

    @Test
    public void convertRomanToNumberTest() {
        System.out
            .println("[RomanToNumber1] real result=40,expected result =" + ArithmeticUtil.convertRomanToNumber(roman1));
        System.out.println(
            "[RomanToNumber2] real result=995,expected result =" + ArithmeticUtil.convertRomanToNumber(roman2));
        System.out.println(
            "[RomanToNumber3] real result=600,expected result =" + ArithmeticUtil.convertRomanToNumber(roman3));
        System.out
            .println("[RomanToNumber4] real result=39,expected result =" + ArithmeticUtil.convertRomanToNumber(roman4));
        System.out.println(
            "[RomanToNumber5] real result=1944,expected result =" + ArithmeticUtil.convertRomanToNumber(roman5));
        Assert.assertEquals(700, ArithmeticUtil.convertRomanToNumber(roman3));
    }

    @Test
    public void convertNumberToRomanTest() {
        System.out.println(
            "[numberToRoman1] real result=" + roman1 + ",expected result =" + ArithmeticUtil.convertNumberToRoman(40));
        System.out.println(
            "[numberToRoman1] real result=" + roman2 + ",expected result =" + ArithmeticUtil.convertNumberToRoman(995));
        System.out.println(
            "[numberToRoman1] real result=" + roman3 + ",expected result =" + ArithmeticUtil.convertNumberToRoman(600));
        System.out.println(
            "[numberToRoman1] real result=" + roman4 + ",expected result =" + ArithmeticUtil.convertNumberToRoman(39));
        System.out.println(
            "[numberToRoman1] real result=" + roman5 + ",expected result =" + ArithmeticUtil.convertNumberToRoman(100));
        System.out.println(
            "[numberToRoman1] real result=" + roman7 + ",expected result =" + ArithmeticUtil.convertNumberToRoman(500));
        System.out.println("[numberToRoman1] real result=" + roman7 + ",expected result ="
            + ArithmeticUtil.convertNumberToRoman(1000));
        Assert.assertEquals("true", 100, ArithmeticUtil.convertRomanToNumber("C"));
        Assert.assertEquals("true", 500, ArithmeticUtil.convertRomanToNumber("D"));
        Assert.assertEquals("true", 1000, ArithmeticUtil.convertRomanToNumber("M"));
        // System.out.println("XA=" + ArithmeticUtil.convertRomanToNumber("XA"));
        // Assert.assertEquals("false", 0, ArithmeticUtil.convertRomanToNumber("XA"));
    }

    @Test
    public void commandCheck() {
        String command = "how many Slivers is glob Gold ?";
        // GoodsExchange goodsExchange = new HowManyGoodsExchangeCommand(command).execute();
        // Assert.assertEquals("true", "Gold", goodsExchange.getGoodsName());
        // Assert.assertEquals("true", "glob", goodsExchange.getAliasName()[0]);
        // GoodsExchange goodsExchangeObject = new HowManyGoodsExchangeCommand(command).execute();
        // goodsExchangeObject.setGoodsName("Slivers");
        // Assert.assertEquals("true", goodsExchangeObject, command);

    }

    @Test
    public void commandStratagey() {
        String command = "how many Slivers is glob Gold ?";
        Assert.assertEquals("true", CommandEnum.HOW_MANY_GOODS_EXCHANGE_COMMAND,
            GalaxyController.matchCommand(command));
    }

}
