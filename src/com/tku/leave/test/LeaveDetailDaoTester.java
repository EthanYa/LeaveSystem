package com.tku.leave.test;

import java.sql.Timestamp;
import java.util.List;
import java.util.Date;

import com.tku.leave.dao.impl.LeaveDetailDaoImpl;
import com.tku.leave.dao.inter.LeaveDetailDaoInter;
import com.tku.leave.domain.LeaveDetail;
import com.tku.leave.utils.DateUtils;

public class LeaveDetailDaoTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeaveDetailDaoInter ddi = new LeaveDetailDaoImpl();
		// List<LeaveDetail> leavedetaillist = ddi.getLeaveDetail(425);
		// for(LeaveDetail l:leavedetaillist){
		// System.out.println(l);
//		// }
//		
//		LeaveDetail leavedetail = new LeaveDetail();
//	//	leavedetail.setUserId(41);
//		Timestamp BeginTime1=(Timestamp) DateUtils.StrToDate("2016-06-15 09:00"));
//		leavedetail.setEndTime(DateUtils.StrToDate("2016-06-15 18:00"));
//		//String BeginTime1 ="03-06-16 09.00.00.000000000 上午";
//		//String  EndTime1 = "03-06-16 06.00.00.000000000 下午";
//		Timestamp BeginTime1=leavedetail.getBeginTime();
//		Timestamp EndTime1=leavedetail.getEndTime();
//		//System.out.println(leavedetail.getBeginTime());
//		//System.out.println(leavedetail.getEndTime());
//		int number = ddi.getRepeatSheetByBeginEnd(41,BeginTime1, EndTime1,BeginTime1, EndTime1,BeginTime1, EndTime1);
//		System.out.println(number);
	}

}
