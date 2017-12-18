package com.dyankova.userfeatures.model;

import javax.persistence.*;

/**
 * Created by dilyanayankova on 12/8/17.
 */
@Entity
@Table(name = "FEATURES")
public class Feature {
    private Long id;
    private String name;
    private boolean enabled;

    public Feature() {}

    public Feature(long id, String name, boolean enabled) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ENABLED")
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Feature feature = (Feature) o;

        return name != null ? name.equals(feature.name) : feature.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

