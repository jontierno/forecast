package ar.com.jtierno.solarsystem.model;

/**
 * Created by jonathan on 16/04/17.
 */
public class Period {

    private final Long peakAt;
    private Long from;
    private Long to;
    private ForecastState state;

    public Period(Long from, Long to, ForecastState state, Long peakAt ) {
        this.from = from;
        this.to = to;
        this.state = state;
        this.peakAt = peakAt;
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

    public Long getPeakAt() {
        return peakAt;
    }
}
