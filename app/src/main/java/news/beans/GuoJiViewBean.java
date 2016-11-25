package news.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baobiao on 2016/11/18.
 */

public class GuoJiViewBean {
    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"title":"美国华人超市出售罗非鱼 致一女子染罕见病菌","date":"2016-11-18 16:48","category":"国际","author_name":"中国侨网","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20161118/20161118164809_b8133aec47c85d2fd8a54cd2a48afc69_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118164809409.html?qid=juheshuju","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20161118/20161118164809_b8133aec47c85d2fd8a54cd2a48afc69_1_mwpl_05500201.jpeg"},{"title":"外媒评习近平出访：中国继续推进自贸协定是众望所归","date":"2016-11-18 16:46","category":"国际","author_name":"国际在线","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161118/20161118164642_ef4532222cb9fcf82ee57ab832e97d82_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118164642349.html?qid=juheshuju","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161118/20161118164642_ef4532222cb9fcf82ee57ab832e97d82_1_mwpl_05500201.jpeg"},{"title":"谷歌地图出境申请再次被否　韩国方面称影响国家安保","date":"2016-11-18 16:44","category":"国际","author_name":"环球网","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161118/20161118164455_878276eebe41ca5785e8132b43430762_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118164455467.html?qid=juheshuju","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161118/20161118164455_878276eebe41ca5785e8132b43430762_1_mwpl_05500201.jpeg"},{"title":"\u201c铭泰之星\u201d闪亮FIA F4中国锦标赛","date":"2016-11-18 16:41","category":"国际","author_name":"新浪体育","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20161118/20161118164113_19268bc150f72be0ac52faa6ffc03b5c_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118164113572.html?qid=juheshuju","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20161118/20161118164113_19268bc150f72be0ac52faa6ffc03b5c_1_mwpl_05500201.jpeg"},{"title":"特朗普\u201c面试\u201d忙","date":"2016-11-18 16:32","category":"国际","author_name":"新华网","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20161118/20161118163231_b7423f77572381e6a76556e2c66a365f_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118163231638.html?qid=juheshuju","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20161118/20161118163231_b7423f77572381e6a76556e2c66a365f_1_mwpl_05500201.jpeg"},{"title":"磁条卡安全性差 日本成银行卡盗刷\u201c重灾区\u201d","date":"2016-11-18 16:25","category":"国际","author_name":"新华社","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20161118/20161118162556_35dcc6bb2bb626039b8eb5774032fce2_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118162556982.html?qid=juheshuju","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20161118/20161118162556_35dcc6bb2bb626039b8eb5774032fce2_1_mwpl_05500201.jpeg"},{"title":"跨越种族的友谊！凶猛的北极熊竟然也会\u201c摸头杀\u201d 而对象居然是\u2026\u2026","date":"2016-11-18 16:25","category":"国际","author_name":"看看新闻Knews","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161118/20161118162547_a94d5c36f8e140bb4766e3c8a4c7434f_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118162547812.html?qid=juheshuju","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161118/20161118162547_a94d5c36f8e140bb4766e3c8a4c7434f_1_mwpl_05500201.jpeg"},{"title":"新西兰失踪华裔女生已找到 与世隔绝不知地震","date":"2016-11-18 16:20","category":"国际","author_name":"中国侨网","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20161118/20161118162037_ed1378175932414f4718ae4571a8d92f_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118162037029.html?qid=juheshuju","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20161118/20161118162037_ed1378175932414f4718ae4571a8d92f_1_mwpl_05500201.jpeg"},{"title":"看到男孩破皮红肿的双脚，这对夫妻马上下定决心做了特别选择","date":"2016-11-18 16:16","category":"国际","author_name":"辣妈传","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20161118/20161118161639_b6fea2f86d7f8357481c5d7b0f5f7c88_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118161639320.html?qid=juheshuju","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20161118/20161118161639_b6fea2f86d7f8357481c5d7b0f5f7c88_1_mwpl_05500201.jpeg"},{"title":"为了\"那个\"，中国人和美国人吵起来，新加坡人劝架","date":"2016-11-18 16:14","category":"国际","author_name":"新加坡眼","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20161118/20161118161443_cc42f487ffd14ea1f0764e9f7f5f0a0a_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118161443357.html?qid=juheshuju","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20161118/20161118161443_cc42f487ffd14ea1f0764e9f7f5f0a0a_1_mwpl_05500201.jpeg"},{"title":"墨尔本一家银行遭纵火致20余人伤","date":"2016-11-18 16:14","category":"国际","author_name":"中新网移动版","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20161118/20161118161405_e995a2a787b67394ebcec54373b46e4a_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118161405782.html?qid=juheshuju","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20161118/20161118161405_e995a2a787b67394ebcec54373b46e4a_1_mwpl_05500201.jpeg"},{"title":"国际奥委会：北京奥运16人药检阳性，10奖牌被剥夺","date":"2016-11-18 16:07","category":"国际","author_name":"新华社","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20161118/20161118160705_1e8f9b1617811c0933d4391cb28c62b3_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118160705026.html?qid=juheshuju","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20161118/20161118160705_1e8f9b1617811c0933d4391cb28c62b3_1_mwpl_05500201.jpeg"},{"title":"中国留德女生称遭难民强暴 使馆确认收到报告","date":"2016-11-18 16:04","category":"国际","author_name":"地球外参","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20161118/20161118160434_84eacf82a52b14d0f4311c2bfda7c506_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118160434823.html?qid=juheshuju","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20161118/20161118160434_84eacf82a52b14d0f4311c2bfda7c506_1_mwpl_05500201.jpeg"},{"title":"以色列创意汤勺丨傲娇天鹅与呆萌水怪","date":"2016-11-18 16:03","category":"国际","author_name":"来点儿","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161118/20161118_18367de8f73f895f5eb5171a92b4d76b_mwpm_03200403.jpg","url":"http://mini.eastday.com/mobile/161118160306436.html?qid=juheshuju","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161118/20161118_18367de8f73f895f5eb5171a92b4d76b_mwpl_05500201.jpg"},{"title":"日本太太是这么布置家的\u2026\u2026我以为走错了艺术展\u2026\u2026","date":"2016-11-18 16:01","category":"国际","author_name":"日本之窗","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161118/20161118160146_e2fde17affd0cfd160e84b828ca396e3_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118160146498.html?qid=juheshuju","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161118/20161118160146_e2fde17affd0cfd160e84b828ca396e3_1_mwpl_05500201.jpeg"},{"title":"水嫩的日本妹子总结出：干性皮肤每天千万不要做的6件事\u2026\u2026","date":"2016-11-18 16:01","category":"国际","author_name":"東京新青年","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20161118/20161118160145_5e07c6cdc779a273930f8cdac6d419ee_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118160145733.html?qid=juheshuju","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20161118/20161118160145_5e07c6cdc779a273930f8cdac6d419ee_1_mwpl_05500201.jpeg"},{"title":"韩媒：朴槿惠将恢复处理国政 支持率连续三周5%","date":"2016-11-18 16:01","category":"国际","author_name":"中国新闻网","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20161118/20161118160123_6c97144a8f8db3d71d2ad9f996ce1181_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118160123027.html?qid=juheshuju","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20161118/20161118160123_6c97144a8f8db3d71d2ad9f996ce1181_1_mwpl_05500201.jpeg"},{"title":"英国14岁女孩患癌去世 获准冷冻遗体在未来\u201c重生\u201d","date":"2016-11-18 15:58","category":"国际","author_name":"封面新闻","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20161118/20161118155849_ee8ef0f3d3d45b9de4b2d2e51698b731_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118155849628.html?qid=juheshuju","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20161118/20161118155849_ee8ef0f3d3d45b9de4b2d2e51698b731_1_mwpl_05500201.jpeg"},{"title":"日本南极海域科研捕鲸船队启程 遭相关团体反对","date":"2016-11-18 15:57","category":"国际","author_name":"中国新闻网","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161118/20161118155724_2f7ce9644a7ea4d18c7b83962d35a611_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118155724535.html?qid=juheshuju","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161118/20161118155724_2f7ce9644a7ea4d18c7b83962d35a611_1_mwpl_05500201.jpeg"},{"title":"美国枪支生意到底有多大？几个数告诉你","date":"2016-11-18 15:55","category":"国际","author_name":"腾讯财经","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20161118/20161118155539_002037c4d7ad431d65a7dbffe43a0f3a_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118155539737.html?qid=juheshuju","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20161118/20161118155539_002037c4d7ad431d65a7dbffe43a0f3a_1_mwpl_05500201.jpeg"},{"title":"全球化的冲击下，美国锈带传统工业愈演愈烈的困局","date":"2016-11-18 15:54","category":"国际","author_name":"澎湃新闻","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20161118/20161118155455_9b3d0660078fad98b99a644fc27074a7_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118155455023.html?qid=juheshuju","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20161118/20161118155455_9b3d0660078fad98b99a644fc27074a7_1_mwpl_05500201.jpeg"},{"title":"法国宇航员不忘美食 鹅肝酱油封鸭带上太空","date":"2016-11-18 15:53","category":"国际","author_name":"环球网","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20161118/20161118155306_cfea09a78871ca2b9fd84a0e9fad848e_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118155306447.html?qid=juheshuju","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20161118/20161118155306_cfea09a78871ca2b9fd84a0e9fad848e_1_mwpl_05500201.jpeg"},{"title":"81岁北京老人被抛美机场，后来呢？","date":"2016-11-18 15:51","category":"国际","author_name":"洪涛说世界","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20161118/20161118155117_d00fbc08e1599543d501c3d599eaa156_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118155117602.html?qid=juheshuju","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20161118/20161118155117_d00fbc08e1599543d501c3d599eaa156_1_mwpl_05500201.jpeg"},{"title":"战斗民族搞了个警花选美大赛\u2026\u2026这颜值是要逆天啊！","date":"2016-11-18 15:51","category":"国际","author_name":"俄罗斯小报","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20161118/20161118155111_0e5b6dd3f3dcb4e8774848728f605e09_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118155111988.html?qid=juheshuju","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20161118/20161118155111_0e5b6dd3f3dcb4e8774848728f605e09_1_mwpl_05500201.jpeg"},{"title":"英最大电信商遭黑客 600万客户资料被偷","date":"2016-11-18 15:47","category":"国际","author_name":"中国小康网","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20161118/20161118154726_b3b18ca175d49eecffd6c0669a8c4899_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118154726009.html?qid=juheshuju","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20161118/20161118154726_b3b18ca175d49eecffd6c0669a8c4899_1_mwpl_05500201.jpeg"},{"title":"俄联盟飞船升空 搭载3欧美宇航员至空间站","date":"2016-11-18 15:47","category":"国际","author_name":"中国小康网","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20161118/20161118154725_d5e71900cf09a17f90cdfbeedd498a5b_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118154725206.html?qid=juheshuju","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20161118/20161118154725_d5e71900cf09a17f90cdfbeedd498a5b_1_mwpl_05500201.jpeg"},{"title":"金融破产加火山爆发拯救冰岛 专心搞旅游成功","date":"2016-11-18 15:47","category":"国际","author_name":"中国小康网","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161118/20161118154724_2d7632bd47d6900fe08f74d3bc52dd8d_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118154724008.html?qid=juheshuju","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161118/20161118154724_2d7632bd47d6900fe08f74d3bc52dd8d_1_mwpl_05500201.jpeg"},{"title":"日本百货公司办黄金展 272万黄金锅上烤章鱼烧","date":"2016-11-18 15:40","category":"国际","author_name":"中国新闻网","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161118/20161118154043_1a4f5d87dfc5bc2933b770409844966b_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118154043271.html?qid=juheshuju","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161118/20161118154043_1a4f5d87dfc5bc2933b770409844966b_1_mwpl_05500201.jpeg"},{"title":"顶级银行锦上添花 每年从政府得益620亿美元","date":"2016-11-18 15:34","category":"国际","author_name":"中国小康网","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20161118/20161118153426_c2946b44c806eeaa9ce2034e6e2c0068_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118153426681.html?qid=juheshuju","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20161118/20161118153426_c2946b44c806eeaa9ce2034e6e2c0068_1_mwpl_05500201.jpeg"},{"title":"美媒：EB-5投资移民多买豪宅 中国富人踊跃","date":"2016-11-18 15:34","category":"国际","author_name":"中国小康网","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20161118/20161118153424_44336f05d8b60c9a3c349b3fb00cf3d4_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118153424824.html?qid=juheshuju","thumbnail_pic_s03":"http://04.imgmini.eastday.com/mobile/20161118/20161118153424_44336f05d8b60c9a3c349b3fb00cf3d4_1_mwpl_05500201.jpeg"},{"title":"伦敦海德公园推出\u201c冬季仙境\u201d冰灯展","date":"2016-11-18 15:34","category":"国际","author_name":"网易综合","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20161118/20161118153410_3a4de6edeb643aff82139625e290b192_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118153410344.html?qid=juheshuju","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20161118/20161118153410_3a4de6edeb643aff82139625e290b192_1_mwpl_05500201.jpeg"},{"title":"日本的那个杀人恶魔为何还未被执行死刑？","date":"2016-11-18 15:30","category":"国际","author_name":"FT中文网","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20161118/20161118153002_6f3ec47651592ad260379b7ed8d43be8_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118153002881.html?qid=juheshuju","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20161118/20161118153002_6f3ec47651592ad260379b7ed8d43be8_1_mwpl_05500201.jpeg"},{"title":"智利废弃铜矿 奇特地貌似火星表面","date":"2016-11-18 15:28","category":"国际","author_name":"网易综合","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20161118/20161118152854_93b75440ac69903f76b65048cf6a0c25_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118152854549.html?qid=juheshuju","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20161118/20161118152854_93b75440ac69903f76b65048cf6a0c25_1_mwpl_05500201.jpeg"},{"title":"墨尔本一银行遭纵火致27人受伤","date":"2016-11-18 15:27","category":"国际","author_name":"人民网-澳大利亚频道","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20161118/20161118152720_a3abf5e430f450e874d90be8b65201bf_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118152720444.html?qid=juheshuju","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20161118/20161118152720_a3abf5e430f450e874d90be8b65201bf_1_mwpl_05500201.jpeg"},{"title":"巴林商务代表团参加中国高交会以加强经贸合作","date":"2016-11-18 15:25","category":"国际","author_name":"北京晨报网","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20161118/20161118152541_0d577f25cc6e291e3488a0db1f66eba7_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118152541842.html?qid=juheshuju","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20161118/20161118152541_0d577f25cc6e291e3488a0db1f66eba7_1_mwpl_05500201.jpeg"},{"title":"男子公园泡温泉被溶解：泉水中无法找到尸体","date":"2016-11-18 15:08","category":"国际","author_name":"中国网","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20161118/20161118150803_6058e61f7228743c83ba4ef8f09b0f81_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118150803550.html?qid=juheshuju","thumbnail_pic_s03":"http://07.imgmini.eastday.com/mobile/20161118/20161118150803_6058e61f7228743c83ba4ef8f09b0f81_1_mwpl_05500201.jpeg"},{"title":"欧洲最强女皇辞世，被列为改变历史事件之一","date":"2016-11-18 15:06","category":"国际","author_name":"我们爱历史","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20161118/20161118150629_1403dae70438c0a324d56198593efbf4_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118150629277.html?qid=juheshuju","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20161118/20161118150629_1403dae70438c0a324d56198593efbf4_1_mwpl_05500201.jpeg"},{"title":"美情报分析师工作或遭歪曲　只为奥巴马圆满结束任期","date":"2016-11-18 15:06","category":"国际","author_name":"环球网","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161118/20161118150601_8301e7da870a43a070c189bf71003717_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118150601010.html?qid=juheshuju","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161118/20161118150601_8301e7da870a43a070c189bf71003717_1_mwpl_05500201.jpeg"},{"title":"美国男子用无人机跟踪妻子 网友批\u201c恐怖情人\u201d","date":"2016-11-18 15:04","category":"国际","author_name":"参考消息网","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20161118/20161118150458_f506d91bd09a9759e4836805d10316b2_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118150458223.html?qid=juheshuju","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20161118/20161118150458_f506d91bd09a9759e4836805d10316b2_1_mwpl_05500201.jpeg"},{"title":"壮志未酬奥巴马（上）","date":"2016-11-18 15:01","category":"国际","author_name":"经济观察报","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20161118/20161118150158_8fdac619ee1ef5d1618109572dfae983_1_mwpm_03200403.jpeg","url":"http://mini.eastday.com/mobile/161118150158542.html?qid=juheshuju","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20161118/20161118150158_8fdac619ee1ef5d1618109572dfae983_1_mwpl_05500201.jpeg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {

        private String stat;
        private ArrayList<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public ArrayList<DataBean> getData() {
            return data;
        }

        public void setData(ArrayList<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {

            private String title;
            private String date;
            private String category;
            private String author_name;
            private String thumbnail_pic_s;
            private String url;
            private String thumbnail_pic_s03;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }
}
