package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by victorsung.
 * Date: 2022/04/18
 * Time: 9:11 PM
 */
public class BallTest {

    @Test
    @DisplayName("strike")
    void 스트라이크(){
        // given
        Ball computer = new Ball(1, 4);
        // when
        GameStatus status = computer.play(new Ball(1, 4));
        // then
        assertThat(status).isEqualTo(GameStatus.STRIKE);
    }

    @Test
    @DisplayName("ball")
    void 뽈(){
        // given
        Ball computer = new Ball(1, 4);
        // when
        GameStatus status = computer.play(new Ball(2, 4));
        // then
        assertThat(status).isEqualTo(GameStatus.BALL);
    }

    @Test
    @DisplayName("noting")
    void 낫띵(){
    	// given 
        Ball computer = new Ball(1, 4);
        // when
        GameStatus status = computer.play(new Ball(2, 5));
    	// then
        assertThat(status).isEqualTo(GameStatus.NOTING);
    }
}
