package exceptions;

public class DiaryIsNotAccessibleException extends RuntimeException {
    public DiaryIsNotAccessibleException(String message){
        super(message);
    }
}
