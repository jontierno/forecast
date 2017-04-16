package ar.com.jtierno.solarsystem.model;

/**
 * Created by jonathan on 16/04/17.
 */
public class Vector {

    private Double x;
    private Double y;

    public Vector(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Vector subtract(Vector p2){
        return new Vector(x - p2.x, y -p2.y);
    }

    public Double cross(Vector p2){
        return x * p2.y - p2.x * y;
    }

    public Vector normalize(){
        Double norm = this.norm();
        return new Vector(x/norm, y/norm);
    }

    public Double norm(){
        return Math.sqrt(sqrNorm());
    }

    public Double sqrNorm(){
        return x*x  + y*y;
    }
}
