package org.qpuc;

import java.util.List;
import java.util.Objects;

import static org.qpuc.PropertyID.*;

public class Character {
    EntityID entityID = EntityID.randomEntityID() ;
    String name = EntityID.fromEntityId(entityID.getEntityId());
    String date_of_birth ;
    String sexe_or_gender;
    String country_of_citizenship;
    List<String> position_held;

    public Character(){
        this.date_of_birth = DateFormatterService.formatBirthDate(Objects.requireNonNull(WikidataQuery.executeSimpleQuery(this.entityID.getEntityId(), DATE_OF_BIRTH.getPropertyID())));
        this.sexe_or_gender = WikidataQuery.executeSimpleQuery(this.entityID.getEntityId(), SEXE_OR_GENDER.getPropertyID());
        this.country_of_citizenship = WikidataQuery.executeSimpleQuery(this.entityID.getEntityId(), COUNTRY_OF_CITIZENSHIP.getPropertyID());
        this.position_held = WikidataQuery.excuteComplexQuery(this.entityID.getEntityId(), POSITION_HELD.getPropertyID());
    }

    public EntityID getEntityID() {
        return entityID;
    }

    public String getName() {
        return name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getSexe_or_gender() {
        return sexe_or_gender;
    }

    public String getCountry_of_citizenship() {
        return country_of_citizenship;
    }

}
