package baseball.game;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * Created by victorsung.
 * Date: 2022/04/18
 * Time: 8:11 PM
 */
public class Game {

    private final List<Ball> computerBalls;

    public Game(List<Integer> input) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(1 + i, input.get(i)));
        }
        this.computerBalls = balls;
    }

    public GameResult play(List<Integer> balls) {
        Game playerGame = new Game(balls);
        GameResult result = new GameResult();

        for (Ball ball : computerBalls) {
            GameStatus gameStatus = playerGame.play(ball);
            result.save(gameStatus);
        }

        return result;
    }

    public GameStatus play(Ball playerBall) {
        return computerBalls.parallelStream()
                .map(ball -> ball.play(playerBall))
                .filter(gameStatus -> gameStatus != GameStatus.NOTING)
                .findFirst()
                .orElse(GameStatus.NOTING);
    }
}
