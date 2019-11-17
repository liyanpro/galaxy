package cloud.liyan.galaxy.util.enums;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 11:20
 */
public enum CommandEnum {

    ALIAS_COMMAND("ALIAS_COMMAND", "罗马货币别名指令"),

    CURRENCY_EXCHANGE_COMMAND("CURRENCY_EXCHANGE_COMMAND", "货币兑换商品指令"),

    HOW_MUCH_COMMAND("HOW_MUCH_COMMAND", "商品总价兑换货币指令"),

    HOW_MANY_COMMAND("HOW_MANY_COMMAND", "商品总价计算货币指令"),
    HOW_MANY_GOODS_EXCHANGE_COMMAND("HOW_MANY_GOODS_EXCHANGE_COMMAND", "商品之间兑换指令"),

    INVALID_COMMAND("INVALID_COMMAND", "无效指令");

    private String type;

    private String desc;

    CommandEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return String.format("[type=%s, desc=%s]", getType(), getDesc());
    }

}
