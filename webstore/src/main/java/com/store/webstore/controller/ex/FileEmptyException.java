package com.store.webstore.controller.ex;


public class FileEmptyException extends FileUploadException{

    public FileEmptyException() {
    }

    public FileEmptyException(String arg0) {
        super(arg0);
    }

    public FileEmptyException(Throwable arg0) {
        super(arg0);
    }

    public FileEmptyException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public FileEmptyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
