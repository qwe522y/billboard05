package com.sotas.billboard05.exception;

import java.io.IOException;

public class ImgValidationErr extends IOException {
    public ImgValidationErr(String message) {
        super(message);
    }
}
