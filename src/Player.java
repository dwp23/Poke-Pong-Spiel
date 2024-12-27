/* Kollisionen zwischen Schläger und Ball erkennen
 Größe und Position des Schlägers verwalten */


public class Player {
    // Größe und Position des Schlägers
    private float size;

    XYTupel position;

    Player(double x, double y, float size) {
        this.position = new XYTupel((float)x, (float)y);
        this.size = size;
    }


// überprüft, ob der Ball mit dem Schläger kollidiert.
    public boolean hits(Ball ball) {
        // Note: This only works in 90% of all cases. Unfortunately it does not work in edge cases (literally).
        //       Sometimes this can cause funny behaviors, because it uses a rectangular bounding box for the ball.
        return ball.collidesX(position.x) &&
                position.y - size/2.0 <= ball.position.y + ball.getSize()/2.0 &&
                position.y + size/2.0 >= ball.position.y - ball.getSize()/2.0;
    }

    public float getSize() {
        return size;
    }
}
