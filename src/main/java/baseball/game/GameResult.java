package baseball.game;

/**
 * Created by victorsung.
 * Date: 2022/04/18
 * Time: 10:05 PM
 */
public class GameResult {

    public static final String BALL_KR = "볼";
    public static final String STRIKE_KR = "스트라이크";
    private int strike = 0;
    private int ball = 0;

    public int getStrke() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void save(GameStatus gameStatus) {
        if (gameStatus == GameStatus.BALL) {
            this.ball += 1;
        }
        if (gameStatus == GameStatus.STRIKE) {
            this.strike += 1;
        }
    }

    public String getResult() {
        StringBuilder result = new StringBuilder();

        // 1. ball인 경우
        if (this.ball > 0 && this.strike == 0) {
            result.append(this.ball + BALL_KR);

            return result.toString();
        }

        // 2. strike인 경우
        if (this.ball == 0 && this.strike > 0) {
            result.append(this.strike + STRIKE_KR);

            return result.toString();
        }

        // 3. ball, strike인 경우
        if (this.ball > 0 && this.strike >0) {
            result.append(this.ball + BALL_KR);
            result.append(" ");
            result.append(this.strike + STRIKE_KR);

            return result.toString();
        }

        // 4. 3 strike인 경우
        if (this.ball == 0 && this.strike == 3) {
            result.append(this.strike + STRIKE_KR);

            return result.toString();
        }

        return "";
    }
}
