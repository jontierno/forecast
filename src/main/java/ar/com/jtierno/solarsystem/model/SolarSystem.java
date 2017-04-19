package ar.com.jtierno.solarsystem.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jonathan on 16/04/17.
 */
public class SolarSystem {

    private final Planet vulcanos;
    private final Planet ferengeis;
    private final Planet betasoides;

    public SolarSystem() {
        vulcanos = new Planet(Math.toRadians(1), 500.0);
        ferengeis = new Planet(Math.toRadians(3), 2000.0);
        betasoides = new Planet(-1 * Math.toRadians(5), 1000.0);
    }


    public Period getNextPeriod(Long from) {
        Boolean keep = true;
        List<Vector> positions = computePositions(from);
        ForecastState initialForecast = calculateForecast(positions);
        PeakFinder peak = new PeakFinder(positions, from);
        Long actualDay = from;
        while (keep) {
            actualDay++;
            positions = computePositions(actualDay);
            ForecastState forecast = calculateForecast(positions);
            keep = forecast.equals(initialForecast);
            if(keep){
                peak.nextPositions(positions, actualDay);
            }
        }
        return new Period(from, actualDay - 1, initialForecast, initialForecast.equals(ForecastState.RAINY) ? peak.getMaxDay() : null);
    }

    private ForecastState calculateForecast(List<Vector> positions) {
        //order doesn't matter
        return new Forecast(positions.get(0), positions.get(1), positions.get(2)).getState();
    }

    private List<Vector> computePositions(Long day) {
        Vector p1 = vulcanos.predictPosition(day);
        Vector p2 = ferengeis.predictPosition(day);
        Vector p3 = betasoides.predictPosition(day);
        return Arrays.asList(p1, p2, p3);
    }

}
