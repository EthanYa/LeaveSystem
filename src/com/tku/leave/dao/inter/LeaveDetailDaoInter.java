package com.tku.leave.dao.inter;



import java.util.List;

import com.sun.jmx.snmp.Timestamp;
import com.tku.leave.domain.LeaveDetail;

public interface LeaveDetailDaoInter {

	// 新增價單Detail
	void addLeaveDetail(LeaveDetail leavedetail);

	// 用mainId查詢假單Detail
	List<LeaveDetail> getLeaveDetail(long mainId);
	
	//用請假起使時間與結束userid與判斷是否有重複假單數
	int getRepeatSheetByBeginEnd(long userId,Timestamp beginTime1,Timestamp endTime1,Timestamp beginTime2,Timestamp endTime2,Timestamp beginTime3,Timestamp endTime3);


}
