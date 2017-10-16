package com.sotas.billboard05.service;

import com.sotas.billboard05.exception.ImgValidationErr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
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
        if(data.length > 700000) throw new ImgValidationErr("too big " + data.length);
        if (!pngValidation(data) && !jpgValidation(data)) {
            throw new ImgValidationErr("it's not png");
        }
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
        if(data.length > 700000) throw new ImgValidationErr("too big " + data.length);
        if (!jpgValidation(data)) {
            throw new ImgValidationErr("it's not jpg");
        }
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

    private boolean jpgValidation(byte[] data) {
        return data.length > 2 && data[0] == (byte) 0xFF && data[1] == (byte) 0xD8;
    }

    private boolean pngValidation(byte[] data) {
        return data.length > 8 &&
                data[0] == (byte) 0x89 &&
                data[1] == (byte) 0x50 &&
                data[2] == (byte) 0x4E &&
                data[3] == (byte) 0x47 &&
                data[4] == (byte) 0x0D &&
                data[5] == (byte) 0x0A &&
                data[6] == (byte) 0x1A &&
                data[7] == (byte) 0x0A;
    }

    @Override
    public void addImg(int bbId, byte[] data) throws IOException {
        updateImg(bbId, data, getImgCount(bbId));
    }

    @Override
    public int getImgCount(int bbId) {
        File dir = new File(photoDir + "/" + bbId);
        if(!dir.exists()) return 0;
        File[] list = dir.listFiles(pathname -> pathname.getName().endsWith(".jpg"));
        return list == null ? 0 : list.length;
    }

    @Override
    public void deleteImg(int id, int index) {
        int count = getImgCount(id);
        new File(photoDir + "/" + id + "/" + index + ".jpg").delete();
        for(int i=index+1; i<count; i++) {
            new File(photoDir + "/" + id + "/" + i + ".jpg").renameTo(new File(photoDir + "/" + id + "/" + (i-1) + ".jpg"));
        }
    }
}
