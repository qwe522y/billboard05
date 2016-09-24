package com.sotas.billboard05.entity;

import javax.persistence.*;
import java.security.acl.Owner;
import java.util.Date;

@Entity
@Table(name = "billboard_access")
public class BillboardAccess {
    @Id @GeneratedValue
    private int id;
    private int ownerId;
    private int billboardId;

    @Version
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
}
