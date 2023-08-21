package edu.kh.jdbc.main.model.service;

import java.sql.Connection;

import edu.kh.jdbc.common.JDBCTemplate;
import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MainService {

	private MainDAO dao = new MainDAO();
	
	/** 로그인 서비스
	 * @param memberId
	 * @param memberPw
	 * @return
	 */
	public Member login(String memberId, String memberPw) {

		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출
		dao.login(conn, memberId, memberPw);
		
		// 3. Connection 반환
		close(conn);
		
		// 4. 결과 반환
		return member;
		
	}

}