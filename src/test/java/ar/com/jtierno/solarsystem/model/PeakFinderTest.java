package ar.com.jtierno.solarsystem.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by jonathan on 18/04/17.
 */
public class PeakFinderTest {

    public static final Long SECOND_DAY = Long.valueOf(2L);
    public static final long FIRST_DAY = 1L;
    public static final long THIRD_DAY = 3L;
    public static final Long FOURTH_DAY = Long.valueOf(4L);

    @Test
    public void findPeak(){
        //first area. b*h/2 = 2*1/2= 1;
        Vector v1 = new Vector(0.0,1.0);
        Vector v2 = new Vector(1.0,0.0);
        Vector v3 = new Vector(-1.0,0.0);
        final PeakFinder finder = new PeakFinder(Arrays.asList(v1, v2, v3), FIRST_DAY);

        //second area. b*h/2 = 2*2/2= 2;
        v1 = new Vector(0.0,2.0);
        v2 = new Vector(1.0,0.0);
        v3 = new Vector(-1.0,0.0);
        finder.nextPositions(Arrays.asList(v1,v2,v3), SECOND_DAY);

        //second area. b*h/2 = 2*0.5/2= 0.5;
        v1 = new Vector(0.0,0.5);
        v2 = new Vector(1.0,0.0);
        v3 = new Vector(-1.0,0.0);
        finder.nextPositions(Arrays.asList(v1,v2,v3), THIRD_DAY);

        Assert.assertEquals(SECOND_DAY,finder.getMaxDay());
        Assert.assertEquals(Double.valueOf(2),finder.getMaxArea());
    }

    @Test
    public void findPeakWithMinimum(){
        //first area. b*h/2 = 2*1/2= 1;
        Vector v1 = new Vector(0.0,1.0);
        Vector v2 = new Vector(1.0,0.0);
        Vector v3 = new Vector(-1.0,0.0);
        final PeakFinder finder = new PeakFinder(Arrays.asList(v1, v2, v3), FIRST_DAY);

        //second area. b*h/2 = 2*2/2= 2;
        v1 = new Vector(0.0,2.0);
        v2 = new Vector(1.0,0.0);
        v3 = new Vector(-1.0,0.0);
        finder.nextPositions(Arrays.asList(v1,v2,v3), SECOND_DAY);

        //second area. b*h/2 = 2*0.5/2= 0.5;
        v1 = new Vector(0.0,0.5);
        v2 = new Vector(1.0,0.0);
        v3 = new Vector(-1.0,0.0);
        finder.nextPositions(Arrays.asList(v1,v2,v3), THIRD_DAY);

        //second area. b*h/2 = 2*4/2= 4;
        v1 = new Vector(0.0,4.0);
        v2 = new Vector(1.0,0.0);
        v3 = new Vector(-1.0,0.0);
        finder.nextPositions(Arrays.asList(v1,v2,v3), FOURTH_DAY);

        Assert.assertEquals(FOURTH_DAY,finder.getMaxDay());
        Assert.assertEquals(Double.valueOf(4),finder.getMaxArea());
    }
}
