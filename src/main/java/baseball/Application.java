package baseball;

import baseball.game.Ball;
import baseball.game.Game;
import baseball.game.GameResult;
import baseball.game.GameStatus;

import java.util.Arrays;
import java.util.Scanner;

import static baseball.util.ValidationUtil.*;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public static final String INPUT_MSG = "숫자를 입력해주세요 : ";
    public static int INPUT_FIRST = pickNumberInRange(1, 9);
    public static int INPUT_SECOND = pickNumberInRange(1, 9);
    public static int INPUT_THIRD = pickNumberInRange(1, 9);

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            String strMsg;
            boolean status = true;

            while (status) {
                Game game = new Game(Arrays.asList(INPUT_FIRST, INPUT_SECOND, INPUT_THIRD));
                System.out.print(INPUT_MSG);
                strMsg = scan.nextLine();
                if (!isNumberic(strMsg)) {
                    throw new IllegalArgumentException("숫자만 입력 가능합니다.");
                }
                if (!checkHundredth(Integer.parseInt(strMsg))) {
                    throw new IllegalArgumentException("백의 자리 숫자만 입력 가능합니다. 다시 한번 확인해주세요.");
                }

                int inputInt = Integer.parseInt(strMsg);
                int first = inputInt / 100;
                int second = inputInt % 100 / 10;
                int third = inputInt % 100 % 10;

                if (!checkNo(first)) {
                    throw new IllegalArgumentException("백의자리는 1~9 자리숫자만 입력 가능합니다.");
                }
                if (!checkNo(second)) {
                    throw new IllegalArgumentException("십의자리는1~9 자리숫자만 입력 가능합니다.");
                }
                if (!checkNo(third)) {
                    throw new IllegalArgumentException("일의자리는 1~9 자리숫자만 입력 가능합니다.");
                }

                GameResult result = game.play(Arrays.asList(first, second, third));
                System.out.println(result.getResult());

                if (strMsg.equals("2")) {
                    break;
                }
                if (result.getResult().equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
                if (strMsg.equals("1")) {
                    INPUT_FIRST = pickNumberInRange(1, 9);
                    INPUT_SECOND = pickNumberInRange(1, 9);
                    INPUT_THIRD = pickNumberInRange(1, 9);
                }
            }
        } finally {
            scan.close();
        }
    }
}
