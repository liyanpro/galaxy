package cloud.liyan.galaxy.exception;

import cloud.liyan.galaxy.util.enums.ExceptionEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 11:45
 */
public class GalaxyException extends RuntimeException {

    public GalaxyException(String message) {
        super(message);
    }

    GalaxyException(ExceptionEnum exceptionEnum, String message) {
        super(exceptionEnum.getDesc() + "," + message);
    }

    public GalaxyException(String message, Throwable cause) {
        super(message, cause);
    }

    public GalaxyException(ExceptionEnum exceptionEnumEnum, Throwable cause) {
        super(exceptionEnumEnum.getDesc(), cause);
    }
}
