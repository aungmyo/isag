//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-833 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.06.18 at 10:29:05 下午 CST 
//


package org.greyhawk.sms.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliveryStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeliveryStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DeliveredToNetwork"/>
 *     &lt;enumeration value="DeliveryUncertain"/>
 *     &lt;enumeration value="DeliveryImpossible"/>
 *     &lt;enumeration value="MessageWaiting"/>
 *     &lt;enumeration value="DeliveredToTerminal"/>
 *     &lt;enumeration value="DeliveryNotificationNotSupported"/>
 *     &lt;enumeration value="AuthPriceFailed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeliveryStatus", namespace = "http://www.chinatelecom.com.cn/schema/ctcc/sms/v2_1")
@XmlEnum
public enum DeliveryStatus {

    @XmlEnumValue("DeliveredToNetwork")
    DELIVERED_TO_NETWORK("DeliveredToNetwork"),
    @XmlEnumValue("DeliveryUncertain")
    DELIVERY_UNCERTAIN("DeliveryUncertain"),
    @XmlEnumValue("DeliveryImpossible")
    DELIVERY_IMPOSSIBLE("DeliveryImpossible"),
    @XmlEnumValue("MessageWaiting")
    MESSAGE_WAITING("MessageWaiting"),
    @XmlEnumValue("DeliveredToTerminal")
    DELIVERED_TO_TERMINAL("DeliveredToTerminal"),
    @XmlEnumValue("DeliveryNotificationNotSupported")
    DELIVERY_NOTIFICATION_NOT_SUPPORTED("DeliveryNotificationNotSupported"),
    @XmlEnumValue("AuthPriceFailed")
    AUTH_PRICE_FAILED("AuthPriceFailed");
    private final String value;

    DeliveryStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeliveryStatus fromValue(String v) {
        for (DeliveryStatus c: DeliveryStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
