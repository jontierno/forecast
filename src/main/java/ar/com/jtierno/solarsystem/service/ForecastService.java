package ar.com.jtierno.solarsystem.service;

import ar.com.jtierno.solarsystem.model.Period;
import ar.com.jtierno.solarsystem.model.SolarSystem;
import com.google.common.base.Stopwatch;
import com.googlecode.objectify.Key;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.googlecode.objectify.ObjectifyService.ofy;
/**
 * Created by jonathan on 19/04/17.
 */
public class ForecastService {

    private static final Long MAX_DAY = 10 * 365L;
    private static final Logger LOGGER = Logger.getLogger(ForecastService.class.toString());
    public Period getPeriod (Long day){
        //two inequities unsupported
        final Period now = ofy().load().type(Period.class).filter("from <=", day).order("-from").first().now();
        return now;
    }

    public void createForecasts(){
        LOGGER.info("Starting forecasts creation");
        Stopwatch sw = Stopwatch.createStarted();
        final SolarSystem solarSystem = new SolarSystem();
        Long i = 0L;
        while(i <= MAX_DAY) {
            final Period nextPeriod = solarSystem.getNextPeriod(i);
            ofy().save().entity(nextPeriod).now();
            i = nextPeriod.getTo() +1;
        }
        LOGGER.info(String.format("Forecasts creation finished: %d elapsed", sw.elapsed(TimeUnit.SECONDS)));
    }
}
