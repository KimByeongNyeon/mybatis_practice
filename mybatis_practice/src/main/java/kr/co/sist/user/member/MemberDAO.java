/*
 * package kr.co.sist.user.member;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException;
 * 
 * import kr.co.sist.dao.DbConnection;
 * 
 *//**
	 * 아이디 중복확인, 회원가입
	 *//*
		 * public class MemberDAO {
		 * 
		 * private static MemberDAO mDAO;
		 * 
		 * private MemberDAO() {
		 * 
		 * }
		 * 
		 * public static MemberDAO getInstance() { if(mDAO == null) { mDAO = new
		 * MemberDAO(); }//end if return mDAO; }//getInstance
		 * 
		 * public String selectId(String id)throws SQLException{ String returnId = "";
		 * 
		 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
		 * 
		 * DbConnection db = DbConnection.getInstance(); try { //1. JDNI 사용객체 생성 //2.
		 * DataSource 얻기 //3. Connection 얻기 con = db.getConn("jdbc/dbcp"); //4. 쿼리문 생성객체
		 * 얻기 pstmt = con.prepareStatement("select id from web_member where id=?");
		 * pstmt.setString(1, id); //5. 쿼리문 수행 후 결과 얻기 rs = pstmt.executeQuery();
		 * if(rs.next()) { returnId=rs.getString("id"); } } finally { //6. 연결 끊기
		 * db.closeCon(rs, pstmt, con); }//end finally return returnId; }//selectId
		 * 
		 * public void insertWebMember(WebMemberVO wmVO)throws SQLException{ Connection
		 * con = null; PreparedStatement pstmt = null;
		 * 
		 * DbConnection db = DbConnection.getInstance(); try { //1.JDNI 사용객체 생성 //2.
		 * DataSource 얻기 //3. Connection 얻기 con = db.getConn("jdbc/dbcp"); //4. 쿼리문 생성객체
		 * StringBuilder insertMember = new StringBuilder(); insertMember
		 * .append("insert into web_member")
		 * .append("(id, pass, name, birth, tel, cellphone, email, gender, loc, zipcode, addr, addr_detail, ip)"
		 * ) .append("values(?,?,?,?,?,?,?,?,?,?,?,?,?)"); pstmt =
		 * con.prepareStatement(insertMember.toString()); //5. 바인드 변수 설정
		 * pstmt.setString(1, wmVO.getId()); pstmt.setString(2, wmVO.getPassword());
		 * pstmt.setString(3, wmVO.getName()); pstmt.setString(4, wmVO.getBirthday());
		 * pstmt.setString(5, wmVO.getTel()); pstmt.setString(6, wmVO.getCell());
		 * pstmt.setString(7, wmVO.getEmail()); //email1 + email2 pstmt.setString(8,
		 * wmVO.getGender()); pstmt.setString(9, wmVO.getArea()); pstmt.setString(10,
		 * wmVO.getZipcode()); pstmt.setString(11, wmVO.getAddr0()); pstmt.setString(12,
		 * wmVO.getAddr1()); pstmt.setString(13, wmVO.getIp()); //6. 쿼리문 수행 후 결과 얻기
		 * pstmt.executeUpdate(); } finally { //7. 연결 끊기 db.closeCon(null, pstmt, con);
		 * } }//insertWebMember
		 * 
		 * }//class
		 */