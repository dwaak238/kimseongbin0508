package game;

import java.util.Random;
import java.util.Scanner;

import vo.NumVO;

public class TheDal {
	// 맴버 변수
	private Scanner sc;
	private NumVO numVo;
	private int op; // 더하기 빼기 곱하기 나누기를 정하는 변수
	private int o;
	private int x;
	
	
//	private int num1;
//	private int num2;
	
	
	// 생성자
	public TheDal() {
		sc = new Scanner(System.in);
		numVo = new NumVO();
	}
	
	// num1 값 변경 하는 기능
//	public void num1(int num1) {
//		this.num1 = num1;
//	}
	
//	// num1 값을 전달 해주는 기능
//	public void num1() {
//		
//	}
	
	// 메뉴 출력
	public int menu() {
		System.out.print("1: 더하기, 2:빼기, 3:곱하기, 4:나누기, 0:종료 >> ");
		op = sc.nextInt();
		System.out.println("당신이 선택한 번호 = " + op);
		return op;
	}
	
	// 랜덤 숫자 만들기 매소드
	public void rNum() {
		Random rnd = new Random();
//		num1 = rnd.nextInt(10);
		numVo.setNum1(rnd.nextInt(89)+10);
		
//		num2 = rnd.nextInt(10);
		numVo.setNum2(rnd.nextInt(89)+10);
	}
	
	// 문제 만들기
	public void matter(int mSu) {
		for (int i = 0; i < mSu; i++) {
		// 문제 출력
		rNum(); // 랜덤 숫자 만들기 매소드
		
		if (op == 1) {
			int dab = add();
			compare(dab);
		}
		else if (op == 2) {
			int dab = sub();
			compare(dab);
			}
		else if (op == 3) {
			int dab = mul();
			compare(dab);
			}
		else if (op == 4) {
			int dab = div();
			compare(dab);
			}
	}
}
	
	// 빼기 또는 나누기일때 num1과 num2를 바꾸는 매소드
	public void change(int a, int b) {
		numVo.setNum1(Math.max(a, b));
		numVo.setNum2(Math.min(a, b));
	}
	
	// 나누기를 무조건 떨어지게 만들기
	public boolean ddul(int a, int b) {
		if (a % b == 0) {
			return true;
		}
			return false;
		
	}
		
		// 답 입력 및 비교
	public void compare(int dab) {
//		int dab = numVo.getNum1() + numVo.getNum2(); 
		
		// 답 입력 받기
		int i = sc.nextInt();
		System.out.println("당신이 선택한 답 = " + i);
		
		// 만약에 사용자의 답과 비교해서
		// 맞으면 정답 틀리면 오답
		if (i == dab) {
			System.out.println("정답입니다.");
			o++; // 맞은 갯수
		}
		else {
			System.out.println("오답입니다.");
			x++; // 틀린 갯수
		}
	}
	
	// 맞은 갯수 틀린 갯수 출력 하기
	public void ShowOX() {
		System.out.println("정답수 : " + o);
		System.out.println("오답수 : " + x);
	}

	// 더하기
	public int add() {
		System.out.print(numVo.getNum1() + "+" + numVo.getNum2() + "= ");
		return numVo.getNum1() + numVo.getNum2();
	}

	// 빼기
	public int sub() {
		change(numVo.getNum1(), numVo.getNum2());
		System.out.print(numVo.getNum1() + "-" + numVo.getNum2() + "= ");
		return numVo.getNum1() - numVo.getNum2();
	}

	// 곱하기
	public int mul() {
		System.out.print(numVo.getNum1() + "x" + numVo.getNum2() + "= ");
		return numVo.getNum1() * numVo.getNum2();
	}

	// 나누기
	public int div() {
		for(;;) {
		change(numVo.getNum1(), numVo.getNum2());
		if (ddul(numVo.getNum1(), numVo.getNum2())) {
			break;
			}
		else {
			rNum();
		}
		}
		System.out.print(numVo.getNum1() + "÷" + numVo.getNum2() + "= ");
		return numVo.getNum1() / numVo.getNum2();
	}
}
