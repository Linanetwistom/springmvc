package com.store.webstore.vo;

import java.io.Serializable;

public class CartVo implements Serializable {

    private Integer cid;

    private Integer uid;

    private Integer pid;

    private Long price;

    private Integer num;

    private String title;

    private String image;

    private Long realPrice;
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cid == null) ? 0 : cid.hashCode());
        result = prime * result + ((uid == null) ? 0 : uid.hashCode());
        result = prime * result + ((pid == null) ? 0 : pid.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((num == null) ? 0 : num.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result + ((realPrice == null) ? 0 : realPrice.hashCode());
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
        CartVo other = (CartVo) obj;
        if (cid == null) {
            if (other.cid != null)
                return false;
        } else if (!cid.equals(other.cid))
            return false;
        if (uid == null) {
            if (other.uid != null)
                return false;
        } else if (!uid.equals(other.uid))
            return false;
        if (pid == null) {
            if (other.pid != null)
                return false;
        } else if (!pid.equals(other.pid))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (num == null) {
            if (other.num != null)
                return false;
        } else if (!num.equals(other.num))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (realPrice == null) {
            if (other.realPrice != null)
                return false;
        } else if (!realPrice.equals(other.realPrice))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CartVo [cid=" + cid + ", uid=" + uid + ", pid=" + pid + ", price=" + price + ", num=" + num + ", title="
                + title + ", image=" + image + ", realPrice=" + realPrice + "]";
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
    }



}