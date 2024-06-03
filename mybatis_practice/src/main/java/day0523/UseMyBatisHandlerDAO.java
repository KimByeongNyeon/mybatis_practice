package day0523;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.vo.EmailVO;
import kr.co.sist.dao.MyBatisDAO;

public class UseMyBatisHandlerDAO {

	private static UseMyBatisHandlerDAO umbhDAO;

	private UseMyBatisHandlerDAO() {

	}

	public static UseMyBatisHandlerDAO getInstance() {
		if (umbhDAO == null) {
			umbhDAO = new UseMyBatisHandlerDAO();
		}
		return umbhDAO;
	}

	public int insertSeq() {
		int cnt = 0;
		// 1.MyBatis Handler 얻기
		MyBatisDAO mbDAO = MyBatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		// 2.쿼리문 수행 : parameterType이 없는 insert
		cnt = ss.insert("kr.co.sist.exam2.insertTestMyBatis");
		if (cnt == 1) {
			ss.commit();
		}
		// 3.MyBatis Handler 닫기
		mbDAO.CloseHandler(ss);
		return cnt;
	}

	public int insertSeq(int num) throws PersistenceException {
		int cnt = 0;
		// 1.MyBatis Handler 얻기
		MyBatisDAO mbDAO = MyBatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		// 2.쿼리문 수행 : parameterType="int"속성이 있는 insert(단일형으로 하나의 값을 추가)
		cnt = ss.insert("kr.co.sist.exam2.insertTestMyBatis2", num);
		if (cnt == 1) {
			ss.commit();
		}
		// 3.MyBatis Handler 닫기
		mbDAO.CloseHandler(ss);
		return cnt;
	}

	public int insertEmail(EmailVO eVO) {
		int cnt = 0;
		MyBatisDAO mbDAO = MyBatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(true);
		cnt = ss.insert("kr.co.sist.exam2.insertTestMyBatis3", eVO);
		mbDAO.CloseHandler(ss);
		return cnt;
	}

	/*
	 * public static void main(String[] args) throws UnsupportedEncodingException,
	 * NoSuchAlgorithmException, GeneralSecurityException {
	 * 
	 * 
	 * DataEncrypt de = new DataEncrypt("01234567891054321");//DES
	 * System.out.println(de.encryption("qud5252@naver.com"));
	 * System.out.println(de.encryption("qudsus5906@@"));
	 * 
	 * 
	 * }
	 */
	/*
	 * try { EmailVO eVO = new EmailVO(1, "qud5252@naver.com", "메일테스트", "잘 사냐?");
	 * UseMyBatisHandlerDAO.getInstance().insertEmail(eVO);
	 * }catch(PersistenceException pe) { System.out.println("예외발생");
	 * pe.printStackTrace(); } }
	 */
}
