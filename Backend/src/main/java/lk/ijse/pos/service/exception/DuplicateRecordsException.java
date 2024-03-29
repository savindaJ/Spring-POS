package lk.ijse.pos.service.exception;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public class DuplicateRecordsException extends ServiceException{
    /**
     * @param message : message
     */
    public DuplicateRecordsException(String message) {
        super(message);
    }
}
