package ir.ac.kntu.Model.Game;

public interface GameSupplies {
    void Update();
    boolean isFinished();
    boolean nextWave();
    String whoWin();
}
