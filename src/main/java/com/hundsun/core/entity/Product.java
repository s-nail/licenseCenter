package com.hundsun.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.*;

import java.util.List;

/**
 * Created by jiayq24996 on 2019-06-04
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("product")
public class Product {
    @XStreamAlias("licence_no")
    private String licenceNo;
    @XStreamAlias("licence_type")
    private String licenceType;
    @XStreamAlias("user_info")
    private String userInfo;
    @XStreamAlias("product_info")
    private String productInfo;
    @XStreamAlias("begin_date")
    private String beginDate;
    @XStreamAlias("expire_date")
    private String expireDate;
    @XStreamAlias("flow_control")
    private String flowControl;
    @XStreamAlias("extend_field_set")
    private List<ExtendField> extendFieldSet;
    @XStreamAsAttribute
    private List<Module> modules;
    @XStreamAlias("old_model")
    private byte[] oldModel;
}
