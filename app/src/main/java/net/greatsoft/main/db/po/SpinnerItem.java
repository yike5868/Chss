package net.greatsoft.main.db.po;

/**
 * Created by zhanglin on 2016/11/16.
 */

public class SpinnerItem {
    private String id = "";
    private String value = "";
    private String type = "";

    public SpinnerItem() {
        id = "";
        value = "";
        type = "";
    }

    public SpinnerItem(String _ID, String _Value) {
        id = _ID;
        value = _Value;
    }

    @Override
    public String toString() {
        // 为什么要重写toString()呢？因为适配器在显示数据的时候，如果传入适配器的对象不是字符串的情况下，直接就使用对象.toString()
        //抛弃使用的arrayadapter  使用自定义的adapter 直接可以获得id
        return value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
