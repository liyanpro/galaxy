package cloud.liyan.galaxy.exception;

import cloud.liyan.galaxy.util.enums.ExceptionEnum;

/**
 * @author liyan
 * @description
 * @date 2019-10-11 11:45
 */
public class HandleException  extends GalaxyException {


    public HandleException(ExceptionEnum exceptionEnum, String message){
        super(exceptionEnum, message);
    }
}
