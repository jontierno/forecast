package ar.com.jtierno.solarsystem.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by jonathan on 18/04/17.
 */
public class SolarSystemTest {

    @Test
    //It isn't a test, its just showing how its works.
    public void startingPeriods() {
        final SolarSystem solarSystem = new SolarSystem();

        Long maxDay = 10L*365;
        Map<ForecastState, Long> counts = new HashMap<>();
        Long counter;
        Long i = 0L;
        List<Long> rainyPeaks = new LinkedList<>();
        while(i <= maxDay) {
            final Period nextPeriod = solarSystem.getNextPeriod(i);
            counter = counts.get(nextPeriod.getState());
            if(counter == null){
                counter = 1L;
            } else{
                counter++;
            }
            counts.put(nextPeriod.getState(),counter);
            i = nextPeriod.getTo() +1;
            if(nextPeriod.getState().equals(ForecastState.RAINY)){
                rainyPeaks.add(nextPeriod.getPeakAt());
            }
        }

        System.out.println("Periods found");
        for (Map.Entry<ForecastState, Long> entry : counts.entrySet()) {
            System.out.println(entry.toString() + ": " + (entry.getValue() == null ? 0: entry.getValue()) );
        }

        System.out.println("Rainy peaks at: ");
        StringBuilder builder = new StringBuilder();
        for (Long rainyPeak : rainyPeaks) {
            builder.append(rainyPeak);
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.deleteCharAt(builder.length()-1);
        System.out.println(builder.toString());
    }
}

