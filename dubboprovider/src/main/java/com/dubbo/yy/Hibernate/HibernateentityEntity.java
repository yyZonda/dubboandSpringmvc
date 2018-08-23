package com.dubbo.yy.Hibernate;

@javax.persistence.Entity
@javax.persistence.Table(name = "hibernateentity", schema = "helloworld")
public class HibernateentityEntity {
    private int sid;
    private String name;
    private Double price;

    @javax.persistence.Id
    @javax.persistence.Column(name = "sid")
    public int getSid() {
        return sid;
    }
    public HibernateentityEntity(){}

    public HibernateentityEntity(int sid,String name,Double price){
        this.sid=sid;
        this.name=name;
        this.price=price;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HibernateentityEntity that = (HibernateentityEntity) o;

        if (sid != that.sid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
