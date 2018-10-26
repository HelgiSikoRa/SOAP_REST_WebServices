package com.epam.lab.webmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;

@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryWrapper {
    @XmlElementRefs({@XmlElementRef(type = SummaryFault.class), @XmlElementRef(type = SummarySuccess.class)})
    private Summary summary;

    public SummaryWrapper(Summary summary) {
        this.summary = summary;
    }

    public SummaryWrapper() {
    }

    public static SummaryWrapper success(String msg) {
        return new SummaryWrapper(new SummarySuccess(msg));
    }

    public static SummaryWrapper fault(String msg) {
        return new SummaryWrapper(new SummaryFault(msg));
    }

    public Summary getSummary() {
        return summary;
    }

    public SummaryWrapper setSummary(Summary summary) {
        this.summary = summary;
        return this;
    }
}