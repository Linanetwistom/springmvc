package com.store.webstore.entity;

import java.util.Date;

public class Order extends BaseEntity{

    private Integer oid;

    private Integer uid;

    private Integer aid;

    private String recvName;

    private String recvPhone;

    private String recvProvince;

    private String recvCity;

    private String recvArea;

    private String recvAddress;

    private Long totalPrice;

    private Integer status;
    
    private Date orderTime;

    private Date payTime;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getRecvName() {
        return recvName;
    }

    public void setRecvName(String recvName) {
        this.recvName = recvName;
    }

    public String getRecvPhone() {
        return recvPhone;
    }

    public void setRecvPhone(String recvPhone) {
        this.recvPhone = recvPhone;
    }

    public String getRecvProvince() {
        return recvProvince;
    }

    public void setRecvProvince(String recvProvince) {
        this.recvProvince = recvProvince;
    }

    public String getRecvCity() {
        return recvCity;
    }

    public void setRecvCity(String recvCity) {
        this.recvCity = recvCity;
    }

    public String getRecvArea() {
        return recvArea;
    }

    public void setRecvArea(String recvArea) {
        this.recvArea = recvArea;
    }

    public String getRecvAddress() {
        return recvAddress;
    }

    public void setRecvAddress(String recvAddress) {
        this.recvAddress = recvAddress;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public String toString() {
        return "Order [oid=" + oid + ", uid=" + uid + ", aid=" + aid + ", recvName=" + recvName + ", recvPhone="
                + recvPhone + ", recvProvince=" + recvProvince + ", recvCity=" + recvCity + ", recvArea=" + recvArea
                + ", recvAddress=" + recvAddress + ", totalPrice=" + totalPrice + ", status=" + status + ", orderTime="
                + orderTime + ", payTime=" + payTime + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((oid == null) ? 0 : oid.hashCode());
        result = prime * result + ((uid == null) ? 0 : uid.hashCode());
        result = prime * result + ((aid == null) ? 0 : aid.hashCode());
        result = prime * result + ((recvName == null) ? 0 : recvName.hashCode());
        result = prime * result + ((recvPhone == null) ? 0 : recvPhone.hashCode());
        result = prime * result + ((recvProvince == null) ? 0 : recvProvince.hashCode());
        result = prime * result + ((recvCity == null) ? 0 : recvCity.hashCode());
        result = prime * result + ((recvArea == null) ? 0 : recvArea.hashCode());
        result = prime * result + ((recvAddress == null) ? 0 : recvAddress.hashCode());
        result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
        result = prime * result + ((payTime == null) ? 0 : payTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (oid == null) {
            if (other.oid != null)
                return false;
        } else if (!oid.equals(other.oid))
            return false;
        if (uid == null) {
            if (other.uid != null)
                return false;
        } else if (!uid.equals(other.uid))
            return false;
        if (aid == null) {
            if (other.aid != null)
                return false;
        } else if (!aid.equals(other.aid))
            return false;
        if (recvName == null) {
            if (other.recvName != null)
                return false;
        } else if (!recvName.equals(other.recvName))
            return false;
        if (recvPhone == null) {
            if (other.recvPhone != null)
                return false;
        } else if (!recvPhone.equals(other.recvPhone))
            return false;
        if (recvProvince == null) {
            if (other.recvProvince != null)
                return false;
        } else if (!recvProvince.equals(other.recvProvince))
            return false;
        if (recvCity == null) {
            if (other.recvCity != null)
                return false;
        } else if (!recvCity.equals(other.recvCity))
            return false;
        if (recvArea == null) {
            if (other.recvArea != null)
                return false;
        } else if (!recvArea.equals(other.recvArea))
            return false;
        if (recvAddress == null) {
            if (other.recvAddress != null)
                return false;
        } else if (!recvAddress.equals(other.recvAddress))
            return false;
        if (totalPrice == null) {
            if (other.totalPrice != null)
                return false;
        } else if (!totalPrice.equals(other.totalPrice))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (orderTime == null) {
            if (other.orderTime != null)
                return false;
        } else if (!orderTime.equals(other.orderTime))
            return false;
        if (payTime == null) {
            if (other.payTime != null)
                return false;
        } else if (!payTime.equals(other.payTime))
            return false;
        return true;
    }

}