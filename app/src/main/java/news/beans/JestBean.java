package news.beans;

import java.util.List;

/**
 * Created by baobiao on 2016/11/19.
 */

public class JestBean {
    /**
     * reason : success
     * result : [{"content":"小明犯了错，妈妈说：\u201c知道哪里做错了没？\u201d小明说：\u201c知道。\u201d妈妈\u201c啪\u201d的一巴掌 ，说：\u201c知道还犯。\u201d妈妈又说：\u201c知道哪里做错了没？\u201d小明说：\u201c不知道。\u201d妈妈\u201c啪\u201d的一巴掌，说：\u201c不知道就让你知道。\u201d ，妈妈再一次说：\u201c知道哪里做错了没？\u201d小明不吭声，妈妈\u201c啪\u201d的一巴掌，说：\u201c让你不说话。\u201d","hashId":"640F204702EDA076485F7ABFE868FA90","unixtime":"1432334533"},{"content":"夏天到了。办公室女同事。都穿起了短裙。我想说的是。干嘛穿安全裤呢。办公室不安全吗？人与人最基本的信任都哪去了？","hashId":"0940EB441454904E204CBDEB17447E09","unixtime":"1432335174"},{"content":"父亲对女儿的男友严厉地说：\u201c你每天只带我女儿看电影，就不能做点别的事？\u201d年轻人又惊又喜：\u201c您是说可以做其它的事儿了吗？\u201d","hashId":"2279239CCA85C91CC08FA5B1FCC8C5E8","unixtime":"1432336334"},{"content":"女同事跟我说肚子饿了，让我买点东西给她吃。我也没啥事，就问她吃啥，她说吃两个鸡蛋一个火腿肠。我拎着一包吃的到她家，她一开门，我就送上吃的。她啪的一声把门关上了。她，不爱吃？次日，我饿了，在家懒得动，就让昨天的女同事买点东西给我吃。她问我吃啥，我想了想，让她帮我带两杯鲜奶和一份木耳炒饭，结果她空着手来我家，我一怒之下把门一摔。真是，啥都没买还敢来我家！！！","hashId":"735A0D2A1897773516BCD003EBCB49C1","unixtime":"1432337548"},{"content":"乱草丛中一老贼， 单枪匹马提俩锤。 \r\n不吃不喝还真肥， 不晒太阳还真黑。\r\n对面半山有个鬼， 披头散发咧着嘴。\r\n一口吞下这老贼， 口外就剩两个锤！\r\n老贼挣扎几分钟， 不退反倒往前冲。\r\n进进出出好几回， 毛兵毛将来解围。\r\n为首两颗黑地雷， 猛似张飞和李逵。\r\n恶鬼还是不撒嘴， 一个劲的流口水。\r\n后悔当初没长牙， 要不肯定把你拿。\r\n老贼越来个越大， 门口地雷要爆炸。\r\n恶鬼心里有点怕， 难道这厮开了挂。\r\n老贼这时有点烦， 知道自己非猛男。\r\n高喊这事不算完， 临走不忘吐口痰。","hashId":"bc43eca411fdffc911ac9bb209750abc","unixtime":"1432337631"},{"content":"一个胖姑娘，因为没有信心而不敢坐电梯，所以每天坚持走楼梯上班。于是，经过近三个月的努力，她因为经常迟到被开除了。","hashId":"4c89589f11aee7ff48ade51d8efaa83f","unixtime":"1432337631"},{"content":"有一天，小名问老汪：你知道问什么苍蝇到现在还没有灭绝？ 老汪说：是因为环境越来越差吗？ 小名：NO ，是因为人类还没有发现它的食用价值。","hashId":"5a6ba00ecbc77191942a9bb6170a18d6","unixtime":"1432337631"},{"content":"今天出去买衣服，看到一店门口的大横幅上面写着，大声喊钓 鱼 岛是中国的打九折，大声喊日 本是中国的打八折，看着那漂亮的老板娘，本着段子的精神说，如果大声喊老板娘是我的打几折，老板娘悠悠的说，打骨折\u2026\u2026","hashId":"f7e46994e4b6e4409b6cabfe00e1f1e3","unixtime":"1432337631"},{"content":"今天早上没起床收到一条短信，\u201c妈的老子今天还活着\u201d！这把我给迷茫的，忽然想起上小学时欺负一同学，骂他\u201c你特么绝对活不过二十岁\u201d这小子还真记仇！","hashId":"b83b6dc64458696a0f134c30c5d993f6","unixtime":"1432337631"},{"content":"男生暗恋女生多年。女对男：\u201c我十七岁那年，高考落榜，当时是你陪在我身边，二十二岁那年，因为考试作弊，没拿到毕业证你也陪在我身边。二十四岁那年因为车祸重伤，也是你在医院陪着我！\u201d女接着说：\u201c今天我失恋了，还是你在我身边陪着我。我终于明白了，你就是一扫把星","hashId":"9818dbc8ebedd8a0332275c5b39a2c13","unixtime":"1432337631"}]
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
         * content : 小明犯了错，妈妈说：“知道哪里做错了没？”小明说：“知道。”妈妈“啪”的一巴掌 ，说：“知道还犯。”妈妈又说：“知道哪里做错了没？”小明说：“不知道。”妈妈“啪”的一巴掌，说：“不知道就让你知道。” ，妈妈再一次说：“知道哪里做错了没？”小明不吭声，妈妈“啪”的一巴掌，说：“让你不说话。”
         * hashId : 640F204702EDA076485F7ABFE868FA90
         * unixtime : 1432334533
         */

        private String content;
        private String hashId;
        private String unixtime;

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
    }
}
