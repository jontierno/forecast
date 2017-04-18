package ar.com.jtierno.solarsystem.model;

import java.util.List;

/**
 * Created by jonathan on 18/04/17.
 */
public class PeakFinder {

    private Long maxDay;
    private Double maxArea;

    //Non self-intersecting
    public PeakFinder(List<Vector> positions, Long day) {
        maxDay = day;
        maxArea = calculateArea(positions);
        maxDay = day;
    }

    //http://www.mathopenref.com/coordpolygonarea.html
    private Double calculateArea(List<Vector> positions){
        double total = 0;
        for (int i = 0; i < positions.size(); i++) {
            final Vector actual = positions.get(i);
            final Vector next = positions.get((i+1) % positions.size());
            total += actual.getX()* next.getY() - actual.getY()*next.getX();
        }
        return Math.abs(total / 2);
    }

    public Long getMaxDay() {
        return maxDay;
    }

    public Double getMaxArea() {
        return maxArea;
    }

    public void nextPositions(List<Vector> positions, Long day){
        final Double area = calculateArea(positions);
        if(area >maxArea){
            maxArea = area;
            maxDay = day;
        }




    }
}


