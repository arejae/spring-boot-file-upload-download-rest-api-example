package com.example.filedemo.payload;

import java.text.DecimalFormat;

public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;
    private String sizeHumanReadable;

    private static long BYTE = 1L;   
    private static long KB = BYTE * 1000;
    private static long MB = KB * 1000;
    private static long GB = MB * 1000;
    private static long TB = GB * 1000;
    private static long PB = TB * 1000;
    private static long EB = PB * 1000;

    private  DecimalFormat DEC_FORMAT = new DecimalFormat("#.##");

    private  String formatSize(long size, long divider, String unitName) {
        return DEC_FORMAT.format((double) size / divider) + " " + unitName;
    }

    public String toHumanReadableSIPrefixes(long size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid file size: " + size);
        if (size >= EB) return formatSize(size, EB, "EB");
        if (size >= PB) return formatSize(size, PB, "PB");
        if (size >= TB) return formatSize(size, TB, "TB");
        if (size >= GB) return formatSize(size, GB, "GB");
        if (size >= MB) return formatSize(size, MB, "MB");
        if (size >= KB) return formatSize(size, KB, "KB");
        return formatSize(size, BYTE, "Bytes");
    }

    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
       
        this.sizeHumanReadable = toHumanReadableSIPrefixes(size);
        System.out.println("Filename :" + this.fileName);
        System.out.println("File Size :" + this.sizeHumanReadable);
    }

    public String getHumanReadablePrefix() {
        return sizeHumanReadable;
    }

    public void setHumanReadablePrefix(String sizeHumanReadable) {
        this.sizeHumanReadable = sizeHumanReadable;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
