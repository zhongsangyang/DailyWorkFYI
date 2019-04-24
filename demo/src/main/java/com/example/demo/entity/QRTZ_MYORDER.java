package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class QRTZ_MYORDER implements Serializable {
    private Integer recodid;

    private String tosomeone;

    private String messagedescription;

    private Date createtime;

    private String mailaccount;

    private static final long serialVersionUID = 1L;

    public Integer getRecodid() {
        return recodid;
    }

    public void setRecodid(Integer recodid) {
        this.recodid = recodid;
    }

    public String getTosomeone() {
        return tosomeone;
    }

    public void setTosomeone(String tosomeone) {
        this.tosomeone = tosomeone == null ? null : tosomeone.trim();
    }

    public String getMessagedescription() {
        return messagedescription;
    }

    public void setMessagedescription(String messagedescription) {
        this.messagedescription = messagedescription == null ? null : messagedescription.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMailaccount() {
        return mailaccount;
    }

    public void setMailaccount(String mailaccount) {
        this.mailaccount = mailaccount == null ? null : mailaccount.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recodid=").append(recodid);
        sb.append(", tosomeone=").append(tosomeone);
        sb.append(", messagedescription=").append(messagedescription);
        sb.append(", createtime=").append(createtime);
        sb.append(", mailaccount=").append(mailaccount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}