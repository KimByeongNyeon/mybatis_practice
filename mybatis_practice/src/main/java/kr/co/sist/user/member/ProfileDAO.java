/*
 * package kr.co.sist.user.member;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.util.List;
 * 
 * import kr.co.sist.dao.DbConnection;
 * 
 * public class ProfileDAO { private ProfileDAO() {
 * 
 * }
 * 
 * private static ProfileDAO pfDAO;
 * 
 * public static ProfileDAO getInstance() { if(pfDAO == null) { pfDAO = new
 * ProfileDAO(); } return pfDAO; }//getInstance
 * 
 * public ProfileVO selectProfile(String id) throws SQLException { ProfileVO
 * profile = null; DbConnection dbCon = DbConnection.getInstance(); Connection
 * con = null; PreparedStatement pstmt = null; ResultSet rs = null;
 * 
 * try { con = dbCon.getConn("jdbc/dbcp");
 * 
 * StringBuilder selectProfile = new StringBuilder(); selectProfile
 * .append("select name, img ") .append("from web_member ")
 * .append("where id=?");
 * 
 * pstmt = con.prepareStatement(selectProfile.toString()); pstmt.setString(1,
 * id); rs = pstmt.executeQuery();
 * 
 * if(rs.next()){ profile = new ProfileVO(); profile.setId(id);
 * profile.setName(rs.getString("name")); profile.setImg(rs.getString("img")); }
 * 
 * } finally { dbCon.closeCon(rs, pstmt, con); }
 * 
 * 
 * return profile; }
 * 
 * public int updateImg(ProfileVO pVO)throws SQLException{ int cnt = 0;
 * 
 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
 * 
 * DbConnection db = DbConnection.getInstance(); try { //1. JDNI 사용객체 생성 //2.
 * DataSource 얻기 //3. Connection 얻기 con = db.getConn("jdbc/dbcp"); //4. 쿼리문 생성객체
 * 얻기 pstmt = con.prepareStatement("update web_member set img=? where id=?");
 * pstmt.setString(1, pVO.getImg()); pstmt.setString(2, pVO.getId()); //5. 쿼리문
 * 수행 후 결과 얻기 cnt = pstmt.executeUpdate(); } finally { //6. 연결 끊기
 * db.closeCon(null, pstmt, con); }//end finally return cnt; }//updateImg
 * 
 * public int updateInfo(ProfileVO pVO)throws SQLException{ int cnt = 0;
 * 
 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
 * 
 * DbConnection db = DbConnection.getInstance(); try { //1. JDNI 사용객체 생성 //2.
 * DataSource 얻기 //3. Connection 얻기 con = db.getConn("jdbc/dbcp"); //4. 쿼리문 생성객체
 * 얻기 pstmt = con.prepareStatement("update web_member set name=? where id=?");
 * pstmt.setString(1, pVO.getName()); pstmt.setString(2, pVO.getId()); //5. 쿼리문
 * 수행 후 결과 얻기 cnt = pstmt.executeUpdate(); } finally { //6. 연결 끊기
 * db.closeCon(null, pstmt, con); }//end finally return cnt; }//selectId }
 */