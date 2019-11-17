package cloud.liyan.galaxy.util.enums;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 11:42
 */
public enum ExceptionEnum {

    ROMAN_SYMBOL_ILLEGAL("ROMAN_SYMBOL_ILLEGAL", "roman symbol is illegal"),

    ARABIC_NUMBER_RANGE_INVALID("ARABIC_NUMBER_RANGE_INVALID", "arabic number must be [1, 3999]"),

    GOODS_NAME_NOT_EXIST_EXCEPTION("GOODS_NAME_INVALID", "the goods name is not exist"),

    ALIAS_NOT_EXIST_EXCEPTION("ALIAS_INVALID", "the alias of symbol is not exist"),

    CREDITS_NOT_INTEGER_EXCEPTION("CREDITS_NOT_INTEGER_EXCEPTION", "the credits of result is not integer"),

    EXCEPTION("EXCEPTION", "system exception");

    /**
     * code
     */
    private String code;

    /**
     * 描述
     */
    private String desc;

    ExceptionEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return String.format("[code=%s, desc=%s]", getCode(), getDesc());
    }
}
