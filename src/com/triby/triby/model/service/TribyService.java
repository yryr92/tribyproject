package com.triby.triby.model.service;

import static com.triby.common.JDBCTemplate.close;
import static com.triby.common.JDBCTemplate.commit;
import static com.triby.common.JDBCTemplate.getConnection;
import static com.triby.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.triby.common.PageInfo;
import com.triby.option.model.service.OptionService;
import com.triby.option.model.vo.Option;
import com.triby.tImage.model.vo.Image;
import com.triby.triby.model.dao.TribyDao;
import com.triby.triby.model.vo.Triby;



public class TribyService {

	public int insertTriby(Triby tr, ArrayList<Image> list) {
		
		Connection conn = getConnection();
		
		int result1 = new TribyDao().insertTriby(conn, tr);
		int result2 = new TribyDao().insertImage(conn, list);
		
		int result = 0;
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}

	public ArrayList<Triby> selectListH(int hNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Triby> tList = new TribyDao().selectListH(conn, hNo);
		
		close(conn);
		
		return tList;
	}

	public ArrayList<Image> selectImgListH(int hNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Image> iList = new TribyDao().selectImgListH(conn, hNo);
		
		close(conn);
		
		return iList;
	}

	public Triby selectUpdateTriby(int tNo) {
		
		Connection conn = getConnection();
		
		Triby tr = new TribyDao().selectUpdateTriby(conn, tNo);
		
		close(conn);
		
		return tr;
	}

	public ArrayList<Image> selectImgListT(int tNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Image> iList = new TribyDao().selectImgListT(conn, tNo);
		
		close(conn);
		
		return iList;
	}

	public int updateTriby(Triby tr, ArrayList<Image> list) {
		
		Connection conn = getConnection();
		
		int result1 = new TribyDao().updateTriby(conn, tr);
		int result2 = new TribyDao().updateImage(conn, list);
		
		int result = 0;
		//  && result2 > 0
		if(result1 > 0) {
			commit(conn);
			result = 1;
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int insertOption(Option op, ArrayList<String> days, ArrayList<String> times) {
		
		Connection conn = getConnection();
		
		int result = new TribyDao().insertOption(conn, op, days, times);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public ArrayList<Option> selectOption(int tNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Option> list = new TribyDao().selectOption(conn, tNo);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Option> updateOption(int tNo) {
		
		Connection conn = getConnection();
		
		return null;
	}

	public ArrayList<Triby> selectListH(int hNo, int status, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Triby> tList = new TribyDao().selectListH(conn, hNo, status, pi);
		
		close(conn);
		
		return tList;
	}

	public ArrayList<Image> selectImgListH(int hNo, int status, PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Image> iList = new TribyDao().selectImgListH(conn, hNo, status, pi);
		
		close(conn);
		
		return iList;
	}
////////////////////////start from pak 10/09/////////////////////////
/**
* 트리비 리스트 조회 서비스
* @param pi
* @return
*/
public ArrayList<Triby> adminSelectDisTribyList(PageInfo pi) {

Connection conn = getConnection();
ArrayList<Triby> list = new TribyDao().adminSelectDisTribyList(conn, pi);
close(conn);
return list;
}

/**
* 트리비리스트갯수 알아오는 서비스
* @return
*/
public int adminGetListCount() {
// TODO Auto-generated method stub
Connection conn = getConnection();
int listCount = new TribyDao().adminGetListCount(conn);
close(conn);
return listCount;
}

/**
* 트리비 승인 서비스
* @param tNo 트리비번호
* @return
*/
public int adminUpdateApproval(int tNo) {
// TODO Auto-generated method stub
Connection conn = getConnection();

int result = new TribyDao().adminUpdateApproval(conn, tNo);
if(result>0) {
commit(conn);
new OptionService().adminCheckToption(tNo);	
}else {
rollback(conn);
}
return result;

}
//////////////////////////////end pak 10/09//////////////////////////////
	public int deleteTriby(int tNo) {
		
		Connection conn = getConnection();
		
		int result = new TribyDao().deleteTriby(conn, tNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int endOption(int tNo, int oNo) {
		
		Connection conn = getConnection();
		
		int result = new TribyDao().endOption(conn, tNo, oNo);
		
		if(result >0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
		
	}

	public int getListCountH(int hNo, int status) {
		
		Connection conn = getConnection();
		
		int result = new TribyDao().getListCountH(conn, hNo, status);
		
		close(conn);
		
		return result;
	}
///////////////start from pak 10/12
	/**승인할 트리비 한개 조회
	 * @param tNo
	 * @return
	 */
	public Triby adminSelectTriby(int tNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Triby one = new TribyDao().adminSelectTriby(conn, tNo);
		close(conn);
		return one;
	}
	/////////////////end pak 10/12
	

	
	
}
