package com.example.cptns.project4;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Vector;


public class MainActivity extends AppCompatActivity {
    Vector<Shape> vector=new Vector();
    int nCirc,nRect, sType;
    TextView status;
    String nStyle="Black & Green";
    String cStyle="Black & Yellow";
    int sInt=1;
    AbstractShapeFactory aSF = new AbstractShapeFactory();
    ShapeFactory shapeFactory = aSF.getShapeFactory(1); //initial shape factory

    //switches between the styles
    public ShapeFactory updateShapeFactory(){
        sInt++;
        switch (sInt){
            case 1:
                shapeFactory = aSF.getShapeFactory(1);
                nStyle="Black & Green";
                cStyle="Black & Yellow";
                break;
            case 2:
                shapeFactory = aSF.getShapeFactory(2);
                nStyle="Blue & White";
                cStyle="Black & Green";
                break;
            case 3:
                shapeFactory = aSF.getShapeFactory(3);
                sInt=0;
                nStyle="Black & Yellow";
                cStyle="Blue & White";
                break;
        }
        updateShapeCount();
        return shapeFactory;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //remove action bar
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
            actionBar.hide();

        //id all widgets
        status = (TextView)findViewById(R.id.textView);
        Button rect = (Button)findViewById(R.id.rectangle);
        Button circ = (Button)findViewById(R.id.circle);
        Button clear = (Button)findViewById(R.id.clear);
        Button style = (Button)findViewById(R.id.styleSwitch);
        final RelativeLayout display = (RelativeLayout)findViewById(R.id.display);
        updateShapeCount();

        //buttons
        style.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                updateShapeFactory();
            }
        });
        rect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Shape rectangle = shapeFactory.getRectangle(v.getContext());
                adjustShapeAlpha();
                vector.addElement(rectangle);
                display.addView(rectangle);
                updateShapeCount();
            }
        });

        circ.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Shape circle = shapeFactory.getCircle(v.getContext());
                adjustShapeAlpha();
                vector.addElement(circle);
                display.addView(circle);
                updateShapeCount();
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                clear();
                updateShapeCount();
            }
        });

    }

    //counts number of shape types currently in the vector.
    void updateShapeCount(){
        nRect=0;
        nCirc=0;
        for(int i=0;i<vector.size();i++) {
            if(vector.elementAt(i).getShapeType().equals("Rectangle")){
                nRect++;
            }else if(vector.elementAt(i).getShapeType().equals("Circle")){
                nCirc++;
            }else {}
        }
        String count = "Number of Rectangles: "+nRect+"  Number of Circles: "+nCirc+"\nCurrent Style: "+cStyle+"  Next Style: "+nStyle;
        status.setText(count);
    }

    //fades the shape and removes any element that isn't visible
    void adjustShapeAlpha(){
        for(int i=0;i<vector.size();i++) {
            vector.elementAt(i).setShapeAlpha(vector.elementAt(i).getShapeAlpha() - 0.1f);
            if(vector.elementAt(i).getShapeAlpha()<0f){
                vector.removeElementAt(i);
            }
        }
    }

    //removes all shapes from vector
    void clear(){
        for(int i=0;i<vector.size();i++){
            vector.elementAt(i).removeShape();
        }
        vector.removeAll(vector);
    }
}
