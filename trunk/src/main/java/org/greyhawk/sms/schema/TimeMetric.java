//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.29 at 05:35:19 下午 CST 
//


package org.greyhawk.sms.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TimeMetric complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeMetric">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="metric" type="{http://www.chinatelecom.com.cn/schema/ctcc/common/v2_1}TimeMetrics"/>
 *         &lt;element name="units" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeMetric", propOrder = {
    "metric",
    "units"
})
public class TimeMetric {

    @XmlElement(required = true)
    protected TimeMetrics metric;
    protected int units;

    /**
     * Gets the value of the metric property.
     * 
     * @return
     *     possible object is
     *     {@link TimeMetrics }
     *     
     */
    public TimeMetrics getMetric() {
        return metric;
    }

    /**
     * Sets the value of the metric property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeMetrics }
     *     
     */
    public void setMetric(TimeMetrics value) {
        this.metric = value;
    }

    /**
     * Gets the value of the units property.
     * 
     */
    public int getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     */
    public void setUnits(int value) {
        this.units = value;
    }

}
