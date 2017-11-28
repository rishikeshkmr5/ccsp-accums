package com.hcsc.ccsp.accums.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.hcsc.ccsp.accums.common.DbTables;
import com.hcsc.ccsp.accums.common.SqlQueries;
import com.hcsc.ccsp.accums.dao.LedgerDAO;
import com.hcsc.ccsp.accums.dto.AccumUtilization;
import com.hcsc.ccsp.accums.dto.ServiceLine;

@Service
public class LedgerServiceImpl implements LedgerService {

	private Object[] params;
	private long ledgerHeaderGeneratedKey = 0;
	private long ledgerEntryGeneratedKey = 0;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private LedgerDAO ledgerDao;

	@Autowired
	private LedgerService ledgerService;

	@Override
	public long insertLedgerHeaderGeneratedKey(AccumUtilization accumUtilization) {
		return ledgerHeaderGeneratedKey = ledgerDao.insertLedgerHeaderGK(ledgerHeaderMapBuilder(accumUtilization));
	}

	@Override
	public long insertLedgerEntryGeneratedKey(ServiceLine serviceLine) {
		return ledgerEntryGeneratedKey = ledgerDao.insertLedgerEntryGK(ledgerEntryMapBuilder(serviceLine));
	}

	@Override
	public void insertLedgerEntry(ServiceLine serviceLine, long id) {
		params = new Object[] { id, ledgerHeaderGeneratedKey, serviceLine.getAccumType(), serviceLine.getRole(),
				serviceLine.getCostShareTier(), serviceLine.getAmount(), serviceLine.getNetwork(),
				serviceLine.getSnapShotSummary(), serviceLine.getUnitOfMeasure(), serviceLine.getServiceDate() };

		ledgerDao.insert(SqlQueries.insertLedgerEntryDbTable, params);

	}

	@Override
	public void insertLedgerSummary(AccumUtilization accumUtilization, ServiceLine serviceLine) {
		params = new Object[] { serviceLine.getAccumType(), accumUtilization.getMemberId(), serviceLine.getNetwork(),
				serviceLine.getCostShareTier(), accumUtilization.getEndDate(), accumUtilization.getEffectiveDate(),
				accumUtilization.getPlanId(), accumUtilization.getSubscriberId(), accumUtilization.getAllowedAmount(),
				accumUtilization.getMaxAmount(), accumUtilization.getMaxVisit(), accumUtilization.getUnitOfMeasure() };

		ledgerDao.insert(SqlQueries.insertLedgerSummaryDbTable, params);
	}


	@Override
	public List<Map<String, Object>> getMemberHeaderRows(String dbColumnName, String dbColumnValue) {
		String sql = "SELECT * FROM LDGR_HDR WHERE " + dbColumnName + " = '" + dbColumnValue + "'";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getMemberEntryRows(String dbColumnName, String dbColumnValue) {
		String sql = "SELECT * FROM LDGR_ENTRY WHERE " + dbColumnName + " = '" + dbColumnValue + "'";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> getMemberSummaryRows(String dbColumnName, String dbColumnValue) {
		String sql = "SELECT * FROM LDGR_SUM WHERE " + dbColumnName + " = '" + dbColumnValue + "'";
		return jdbcTemplate.queryForList(sql);
	}

	public Map<String, Object> ledgerHeaderMapBuilder(AccumUtilization accumUtilization) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("DCN", accumUtilization.getDcn());
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
		parameters.put("ACCUM_TYP_NM", accumUtilization.getAccumType());
		parameters.put("VEND_XACTN_ID", accumUtilization.getTransactionCode());

		return parameters;
	}

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

	@Override
	public Object getLedgerHeader(String dbColumnName, String dbColumnValue) {
		return ledgerService.getMemberHeaderRows(dbColumnName, dbColumnValue);
	}

	@Override
	public Object getLedgerEntry(String dbColumnName, String dbColumnValue) {
		return ledgerService.getMemberEntryRows(dbColumnName, dbColumnValue);
	}

	@Override
	public Object getLedgerSummary(String dbColumnName, String dbColumnValue) {
		return ledgerService.getMemberSummaryRows(dbColumnName, dbColumnValue);
	}
	
	
}
