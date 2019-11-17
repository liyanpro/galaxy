package cloud.liyan.galaxy.util.constant;

/**
 * @author liyan
 * @description
 * @date 2019-10-10 19:25
 */
public class Constants {

    public static final String UTF8 = "UTF-8";

    public static final String INPUT_COMMAND_NAME = "input.txt";
    /**
     * 罗马数字匹配规则：（1）从左向右，最大的数字M在左边，最小的数子I在最右边 (2)M、C、X、I最多重复3次，若以它结尾则可以重复4次，并且D、L、V最多出现1次
     * （3）从左向右，小数字在前面，大数字在后面，则表示相减。因此"CM或CD或D"只能出现1次，“XC|XL|L”只能出现1次,"IX|IV|V"只会出现1次
     */
    public static final String ROMAN_SYMBOL_REGEX = "(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";
    public static final String SYMBOL_IS = "is";
    public static final String SYMBOL_CREDITS = "Credits";
    // how much 指令前缀
    public static final String HOW_MUCH_SYMBOLE_PRE = "how much is";

    // how many 指令前缀
    public static final String HOW_MANY_SYMBOLE_PRE = "how many credits is";
    // 商品兑换指令
    public static final String HOW_MANY_GOODS_EXCHANGE_SYMBOLE_PRE = "how many";

    // 空白字符串分割符
    public static final String SEPARATOR_REGEX = "\\s+";

    // 无效语句
    public static final String INVALID_OUTPUT_DATA = "I have no idea what you are talking about";

    // how much 输出格式
    public static final String HOW_MUCH_OUTPUT_FORMATTER = "%s is %s";

    // how many 输出格式
    public static final String HOW_MANY_OUTPUT_FORMATTER = "%s is %s Credits";

}
