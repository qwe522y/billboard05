package com.sotas.billboard05.service;

import java.io.IOException;

public interface ImgService {
    void setMiniImg(int bbId, byte[] data) throws IOException;
    void updateImg(int bbId, byte[] data, int index) throws IOException;
    void addImg(int bbId, byte[] data) throws IOException;
    int getImgCount(int bbId);
}
