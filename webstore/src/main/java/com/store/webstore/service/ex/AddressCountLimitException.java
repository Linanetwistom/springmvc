package com.store.webstore.service.ex;

public class AddressCountLimitException extends ServiceException{

    public AddressCountLimitException() {
    }

    public AddressCountLimitException(String arg0) {
        super(arg0);
    }

    public AddressCountLimitException(Throwable arg0) {
        super(arg0);
    }

    public AddressCountLimitException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public AddressCountLimitException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
