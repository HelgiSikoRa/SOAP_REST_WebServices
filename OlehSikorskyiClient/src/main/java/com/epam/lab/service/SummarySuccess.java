
package com.epam.lab.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for summarySuccess complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="summarySuccess">
 *   &lt;complexContent>
 *     &lt;extension base="{http://service.lab.epam.com/}summary">
 *       &lt;sequence>
 *         &lt;element name="successMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "summarySuccess", propOrder = {
    "successMessage"
})
public class SummarySuccess
    extends Summary
{

    @XmlElement(namespace = "")
    protected String successMessage;

    /**
     * Gets the value of the successMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuccessMessage() {
        return successMessage;
    }

    /**
     * Sets the value of the successMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuccessMessage(String value) {
        this.successMessage = value;
    }

}
