package com.example.cptns.project4;

import android.content.Context;
import android.graphics.Color;

public class AbstractShapeFactory {
    private Context context;


    public Context getContext() {
        return context;
    }

    public ShapeFactory getShapeFactory(int style){
        if(style==1){
            return new ShapeFactory(getContext(), Color.BLACK, Color.YELLOW);
        }else if (style==2){
            return new ShapeFactory(getContext(),Color.BLACK, Color.GREEN);
        }else if (style==3){
            return new ShapeFactory(getContext(),Color.BLUE, Color.WHITE);
        }else {
            return null;
        }
    }
}
