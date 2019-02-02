package com.cs.testapplication.orderbooks.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity(name = "FINANCIAL_INSTRUMENT")
@Immutable
public class FinancialInstrument extends VersionObject{

    @Id
    @SequenceGenerator(allocationSize = 1, name = "FI", sequenceName = "FINANCIALINSTRUMENT_SEQ") //TODO
    @GeneratedValue(generator = "FI")
    @Column(name = "INSTRUMENT_ID")
    Long instrumentId;

    @Column(name = "INSTRUMENT_NAME")
    private String instrumentName;

    public FinancialInstrument(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public FinancialInstrument() {}

    public Long getInstrumentId() {
        return instrumentId;
    }

    public String getInstrumentName() {
        return instrumentName;
    }
}
