package lotto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LottoGame game = new LottoGame();

        System.out.println("구입 금액을 입력해 주세요.");

        int lottoCount = game.calculateLottoCount(Integer.parseInt(scanner.nextLine()));
        System.out.println(lottoCount + "개를 구매했습니다");

        game.purchaseLotto(lottoCount);
        game.printLottoList();

        System.out.println();


    }
}
