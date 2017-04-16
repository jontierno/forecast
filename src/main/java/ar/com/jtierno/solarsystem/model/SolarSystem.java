package ar.com.jtierno.solarsystem.model;

/**
 * Created by jonathan on 16/04/17.
 */
public class SolarSystem {

    private Planet vulcanos;
    private Planet ferengeis;
    private Planet betasoides;

    public SolarSystem() {
        vulcanos = new Planet(Math.toRadians(1), 500.0);
        ferengeis = new Planet(Math.toRadians(3), 2000.0);
        betasoides = new Planet(-1*Math.toRadians(5),1000.0);
    }


}
