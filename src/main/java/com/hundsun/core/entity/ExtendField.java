package com.hundsun.core.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;

/**
 * Created by jiayq24996 on 2019-06-04
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("extend_field")
public class ExtendField {
    @XStreamAlias("validate_field")
    private String validateField;
    @XStreamAlias("function_name")
    private String functionName;
    @XStreamAlias("lib_name")
    private String libName;
}
