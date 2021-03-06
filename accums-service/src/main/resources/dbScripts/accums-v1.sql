
CREATE TABLE LDGR_HDR
(
	LDGR_ID               INTEGER NOT NULL ,
	DCN                   VARCHAR(20),
	CLM_LN_ID             INTEGER,
	SVC_ID                INTEGER,
	SVC_NM                VARCHAR(50),
	SVC_DT                DATE,
	PROC_DT               TIMESTAMP,
	NTWK_CD               CHAR(3),
	NTWK_TIER_NM          VARCHAR(10),
	PLN_ID                INTEGER,
	ALWD_AMT              DECIMAL(10,2),
	MBR_ID                VARCHAR(16),
	SUB_ID                VARCHAR(16),
	UOM_NM                VARCHAR(10),
	ACCUM_TYP_NM          VARCHAR(25),
	VEND_XACTN_ID         VARCHAR(20)
);

CREATE UNIQUE INDEX XPKLEDGER_HEADER ON LDGR_HDR
(
	LDGR_ID
);

ALTER TABLE LDGR_HDR
	ADD CONSTRAINT XPKLEDGER_HEADER  PRIMARY KEY (LDGR_ID);

CREATE TABLE LDGR_SUM
(
	LDGR_SUM_ID           INTEGER NOT NULL ,
	LDGR_ID               INTEGER NULL,
	ACCUM_TYP_NM          VARCHAR(25),
	MBR_ID                VARCHAR(16),
	NTWK_CD               CHAR(3),
	NTWK_TIER_NM          VARCHAR(10),
	END_DT                DATE,
	EFF_DT                DATE,
	PLN_ID                INTEGER,
	SUB_ID                VARCHAR(16),
	AMT                   DECIMAL(10,2),
	MAX_AMT               DECIMAL(10,2),
	MAX_VST_CNT           INTEGER,
	UOM_NM                VARCHAR(10)
);

CREATE UNIQUE INDEX XPKLEDGER_SUMMARY ON LDGR_SUM
(
	LDGR_SUM_ID
);

ALTER TABLE LDGR_SUM
	ADD CONSTRAINT XPKLEDGER_SUMMARY  PRIMARY KEY (LDGR_SUM_ID);

CREATE UNIQUE INDEX XAK1LEDGER_SUMMARY ON LDGR_SUM
(
	ACCUM_TYP_NM,
	MBR_ID,
	NTWK_CD,
	NTWK_TIER_NM,
	END_DT
);

CREATE INDEX XIF1LEDGER_SUMMARY ON LDGR_SUM
(
	LDGR_ID
);

CREATE TABLE LDGR_ENTRY
(
	LDGR_ENTRY_ID         INTEGER NOT NULL ,
	PRIMY_LDGR_ENTRY_ID   INTEGER,
	LDGR_ID               INTEGER NOT NULL ,
	ACCUM_TYP_NM          VARCHAR(25),
	ROLE_NM               VARCHAR(10),
	CST_SHR_TIER_NM       VARCHAR(10),
	AMT                   DECIMAL(10,2),
	NTWK_CD               CHAR(3),
	SNPSHT_SUM_AMT        DECIMAL(10,2),
	UOM_NM                VARCHAR(10),
	SVC_DT                DATE
);

CREATE UNIQUE INDEX XPKLEDGER_ENTRY ON LDGR_ENTRY
(
	LDGR_ENTRY_ID
);

ALTER TABLE LDGR_ENTRY
	ADD CONSTRAINT XPKLEDGER_ENTRY  PRIMARY KEY (LDGR_ENTRY_ID);

CREATE INDEX XIF1LEDGER_ENTRY ON LDGR_ENTRY
(
	LDGR_ID
);

CREATE INDEX XIF2LEDGER_ENTRY ON LDGR_ENTRY
(
	PRIMY_LDGR_ENTRY_ID
);

ALTER TABLE LDGR_SUM
	ADD CONSTRAINT R_2  FOREIGN KEY (LDGR_ID) REFERENCES LDGR_HDR (LDGR_ID)
		ON DELETE NO ACTION;

