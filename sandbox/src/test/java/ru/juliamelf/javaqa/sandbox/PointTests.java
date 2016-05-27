package ru.juliamelf.javaqa.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by korotkova on 5/27/2016.
 */
public class PointTests {

    @Test
    public void testDistanceP1() {
        Point p1 = new Point(5,10);
        Point p2 = new Point(10,20);
        Assert.assertEquals(p1.distance(p2), 2.3234340183590687);
    }

    @Test
    public void testDistanceP2() {
        Point p1 = new Point(10,20);
        Point p2 = new Point(5,10);
        Assert.assertEquals(p2.distance(p1), 2.3234340183590687);
    }

    @Test
    public void testDistanceP3() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(5,5);
        Assert.assertEquals(p1.distance(p2), 2.114742526881128);
    }


}
