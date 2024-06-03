package day0531;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.EmpDomain;

public class ExamMapper7DAO {
	
	private static ExamMapper7DAO em7DAO;
	
	private ExamMapper7DAO() {
		
	}
	
	public static ExamMapper7DAO getInstance() {
		if(em7DAO == null) {
			em7DAO = new ExamMapper7DAO();
		}
		return em7DAO;
	}
	
	
	public List<EmpDomain> selectProcedure( int deptno )throws PersistenceException{
		List<EmpDomain> list = new ArrayList<EmpDomain>();
		
		MyBatisDAO mbDAO = MyBatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(true);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("deptno", deptno);
		ss.selectOne("kr.co.sist.exam6.selectDeptEmp", map);
		
		//조회 결과가 map에 저장
		
		mbDAO.CloseHandler(ss);
		//System.out.println(map.get("selectEmp"));
		//System.out.println(map.get("msg"));
		
		EmpDomain ed = null;
		List<Map<String, Object>> searchList = 
				(List<Map<String, Object>>)map.get("selectEmp"); 
		for( Map<String, Object> searchMap: searchList ) {
			ed = new EmpDomain();
			//String, BigDecimal, TimeStamp가 나온다
			ed.setEname((String)searchMap.get("ENAME"));
			ed.setJob((String)searchMap.get("JOB"));
			ed.setSal(((BigDecimal)searchMap.get("SAL")).intValue());
			ed.setHiredate(new Date(((Timestamp)searchMap.get("HIREDATE")).getTime()));
			
			list.add(ed);
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println( ExamMapper7DAO.getInstance().selectProcedure(20));
	}
}
