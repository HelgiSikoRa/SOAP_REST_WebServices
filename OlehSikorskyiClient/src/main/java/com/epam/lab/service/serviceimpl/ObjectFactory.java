package com.epam.lab.service.serviceimpl;

import com.epam.lab.service.modelweb.Summary;
import com.epam.lab.service.modelweb.SummaryFault;
import com.epam.lab.service.modelweb.SummarySuccess;
import com.epam.lab.service.modelweb.SummaryWrapper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.lab.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SummarySuccess_QNAME = new QName("http://service.lab.epam.com/", "summarySuccess");
    private final static QName _SummaryFault_QNAME = new QName("http://service.lab.epam.com/", "summaryFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.lab.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SummaryFault }
     * 
     */
    public SummaryFault createSummaryFault() {
        return new SummaryFault();
    }

    /**
     * Create an instance of {@link SummarySuccess }
     * 
     */
    public SummarySuccess createSummarySuccess() {
        return new SummarySuccess();
    }

    /**
     * Create an instance of {@link Summary }
     * 
     */
    public Summary createSummary() {
        return new Summary();
    }

    /**
     * Create an instance of {@link SummaryWrapper }
     * 
     */
    public SummaryWrapper createSummaryWrapper() {
        return new SummaryWrapper();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SummarySuccess }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.lab.epam.com/", name = "summarySuccess")
    public JAXBElement<SummarySuccess> createSummarySuccess(SummarySuccess value) {
        return new JAXBElement<SummarySuccess>(_SummarySuccess_QNAME, SummarySuccess.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SummaryFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.lab.epam.com/", name = "summaryFault")
    public JAXBElement<SummaryFault> createSummaryFault(SummaryFault value) {
        return new JAXBElement<SummaryFault>(_SummaryFault_QNAME, SummaryFault.class, null, value);
    }

}
