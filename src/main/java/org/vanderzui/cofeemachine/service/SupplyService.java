package org.vanderzui.cofeemachine.service;

import org.vanderzui.cofeemachine.entity.SupplyEntity;
import org.vanderzui.cofeemachine.entity.SupplyType;

import java.util.List;
import java.util.Map;

public interface SupplyService {

    List<SupplyEntity> fillSupply(Map<SupplyType, Integer> supplies);

    void processRecipeSupplies(Map<SupplyType, Integer> requiredSupplies);
}
