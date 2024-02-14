package ai.solvo.stochastic_chess;


import ch.astorm.jchess.JChessGame;
import ch.astorm.jchess.io.MoveParser;
import ch.astorm.jchess.util.UnicodePositionRenderer;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JChessGame jChessGame = JChessGame.newGame();
        Game game = new Game(jChessGame);

        Scanner scanner = new Scanner(System.in);
        boolean inPlay = true;

        do {
            System.out.print("Provide move:");
            String nextLine = scanner.nextLine();
            try {
                List<Status> statuses = game.move(nextLine);
                for (Status status : statuses) {
                    UnicodePositionRenderer.render(System.out, status.getPosition());
                    inPlay = status.getStatus().isPlayAllowed();
                }
            }
            catch (MoveParser.InvalidMoveException e) {
                System.out.println(e.getMessage());
            }

        } while (inPlay);
    }
}