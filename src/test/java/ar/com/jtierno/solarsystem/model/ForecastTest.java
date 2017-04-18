package ar.com.jtierno.solarsystem.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jonathan on 16/04/17.
 */
public class ForecastTest {


    @Test
    public void droughtDayOrigin() {
        Vector p1 = new Vector(10.0, 0.0);
        Vector p2 = new Vector(20.0, 0.0);
        Vector p3 = new Vector(30.0, 0.0);
        final Forecast forecast = new Forecast(p1, p2, p3);
        Assert.assertEquals(ForecastState.DROUGHT, forecast.getState());
    }

    @Test
    public void droughtNotPerfect() {
        Vector p1 = new Vector(10.0, 1.0);
        Vector p2 = new Vector(20.0, 1.0);
        Vector p3 = new Vector(30.0, 0.0);
        final Forecast forecast = new Forecast(p1, p2, p3);
        Assert.assertEquals(ForecastState.DROUGHT, forecast.getState());
    }


    @Test
    public void droughtGreatDeviation() {
        Vector p1 = new Vector(10.0, 1.0);
        Vector p2 = new Vector(20.0, 3.0);
        Vector p3 = new Vector(30.0, 0.0);
        final Forecast forecast = new Forecast(p1, p2, p3);
        Assert.assertNotEquals(ForecastState.DROUGHT, forecast.getState());
    }

    @Test
    public void optimalDayOrigin() {
        Vector p1 = new Vector(10.0, 5.0);
        Vector p2 = new Vector(20.0, 5.0);
        Vector p3 = new Vector(30.0, 5.0);
        final Forecast forecast = new Forecast(p1, p2, p3);
        Assert.assertEquals(ForecastState.OPTIMAL, forecast.getState());
    }

    @Test
    public void optimalDayNotPerfect() {
        Vector p1 = new Vector(10.0, 5.0);
        Vector p2 = new Vector(20.0, 4.0);
        Vector p3 = new Vector(30.0, 5.0);
        final Forecast forecast = new Forecast(p1, p2, p3);
        Assert.assertEquals(ForecastState.OPTIMAL, forecast.getState());
    }

    @Test
    public void optimalDayGreatDeviation() {
        Vector p1 = new Vector(10.0, 5.0);
        Vector p2 = new Vector(20.0, 5.0);
        Vector p3 = new Vector(30.0, 2.0);
        final Forecast forecast = new Forecast(p1, p2, p3);
        Assert.assertNotEquals(ForecastState.OPTIMAL, forecast.getState());
    }
    @Test
    public void rainyForecast() {
        Vector p1 = new Vector(-10.0, -10.0);
        Vector p2 = new Vector(10.0, -11.0);
        Vector p3 = new Vector(0.0, 20.0);
        final Forecast forecast = new Forecast(p1, p2, p3);
        Assert.assertEquals(ForecastState.RAINY, forecast.getState());
    }

    @Test
    public void rainyTwoInSameQuadrant() {
        Vector p1 = new Vector(-10.0, 1.0);
        Vector p2 = new Vector(-10.0, 5.0);
        Vector p3 = new Vector(30.0, -5.0);
        final Forecast forecast = new Forecast(p1, p2, p3);
        Assert.assertEquals(ForecastState.RAINY, forecast.getState());
    }


    @Test
    public void normalForecast() {
        Vector p1 = new Vector(-5.0, 5.0);
        Vector p2 = new Vector(1.0, -5.0);
        Vector p3 = new Vector(-10.0, -1.0);
        final Forecast forecast = new Forecast(p1, p2, p3);
        Assert.assertEquals(ForecastState.NORMAL, forecast.getState());
    }

}
