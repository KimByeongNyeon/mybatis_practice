package day0524;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.CpEmpDomain;
import kr.co.sist.vo.CpEmpVO;

public class UseMyBatisHandlerDAO2 {
	public int updateCpEmp(CpEmpVO ceVO)throws PersistenceException{
		int cnt = 0;
		//1. MyBatis Handler 얻기
		MyBatisDAO mbDAO = MyBatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(true);
		//2.
		cnt = ss.update("kr.co.sist.exam3.updateCpEmp", ceVO);
		//3.
		mbDAO.CloseHandler(ss);
		return cnt;
	}
	
	public int deletCpEmp(int empno)throws PersistenceException{
		int cnt=0;
		
		MyBatisDAO mbDao = MyBatisDAO.getInstance();
		SqlSession ss = mbDao.getMyBatisHandler(true);
		cnt = ss.delete("kr.co.sist.exam3.deleteCpEmp", empno);
		mbDao.CloseHandler(ss);
		
		return cnt;
	}
	
	public CpEmpDomain selectCpEmp(int empno)throws PersistenceException{
		CpEmpDomain ced = null;
		
		MyBatisDAO mbDAO = MyBatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		ced = ss.selectOne("kr.co.sist.exam3.selectOneCpEmp", empno);
		mbDAO.CloseHandler(ss);
		
		return ced;
	}
	
	public List<CpEmpDomain> selectDept(int deptno)throws PersistenceException{
		List<CpEmpDomain> list = null;
		
		MyBatisDAO mbDAO = MyBatisDAO.getInstance();
		SqlSession ss = mbDAO.getMyBatisHandler(false);
		
		list = ss.selectList("kr.co.sist.exam3.selectAllCpEmp", deptno);
		mbDAO.CloseHandler(ss);
		
		return list;
	}
	
	public static void main(String[] args) {
		//CpEmpVO ceVO = new CpEmpVO(20, 3000, 0, 40, "김병년", "타짜", null);
		UseMyBatisHandlerDAO2 umbhDAO = new UseMyBatisHandlerDAO2();
		//int cnt = umbhDAO.updateCpEmp(ceVO);
		//int cnt = umbhDAO.deletCpEmp(20);
		List<CpEmpDomain> list = umbhDAO.selectDept(20);
		CpEmpDomain ced = umbhDAO.selectCpEmp(7788);
		System.out.println(list);
	}
}
