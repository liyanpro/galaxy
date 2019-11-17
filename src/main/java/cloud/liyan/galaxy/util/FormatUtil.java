package cloud.liyan.galaxy.util;

import java.math.BigDecimal;

/**
 * @author liyan
 * @description
 * @date 2019-11-06 21:21
 */
public class FormatUtil {

    /**
     * 四舍五入保留两位小数
     * 
     * @param number
     * @return
     */
    public static double formatDouble(Double number) {
        if (number == null) {
            return 0d;
        }
        BigDecimal bigDecimal = new BigDecimal(number);
        return bigDecimal.setScale(BigDecimal.ROUND_HALF_UP, 2).doubleValue();

    }
}