ALTER TABLE LDGR_ENTRY
	ADD CONSTRAINT R_1  FOREIGN KEY (LDGR_ID) REFERENCES LDGR_HDR (LDGR_ID)
		ON DELETE NO ACTION;

ALTER TABLE LDGR_ENTRY
	ADD CONSTRAINT R_3  FOREIGN KEY (PRIMY_LDGR_ENTRY_ID) REFERENCES LDGR_ENTRY (LDGR_ENTRY_ID)
		ON DELETE NO ACTION;
		
CREATE SEQUENCE SEQ_LDGR_HDR AS INT START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_LDGR_ENTRY AS INT START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE SEQ_LDGR_SUM AS INT START WITH 1 INCREMENT BY 1;

--Ramesh: October 30, 2017: Removed foreign key constraints on LDGR_ID---
ALTER TABLE LDGR_SUM DROP FOREIGN KEY R_2;

ALTER TABLE LDGR_SUM DROP COLUMN LDGR_ID;

CALL SYSPROC.ADMIN_CMD('REORG TABLE LDGR_SUM');

--Ramesh: November 06, 2017: Removed accum type dependency from header table---
ALTER TABLE LDGR_HDR DROP COLUMN ACCUM_TYP_NM;

CALL SYSPROC.ADMIN_CMD('REORG TABLE LDGR_HDR');


--Vaibhav: November 07, 2017: Category table creation script
CREATE TABLE CATEGORY_TYPE
(
	ID               	  	INTEGER NOT NULL ,
	CATEGORY                VARCHAR(20) NOT NULL,
	CODE                	VARCHAR(50) NOT NULL,
	DISPLAY_NAME          	VARCHAR(50),
	ACTIVE         			CHAR(1)
);

CREATE UNIQUE INDEX XPKCATEGORY_TYPE ON CATEGORY_TYPE
(
	ID
);

ALTER TABLE CATEGORY_TYPE
	ADD CONSTRAINT XPKCATEGORY_TYPE  PRIMARY KEY (ID);
	
CREATE SEQUENCE SEQ_CATEGORY_TYPE AS INT START WITH 1 INCREMENT BY 1;

--Nithish: Nov 11, 2017: All primary keys converted to big int

ALTER TABLE LDGR_ENTRY 
      ALTER LDGR_ENTRY_ID SET DATA TYPE BIGINT 
      ALTER PRIMY_LDGR_ENTRY_ID SET DATA TYPE BIGINT 
      ALTER LDGR_ID SET DATA TYPE BIGINT;

ALTER TABLE LDGR_HDR
      ALTER LDGR_ID SET DATA TYPE BIGINT;

ALTER TABLE LDGR_HDR
      ADD CORP_ENT_CD CHAR(03);
      
ALTER TABLE LDGR_SUM
      ALTER LDGR_SUM_ID SET DATA TYPE BIGINT;
      
call sysproc.admin_cmd('REORG TABLE LDGR_HDR');
call sysproc.admin_cmd('REORG TABLE LDGR_ENTRY');
call sysproc.admin_cmd('REORG TABLE LDGR_SUM');

--Nithish: Nov 27, 2017 : Sequence name change

--Get the max values from the current sequences as below.
 VALUES NEXTVAL FOR SEQ_LDGR_HDR;
 VALUES NEXTVAL FOR SEQ_LDGR_ENTRY;
 VALUES NEXTVAL FOR SEQ_LDGR_SUM;
 
-- => pass the max values got from the above to the below as start values 
CREATE SEQUENCE LDGR_ID_SEQ AS INT START WITH 5293 INCREMENT BY 1;

CREATE SEQUENCE LDGR_ENTRY_ID_SEQ AS INT START WITH 26418 INCREMENT BY 1;

CREATE SEQUENCE LDGR_SUM_ID_SEQ AS INT START WITH 26344 INCREMENT BY 1;