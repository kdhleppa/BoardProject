package edu.kh.jdbc.main.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.*;
import java.sql.Connection;

import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MainService {

	private MainDAO dao = new MainDAO();
	
	/** 로그인 서비스
	 * @param memberId
	 * @param memberPw
	 * @return
	 * @throws Exception 
	 */
	public Member login(String memberId, String memberPw) throws Exception {

		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출
		Member member = dao.login(conn, memberId, memberPw);
		
		// 3. Connection 반환
		close(conn);
		
		// 4. 결과 반환
		return member;
		
	}

	public int idDuplicationCheck(String memberId) throws Exception {
		Connection conn = getConnection();
		
		int result =dao.idDuplicationCheck(conn, memberId);
		
		close(conn);
		
		return result;
	}

	/** 회원가입 메소드
	 * @param member
	 * @return result
	 */
	public int signUp(Member member) throws Exception {
		
		
		
		Connection conn = getConnection();
		
		int result = dao.signUp(conn, member); // -> INSERT 수행
		
		// 트랜잭션 처리
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		
		return result;
	}

}
