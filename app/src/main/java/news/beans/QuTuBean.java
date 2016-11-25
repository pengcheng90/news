package news.beans;

import java.util.List;

/**
 * Created by baobiao on 2016/11/19.
 */

public class QuTuBean {
    /**
     * reason : success
     * result : [{"content":"打开冰箱，吓尿了","hashId":"7B5C67EA53E7BAE6F183650EE3551729","unixtime":"1424986950","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/7B5C67EA53E7BAE6F183650EE3551729.jpg"},{"content":"新手护士 好揪心\u2026\u2026","hashId":"147898D0A31EB771D1EA5A6B50FF479A","unixtime":"1424988147","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/147898D0A31EB771D1EA5A6B50FF479A.gif"},{"content":"在卫生间看到的-醉了-醉了！","hashId":"6B5F1906703209BD4D39E9AABBF03448","unixtime":"1424988747","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/6B5F1906703209BD4D39E9AABBF03448.jpg"},{"content":"鸡都能坐上地铁啦！","hashId":"0A5CCCE65552257899523062312D8732","unixtime":"1424989334","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/0A5CCCE65552257899523062312D8732.png"},{"content":"外星生物惊现地球\u2026\u2026战斗力爆表","hashId":"783B915FDB744FD40978034249CF5F13","unixtime":"1424989935","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/783B915FDB744FD40978034249CF5F13.gif"},{"content":"啊偶，注意下面的文字","hashId":"09553B8F32543958A7E25286570D4D05","unixtime":"1424991132","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/09553B8F32543958A7E25286570D4D05.jpg"},{"content":"为了咱们的下一代，必须铲除这小子！","hashId":"7868D24EC307798343F76C6F24E31E67","unixtime":"1424991734","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/7868D24EC307798343F76C6F24E31E67.jpg"},{"content":"感觉是没按空格，直接就跑出去了","hashId":"551A4CB54605FD80ABFC7958946BAE8C","unixtime":"1424992339","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/551A4CB54605FD80ABFC7958946BAE8C.gif"},{"content":"这么多年米其林也该有个儿子了","hashId":"4E5F30522C03DD71C0D309BE9AB33573","unixtime":"1424992357","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/4E5F30522C03DD71C0D309BE9AB33573.jpg"},{"content":"这个是技术还是追尾","hashId":"D11B1FB8AC04861AF10743AA3038765D","unixtime":"1424992357","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/D11B1FB8AC04861AF10743AA3038765D.jpg"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 打开冰箱，吓尿了
         * hashId : 7B5C67EA53E7BAE6F183650EE3551729
         * unixtime : 1424986950
         * url : http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201502/27/7B5C67EA53E7BAE6F183650EE3551729.jpg
         */

        private String content;
        private String hashId;
        private String unixtime;
        private String url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
