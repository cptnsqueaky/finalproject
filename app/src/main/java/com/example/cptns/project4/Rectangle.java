package com.example.cptns.project4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Rectangle extends Shape {
    private Rect rectangle;
    private Paint paint = new Paint();

    public Rectangle (Context context, int sColor, int fColor){
        super(context, sColor, fColor);
        double rX = Math.random()*400;
        double rY = Math.random()*500;
        double rS1= Math.random()*1000;
        double rS2= Math.random()*1000;
        int x = (int)rX;
        int y = (int)rY;
        int s1 = (int)rS1;
        int s2 = (int)rS2;
        rectangle = new Rect(x,y,s1,s2);
    }

    String getShapeType(){
        return "Rectangle";
    }

    @Override
    public void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
//        int R = (int)(Math.random()*256);
//        int G = (int)(Math.random()*256);
//        int B= (int)(Math.random()*256);
        paint.setColor(this.getFill());
        canvas.drawRect(rectangle, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(12f);
        paint.setColor(this.getStroke());
        canvas.drawRect(rectangle, paint);
    }
}
