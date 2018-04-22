package net.greatsoft.main.rsp;

import android.content.Intent;

/**
 * Created by zhanglin on 2016/12/4.
 */

public class AndroidVerson {

    private String outsideVersion;
    private String urlStr;
    private String id;
    private String name;
    private Integer innerVersion;
    private String type;
    /**
     * 是否裁剪 0否1是
     */
    private Integer isTailor;

    /**
     * 是否拍照(0否1是)
     */
    private Integer isTakePhoto;

    /**
     * 文件压缩容量(0不压缩)kb
     */
    private Integer fileZipCapicity;

    /**
     * 是否使用蓝牙
     * @return
     */

    private Integer isBluetooth;

    /**
     * 是否需要授权验证
     * @return
     */

    private Integer isNeedAuthorize;

    public Integer getIsNeedAuthorize() {
        return isNeedAuthorize;
    }

    public void setIsNeedAuthorize(Integer isNeedAuthorize) {
        this.isNeedAuthorize = isNeedAuthorize;
    }

    public Integer getIsBluetooth() {
        return isBluetooth;
    }

    public void setIsBluetooth(Integer isBluetooth) {
        this.isBluetooth = isBluetooth;
    }

    public Integer getIsTailor() {
        return isTailor;
    }

    public void setIsTailor(Integer isTailor) {
        this.isTailor = isTailor;
    }

    public Integer getIsTakePhoto() {
        return isTakePhoto;
    }

    public void setIsTakePhoto(Integer isTakePhoto) {
        this.isTakePhoto = isTakePhoto;
    }

    public Integer getFileZipCapicity() {
        return fileZipCapicity;
    }

    public void setFileZipCapicity(Integer fileZipCapicity) {
        this.fileZipCapicity = fileZipCapicity;
    }

    public String getOutsideVersion() {
        return outsideVersion;
    }

    public void setOutsideVersion(String outsideVersion) {
        this.outsideVersion = outsideVersion;
    }

    public String getUrlStr() {
        return urlStr;
    }

    public void setUrlStr(String urlStr) {
        this.urlStr = urlStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInnerVersion() {
        return innerVersion;
    }

    public void setInnerVersion(Integer innerVersion) {
        this.innerVersion = innerVersion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
