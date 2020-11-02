package org.vanderzui.cofeemachine.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SupplyEntity {
    private int count;
    private int price;
    private SupplyType type;
}
