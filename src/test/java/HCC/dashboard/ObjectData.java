package HCC.dashboard;

import java.util.Date;

public class ObjectData {
    private Date createdAt;
    private Integer createdBy;
    private Date updatedAt;
    private Integer updatedBy;
    private Date deletedAt;
    private Integer deletedBy;
    private Integer id;
    private String fullName;
    private String alias;
    private String code;
    private String email;
    private String dpURL;
    private String lineManagerCode;
    private String department;
    private String designation;
    private String resourceType;
    private String cellNumber;
    private String workingCity;
    private Integer totalExperience;
    private String lineManagerName;
    private String lineManagerEmail;
    private String isLineManager;
    private Boolean active;
    private Boolean deleted;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDpURL() {
        return dpURL;
    }

    public void setDpURL(String dpURL) {
        this.dpURL = dpURL;
    }

    public String getLineManagerCode() {
        return lineManagerCode;
    }

    public void setLineManagerCode(String lineManagerCode) {
        this.lineManagerCode = lineManagerCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getWorkingCity() {
        return workingCity;
    }

    public void setWorkingCity(String workingCity) {
        this.workingCity = workingCity;
    }

    public Integer getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Integer totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getLineManagerName() {
        return lineManagerName;
    }

    public void setLineManagerName(String lineManagerName) {
        this.lineManagerName = lineManagerName;
    }

    public String getLineManagerEmail() {
        return lineManagerEmail;
    }

    public void setLineManagerEmail(String lineManagerEmail) {
        this.lineManagerEmail = lineManagerEmail;
    }

    public String getLineManager() {
        return isLineManager;
    }

    public void setLineManager(Boolean lineManager) {
        isLineManager = String.valueOf(lineManager);
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
