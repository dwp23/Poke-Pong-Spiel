package Model;

public class PongData {

     GameState state;
    Player player1;
    Player player2;
    Ball ball;


    public GameState getState(){
        return state;
    }
    public void setState(GameState state){
        this.state  = state;
    }

    public Ball getBall(){
        return ball;
    }
    public Player getPlayer1 (){
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }
}
