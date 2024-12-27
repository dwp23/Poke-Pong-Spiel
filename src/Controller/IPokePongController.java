package Controller;

import Model.GameState;
import Model.PokePongModel;
import Model.PongData;

public interface IPokePongController {
    void handleDisplay();
    void handleUserInput(char key1 , int key2);


    PongData getData();

    void getStartGame();
    void movePlayer1Up();
    void movePlayer1Down();

    void movePlayer2Down();

    void movePlayer2UP();

}
