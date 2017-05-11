package com.tku.leave.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.jmx.snmp.Timestamp;
import com.tku.leave.dao.inter.LeaveDetailDaoInter;
import com.tku.leave.dao.jdbc.DaoJDBC;
import com.tku.leave.domain.LeaveDetail;
import com.tku.leave.exception.DataAccessException;

public class LeaveDetailDaoImpl implements LeaveDetailDaoInter {

	@Override
	// 新增價單Detail
	public void addLeaveDetail(LeaveDetail leavedetail) {
		// TODO Auto-generated method stub
		DaoJDBC.executeUpdate(
				"insert into leave_detail values(seq_leave.nextval,?,?,?,?,?,?)",
				new Object[] {
						// leavemain.getMainId(),
						// new
						// java.sql.Timestamp(leavemain.getApplytime().getTime()),
						leavedetail.getMainId(),
						leavedetail.getClassId(),
						new java.sql.Timestamp(leavedetail.getBeginTime()
								.getTime()),
						new java.sql.Timestamp(leavedetail.getEndTime()
								.getTime()), leavedetail.getLeaveTime(),
						leavedetail.getReason()

				});

	}

	@Override
	// 用mainId查詢假單Detail
	public List<LeaveDetail> getLeaveDetail(long mainId) {
		// TODO Auto-generated method stub
		ResultSet rset = DaoJDBC
				.executeQuery(
						"select c.name, d.classname, b.begintime, b.endtime, b.leavetime, b.reason , a.mainid, c.mail, b.detailid, d.classid from leave_main a,leave_detail b,leave_user c,leave_class d where a.userid=c.userid and a.mainid = b.mainid and d.classid = b.classid and a.mainid =?",// 依時間排序
						new Object[] { mainId });

		List<LeaveDetail> leavedetaillist = null;
		try {
			leavedetaillist = new ArrayList<LeaveDetail>();
			while (rset.next()) {
				LeaveDetail Leavedetail = new LeaveDetail();
				// 數據封裝
				Leavedetail.setName(rset.getString("name"));
				Leavedetail.setClassName(rset.getString("className"));
				Leavedetail.setBeginTime(rset.getTimestamp("begintime"));
				Leavedetail.setEndTime(rset.getTimestamp("endtime"));
				Leavedetail.setLeaveTime(rset.getString("leavetime"));
				Leavedetail.setReason(rset.getString("reason"));
				Leavedetail.setMainId(rset.getLong("mainId"));
				Leavedetail.setMail(rset.getString("mail"));
				Leavedetail.setDetailId(rset.getLong("detailId"));
				Leavedetail.setClassId(rset.getLong("classId"));
				leavedetaillist.add(Leavedetail);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			DaoJDBC.close(rset, DaoJDBC.getPs(), DaoJDBC.getCt());
		}

		return leavedetaillist;
	}

	
	@Override
	//用請假起使時間與結束userid與判斷是否有重複假單數
	public int getRepeatSheetByBeginEnd(long userId,Timestamp beginTime1,Timestamp endTime1,Timestamp beginTime2,Timestamp endTime2,Timestamp beginTime3,Timestamp endTime3) {
		// TODO Auto-generated method stub
		ResultSet rset = DaoJDBC.executeQuery(
				"select count(*) from  (SELECT * FROM leave_detail a,leave_main b where a.mainid=b.mainid and b.approvestatus in('1','0') and b.userid = ?  ) c where c.begintime between ? and ? or c.endtime between  ?   and ? or c.begintime <= ?  and  ?<=c.endtime ",
				new Object[] {userId,beginTime1,endTime1,beginTime2,endTime2,beginTime3,endTime3});
		int number = 0;
		try {
			if (rset.next()) {
				// 数据封装
			 number = rset.getInt("count(*)");

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		} finally {
			DaoJDBC.close(rset, DaoJDBC.getPs(), DaoJDBC.getCt());
		}

		return number;
	}

	
	
}
