package com.example.cptns.project4;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public abstract class Shape extends View{
    private int stroke, fill;

//    public Shape(Context context){
//        super(context);
//    }

    public Shape(Context context, int sColor, int fColor){
        super(context);
        this.stroke = sColor;
        this.fill = fColor;
    }

    void setShapeAlpha(float alpha){
        this.setAlpha(alpha);
    }

    float getShapeAlpha(){
        return this.getAlpha();
    }
    void removeShape(){
        this.setVisibility(GONE);
    }

    abstract String getShapeType();

    @Override
    public abstract void onDraw(Canvas canvas);

    public int getFill(){
        return fill;
    }
    public int getStroke(){
        return stroke;
    }
}
