package com.hci.test.domain.request;

import java.io.Serializable;
import lombok.Data;

@Data
public class PatchDetailRequest implements Serializable {
  private String moduleName;
  private Integer moduleOrder;
}
