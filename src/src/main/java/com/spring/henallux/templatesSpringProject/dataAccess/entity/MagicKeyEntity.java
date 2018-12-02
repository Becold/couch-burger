package com.spring.henallux.templatesSpringProject.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="magickey")
public class MagicKeyEntity {
    @Id
    @Column
    private String magicvalue;

    public MagicKeyEntity() { }

    public String getMagicvalue() {
        return magicvalue;
    }

    public void setMagicvalue(String magicvalue) {
        this.magicvalue = magicvalue;
    }
}
