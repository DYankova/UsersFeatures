package com.dyankova.userfeatures.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dilyanayankova on 12/13/17.
 */
@Entity
@Table(name = "USERS_FEATURES")
public class UserFeature implements Serializable {
    private long userId;
    private long featureId;
    private boolean enabled;
    private static final long serialVersionUID = 1L;

    public UserFeature(long userId, long featureId, boolean enabled) {
        this.userId = userId;
        this.featureId = featureId;
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
    @GeneratedValue
    @Column(name = "FEATURE_ID")
    public long getFeatureId() {
        return featureId;
    }
    public void setFeatureId(long featureId) {
        this.featureId = featureId;
    }

    @Column(name = "ENABLED")
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
