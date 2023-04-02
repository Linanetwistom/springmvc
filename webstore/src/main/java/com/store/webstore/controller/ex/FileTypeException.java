package com.store.webstore.controller.ex;


public class FileTypeException extends FileUploadException{

    public FileTypeException() {
    }

    public FileTypeException(String arg0) {
        super(arg0);
    }

    public FileTypeException(Throwable arg0) {
        super(arg0);
    }

    public FileTypeException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public FileTypeException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
