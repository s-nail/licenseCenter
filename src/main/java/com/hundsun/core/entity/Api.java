package com.hundsun.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
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
@XStreamAlias("api")
public class Api {
    @XStreamAlias("api_name")
    private String apiName;
    @XStreamAlias("function_id")
    private String functionId;
    @XStreamAlias("begin_date")
    private String beginDate;
    @XStreamAlias("expire_date")
    private String expireDate;
    @XStreamAlias("flow_control")
    private String flowControl;
    @XStreamAlias("extend_field_set")
    private List<ExtendField> extendFieldSet;
}
