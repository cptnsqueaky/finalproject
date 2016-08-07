package com.example.cptns.project4;

import static org.mockito.Mockito.*;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Vector;

@RunWith(MockitoJUnitRunner.class)
public class UnitTest{
    @Mock View v;
    @Mock Shape shape;
    @Mock ShapeFactory shapeFactory;
    @Mock AbstractShapeFactory abstractShapeFactory;
    @InjectMocks private MainActivity mainActivity;

    Context context = mock(Context.class);
    AbstractShapeFactory testASF = new AbstractShapeFactory();
    ShapeFactory testShapeFactory = testASF.getShapeFactory(1);
    Shape testCircle = testShapeFactory.getCircle(context);
    Shape testRect = testShapeFactory.getRectangle(context);

    @Test
    public void testGetCircleShapeType() throws Exception {
        Assert.assertTrue(testCircle.getShapeType().equals("Circle"));
    }
    @Test
    public void testGetRectangleShapeType() throws Exception {
        Assert.assertTrue(testRect.getShapeType().equals("Rectangle"));
    }

    @Test
    public void testClear() throws Exception{
        mainActivity.vector.addElement(testCircle);
        mainActivity.vector.addElement(testRect);
        mainActivity.clear();
        Assert.assertEquals(true, mainActivity.vector.isEmpty());
    }

    @Test
    public void testUpdateRectShapeCount() throws Exception{
        mainActivity.vector.addElement(testRect);
        mainActivity.vector.addElement(testRect);
        mainActivity.updateShapeCount();
        Assert.assertEquals(2, mainActivity.nRect);
    }
    @Test
    public void testUpdateCircShapeCount() throws Exception{
        mainActivity.vector.addElement(testCircle);
        mainActivity.vector.addElement(testCircle);
        mainActivity.updateShapeCount();
        Assert.assertEquals(2, mainActivity.nCirc);
    }
}