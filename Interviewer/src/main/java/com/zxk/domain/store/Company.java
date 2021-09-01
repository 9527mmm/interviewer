package com.zxk.domain.store;

import com.zxk.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: interviewer
 * @description:
 * @author: zhaoxuekai
 * @GitHub: 9527mmm
 * @Create: 2021-08-28 09:52
 **/
public class Company implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 362498820763181265L;
    /**
     * 主键id
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 注册日期
     */
    private Date expirationDate;
    /**
     * 地址
     */
    private String address;
    /**
     * 营业执照编号
     */
    private String licenseId;
    /**
     * 法人
     */
    private String representative;
    /**
     * 电话
     */
    private String phone;
    /**
     * 规模
     */
    private String companySize;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 备注/描述
     */
    private String remarks;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 所在城市
     */
    private String city;

    public Company() {
    }

    public Company(String id, String name, Date expirationDate, String address, String licenseId, String representative,
                   String phone, String companySize, String industry, String remarks, Integer state, String city) {
        this.id = id;
        this.name = name;
        this.expirationDate = expirationDate;
        this.address = address;
        this.licenseId = licenseId;
        this.representative = representative;
        this.phone = phone;
        this.companySize = companySize;
        this.industry = industry;
        this.remarks = remarks;
        this.state = state;
        this.city = city;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getExpirationDateStr() {

        return DateUtil.date2Str(getExpirationDate());
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getRepresentative() {
        return representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Company company = (Company) o;
        return Objects.equals(getId(), company.getId()) &&
                Objects.equals(getName(), company.getName()) &&
                Objects.equals(getExpirationDate(), company.getExpirationDate()) &&
                Objects.equals(getAddress(), company.getAddress()) &&
                Objects.equals(getLicenseId(), company.getLicenseId()) &&
                Objects.equals(getRepresentative(), company.getRepresentative()) &&
                Objects.equals(getPhone(), company.getPhone()) &&
                Objects.equals(getCompanySize(), company.getCompanySize()) &&
                Objects.equals(getIndustry(), company.getIndustry()) &&
                Objects.equals(getRemarks(), company.getRemarks()) &&
                Objects.equals(getState(), company.getState()) &&
                Objects.equals(getCity(), company.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getExpirationDate(), getAddress(), getLicenseId(), getRepresentative(), getPhone(), getCompanySize(), getIndustry(), getRemarks(), getState(), getCity());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                ", address='" + address + '\'' +
                ", licenseId='" + licenseId + '\'' +
                ", representative='" + representative + '\'' +
                ", phone='" + phone + '\'' +
                ", companySize='" + companySize + '\'' +
                ", industry='" + industry + '\'' +
                ", remarks='" + remarks + '\'' +
                ", state=" + state +
                ", city='" + city + '\'' +
                '}';
    }
}
