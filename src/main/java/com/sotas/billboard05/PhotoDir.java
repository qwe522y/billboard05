package com.sotas.billboard05;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;

public class PhotoDir {
    @Autowired
    private ServletContext context;

    @Override
    public String toString() {
        return context.getRealPath("/") + "/res/photo";
    }
}
