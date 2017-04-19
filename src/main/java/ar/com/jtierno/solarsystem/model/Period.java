package ar.com.jtierno.solarsystem.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by jonathan on 16/04/17.
 */
@Entity
public class Period {


    @Id private Long id;
    @Index private Long from;
    @Index private Long to;
    private ForecastState state;
    @Index private Long peakDay;
    public Period() {
    }

    public Period(Long from, Long to, ForecastState state, Long peakAt ) {
        this.id = from+1;
        this.from = from;
        this.to = to;
        this.state = state;
        this.peakDay = peakAt;
    }

    public Long getFrom() {
        return from;
    }

    public Long getTo() {
        return to;
    }

    public ForecastState getState() {
        return state;
    }

    public Long getPeakDay() {
        return peakDay;
    }
}
