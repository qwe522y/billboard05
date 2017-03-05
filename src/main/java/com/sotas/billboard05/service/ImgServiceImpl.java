package com.sotas.billboard05.service;

import com.sotas.billboard05.exception.ImgValidationErr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class ImgServiceImpl implements ImgService{
    private String photoDir;

    @Autowired
    public ImgServiceImpl(String photoDir) {
        this.photoDir = photoDir;
    }

    @Override
    public void setMiniImg(int bbId, byte[] data) throws IOException {
        //png validation
        if (data.length > 8 &&
        data[0] == (byte) 0x89 &&
        data[1] == (byte) 0x50 &&
        data[2] == (byte) 0x4E &&
        data[3] == (byte) 0x47 &&
        data[4] == (byte) 0x0D &&
        data[5] == (byte) 0x0A &&
        data[6] == (byte) 0x1A &&
        data[7] == (byte) 0x0A) {/* ok */}
        else throw new ImgValidationErr("it's not png");
        if(data.length > 500000) throw new ImgValidationErr("too big " + data.length);
        FileOutputStream fos = null;
        try {
            File bbPhotoDir = new File(photoDir + "/" + bbId);
            if (!bbPhotoDir.exists()) bbPhotoDir.mkdir();
            File imgFile = new File(bbPhotoDir.getPath() + "/0.png");
            if (!imgFile.exists()) {
                imgFile.createNewFile();
            }
            fos = new FileOutputStream(imgFile, false);
            fos.write(data);
        } finally {
            if(fos != null) fos.close();
        }
    }

    @Override
    public void updateImg(int bbId, byte[] data, int index) throws IOException {
        //jpg validation
        if (data.length > 2 && data[0] == (byte) 0xFF && data[1] == (byte) 0xD8) { /* ok */ }
        else throw new ImgValidationErr("it's not jpg");
        if(data.length > 500000) throw new ImgValidationErr("too big " + data.length);

        FileOutputStream fos = null;
        try {
            File bbPhotoDir = new File(photoDir + "/" + bbId);
            if (!bbPhotoDir.exists()) bbPhotoDir.mkdir();
            String fName = index + ".jpg";
            int imgCount = getImgCount(bbId);
            if (imgCount < index) throw new RuntimeException("error imgCount(" + imgCount + ") < index(" + index + ")");
            File imgFile = new File(photoDir + "/" + bbId + "/" + fName);
            if (!imgFile.exists()) {
                imgFile.createNewFile();
            }
            fos = new FileOutputStream(imgFile, false);
            fos.write(data);
        } finally {
            if(fos != null) fos.close();
        }
    }

    @Override
    public void addImg(int bbId, byte[] data) throws IOException {
        updateImg(bbId, data, getImgCount(bbId));
    }

    @Override
    public int getImgCount(int bbId) {
        File dir = new File(photoDir + "/" + bbId);
        if(!dir.exists()) return 0;
        File[] list = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".jpg");
            }
        });
        return list == null ? 0 : list.length;
    }
}
