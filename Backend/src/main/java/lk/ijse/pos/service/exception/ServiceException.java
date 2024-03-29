package lk.ijse.pos.service.exception;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public class ServiceException extends RuntimeException {

    /**
     * @param message : message
     */
    public ServiceException(String message) {
        super(message);
    }

}
