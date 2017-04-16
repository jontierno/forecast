package ar.com.jtierno.solarsystem.model;

/**
 * Created by jonathan on 16/04/17.
 */
public class Forecast {

    private ForecastState state;
    public Forecast(Vector p1, Vector p2, Vector p3) {
        final ForecastState forecastState = checkDroughtOrOptimal(p1, p2, p3);
        if(forecastState == null){
            final Boolean inside = isInside(new Vector(0.0, 0.0), p1, p2, p3);
            state =  inside ? ForecastState.RAINY : ForecastState.NORMAL;
        } else {
            this.state = forecastState;
        }
    }

    private ForecastState checkDroughtOrOptimal(Vector p1, Vector p2, Vector p3) {
        double slope1 = calculateSlope(p1, p2);
        double slope2 = calculateSlope(p3, p1);

        if(slope1 == slope2){
            double slopeOrigin = calculateSlope(p2, new Vector(0.0,0.0));
            if(slopeOrigin == slope1){
                return ForecastState.DROUGHT;
            }
            return ForecastState.OPTIMAL;
        }
       return null;
    }

    private Double calculateSlope(Vector puntoA, Vector puntoB){
        double dx = puntoB.getX() - puntoA.getX();
        double dy = puntoB.getY() - puntoA.getY();
        return (dx != 0) ? (dy / dx) : Double.POSITIVE_INFINITY;
    }

    public ForecastState getState() {
        return state;
    }
    private double sign (Vector p1, Vector p2, Vector p3)
    {
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }

    private Boolean isInside(Vector p, Vector v1, Vector v2, Vector v3)
    {
        Boolean b1, b2, b3;
        b1 = sign(p, v1, v2) < 0.0f;
        b2 = sign(p, v2, v3) < 0.0f;
        b3 = sign(p, v3, v1) < 0.0f;

        return ((b1 == b2) && (b2 == b3));
    }
}
