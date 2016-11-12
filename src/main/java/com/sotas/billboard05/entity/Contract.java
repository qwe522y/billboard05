package com.sotas.billboard05.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contracts")
public class Contract {
    public static class Status{
        public final static int NEW = 1;
        public final static int ACCEPTED = 2;
        public final static int REJECTED = 3;
    }
    @Id @GeneratedValue
    private int id;
    @Column(name = "timetable_id")
    private int timetableId;
    @Column(name = "client_phone")
    private String clientPhone;
    @Column(name = "agent_comment")
    private String agentComment;
    @Column(name = "client_comment")
    private String clientComment;
    private int status = Status.NEW;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private Date updateDate;

    public Contract(int timetableId, String clientPhone, String clientComment) {
        this.timetableId = timetableId;
        this.clientPhone = clientPhone;
        this.clientComment = clientComment;
    }

    public Contract() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contract)) return false;

        Contract contract = (Contract) o;

        if (id != contract.id) return false;
        if (timetableId != contract.timetableId) return false;
        if (status != contract.status) return false;
        if (clientPhone != null ? !clientPhone.equals(contract.clientPhone) : contract.clientPhone != null)
            return false;
        if (agentComment != null ? !agentComment.equals(contract.agentComment) : contract.agentComment != null)
            return false;
        if (clientComment != null ? !clientComment.equals(contract.clientComment) : contract.clientComment != null)
            return false;
        if (createDate != null ? !createDate.equals(contract.createDate) : contract.createDate != null) return false;
        return updateDate != null ? updateDate.equals(contract.updateDate) : contract.updateDate == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + timetableId;
        result = 31 * result + (clientPhone != null ? clientPhone.hashCode() : 0);
        result = 31 * result + (agentComment != null ? agentComment.hashCode() : 0);
        result = 31 * result + (clientComment != null ? clientComment.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", timetableId=" + timetableId +
                ", clientPhone='" + clientPhone + '\'' +
                ", agentComment='" + agentComment + '\'' +
                ", clientComment='" + clientComment + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(int timetableId) {
        this.timetableId = timetableId;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getAgentComment() {
        return agentComment;
    }

    public void setAgentComment(String agentComment) {
        this.agentComment = agentComment;
    }

    public String getClientComment() {
        return clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
