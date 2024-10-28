package org.qpuc;

public enum PropertyID {
    DATE_OF_BIRTH("P569"),
    SEXE_OR_GENDER("P21"),
    COUNTRY_OF_CITIZENSHIP("P27");

    private final String propertyID;

    /**
     * Constructor of the enumeration
     * @param propertyID of the character
     */
    PropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    /**
     *
     * @return the entityID associated with the character
     */
    public String getPropertyID() {
        return propertyID;
    }
}
