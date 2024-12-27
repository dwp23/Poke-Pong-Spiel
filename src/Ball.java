//Diese Klasse ist Teil von Model
public class Ball {
    //Eigenschaften eines Balls im Spiel
    private float size;
    private int speedFactor = 150;
    private float angle = 0;

    XYTupel position;// Positionen des Balls und Winkel
    XYTupel acceleration;

// Initialisierung von Anfangsposition und Anfangsbeschleunigung
    public Ball(double x, double y, float size) {
        this.position = new XYTupel((float)x, (float)y);
        this.acceleration = new XYTupel(0, 0);
        this.size = size;
    }

    // Aktualisieren der Position des Balls je nach Beschleunigung
    public void updateBallPosition(double timeFactor) {
        position.x += (float) (acceleration.x * speedFactor * timeFactor);
        position.y += (float) (acceleration.y * speedFactor * timeFactor);
        angle += 2;
    }

    //zufällige Änderung der Beschleunigung des Balls
    public void randomizeAcceleration() {
        acceleration.x = (Math.random() >= 0.5) ? 1 : -1;
        acceleration.y = (float) (2 * Math.random() - 1);
    }

    //überprüft, ob der Ball mit einer horizontalen Wand kollidiert
    public boolean collidesY(float wall) {
        return (wall >= position.y - size / 2.0) && (wall <= position.y + size / 2.0);
    }

    //überprüft, ob der Ball mit einer vertikalen Wand

    public boolean collidesX(float wall) {
        return (wall >= position.x - size / 2.0) && (wall <= position.x + size / 2.0);
    }

    public float getSize() {
        return size;
    }

    public float getRotationAngle() {
        return (float)Math.toRadians(angle);
    }
}
