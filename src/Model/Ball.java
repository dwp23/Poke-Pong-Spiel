package Model;

public class Ball {

    private float size;

    private int speedFactor = 150;

    private float angle = 0;

    XYTupel position;

    XYTupel acceleration;

    public Ball(double x, double y, float size){
        this.position = new XYTupel((float)x,(float)y);
        this.acceleration = new  XYTupel(0,0);
        this.size = size;
    }

    public void updateBallPosition(double timeFactor){
        position.x += (float)(acceleration.x * speedFactor * timeFactor);
        position.y += (float)(acceleration.y * speedFactor * timeFactor);
        angle += 2;
    }

    public void randomizeAcceleration() {
        acceleration.x = (Math.random() >= 0.5) ? 1 : -1;
        acceleration.y = (float) (2 * Math.random() - 1);
    }

    public boolean collidesY(float wall) {
        return (wall >= position.y - size / 2.0) && (wall <= position.y + size / 2.0);
    }

    public boolean collidesX(float wall) {
        return (wall >= position.x - size / 2.0) && (wall <= position.x + size / 2.0);
    }

    public float getSize() {
        return size;
    }

    public float getRotationAngle() {
        return (float)Math.toRadians(angle);
    }

    public  XYTupel getPosition(){
        return  position;
    }

    public XYTupel getAcceleration(){
        return acceleration;

    }

    public void setPosition(XYTupel position){
        this.position=position;
    }

    public void setAcceleration(XYTupel acceleration){
        this.acceleration=acceleration;
    }
}
