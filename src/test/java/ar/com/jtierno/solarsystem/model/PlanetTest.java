package ar.com.jtierno.solarsystem.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jonathan on 16/04/17.
 */
public class PlanetTest {


    public static final double DELTA = 0.00001;
    public static final Double SUN_DISTANCE = Double.valueOf(100.0);
    public static final Double MID_DISTANCE = Double.valueOf(100.0 * Math.sqrt(2) / 2.0);

    @Test
    public void testPositionPrediction() {
        //a planet with a 45° speed per day.
        final Planet planet = new Planet(Math.PI / 4, 100.0);
        Vector position = planet.predictPosition(0);
        Assert.assertEquals("Starting position Y", SUN_DISTANCE, position.getX());
        Assert.assertEquals("Starting position Y", Double.valueOf(0.0), position.getY());

        position = planet.predictPosition(1);
        Assert.assertEquals("45 degree position X", MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("45 degree position Y", MID_DISTANCE, position.getY(), DELTA);

        position = planet.predictPosition(2);
        Assert.assertEquals("90 degree position X", Double.valueOf(0), position.getX(), DELTA);
        Assert.assertEquals("90 degree position Y", SUN_DISTANCE, position.getY(), DELTA);


        position = planet.predictPosition(3);
        Assert.assertEquals("135 degree position X", -1 * MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("135 degree position Y", MID_DISTANCE, position.getY(), DELTA);

        position = planet.predictPosition(4);
        Assert.assertEquals("180 degree position X", -1 * SUN_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("180 degree position Y", 0.0, position.getY(), DELTA);

        position = planet.predictPosition(5);
        Assert.assertEquals("225 degree position X", -1 * MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("225 degree position Y", -1 * MID_DISTANCE, position.getY(), DELTA);

        position = planet.predictPosition(6);
        Assert.assertEquals("270 degree position X", 0.0, position.getX(), DELTA);
        Assert.assertEquals("270 degree position Y", -1 * SUN_DISTANCE, position.getY(), DELTA);
        position = planet.predictPosition(7);
        Assert.assertEquals("315 degree position X", MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("315 degree position Y", -1 * MID_DISTANCE, position.getY(), DELTA);
        position = planet.predictPosition(8);
        Assert.assertEquals("360 degree position X", SUN_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("360 degree position Y", Double.valueOf(0.0), position.getY(), DELTA);
        position = planet.predictPosition(9);
        Assert.assertEquals("405 degree position X", MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("405 degree position Y", MID_DISTANCE, position.getY(), DELTA);
    }


    @Test
    public void testPositionPredictionReverse() {
        //a planet with a 45° speed per day.
        final Planet planet = new Planet(-1 * Math.PI / 4, 100.0);
        Vector position = planet.predictPosition(0);
        Assert.assertEquals("Starting position Y", SUN_DISTANCE, position.getX());
        Assert.assertEquals("Starting position Y", Double.valueOf(-0.0), position.getY());

        position = planet.predictPosition(1);
        Assert.assertEquals("-45 degree position X", MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("-45 degree position Y", -1 * MID_DISTANCE, position.getY(), DELTA);

        position = planet.predictPosition(2);
        Assert.assertEquals("-90 degree position X", Double.valueOf(0), position.getX(), DELTA);
        Assert.assertEquals("-90 degree position Y", -1 * SUN_DISTANCE, position.getY(), DELTA);


        position = planet.predictPosition(3);
        Assert.assertEquals("-135 degree position X", -1 * MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("-135 degree position Y", -1 * MID_DISTANCE, position.getY(), DELTA);

        position = planet.predictPosition(4);
        Assert.assertEquals("-180 degree position X", -1 * SUN_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("-180 degree position Y", 0.0, position.getY(), DELTA);

        position = planet.predictPosition(5);
        Assert.assertEquals("-225 degree position X", -1 * MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("-225 degree position Y", MID_DISTANCE, position.getY(), DELTA);

        position = planet.predictPosition(6);
        Assert.assertEquals("-270 degree position X", 0.0, position.getX(), DELTA);
        Assert.assertEquals("-270 degree position Y", SUN_DISTANCE, position.getY(), DELTA);
        position = planet.predictPosition(7);
        Assert.assertEquals("-315 degree position X", MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("-315 degree position Y", MID_DISTANCE, position.getY(), DELTA);
        position = planet.predictPosition(8);
        Assert.assertEquals("-360 degree position X", SUN_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("-360 degree position Y", Double.valueOf(0.0), position.getY(), DELTA);

        position = planet.predictPosition(9);
        Assert.assertEquals("-405 degree position X", MID_DISTANCE, position.getX(), DELTA);
        Assert.assertEquals("-405 degree position Y", -1 * MID_DISTANCE, position.getY(), DELTA);

    }
}
