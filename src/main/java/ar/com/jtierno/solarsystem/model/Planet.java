package ar.com.jtierno.solarsystem.model;

/**
 * Created by jonathan on 16/04/17.
 */
public class Planet {

    private Double angularSpeed;
    private Double sunDistance;


    /**
     * @param angularSpeed angular speed in radians/day
     * @param sunDistance distance to sun in kilometers
     */
    public Planet(Double angularSpeed, Double sunDistance) {
        this.angularSpeed = angularSpeed;
        this.sunDistance = sunDistance;
    }

    public Double getAngularSpeed() {
        return angularSpeed;
    }

    public Double getSunDistance() {
        return sunDistance;
    }

    public Vector predictPosition(Integer day){
        Double angularPosition = day * angularSpeed;
        Double xPos = Math.cos(angularPosition) * sunDistance;
        Double yPos = Math.sin(angularPosition) * sunDistance;

        return new Vector(xPos, yPos);
    }
}
