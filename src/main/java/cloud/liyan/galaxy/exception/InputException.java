package cloud.liyan.galaxy.exception;

import cloud.liyan.galaxy.util.enums.ExceptionEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 14:38
 */
public class InputException extends GalaxyException {
    public InputException(String message) {
        super(message);
    }

    public InputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputException(ExceptionEnum exceptionEnum, Throwable cause) {
        super(exceptionEnum.getDesc(), cause);
    }
}
