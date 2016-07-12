package com.example.cptns.project4;

import android.content.Context;

public class ShapeFactory extends AbstractShapeFactory {
    private int fColor, sColor;

    public ShapeFactory(Context context, int sColor, int fColor){
        this.sColor = sColor;
        this.fColor = fColor;
    }

    public Shape getCircle(Context context){
        return new Circle(context, sColor, fColor);
    }
    public Shape getRectangle(Context context){
        return new Rectangle(context, sColor, fColor);
    }

/*    public Shape getShape(Context context, String shape){
        if(shape.equals("Rectangle")){
            return new Rectangle(context);
        }
        else if (shape.equals("Circle")){
            return new Circle(context);
        }
        else{
            return null;
        }
    }*/
}
