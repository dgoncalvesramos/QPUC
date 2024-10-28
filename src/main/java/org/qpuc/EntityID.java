package org.qpuc;

import java.util.List;
import java.util.Random;

/**
 * EntityID enumération class, list all of the characters available in the game with their entityId in wikidata
 */

public enum EntityID {

    JACQUES_CHIRAC("Q2105"),
    BARACK_OBAMA("Q76"),
    DONALD_TRUMP("Q22686");

    private final String entityId;
    private static final List<EntityID> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    /**
     * Constructor of the enumeration
     * @param entityId of the character
     */
    EntityID(String entityId) {
        this.entityId = entityId;
    }

    /**
     *
     * @return the entityID associated with the character
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     *
     * @return a random entityID
     */
    public static EntityID randomEntityID()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static String fromEntityId(String entityId) {
        for (EntityID entityID : EntityID.values()) {
            if (entityID.getEntityId().equals(entityId)) {
                return entityID.name();
            }
        }
        throw new IllegalArgumentException("No character found with entityId: " + entityId);
    }
}