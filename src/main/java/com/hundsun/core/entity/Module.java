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
@XStreamAlias("module")
public class Module {
    /**
     *
     */
    @XStreamAlias("module_name")
    private String moduleName;
    @XStreamAlias("module_no")
    private String moduleNo;
    @XStreamAlias("begin_date")
    private String beginDate;
    @XStreamAlias("expire_date")
    private String expireDate;
    @XStreamAlias("max_connections")
    private Integer maxConnections;
    @XStreamAlias("flow_control")
    private String flowControl;
    @XStreamAlias("extend_field_set")
    private List<ExtendField> extendFieldSet;
    @XStreamAlias("api_set")
    private List<Api> apiSet;
}
