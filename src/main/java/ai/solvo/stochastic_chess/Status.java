package ai.solvo.stochastic_chess;

import ch.astorm.jchess.JChessGame;
import ch.astorm.jchess.core.Position;

public class Status {

    private final JChessGame.Status status;
    private final Position position;


    public Status(JChessGame.Status status, Position position) {
        this.status = status;
        this.position = position;
    }

    public JChessGame.Status getStatus() {
        return this.status;
    }

    public Position getPosition() {
        return this.position;
    }

}
