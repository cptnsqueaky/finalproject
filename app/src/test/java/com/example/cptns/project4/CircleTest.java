package com.example.cptns.project4;

import android.content.Context;
import android.graphics.Color;
import android.test.mock.MockContext;
import android.view.View;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cptns on 06-Aug-16.
 */
public class CircleTest{
    
    Shape testCircle=new Circle();


    @Test
    public void testGetShapeType() throws Exception {
        Assert.assertTrue(testCircle.getShapeType().equals("Circle"));
    }

    @Test
    public void testGetShapeAlpha() throws Exception {

    }

    @Test
    public void testGetFill() throws Exception {

    }

    @Test
    public void testGetStroke() throws Exception {

    }
}