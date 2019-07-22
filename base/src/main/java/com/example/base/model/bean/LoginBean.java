package com.example.base.model.bean;

public class LoginBean {

    /**
     * result : {"departmentId":2,"departmentName":"骨科 ","id":7,"imagePic":"http://mobile.bwstudent.com/images/health/doctor/image_pic/2019-07-17/20190717142945.jpg","inauguralHospital":"清华大学附属医院","jiGuangPwd":"enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=","jobTitle":"主任","name":"于玖刚","reviewStatus":2,"sessionId":"715633458703597","userName":"F3tg4E2282391318","whetherHaveImagePic":1}
     * message : 登录成功
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
         * id : 7
         * imagePic : http://mobile.bwstudent.com/images/health/doctor/image_pic/2019-07-17/20190717142945.jpg
         * inauguralHospital : 清华大学附属医院
         * jiGuangPwd : enlOnObxlUlF74bz96CjPAF7DJv5WDYHfpyXPw9EkGiGK5VMYIm9+xblEVkY3jUw1SQ8R1pIZQV/ueLVisXlImCSkfHJ6BTbN39s+smgAYz4grYDwYAzFcH2c2ywv3HrP79oCMpGnR7oB4lQzePxzArW+4K17baeCzxyO6m7Epk=
         * jobTitle : 主任
         * name : 于玖刚
         * reviewStatus : 2
         * sessionId : 715633458703597
         * userName : F3tg4E2282391318
         * whetherHaveImagePic : 1
         */

        private int departmentId;
        private String departmentName;
        private int id;
        private String imagePic;
        private String inauguralHospital;
        private String jiGuangPwd;
        private String jobTitle;
        private String name;
        private int reviewStatus;
        private String sessionId;
        private String userName;
        private int whetherHaveImagePic;

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

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
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

        public int getReviewStatus() {
            return reviewStatus;
        }

        public void setReviewStatus(int reviewStatus) {
            this.reviewStatus = reviewStatus;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getWhetherHaveImagePic() {
            return whetherHaveImagePic;
        }

        public void setWhetherHaveImagePic(int whetherHaveImagePic) {
            this.whetherHaveImagePic = whetherHaveImagePic;
        }
    }
}
