package edu.kh.jdbc.main.model.view;

import java.util.Scanner;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.main.model.service.MainService;

public class MainView {
	
	private Scanner sc = new Scanner(System.in);
	
	private MainService service = new MainService();
	
	/** 메인 메뉴 출력
	 * 
	 */
	public void mainMenu() {
		
		int input = 0;
		
		
		do {
			
			try {
				
				if(Session.loginMember == null	) { // 로그인 X
					
					System.out.println("\n ==========회원제 게시판 프로그램 ========== \n");
					System.out.println("1. 로그인");
					System.out.println("2. 회원가입");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n메뉴선택 : ");
					input = sc.nextInt();
					sc.nextLine(); // 입력 버퍼 개행문자 제거
					
					switch(input) {
					case 1: login(); break;
					case 2: signUp(); break;
					case 0: System.out.println("\n====프로그램 종료====\n"); break;
					default : System.out.println("\n**** 메뉴 번호만 입력해 주세요 ****\n");
					}
					
				} else { // 로그인 O
					System.out.println("\n ==========로그인 메뉴 ========== \n");
					System.out.println("1. 회원 기능");
					System.out.println("2. 게시판 기능");
					System.out.println("3. 로그아웃");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n메뉴선택 : ");
					input = sc.nextInt();
					sc.nextLine(); // 입력 버퍼 개행문자 제거
					
					switch(input) {
					case 1 : break;
					case 2 : break;
					case 3 : 
						System.out.println("\n=== 로그아웃 되었습니다 ===\n");
						
						Session.loginMember=null;
						// 참조하고 있던 로그인 회원 객체를 없앰
						
						break;
					case 0 : System.out.println("\n====프로그램 종료====\n"); break;
					default : System.out.println("\n**** 메뉴 번호만 입력해 주세요 ****\n");
					}
					
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			
		} while (input !=0);
	}
	
	/** 로그인
	 * 
	 * 
	 */
	private void login() {
		System.out.println("\n[로그인]\n");
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		try {
			// 로그인 서비스 호출 후 결과 반환받기
			// -> 반환 받은 결과는 Session.loginMember에 저장
			Session.loginMember = service.login(memberId, memberPw);
			
			if (Session.loginMember == null) { // 로그인실패
				System.out.println("\n**아이디 / 비밀번호가 일치하지 않습니다. **\n");
				
			}else {
				System.out.printf("\n === %s 님 환영합니다 === \n\n",
						Session.loginMember.getMemberName());
			}
		} catch(Exception e) {
			System.out.println("\n******로그인 중 예외 발생******\n");
			e.printStackTrace();
		}
	}
	
	/** 회원 가입
	 * 
	 */
	private void signUp() {
		System.out.println("\n[회원가입]\n");
		
		// 아이디, 비밀번호, 이름, 성별(M/F)을 저장할 변수 선언
		String memberId = null;
		
		String memberPw = null;
		String poConfirm = null; // 비밀번호 확인용 변수
		
		String memberName = null;
		
		String membergender = null;
		
		try {
			
			// 아이디 입력
			while(true) {
				System.out.print("아이디 입력 : ");
				memberId = sc.next();
				
			} if ()
			
		} catch (Exception e) {
			System.out.println("\n*****회원 가입 중 예외 발생*****\n");
			e.printStackTrace();
		}
		
	}
}
