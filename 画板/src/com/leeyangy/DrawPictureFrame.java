package com.leeyangy;

//导包
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

//DrawPictureFrame继承自JFrame
public class DrawPictureFrame extends JFrame {
        //创建一个8位RGB
        BufferedImage bfimg=new BufferedImage(570,390,BufferedImage.TYPE_INT_BGR);
        //获得图像的绘图对象
        Graphics graphics=bfimg.getGraphics();
        //将绘图对象转换为2d样式
        Graphics2D graphics2D=(Graphics2D) graphics;
        //创建画布对象
        DrawPictureCanvas drawPictureCanvas=new DrawPictureCanvas();
        //定义前景色
        Color foreColor=Color.BLACK;
        Color backupColor=Color.WHITE;

        //初始化鼠标绘制横纵坐标和橡皮擦表示变量
        int x=-1;
        int y=-1;
        boolean rubber = false;

        //添加工具栏及按钮
        //工具栏
        private JToolBar toolBar;
        //橡皮擦按钮
        private JButton eraserButton;
        //细线按钮
        private JButton strokeButton1;
        //粗线按钮
        private JButton strokeButton2;
        //较粗按钮
        private JButton strokeButton3;
        //前景色按钮
        private JButton foregroundButton;
        //背景色按钮
        private JButton backgroundButton;
        //清除按钮
        private JButton clearButton;
        //保存按钮
        private JButton saveButton;
        //图形按钮
        private JButton shapeButton;


        /**
         * 构造方法，添加鼠标监听事件
         */
        public DrawPictureFrame() {
            //使窗体不能改变大小
            setResizable(false);
            //设置窗体标题
            setTitle("画 画小程序");
            //点击右上角关闭连同程序一起关闭
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //设置窗体位置和宽高
            setBounds(500,100,574,460);
            //组件初始化
            init();
            addListen();
        }

    /**
     * 组件初始化
     */
    private void init(){
            //用背景色设置绘图对象的颜色
            graphics2D.setColor(backupColor);
            //用背景色填充整个画布
            graphics2D.fillRect(0,0,570,390);
            //用前景色设置绘图对象的颜色
            graphics2D.setColor(foreColor);
            //设置画布图像
            drawPictureCanvas.setImage(bfimg);
            //将画布添加到窗体容器默认布局的中部位置
            getContentPane().add(drawPictureCanvas);

            //初始化工具栏
            toolBar =new JToolBar();
            //工具栏添加到最北的位置
            getContentPane().add(toolBar, BorderLayout.NORTH);
            //添加保存按钮
            saveButton =new JButton("保存");
            toolBar.add(saveButton);
            //添加分割
            toolBar.addSeparator();
            //以下同类方法省略（添加按钮注释之类的，toolBar.addSeparator()添加分割）
            //添加画笔粗细按钮
            strokeButton1= new JButton("细  线");
            strokeButton1.setSelected(true);
            toolBar.add(strokeButton1);

            strokeButton2= new JButton("粗  线");
            toolBar.add(strokeButton2);

            strokeButton3= new JButton("比较粗");
            toolBar.add(strokeButton3);

            //画笔粗细按钮，确保只能有一个按钮被选中
            ButtonGroup buttonGroup=new ButtonGroup();
            buttonGroup.add(strokeButton1);
            buttonGroup.add(strokeButton2);
            buttonGroup.add(strokeButton3);
            toolBar.add(strokeButton3);
            toolBar.addSeparator();
            //添加背景色
            backgroundButton=new JButton("背景色");
            toolBar.add(backgroundButton);

            //添加前景色
            foregroundButton=new JButton("前景色");
            toolBar.add(foregroundButton);
            toolBar.addSeparator();
            //添加清除按钮
            clearButton=new JButton("清除");
            toolBar.add(clearButton);
            //添加橡皮按钮
            eraserButton=new JButton("橡皮");
            toolBar.add(eraserButton);
    }

    /**
     * 组件初始化
     */
    private  void addListen(){
        //注册鼠标监听事件
        drawPictureCanvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            /**
             * 重写方法
             *当鼠标拖拽时
             */
            public void mouseDragged(final MouseEvent e) {
                // 如果x和y存在鼠标记录
                if(x>0 && y>0){
                    if(rubber){
                        //如果rubber为true，表示使用rubber
                        //绘图工具使用前景色
                        //在鼠标滑过的位置填充正方形
                        graphics2D.setColor(backupColor);
                        graphics2D.fillRect(x,y,10,10);
                    }
                    else {
                        //如果rubber标识为false，表示用画笔
                        //在鼠标滑过的位置画直线
                        graphics2D.drawLine(x,y,e.getX(),e.getY());
                    }
                }
                //获取鼠标xy位置
                y=e.getY();
                x=e.getX();
                //更新画布
                drawPictureCanvas.repaint();;
            }
        });
        drawPictureCanvas.addMouseListener(new MouseAdapter() {
            @Override
            //重写鼠标抬起方法
            //当鼠标释放时将鼠标恢复
            public void mouseReleased(final MouseEvent e) {
                //恢复鼠标横纵坐标
                x=-1;
                y=-1;
            }
        });

        //添加画笔粗细 0-3
        //添加线条按钮动作监听事件
        strokeButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                //声明画笔属性，粗细像素为1像素。线条末端无修饰，折线处成尖角
                BasicStroke bs=new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
                //使用此画笔
                graphics2D.setStroke(bs);
            }
        });
        //以下方法同上
        strokeButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                BasicStroke bs=new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
                graphics2D.setStroke(bs);
            }
        });
        //以下方法同上
        strokeButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                BasicStroke bs=new BasicStroke(3,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER);
                graphics2D.setStroke(bs);
            }
        });

        //背景颜色按钮添加动作监听
        backgroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Color bgColor =JColorChooser.showDialog(DrawPictureFrame.this,"选择颜色",Color.CYAN);
                if (bgColor !=null){
                    backupColor=bgColor;

                }
                backgroundButton.setBackground(backupColor);
                graphics2D.setColor(backupColor);
                graphics2D.fillRect(0,0,570,390);
                graphics2D.setColor(foreColor);
                drawPictureCanvas.repaint();

            }
        });

        //前景色按钮添加动作监听
        foregroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color fcolor=JColorChooser.showDialog(DrawPictureFrame.this,"选择颜色",Color.CYAN);
                if(fcolor!=null){
                    foreColor=fcolor;

                }
                foregroundButton.setForeground(foreColor);
                graphics2D.setColor(foreColor);
            }
        });

        //清屏按钮添加动作监听事件
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                graphics2D.setColor(backupColor);
                graphics2D.fillRect(0,0,570,390);
                graphics2D.setColor(foreColor);
                drawPictureCanvas.repaint();
            }
        });

        //橡皮擦按钮动作监听事件
        eraserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if(eraserButton.getText().equals("橡皮")){
                    rubber=true;
                    eraserButton.setText("画图");
                }else{
                    rubber=false;
                    eraserButton.setText("橡皮");
                    graphics2D.setColor(foreColor);

                }
            }
        });
    }
        //主程序入口
        public static void main(String[] args) {
            //实例化对象
            DrawPictureFrame dpf=new DrawPictureFrame();
            //让其显示出来
            dpf.setVisible(true);
        }
}