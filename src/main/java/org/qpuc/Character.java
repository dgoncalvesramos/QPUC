package org.qpuc;

public class Character {
    EntityID entityID = EntityID.randomEntityID() ;
    String name = EntityID.fromEntityId(entityID.getEntityId());
}
