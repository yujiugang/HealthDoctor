package com.example.base.model.bean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：liudada<p>
 * <p>创建时间：2019/7/11<p>
 */
public class CircleTitleBean {

    /**
     * result : [{"departmentName":"内科","id":7,"pic":"http://172.17.8.100/images/health/department_pic/nk.jpg","rank":1},{"departmentName":"眼科","id":4,"pic":"http://172.17.8.100/images/health/department_pic/yk.jpg","rank":2},{"departmentName":"骨科","id":2,"pic":"http://172.17.8.100/images/health/department_pic/gk.jpg","rank":3},{"departmentName":"小儿科","id":5,"pic":"http://172.17.8.100/images/health/department_pic/xek.jpg","rank":4},{"departmentName":"传染病科","id":12,"pic":"http://172.17.8.100/images/health/department_pic/crbk.jpg","rank":5},{"departmentName":"皮肤科","id":9,"pic":"http://172.17.8.100/images/health/department_pic/pfk.jpg","rank":6},{"departmentName":"耳鼻喉科","id":6,"pic":"http://172.17.8.100/images/health/department_pic/ebhk.jpg","rank":7},{"departmentName":"精神病科","id":11,"pic":"http://172.17.8.100/images/health/department_pic/jsbk.jpg","rank":8}]
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
         * departmentName : 内科
         * id : 7
         * pic : http://172.17.8.100/images/health/department_pic/nk.jpg
         * rank : 1
         */

        private String departmentName;
        private int id;
        private String pic;
        private int rank;
        private boolean checked;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
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

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}
