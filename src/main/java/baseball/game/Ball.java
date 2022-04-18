package baseball.game;

import java.util.Objects;

/**
 * Created by victorsung.
 * Date: 2022/04/18
 * Time: 8:16 PM
 */
public class Ball {
    private final int position;
    private final int no;

    public Ball(int position, int no) {
        this.position = position;
        this.no = no;
    }

    public GameStatus play(Ball ball) {
        if (this.equals(ball)) {
            return GameStatus.STRIKE;
        }
        if (no == ball.no) {
            return GameStatus.BALL;
        }
        return GameStatus.NOTING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && no == ball.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, no);
    }
}
