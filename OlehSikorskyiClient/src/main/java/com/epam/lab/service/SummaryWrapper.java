
package com.epam.lab.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for summaryWrapper complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="summaryWrapper">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://service.lab.epam.com/}summaryFault"/>
 *         &lt;element ref="{http://service.lab.epam.com/}summarySuccess"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "summaryWrapper", propOrder = {
    "summaryFault",
    "summarySuccess"
})
public class SummaryWrapper {

    protected SummaryFault summaryFault;
    protected SummarySuccess summarySuccess;

    /**
     * Gets the value of the summaryFault property.
     * 
     * @return
     *     possible object is
     *     {@link SummaryFault }
     *     
     */
    public SummaryFault getSummaryFault() {
        return summaryFault;
    }

    /**
     * Sets the value of the summaryFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link SummaryFault }
     *     
     */
    public void setSummaryFault(SummaryFault value) {
        this.summaryFault = value;
    }

    /**
     * Gets the value of the summarySuccess property.
     * 
     * @return
     *     possible object is
     *     {@link SummarySuccess }
     *     
     */
    public SummarySuccess getSummarySuccess() {
        return summarySuccess;
    }

    /**
     * Sets the value of the summarySuccess property.
     * 
     * @param value
     *     allowed object is
     *     {@link SummarySuccess }
     *     
     */
    public void setSummarySuccess(SummarySuccess value) {
        this.summarySuccess = value;
    }

}
