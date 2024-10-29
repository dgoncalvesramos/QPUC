package org.qpuc;

import java.util.List;
import java.util.Objects;

import static org.qpuc.PropertyID.*;

public class Character {
    private EntityID entityID = EntityID.randomEntityID() ;
    private String name = EntityID.fromEntityId(entityID.getEntityId());
    private String date_of_birth ;
    private List<String> sexe_or_gender;
    private List<String> country_of_citizenship;
    private List<String> position_held;
    private List<String> spouce;
    private String date_of_death;
    private List<String> convicted_of;
    private List<String> nickname ;
    private List<String> father;
    private List<String> occupation;

    public Character(){
        this.date_of_birth = DateFormatterService.formatBirthDate(Objects.requireNonNull(WikidataQuery.executeSimpleQuery(this.entityID.getEntityId(), DATE_OF_BIRTH.getPropertyID())));
        this.sexe_or_gender = WikidataQuery.excuteComplexQuery(this.entityID.getEntityId(), SEXE_OR_GENDER.getPropertyID(), "sexe_or_gender");
        this.country_of_citizenship = WikidataQuery.excuteComplexQuery(this.entityID.getEntityId(), COUNTRY_OF_CITIZENSHIP.getPropertyID(),"country_of_citizenship");
        this.position_held = WikidataQuery.excuteComplexQuery(this.entityID.getEntityId(), POSITION_HELD.getPropertyID(),"position");
        this.spouce = WikidataQuery.excuteComplexQuery(this.entityID.getEntityId(), SPOUSE.getPropertyID(),"spouce");
        String date_of_death_not_formated = WikidataQuery.executeSimpleQuery(this.entityID.getEntityId(), DATE_OF_DEATH.getPropertyID());
        if(date_of_death_not_formated != null)
            this.date_of_death = DateFormatterService.formatBirthDate(date_of_death_not_formated);
        this.convicted_of = WikidataQuery.excuteComplexQuery(this.entityID.getEntityId(), CONVICTED_OF.getPropertyID(),"convicted_of");
        this.nickname = WikidataQuery.excuteComplexQuery(this.entityID.getEntityId(), NICKNAME.getPropertyID(),"nickname");
        this.father = WikidataQuery.excuteComplexQuery(this.entityID.getEntityId(), FATHER.getPropertyID(),"father");
        this.occupation = WikidataQuery.excuteComplexQuery(this.entityID.getEntityId(), OCCUPATION.getPropertyID(),"occupation");
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

    public List<String> getSexe_or_gender() {
        return sexe_or_gender;
    }

    public List<String> getCountry_of_citizenship() {
        return country_of_citizenship;
    }

    public List<String> getPosition_held() {
        return position_held;
    }

    public List<String> getSpouce() {
        return spouce;
    }

    public String getDate_of_death() {
        return date_of_death;
    }

    public List<String> getConvicted_of() {
        return convicted_of;
    }

    public List<String> getNickname() {
        return nickname;
    }

    public List<String> getFather() {
        return father;
    }

    public List<String> getOccupation() {
        return occupation;
    }
}
