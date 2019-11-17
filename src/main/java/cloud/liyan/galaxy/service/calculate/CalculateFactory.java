package cloud.liyan.galaxy.service.calculate;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 13:10
 */
public class CalculateFactory {

    private static volatile CalculateFactory calculateFactory;

    private CalculateFactory() {}

    public static CalculateFactory getInstance() {
        if (calculateFactory == null) {
            synchronized (CalculateFactory.class) {
                if (calculateFactory == null) {
                    calculateFactory = new CalculateFactory();
                }
            }
        }
        return calculateFactory;
    }

    public <T> T buildCalcultor(Class<T> calculate) {
        if (calculate.equals(CurrencyCalculator.class)) {
            return (T)new CurrencyCalculator();
        } else if (calculate.equals(GoodsCalculator.class)) {
            return (T)new GoodsCalculator();
        } else {
            return null;
        }
    }
}
