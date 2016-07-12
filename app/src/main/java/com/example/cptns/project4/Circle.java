package com.example.cptns.project4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle extends Shape {
    private Paint paint = new Paint();

    public Circle (Context context, int sColor, int fColor){
        super(context, sColor, fColor);
    }

    String getShapeType(){
        return "Circle";
    }

    @Override
    public void onDraw(Canvas canvas) {
        double rX = Math.random()*1000;
        int x = (int)rX;
        double rY = Math.random()*1000;
        int y = (int)rY;
        double rZ = Math.random()*500;
        int z = (int)rZ;

//        int R = (int)(Math.random()*256);
//        int G = (int)(Math.random()*256);
//       int B= (int)(Math.random()*256);
//        paint.setColor(Color.rgb(R,G,B));
        paint.setColor(getFill());
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x,y,z,paint);

        paint.setColor(getStroke());
        paint.setStrokeWidth(10f);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x,y,z,paint);
    }
}
