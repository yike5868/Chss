package net.greatsoft.main.db.po;


import java.io.Serializable;

/**
 * Created by zhanglin on 16/8/12.
 */

public class Entry implements Serializable{

    public Integer isAppCreate = 1;//标识是否是app新增的

    public Integer getIS_APP_CREATE() {
        return isAppCreate;
    }

    public void setIS_APP_CREATE(Integer IS_APP_CREATE) {
        this.isAppCreate = IS_APP_CREATE;
    }
}
