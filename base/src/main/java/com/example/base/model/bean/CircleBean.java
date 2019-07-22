package com.example.base.model.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：liudada<p>
 * <p>创建时间：2019/7/11<p>
 */
public class CircleBean {

    /**
     * result : [{"amount":10,"detail":"详情","releaseTime":1556985600000,"sickCircleId":7,"title":"急寻：面神经炎的治疗方法"},{"amount":10,"detail":"详情","releaseTime":1556985600000,"sickCircleId":8,"title":"急寻：面神经炎的治疗方法"},{"amount":0,"detail":"详情","releaseTime":1555948800000,"sickCircleId":4,"title":"急寻：面神经炎的治疗方法"}]
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
         * amount : 10
         * detail : 详情
         * releaseTime : 1556985600000
         * sickCircleId : 7
         * title : 急寻：面神经炎的治疗方法
         */

        private int amount;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
