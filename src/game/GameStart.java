package game;

public class GameStart {
	public static void start() {
		for(;;) {
		TheDal td = new TheDal();
		if (0 == td.menu()) {
			break;
		}
//		td.menu();
		td.matter(10); // 문제 수 넣기
		td.ShowOX();
		}
		System.out.println("감사합니다.");
	}
}
