package Test;

import Model.GameState;
import Model.PokePongModel;
import Model.XYTupel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PokePongTest {
    private PokePongModel model;

    @BeforeEach
    void setup(){
        model=new PokePongModel(900,600);

    }


    @AfterEach
    void tearDown(){

    }

    @Test
    void startNewGame_ShouldInitialisePlayerAndBAll(){
        model.initialisePlayer();
        model.startNewGame();
        assertNotNull(model.data.getPlayer1());
        assertNotNull(model.data.getPlayer2());
        assertNotNull(model.data.getBall());
        assertNotEquals(0,model.data.getBall().getAcceleration());
    }


    @Test

    void handleCollision_ShouldHandleCollision(){
        model.initialisePlayer();
        model.startNewGame();
        model.getData().getBall().setPosition(new XYTupel(123,0));
        float ballAccelerationy=model.data.getBall().getAcceleration().getY();
        model.handleCollisions();
        assertEquals(ballAccelerationy*-1,model.data.getBall().getAcceleration().getY());

        model.getData().getBall().setPosition(new XYTupel(120,model.height));
        ballAccelerationy=model.getData().getBall().getAcceleration().getY();
        model.handleCollisions();
        assertEquals(ballAccelerationy*-1,model.getData().getBall().getAcceleration().getY());

        model.getData().getBall().setPosition(model.getData().getPlayer1().getPosition());
        float ballAccelerationx =model.getData().getBall().getAcceleration().getX();
        model.handleCollisions();
        assertEquals(ballAccelerationx*-1,model.getData().getBall().getAcceleration().getX());

        model.getData().getBall().setPosition(model.getData().getPlayer1().getPosition());
        ballAccelerationx=model.getData().getBall().getAcceleration().getX();
        model.handleCollisions();
        assertEquals(ballAccelerationx*-1,model.getData().getBall().getAcceleration().getX());


        model.getData().getBall().setPosition(new XYTupel(0,100));
        model.handleCollisions();
        assertEquals(GameState.GAME_OVER,model.getData().getState());


        model.getData().getBall().setPosition(new XYTupel(model.height,100));
        model.handleCollisions();
        assertEquals(GameState.GAME_OVER,model.getData().getState());

    }






}
