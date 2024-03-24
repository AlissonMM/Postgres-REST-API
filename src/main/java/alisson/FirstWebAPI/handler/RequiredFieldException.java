package alisson.FirstWebAPI.handler;

public class RequiredFieldException extends BusinessException{
    public RequiredFieldException(String field) {
        super("%s field is mandatory", field);
    }
}
