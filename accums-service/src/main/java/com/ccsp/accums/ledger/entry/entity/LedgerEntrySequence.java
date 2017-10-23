package com.ccsp.accums.ledger.entry.entity;

import javax.persistence.SequenceGenerator;

@SequenceGenerator(name = "SEQ_GENERATOR", sequenceName = "SEQ_LEDGER_ENTRY", allocationSize = 1)
public class LedgerEntrySequence extends LedgerEntryEntity{

}
