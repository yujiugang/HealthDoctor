package com.example.base.model.bean;

public class MineBean {

    /**
     * result : {"departmentId":2,"departmentName":"骨科 ","goodField":"埃里克森都没了卡萨达姆","id":7,"imagePic":"http://mobile.bwstudent.com/images/health/doctor/image_pic/2019-07-17/20190717142945.jpg","inauguralHospital":"清华大学附属医院","jobTitle":"主任","name":"于玖刚","personalProfile":"刷卡单年卡十多年"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * departmentId : 2
         * departmentName : 骨科
         * goodField : 埃里克森都没了卡萨达姆
         * id : 7
         * imagePic : http://mobile.bwstudent.com/images/health/doctor/image_pic/2019-07-17/20190717142945.jpg
         * inauguralHospital : 清华大学附属医院
         * jobTitle : 主任
         * name : 于玖刚
         * personalProfile : 刷卡单年卡十多年
         */

        private int departmentId;
        private String departmentName;
        private String goodField;
        private int id;
        private String imagePic;
        private String inauguralHospital;
        private String jobTitle;
        private String name;
        private String personalProfile;

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getGoodField() {
            return goodField;
        }

        public void setGoodField(String goodField) {
            this.goodField = goodField;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }

        public String getInauguralHospital() {
            return inauguralHospital;
        }

        public void setInauguralHospital(String inauguralHospital) {
            this.inauguralHospital = inauguralHospital;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
            this.personalProfile = personalProfile;
        }
    }
}
