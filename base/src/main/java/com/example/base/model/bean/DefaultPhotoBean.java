package com.example.base.model.bean;

import java.util.List;

public class DefaultPhotoBean {

    /**
     * result : [{"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image1.jpg"},{"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image2.jpg"},{"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image3.jpg"},{"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image4.jpg"},{"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image5.jpg"},{"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image6.jpg"},{"imagePic":"http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image7.jpg"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * imagePic : http://mobile.bwstudent.com/images/health/doctor/system_image_pic/system_image1.jpg
         */

        private String imagePic;

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }
    }
}
