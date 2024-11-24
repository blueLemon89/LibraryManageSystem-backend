package lm.libraryManagementSystem.model;

public class CommonEntity {
    private String createdBy;
    private String createdOn;
    private String lst_updtBy;
    private String lst_udptOn;
    private String deleteFlag;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getLst_updtBy() {
        return lst_updtBy;
    }

    public void setLst_updtBy(String lst_updtBy) {
        this.lst_updtBy = lst_updtBy;
    }

    public String getLst_udptOn() {
        return lst_udptOn;
    }

    public void setLst_udptOn(String lst_udptOn) {
        this.lst_udptOn = lst_udptOn;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
