package com.store.webstore.service.ex;

public class UserNotFoundException extends ServiceException{

    public UserNotFoundException() {
    }

    public UserNotFoundException(String arg0) {
        super(arg0);
    }

    public UserNotFoundException(Throwable arg0) {
        super(arg0);
    }

    public UserNotFoundException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public UserNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
    
}
