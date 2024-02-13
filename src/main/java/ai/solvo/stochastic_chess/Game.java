package ai.solvo.stochastic_chess;

import ch.astorm.jchess.JChessGame;
import ch.astorm.jchess.core.Move;
import ch.astorm.jchess.core.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private final JChessGame game;
    private final Random random;

    public Game(JChessGame jChessGame){
        this.game = jChessGame;

        this.random = new Random();
    }

    public List<Status> move(String algebraicNotation){
        List<Status> statuses = new ArrayList<>();

        JChessGame.Status first_game_status = this.game.play(algebraicNotation);
        Status first_status = new Status(first_game_status, this.game.getPosition());
        statuses.add(first_status);

        if (first_game_status.isFinished()) {
            return statuses;
        }

        this.game.switchColorOnMove();
        List<Move> moves = this.game.getAvailableMoves();
        Move randomMove = moves.get(this.random.nextInt(moves.size()));

        JChessGame.Status second_game_status = this.game.play(randomMove);
        Status second_status = new Status(second_game_status, this.game.getPosition());
        statuses.add(second_status);

        return statuses;
    }

}
