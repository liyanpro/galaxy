package cloud.liyan.galaxy.model;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 11:06
 */
public class Goods {

    // 商品名称
    private String goodsName;
    // 商品所占罗马货币份额
    private Integer exchange;
    // 商品总价
    private Integer credits;

    public Goods(String goodsName, Integer exchange, Integer credits) {
        this.goodsName = goodsName;
        this.exchange = exchange;
        this.credits = credits;
    }

    /**
     * 计算商品单价
     * 
     * @return
     */
    public Double calculateGoodsPrice() {
        return Double.valueOf(credits / exchange);
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getExchange() {
        return exchange;
    }

    public void setExchange(Integer exchangeCredits) {
        this.exchange = exchange;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
