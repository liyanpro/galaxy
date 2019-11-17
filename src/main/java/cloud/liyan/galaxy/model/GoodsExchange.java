package cloud.liyan.galaxy.model;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 11:07
 */
public class GoodsExchange {
    /**
     * 货币别名，可能有多个
     */
     private String[]  aliasName;

    /**
     * 商品
     */
    private String  goodsName;

    /**
     * 商品总价
    */
    private Integer credits;

    /**
    * 构建输出格式
    * @return
    */
    public String buildOutputPattern() {
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<aliasName.length;i++){
            buffer.append(aliasName[i]).append(" ");
        }
        buffer.append(goodsName);
        return buffer.toString();
  }

    public String[] getAliasName() {
        return aliasName;
    }

    public void setAliasName(String[] aliasName) {
        this.aliasName = aliasName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }
}
