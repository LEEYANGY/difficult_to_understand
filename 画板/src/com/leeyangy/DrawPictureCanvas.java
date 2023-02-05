package com.leeyangy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPictureCanvas extends Canvas {
    //创建画板中显示的图片对象
    private Image image =null;

    /**
     * 设置面板中的图片
     */

    public void setImage(Image image) {
        //为成员变量赋值
        this.image=image;
    }

    public void paint(Graphics graphics){
        //在画布上绘制图像
        graphics.drawImage(image,0,0,null);
    }
    public void update(Graphics graphics){
        //调用paint方法
        paint(graphics);
    }


}
