package alisson.FirstWebAPI.handler;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message); //super is used to invoke
        // the constructor of the parent class (or superclass)
        // from the current class.
    }
    public BusinessException(String message, Object ... params){ //params: An array of objects (varargs)
        // that can be used to format the error message.

        //formats the message using the provided params.
        // For example, if message is "Error: %s" and params contains "Invalid input",
        // the formatted message would be "Error: Invalid input".
        super(String.format(message, params));

    }
}
