/**
 * The package model represents the internal logic and data structures of our game.
 *  * It includes classes that manage the player's state,
 *  * ,which deal with the movements and collisions of the game objects, and
 *  * Provide information about the state of the game.
 */

package Model;

public class PokePongModel {
    /**
     * Hier sind die schon initialisierten Variablen.
     * Die Größe der Ball(BALL_SIZE) und des  Spieler(PLAYER_SIZE),Die Breite des Sclägers(PADDLE_WIDTH) ändern sich nicht während des Spiels,deswegen sind sie als final initialisiert mit gewünschter Größe
     * Diese oben genannten Variablen sind ohne Zugriffsmodifizierer initialisiert,da sie von allen Klassen im Package Model benutzbar sein sollen.
     */

    final int PADDLE_WIDTH = 5;
    final int BALL_SIZE = 25;
    final int PLAYER_SIZE = 50;
    /**
     * Breite(width) und Höhe(height) des Spielsfelds
     * Sie sind als public für eine mögliche Benutzung von anderen Klassen des Packages Model
     *
     */
    public int width, height;
    /**
     * Ein Objekt vom Typ PongData, das Spielzustandsinformationen enthält.
     */
    public PongData data;
    /**
     * Hier sind die Variablen für die beiden Spieler,also Objekte vom Typ Spieler
     * p1 steht für den ersten Spieler
     * p2 steht für den zweiten SPieler
     */
    public Player p1;
    public Player p2;

    public PokePongModel(int width, int height){
        this.width = width;
        this.height = height;
        data = new PongData();
        data.state =  GameState.START;




    }

    /**
     * Die Methode
     */

    public void initialisePlayer(){
        p1 = data.player1;
        p2 = data.player2;

    }

    public void startNewGame() {


        data.player1 = new Player(PLAYER_SIZE+PADDLE_WIDTH, (width-PLAYER_SIZE)/2.0 - PADDLE_WIDTH, PLAYER_SIZE);
        data.player2 = new Player(width-PLAYER_SIZE-PADDLE_WIDTH, (height-PLAYER_SIZE)/2.0 + PADDLE_WIDTH, PLAYER_SIZE);
        data.ball = new Ball(width/2.0, height/2.0, BALL_SIZE);
        data.ball.randomizeAcceleration();
    }


    public PongData getData(){
        return data;
    }

    public void handleCollisions() {
        // Reflect on y-axis on top and bottom wall
        if(data.ball.collidesY(0) || data.ball.collidesY(height)) {
            data.ball.acceleration.y *= -1;
        }

        // Reflect on x-axis when paddle hits the ball
        if (data.player1.hits(data.ball) || data.player2.hits(data.ball)) {
            data.ball.acceleration.x *= -1;
        }

        // Game over on hitting left or right wall
        if (data.ball.collidesX(0) || data.ball.collidesX(width)){
            data.state = GameState.GAME_OVER;
        }
    }

    public int getPADDLE_WIDTH(){
        return PADDLE_WIDTH;
    }


    public GameState getState(){
        return data.state;
    }

    public Player getPlayer1(){
        return p1;
    }

    public Player getPlayer2(){
        return  p2;
    }

    public void setPlayer1(Player p1){
        this.p1 = p1;
    }

    public void setPlayer2(Player p2){
        this.p2 = p2;
    }

    public PongData getPongDate(){
        return data;
    }

    public String toString(){
        System.out.println();
        return "Player1: (" + p1.getPosition().x + "," + p1.getPosition().y + ")" + "\nPlayer2: (" + p2.getPosition().x +"," + p2.getPosition().y +")" + "\nBall: (" + data.ball.position.x +"," + data.ball.position.y + ")"  ;

    }







}
