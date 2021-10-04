package io.sahil.f1dashboard.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Status {
    
    @Id
    private String statusId;
    private String status;

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

}
