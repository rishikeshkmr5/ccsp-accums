package com.hcsc.ccsp.accums.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcsc.ccsp.accums.common.SqlQueries;
import com.hcsc.ccsp.accums.dao.LedgerDAO;
import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.dto.ServiceLine;

@Service
public class LedgerServiceImpl implements LedgerService {

	private Object[] params;
//	private long ledgerHeaderGeneratedKey = 0;
//	private long ledgerEntryGeneratedKey = 0;


	@Autowired
	private LedgerDAO ledgerDao;


	public BigInteger insertLedgerHeaderGeneratedKey(AccumUtilization accumUtilization) {
//		return ledgerDao.insertLedgerHeaderGK(ledgerHeaderMapBuilder(accumUtilization));
		return ledgerDao.insertLedgerHeaderGK(accumUtilization);
	}
	

	public BigInteger insertLedgerEntryGeneratedKey(ServiceLine serviceLine, BigInteger headerKey, BigInteger entryKey ) {
//		return ledgerDao.insertLedgerEntryGK(ledgerEntryMapBuilder(serviceLine));
		return ledgerDao.insertLedgerEntryGK(serviceLine, headerKey, entryKey);
	}

	public void insertLedgerEntry(ServiceLine serviceLine, BigInteger headerKey, BigInteger entryKey) {
		params = new Object[] { entryKey, headerKey, serviceLine.getAccumType(), serviceLine.getRole(),
				serviceLine.getCostShareTier(), serviceLine.getAmount(), serviceLine.getNetwork(),
				serviceLine.getSnapShotSummary(), serviceLine.getUnitOfMeasure(), serviceLine.getServiceDate() };

		ledgerDao.insert(SqlQueries.insertLedgerEntry.getSql(), params);

	}


	public void insertLedgerSummary(AccumUtilization accumUtilization, ServiceLine serviceLine) {
		params = new Object[] { serviceLine.getAccumType(), accumUtilization.getMemberId(), serviceLine.getNetwork(),
				serviceLine.getCostShareTier(), accumUtilization.getEndDate(), accumUtilization.getEffectiveDate(),
				accumUtilization.getPlanId(), accumUtilization.getSubscriberId(), accumUtilization.getAllowedAmount(),
				accumUtilization.getMaxAmount(), accumUtilization.getMaxVisit(), accumUtilization.getUnitOfMeasure() };

		ledgerDao.insert(SqlQueries.insertLedgerSummary.getSql(), params);
	}
	
	
	public Object getById(String sTable, String dbColumnName, String dbColumnValue) {
		return ledgerDao.getById(sTable, dbColumnName, dbColumnValue);
	}


	/*
	public Map<String, Object> ledgerHeaderMapBuilder(AccumUtilization accumUtilization) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		//parameters.put("LDGR_ID", "nextval for LDGR_ID_SEQ");
		parameters.put("LDGR_ID", 2102);
		
		parameters.put("DCN", accumUtilization.getDcn());
		parameters.put("CORP_ENT_CD", accumUtilization.getCorpEntCd());
		parameters.put("CLM_LN_ID", accumUtilization.getClaimLineId());
		parameters.put("SVC_ID", accumUtilization.getServiceId());
		parameters.put("SVC_NM", accumUtilization.getServiceName());
		parameters.put("SVC_DT", accumUtilization.getServiceDate());
		parameters.put("PROC_DT", accumUtilization.getProcessedDate());
		parameters.put("NTWK_CD", accumUtilization.getNetworkCode());
		parameters.put("NTWK_TIER_NM", accumUtilization.getNetworkTier());
		parameters.put("PLN_ID", accumUtilization.getPlanId());
		parameters.put("ALWD_AMT", accumUtilization.getAllowedAmount());
		parameters.put("MBR_ID", accumUtilization.getMemberId());
		parameters.put("SUB_ID", accumUtilization.getSubscriberId());
		parameters.put("UOM_NM", accumUtilization.getUnitOfMeasure());
		parameters.put("VEND_XACTN_ID", accumUtilization.getTransactionCode());

		return parameters;
	}
*/
	
/*	
	public Map<String, Object> ledgerEntryMapBuilder(ServiceLine serviceLine) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("PRIMY_LDGR_ENTRY_ID", 0);
		parameters.put("LDGR_ID", ledgerHeaderGeneratedKey);
		parameters.put("ACCUM_TYP_NM", serviceLine.getAccumType());
		parameters.put("ROLE_NM", serviceLine.getRole());
		parameters.put("CST_SHR_TIER_NM", serviceLine.getCostShareTier());
		parameters.put("AMT", serviceLine.getAmount());
		parameters.put("NTWK_CD", serviceLine.getNetwork());
		parameters.put("SNPSHT_SUM_AMT", serviceLine.getSnapShotSummary());
		parameters.put("UOM_NM", serviceLine.getUnitOfMeasure());
		parameters.put("SVC_DT", serviceLine.getServiceDate());
		return parameters;
	}
*/
}
