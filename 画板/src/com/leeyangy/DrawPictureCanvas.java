package com.leeyangy;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPictureCanvas extends Canvas {
    //������������ʾ��ͼƬ����
    private Image image =null;

    /**
     * ��������е�ͼƬ
     */

    public void setImage(Image image) {
        //Ϊ��Ա������ֵ
        this.image=image;
    }

    public void paint(Graphics graphics){
        //�ڻ����ϻ���ͼ��
        graphics.drawImage(image,0,0,null);
    }
    public void update(Graphics graphics){
        //����paint����
        paint(graphics);
    }


}
