package com.pingan.apple.immersivestatusbar.recyclerviewdemo.complexdemo;

/**
 * @author apple
 * @Description :
 * @date 17/1/16  下午4:48
 */

public class Category {

    public static final int SECOND_TYPE = 0;
    public static final int THIRD_TYPE = 1;

    private String categoryName;
    private int type;

    public Category(String name, int type) {
        this.categoryName = name;
        this.type = type;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getType() {
        return type;
    }
}
