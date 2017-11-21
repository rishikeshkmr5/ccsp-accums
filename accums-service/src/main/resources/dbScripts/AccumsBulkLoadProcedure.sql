CREATE OR REPLACE PROCEDURE ACCUMS_BULK_LOAD (in ID int)
	
BEGIN
    DECLARE START_INDEX INTEGER;
	DECLARE ENTRY_START_INDEX INTEGER;
	DECLARE LDGR_ID INTEGER;
	DECLARE LDGR_ENTRY_ID INTEGER;
	DECLARE PRIMY_LDGR_ENTRY_ID INTEGER;
	DECLARE MEMBER_ID VARCHAR(10);
	DECLARE ACCUM_TYPE VARCHAR(25);
	DECLARE RECORDS_COUNT int;
	DECLARE CLAIM_ID VARCHAR(25);
	
	SET RECORDS_COUNT = ID;
	SET START_INDEX = 0;
	SET ENTRY_START_INDEX = 0;
	
	WHILE START_INDEX < RECORDS_COUNT DO
		SET LDGR_ID = LDGR_ID_SEQ.NEXTVAL;
		SET MEMBER_ID = CONCAT('A', cast(LDGR_ID as char(7)));
		SET CLAIM_ID = CONCAT('CLM', cast(LDGR_ID as char(7)));
		
		INSERT INTO LDGR_HDR (LDGR_ID, DCN, CLM_LN_ID, SVC_ID, SVC_NM, SVC_DT, PROC_DT, NTWK_CD, NTWK_TIER_NM, PLN_ID, ALWD_AMT, MBR_ID, SUB_ID, UOM_NM, VEND_XACTN_ID)
		VALUES (LDGR_ID, CLAIM_ID, 1, 10, 'Specialist Office Visit', CURRENT DATE - ((18 * 365) + RAND()*(47*365)) DAYS, CURRENT DATE - ((18 * 365) + RAND()*(47*365)) DAYS, 'INB', 'PPO', 10, rand()*100, MEMBER_ID, MEMBER_ID,'Dollars', 'xxx');
	
		WHILE  ENTRY_START_INDEX < 4 DO
			SET LDGR_ENTRY_ID = LDGR_ENTRY_ID_SEQ.NEXTVAL;
			
			IF ENTRY_START_INDEX > 0 THEN 
				SET PRIMY_LDGR_ENTRY_ID = LDGR_ENTRY_ID;
			END IF;
			
			IF ENTRY_START_INDEX = 0 THEN
				SET ACCUM_TYPE = 'SPC Copay';
			ELSE IF ENTRY_START_INDEX = 1 THEN
				SET ACCUM_TYPE = 'Individual OPX';
			ELSE IF ENTRY_START_INDEX = 2 THEN
				SET ACCUM_TYPE = 'Individual Ded';
			ELSE IF ENTRY_START_INDEX = 3 THEN
				SET ACCUM_TYPE = 'Family Ded';
			END IF;
			END IF;
			END IF;
			END IF;
			
			INSERT INTO LDGR_ENTRY (LDGR_ENTRY_ID, PRIMY_LDGR_ENTRY_ID, LDGR_ID, ACCUM_TYP_NM, ROLE_NM, CST_SHR_TIER_NM, AMT, NTWK_CD, SNPSHT_SUM_AMT, UOM_NM,SVC_DT)
			VALUES (LDGR_ENTRY_ID, PRIMY_LDGR_ENTRY_ID, LDGR_ID, ACCUM_TYPE, 'PTNT', 'PPO', rand()*100, 'INB', rand()*100, 'Dollars', CURRENT DATE - ((18 * 365) + RAND()*(47*365)) DAYS);
        
			INSERT INTO LDGR_SUM(LDGR_SUM_ID, ACCUM_TYP_NM, MBR_ID, NTWK_CD, NTWK_TIER_NM, END_DT, EFF_DT, PLN_ID, SUB_ID, AMT,MAX_AMT, MAX_VST_CNT, UOM_NM)
				values(LDGR_SUM_ID_SEQ.NEXTVAL, ACCUM_TYPE, MEMBER_ID, 'INB', 'PPO', CURRENT TIMESTAMP, CURRENT DATE, 10, MEMBER_ID, rand()*100, 1000, 100, 'Dollars');
			
			SET ENTRY_START_INDEX = ENTRY_START_INDEX + 1;
			
		END WHILE;
		
		SET START_INDEX = START_INDEX + 1;
		SET ENTRY_START_INDEX = 0;
		
	END WHILE;	
END