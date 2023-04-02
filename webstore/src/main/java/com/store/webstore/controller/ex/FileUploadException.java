package com.store.webstore.controller.ex;

public class FileUploadException extends RuntimeException{

    public FileUploadException() {
    }

    public FileUploadException(String arg0) {
        super(arg0);
    }

    public FileUploadException(Throwable arg0) {
        super(arg0);
    }

    public FileUploadException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public FileUploadException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }
    
}
