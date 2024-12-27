package View;

import Controller.IPokePongController;
import processing.core.PApplet;
import processing.core.PImage;



public class PokePongView extends PApplet implements IPokePongView {

    private IPokePongController controller;

    private PImage startScreen;
    private PImage gameOverScreen;
    private PImage player1Image;
    private PImage player2Image;
    private PImage ballImage;

    public PokePongView(int width, int height){
        setSize(width, height);

    }

    public void setPokePongController(IPokePongController controller){
        this.controller = controller;
    }


    public  void setup(){

    }


    public void draw(){
        controller.handleDisplay();

    }

    public void drawStartScreen(){
        startScreen = loadImage("StartScreen.jpg");
        imageMode(CORNER);
        image(startScreen, 0, 0, width, height);

    }

    public  void drawGameOverScreen(){

        gameOverScreen = loadImage("GameOverScreen.jpg");
        imageMode(CORNER);
        image(gameOverScreen,0,0,width,height);


    }

    public void drawPlayer1(float xPos, float yPos, float breite, float laenge){
        player1Image = loadImage("025.png");
        background(255);
        imageMode(CENTER);
        image(player1Image,xPos,yPos,breite,laenge);


    }

    public void drawPaddle1(float x, float y,float breite, float laenge){
        fill(0);
        rect(x,y,breite,laenge);
    }

    public void drawPlayer2(float xPos, float yPos, float breite, float laenge){
        player2Image = loadImage("133.png");
        image(player2Image,xPos,yPos,breite,laenge);

    }

    public void drawPaddle2(float x, float y, float breite, float laenge){
        fill(0);
        rect(x,y,breite,laenge);
    }

    public void drawBallImage(float x, float y , float angle,float size){
        ballImage = loadImage("100.png");
        translate(x,y);
        rotate(angle);
        image(ballImage, 0 ,0,size,size);

    }

    public  void keyPressed(){
        controller.handleUserInput(key, keyCode);

    }





    public float getFramerate(){
        return  frameRate;
    }

    }



