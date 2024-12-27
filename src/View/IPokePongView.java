package View;

import Controller.IPokePongController;

public interface IPokePongView {

    void drawStartScreen();

    void drawGameOverScreen();

    void drawPlayer1(float xPos, float yPos, float breite, float laenge);

    void drawPlayer2(float xPos, float yPos, float breite, float laenge);

    void drawPaddle1(float x, float y,float breite, float laenge);

    void drawPaddle2(float x, float y, float breite, float laenge);
    void drawBallImage(float x, float y , float angle,float size);

    float getFramerate();

}

