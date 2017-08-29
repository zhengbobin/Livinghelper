package com.boby.livinghelper.app.example.entity;

import java.util.List;

/**
 * Example JSON 实体类
 *
 * @author zbobin.com
 * @date 2017/8/28.
 */

public class ExampleEntity {

    private int status;
    private String msg;

    /**
     * id : 1
     * kind_name : Android
     * kind_url : index.html
     */

    private List<KindEntity> kind;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<KindEntity> getKind() {
        return kind;
    }

    public void setKind(List<KindEntity> kind) {
        this.kind = kind;
    }

    public static class KindEntity {

        private String id;
        private String kind_name;
        private String kind_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getKind_name() {
            return kind_name;
        }

        public void setKind_name(String kind_name) {
            this.kind_name = kind_name;
        }

        public String getKind_url() {
            return kind_url;
        }

        public void setKind_url(String kind_url) {
            this.kind_url = kind_url;
        }

        @Override
        public String toString() {
            return "KindEntity{" +
                    "id='" + id + '\'' +
                    ", kind_name='" + kind_name + '\'' +
                    ", kind_url=" + kind_url +
                    '}';
        }
    }
}
