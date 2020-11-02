package org.vanderzui.cofeemachine.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.vanderzui.cofeemachine.entity.SupplyEntity;
import org.vanderzui.cofeemachine.entity.SupplyType;
import org.vanderzui.cofeemachine.exception.CoffeeMachineException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.vanderzui.cofeemachine.entity.SupplyType.COFFEE;
import static org.vanderzui.cofeemachine.entity.SupplyType.CUP;
import static org.vanderzui.cofeemachine.entity.SupplyType.MILK;
import static org.vanderzui.cofeemachine.entity.SupplyType.SUGAR;
import static org.vanderzui.cofeemachine.entity.SupplyType.WATER;

@Slf4j
@Service
public class SimpleSupplyService implements SupplyService {
    private static final List<SupplyEntity> supplies = new ArrayList<>();

    @PostConstruct
    private void postConstruct(){
        SupplyEntity coffee = SupplyEntity.builder()
                .count(15)
                .price(10)
                .type(COFFEE)
                .build();
        SupplyEntity milk = SupplyEntity.builder()
                .count(15)
                .price(10)
                .type(MILK)
                .build();
        SupplyEntity cup = SupplyEntity.builder()
                .count(15)
                .price(10)
                .type(CUP)
                .build();
        SupplyEntity sugar = SupplyEntity.builder()
                .count(15)
                .price(10)
                .type(SUGAR)
                .build();
        SupplyEntity water = SupplyEntity.builder()
                .count(15)
                .price(10)
                .type(WATER)
                .build();

        supplies.add(coffee);
        supplies.add(milk);
        supplies.add(cup);
        supplies.add(sugar);
        supplies.add(water);
    }

    @Override
    public List<SupplyEntity> fillSupply(Map<SupplyType, Integer> newSupplies) {
        supplies.stream()
                .filter(supplyEntity -> newSupplies.get(supplyEntity.getType()) != null)
                .forEach(supplyEntity -> updateSupplyCount(supplyEntity, newSupplies));
        log.info("Current supply is {}", supplies);

        return Collections.unmodifiableList(supplies);
    }

    private void updateSupplyCount(SupplyEntity supplyEntity, Map<SupplyType, Integer> newSupplies) {
        Integer addedQuantity = newSupplies.get(supplyEntity.getType());
        supplyEntity.setCount(supplyEntity.getCount() + addedQuantity);
    }

    @Override
    public void processRecipeSupplies(Map<SupplyType, Integer> requiredSupplies) {
        supplies.stream()
                .filter(supplyEntity -> requiredSupplies.get(supplyEntity.getType()) != null)
                .forEach(supplyEntity -> reduceSupplyCount(supplyEntity, requiredSupplies));
        log.info("Current supply is {}", supplies);
    }

    private void reduceSupplyCount(SupplyEntity supplyEntity, Map<SupplyType, Integer> requiredSupplies) {
        Integer requiredQuantity = requiredSupplies.get(supplyEntity.getType());
        int currentQuantity = supplyEntity.getCount();
        if (requiredQuantity < currentQuantity) {
            supplyEntity.setCount(currentQuantity - requiredQuantity);
        } else {
            throw new CoffeeMachineException(String.format("Insufficient supply %s", supplyEntity.getType()));
        }
    }
}
