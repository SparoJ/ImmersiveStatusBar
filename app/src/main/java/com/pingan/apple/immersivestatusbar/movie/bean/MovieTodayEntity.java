package com.pingan.apple.immersivestatusbar.movie.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @author apple
 * @Description :
 * @date 17/1/23  下午4:05
 */

public class MovieTodayEntity implements Serializable {

    /**
     * control : {"expires":1800}
     * status : 0
     * data : {"hasNext":false,"movies":[{"late":false,"showInfo":"今天205家影院放映1898场","cnms":0,"sn":0,"snum":16914,"sc":7.5,"ver":"2D/中国巨幕","rt":"2017-01-20上映","dur":117,"imax":false,"src":"","nm":"降临","showDate":"","img":"http://p0.meituan.net/165.220/movie/0807f31f1b8e0058774a23fba89858842258512.jpeg","preSale":0,"vd":"","dir":"丹尼斯·维伦纽瓦","star":"艾米·亚当斯,杰瑞米·雷纳,福里斯特·惠特克","cat":"悬疑,冒险,科幻","wish":16022,"3d":false,"pn":124,"scm":"外星来访客，目的难预测","time":"","id":338387},{"late":false,"showInfo":"今天209家影院放映1689场","cnms":0,"sn":0,"snum":71952,"sc":8.5,"ver":"3D/中国巨幕","rt":"2017-01-13上映","dur":118,"imax":false,"src":"","nm":"太空旅客","showDate":"","img":"http://p0.meituan.net/165.220/movie/9b7f7df143af8a13ccd17057d772e9e7654933.png","preSale":0,"vd":"","dir":"莫腾·泰杜姆","star":"詹妮弗·劳伦斯,克里斯·帕拉特,迈克尔·辛","cat":"爱情,冒险,科幻","wish":44420,"3d":true,"pn":169,"scm":"未达目的地，太空铁达尼","time":"","id":341201},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":9678,"sc":0,"ver":"3D/IMAX 3D/中国巨幕","rt":"本周六上映","dur":108,"imax":true,"src":"","nm":"西游伏妖篇","showDate":"","img":"http://p0.meituan.net/165.220/movie/cd2791a174bfc7c1bc630fbb281c30e0308728.jpg","preSale":1,"vd":"","dir":"徐克","star":"吴亦凡,林更新,杨一威","cat":"喜剧,动作,奇幻","wish":193667,"3d":true,"pn":216,"scm":"取经矛盾多，面和心不和","time":"","id":248904},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":9662,"sc":0,"ver":"2D/中国巨幕/全景声","rt":"本周六上映","dur":100,"imax":false,"src":"","nm":"大闹天竺","showDate":"","img":"http://p1.meituan.net/165.220/movie/015de6bbaa2ecc299254b24e4f96939d489607.jpg","preSale":1,"vd":"","dir":"王宝强","star":"王宝强,白客,岳云鹏","cat":"喜剧,动作,冒险","wish":225296,"3d":false,"pn":272,"scm":"宝强取真经，争当搞笑King","time":"","id":248935},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":2247,"sc":0,"ver":"2D/3D/中国巨幕","rt":"本周六上映","dur":108,"imax":false,"src":"","nm":"功夫瑜伽","showDate":"","img":"http://p1.meituan.net/165.220/movie/d273af80e581b4c60abcbb57a95ad2b72956123.jpg","preSale":1,"vd":"","dir":"唐季礼","star":"成龙,李治廷,张艺兴","cat":"喜剧,动作,冒险","wish":80289,"3d":true,"pn":228,"scm":"科学家寻宝，中印来回跑","time":"","id":248933},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":3183,"sc":0,"ver":"2D/中国巨幕/全景声","rt":"本周六上映","dur":102,"imax":false,"src":"","nm":"乘风破浪","showDate":"","img":"http://p0.meituan.net/165.220/movie/c6cadc16e53ee7a0f79a9455a147449d50210.jpeg","preSale":1,"vd":"","dir":"韩寒","star":"邓超,彭于晏,赵丽颖","cat":"剧情,喜剧,冒险","wish":41844,"3d":false,"pn":121,"scm":"阿浪梦追逐，意外入险途","time":"","id":1170255},{"late":false,"showInfo":"今天202家影院放映1032场","cnms":0,"sn":0,"snum":127938,"sc":8,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-01-06上映","dur":134,"imax":true,"src":"","nm":"星球大战外传：侠盗一号","showDate":"","img":"http://p0.meituan.net/165.220/movie/ef1bc6e7987fcb64558d11cadb86b3be687974.jpg","preSale":0,"vd":"","dir":"加里斯·爱德华斯","star":"菲丽希缇·琼斯,迭戈·鲁纳,艾伦·图代克","cat":"动作,冒险,科幻","wish":100271,"3d":true,"pn":507,"scm":"姜文和子丹，去打太空战","time":"","id":247185},{"late":false,"showInfo":"今天178家影院放映770场","cnms":0,"sn":0,"snum":310139,"sc":8.7,"ver":"2D","rt":"2016-12-30上映","dur":113,"imax":false,"src":"","nm":"情圣","showDate":"","img":"http://p0.meituan.net/165.220/movie/8bd63a54c2ebcb79fbaa3777e2d72d0c199654.jpg","preSale":0,"vd":"","dir":"宋晓飞,董旭","star":"肖央,闫妮,小沈阳","cat":"喜剧,爱情","wish":37660,"3d":false,"pn":144,"scm":"渣男要出轨，结局很崩溃","time":"","id":1188324},{"late":false,"showInfo":"今天191家影院放映738场","cnms":0,"sn":0,"snum":24214,"sc":8.6,"ver":"2D/3D","rt":"2017-01-13上映","dur":86,"imax":false,"src":"","nm":"大卫贝肯之倒霉特工熊","showDate":"","img":"http://p1.meituan.net/165.220/movie/d0f9c85f526557c1d0ad3011e2c83cbb446135.png","preSale":0,"vd":"","dir":"李清舫,张遥函,雪萌","star":"汤水雨,徐佳琦,杨默","cat":"喜剧,冒险,家庭","wish":8342,"3d":true,"pn":79,"scm":"保护北极圈，笨熊命被玄","time":"","id":1197753},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":4830,"sc":9,"ver":"2D/3D","rt":"本周六上映","dur":91,"imax":false,"src":"","nm":"熊出没·奇幻空间","showDate":"","img":"http://p1.meituan.net/165.220/movie/cfcdb50d181a2111a2b79a0639db0f19764116.png","preSale":1,"vd":"","dir":"丁亮,林永长,林汇达","star":"尚雯婕,鲍春来,曾舜晞","cat":"动画,冒险","wish":23490,"3d":true,"pn":52,"scm":"熊抱春来到，保护金鹿角","time":"","id":1189089},{"late":false,"showInfo":"今天145家影院放映317场","cnms":0,"sn":0,"snum":12630,"sc":8.5,"ver":"2D/3D/中国巨幕","rt":"2017-01-13上映","dur":102,"imax":false,"src":"","nm":"魔弦传说","showDate":"","img":"http://p1.meituan.net/165.220/movie/410402a478c7e9eb35c060ef005070f8521338.jpg","preSale":0,"vd":"","dir":"塔拉维斯·柯奈特","star":"阿特·帕金森,马修·麦康纳,查理兹·塞隆","cat":"动画,奇幻,冒险","wish":13841,"3d":true,"pn":198,"scm":"男孩得庇佑，力战妖灵兽","time":"","id":246463},{"late":false,"showInfo":"今天96家影院放映207场","cnms":0,"sn":0,"snum":285145,"sc":9.4,"ver":"2D/中国巨幕","rt":"2016-12-08上映","dur":139,"imax":false,"src":"","nm":"血战钢锯岭","showDate":"","img":"http://p0.meituan.net/165.220/movie/018ceaadb90ac5c1b9ba33546d1fb746401981.jpg","preSale":0,"vd":"","dir":"梅尔·吉布森","star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","cat":"剧情,战争","wish":32064,"3d":false,"pn":198,"scm":"士兵有信仰，战场拒拿枪","time":"","id":338349},{"late":false,"showInfo":"今天91家影院放映188场","cnms":0,"sn":0,"snum":5641,"sc":8,"ver":"2D","rt":"2017-01-13上映","dur":102,"imax":false,"src":"","nm":"天空之眼","showDate":"","img":"http://p1.meituan.net/165.220/movie/aa3edbf989db78fadc693ebee159f4dd3535520.jpg","preSale":0,"vd":"","dir":"加文·胡德","star":"海伦·米伦,亚伦·保尔,艾伦·里克曼","cat":"剧情,悬疑,战争","wish":6812,"3d":false,"pn":55,"scm":"高空狙击手，反恐破阴谋","time":"","id":246230},{"late":false,"showInfo":"今天51家影院放映100场","cnms":0,"sn":0,"snum":214419,"sc":8.5,"ver":"2D/3D/中国巨幕/全景声","rt":"2016-12-23上映","dur":124,"imax":false,"src":"","nm":"铁道飞虎","showDate":"","img":"http://p1.meituan.net/165.220/movie/fb54328788845ca6aaf8362875a699951041538.jpg","preSale":0,"vd":"","dir":"丁晟","star":"成龙,黄子韬,房祖名","cat":"剧情,喜剧,动作","wish":58366,"3d":true,"pn":356,"scm":"铁道抗日寇，有勇更有谋","time":"","id":248916},{"late":false,"showInfo":"今天58家影院放映100场","cnms":0,"sn":0,"snum":22983,"sc":8.7,"ver":"2D/3D","rt":"2017-01-07上映","dur":91,"imax":false,"src":"","nm":"猪猪侠之英雄猪少年","showDate":"","img":"http://p1.meituan.net/165.220/movie/a7b1c628181c0185e1745d4c80c9aba6164580.jpg","preSale":0,"vd":"","dir":"陆锦明,钟裕","star":"易烊千玺,陈志荣,彭雨菲","cat":"喜剧,动画,奇幻","wish":11755,"3d":true,"pn":75,"scm":"猪猪侠归来，再战大反派","time":"","id":1197558},{"late":false,"showInfo":"2017-02-03 下周五上映","cnms":0,"sn":0,"snum":282,"sc":0,"ver":"2D","rt":"下周五上映","dur":99,"imax":false,"src":"","nm":"东北往事之破马张飞","showDate":"","img":"http://p0.meituan.net/165.220/movie/d9d800469e30249c9319dc7c4fa0211651185.jpeg","preSale":1,"vd":"","dir":"郭大雷","star":"贾乃亮,马丽,梁超","cat":"喜剧,动作","wish":21552,"3d":false,"pn":123,"scm":"东北小混混，斗黑帮恶棍","time":"","id":344032},{"late":false,"showInfo":"今天34家影院放映85场","cnms":0,"sn":0,"snum":630803,"sc":8.4,"ver":"2D/3D","rt":"2016-12-16上映","dur":104,"imax":false,"src":"","nm":"长城","showDate":"","img":"http://p0.meituan.net/165.220/movie/e4a3447ebe8c44eea59ab7f68790c7e2179321.jpeg","preSale":0,"vd":"","dir":"张艺谋","star":"马特·达蒙,景甜,佩德罗·帕斯卡","cat":"剧情,冒险,奇幻","wish":242315,"3d":true,"pn":209,"scm":"五军战饕餮，中国魂不灭","time":"","id":246267},{"late":false,"showInfo":"今天25家影院放映47场","cnms":0,"sn":0,"snum":549253,"sc":9.2,"ver":"2D","rt":"2016-12-02上映","dur":107,"imax":false,"src":"","nm":"你的名字。","showDate":"","img":"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","preSale":0,"vd":"","dir":"新海诚","star":"上白石萌音,佟心竹,神木隆之介","cat":"动画,爱情,奇幻","wish":277114,"3d":false,"pn":286,"scm":"寻君千里行，心系君之名","time":"","id":344881},{"late":false,"showInfo":"2017-01-27 本周五上映","cnms":0,"sn":0,"snum":548,"sc":0,"ver":"2D","rt":"本周五上映","dur":116,"imax":false,"src":"","nm":"健忘村","showDate":"","img":"http://p0.meituan.net/165.220/movie/cd23a5f30b3918cf241074bad9589d0d421744.jpg","preSale":1,"vd":"","dir":"陈玉勋","star":"舒淇,王千源,张孝全","cat":"喜剧,奇幻,武侠","wish":13244,"3d":false,"pn":233,"scm":"偏僻小山村，通车换乾坤","time":"","id":345668},{"late":false,"showInfo":"今天18家影院放映31场","cnms":0,"sn":0,"snum":124789,"sc":9.1,"ver":"2D/3D/中国巨幕/全景声","rt":"2016-11-25上映","dur":107,"imax":false,"src":"","nm":"海洋奇缘","showDate":"","img":"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","preSale":0,"vd":"","dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","star":"奥伊伊·卡瓦略,道恩·强森,瑞秋·豪斯","cat":"动画,动作,冒险","wish":42849,"3d":true,"pn":128,"scm":"航海家后代，征程向大海","time":"","id":246222},{"late":false,"showInfo":"今天14家影院放映24场","cnms":0,"sn":0,"snum":150,"sc":0,"ver":"2D/3D","rt":"2017-01-20上映","dur":90,"imax":false,"src":"","nm":"蛋计划","showDate":"","img":"http://p0.meituan.net/165.220/movie/486e0b84b0540c1a2bb08e1ae0615f60120249.jpg","preSale":0,"vd":"","dir":"李杨武","star":"胡婷,周微,孟雨田","cat":"喜剧,动画,冒险","wish":209,"3d":true,"pn":21,"scm":"草根小英雄，拯救大星球","time":"","id":343244},{"late":false,"showInfo":"今天22家影院放映24场","cnms":0,"sn":0,"snum":536,"sc":0,"ver":"2D","rt":"2017-01-20上映","dur":90,"imax":false,"src":"","nm":"心惊胆战","showDate":"","img":"http://p1.meituan.net/165.220/movie/040db77878efddaa622da5c90aca3079393144.jpg","preSale":0,"vd":"","dir":"陈鹏振","star":"惠英红,陈颖欣,黄德斌","cat":"惊悚","wish":842,"3d":false,"pn":26,"scm":"女为情假死，母亲变疯子","time":"","id":1199238},{"late":false,"showInfo":"今天12家影院放映15场","cnms":0,"sn":0,"snum":1443,"sc":9,"ver":"2D/3D","rt":"2017-01-13上映","dur":86,"imax":false,"src":"","nm":"超能龙骑侠","showDate":"","img":"http://p1.meituan.net/165.220/movie/72e473421c5304a7fd2f9f0abbac67021550343.jpg","preSale":0,"vd":"","dir":"刘可欣","star":"山新,乔诗语,李姗姗","cat":"动画,冒险,科幻","wish":6469,"3d":true,"pn":31,"scm":"打败大魔王，重见花果香","time":"","id":346662},{"late":false,"showInfo":"今天8家影院放映13场","cnms":0,"sn":0,"snum":307610,"sc":8.9,"ver":"3D/IMAX 3D/中国巨幕","rt":"2016-11-25上映","dur":133,"imax":true,"src":"","nm":"神奇动物在哪里","showDate":"","img":"http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","preSale":0,"vd":"","dir":"大卫·叶茨","star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·苏朵儿","cat":"冒险,奇幻,家庭","wish":130686,"3d":true,"pn":248,"scm":"神奇动物城，法师显超能","time":"","id":248918},{"late":false,"showInfo":"今天11家影院放映13场","cnms":0,"sn":0,"snum":9088,"sc":8.4,"ver":"2D","rt":"2017-01-06上映","dur":97,"imax":false,"src":"","nm":"玩命直播","showDate":"","img":"http://p0.meituan.net/165.220/movie/5f93a6f494de4778dedd0dff1671663f190718.jpg","preSale":0,"vd":"","dir":"亨利·朱斯特,阿里尔·舒尔曼","star":"艾玛·罗伯茨,戴夫·弗兰科,艾米丽·梅德","cat":"动作,冒险","wish":2328,"3d":false,"pn":149,"scm":"直播出人命，幕后太震惊","time":"","id":367889},{"late":false,"showInfo":"2017-02-01 下周三上映","cnms":0,"sn":0,"snum":118,"sc":0,"ver":"2D/3D","rt":"下周三上映","dur":90,"imax":false,"src":"","nm":"了不起的菲丽西","showDate":"","img":"http://p0.meituan.net/165.220/movie/b7137d7ef1fdd383255bf4d62308da142119370.jpg","preSale":1,"vd":"","dir":"埃里克·韦林,埃里克·萨默","star":"艾丽·范宁,卡莉·蕾·吉普森,戴恩·德哈恩","cat":"喜剧,动画,冒险","wish":7134,"3d":true,"pn":73,"scm":"孤儿院少女，逐梦去巴黎","time":"","id":1042603},{"late":false,"showInfo":"今天9家影院放映12场","cnms":0,"sn":0,"snum":15116,"sc":7.7,"ver":"3D","rt":"2016-12-31上映","dur":79,"imax":false,"src":"","nm":"冰雪女皇之冬日魔咒","showDate":"","img":"http://p1.meituan.net/165.220/movie/43599734212cffe752e257a8f86e61c46575058.jpg","preSale":0,"vd":"","dir":"阿列克谢·特斯蒂斯林","star":"贝拉·索恩,沙尔托·科普雷,肖恩·宾","cat":"喜剧,动画,家庭","wish":50214,"3d":true,"pn":133,"scm":"北风使劲吹，公主又悲催","time":"","id":246276},{"late":false,"showInfo":"今天8家影院放映12场","cnms":0,"sn":0,"snum":49,"sc":0,"ver":"2D","rt":"2017-01-20上映","dur":90,"imax":false,"src":"","nm":"大魔法师孟兜兜","showDate":"","img":"http://p1.meituan.net/165.220/movie/cdb2129dc0fe266c9b98fe40a2546083361581.jpg","preSale":0,"vd":"","dir":"孟晖","star":"郭太旭,杨小兰,石梁一骁","cat":"喜剧,动画","wish":592,"3d":false,"pn":36,"scm":"幻想有魔力，生活有乐趣","time":"","id":1199241},{"late":false,"showInfo":"今天8家影院放映10场","cnms":0,"sn":0,"snum":91876,"sc":7.6,"ver":"2D/中国巨幕/全景声","rt":"2016-12-16上映","dur":125,"imax":false,"src":"","nm":"罗曼蒂克消亡史","showDate":"","img":"http://p0.meituan.net/165.220/movie/c23a59322f0053bba6bb05853b1958507925907.jpg","preSale":0,"vd":"","dir":"程耳","star":"葛优,章子怡,浅野忠信","cat":"剧情,动作,悬疑","wish":60896,"3d":false,"pn":286,"scm":"教父葛大爷，死磕男间谍","time":"","id":246261},{"late":false,"showInfo":"2017-02-14上映","cnms":0,"sn":0,"snum":163,"sc":0,"ver":"2D/IMAX 2D/中国巨幕/全景声","rt":"2017-02-14上映","dur":129,"imax":true,"src":"","nm":"爱乐之城","showDate":"","img":"http://p0.meituan.net/165.220/movie/f4990a965755af1be2a16c421951c48219905345.jpg","preSale":1,"vd":"","dir":"达米恩·查泽雷","star":"瑞恩·高斯林,艾玛·斯通,约翰·传奇","cat":"爱情,歌舞","wish":9175,"3d":false,"pn":126,"scm":"爵士钢琴家，恋爱舞天涯","time":"","id":338436},{"late":false,"showInfo":"今天4家影院放映4场","cnms":0,"sn":0,"snum":5229,"sc":5.2,"ver":"2D","rt":"2017-01-06上映","dur":89,"imax":false,"src":"","nm":"恐怖理发店","showDate":"","img":"http://p0.meituan.net/165.220/movie/ef0e076422b75f9784574c5cc0367d0b136038.jpeg","preSale":0,"vd":"","dir":"陆诗雷","star":"殷果儿,姜星丘,任青安","cat":"爱情,惊悚,悬疑","wish":6983,"3d":false,"pn":22,"scm":"骷髅理发师，猛鬼追命时","time":"","id":343253},{"late":false,"showInfo":"今天3家影院放映4场","cnms":0,"sn":0,"snum":1754,"sc":0,"ver":"2D","rt":"2017-01-13上映","dur":84,"imax":false,"src":"","nm":"逗逗迪迪之美梦年年","showDate":"","img":"http://p0.meituan.net/165.220/movie/bac6981b45b5c188a87c840ecd0c9adb543403.jpg","preSale":0,"vd":"","dir":"张苑,王龙波,陆锦辉,陆锦明","star":"林美秀,曾允凡,孙国卿","cat":"动画,冒险","wish":8312,"3d":false,"pn":26,"scm":"噩梦从天降，兄妹寻真相","time":"","id":342584},{"late":false,"showInfo":"今天3家影院放映4场","cnms":0,"sn":0,"snum":482,"sc":9,"ver":"2D","rt":"2017-01-13上映","dur":110,"imax":false,"src":"","nm":"我的诗篇","showDate":"","img":"http://p1.meituan.net/165.220/movie/c90e380155fe29e7f7b728a44fde28052125871.jpg","preSale":0,"vd":"","dir":"吴飞跃,秦晓宇","star":"乌鸟鸟,陈年喜,老井","cat":"纪录片","wish":1628,"3d":false,"pn":22,"scm":"生产线诗歌，朴素却深刻","time":"","id":341084},{"late":false,"showInfo":"今天3家影院放映3场","cnms":0,"sn":0,"snum":22,"sc":0,"ver":"2D","rt":"2016-12-30上映","dur":110,"imax":false,"src":"","nm":"难忘金银滩","showDate":"","img":"http://p1.meituan.net/165.220/movie/70a956864b29369154c6e424707daba9273079.jpg","preSale":0,"vd":"","dir":"亮子","star":"王一,翟佳,濡雪","cat":"剧情,爱情,战争","wish":342,"3d":false,"pn":80,"scm":"知青建祖国，热血谱赞歌","time":"","id":344762},{"late":false,"showInfo":"今天2家影院放映3场","cnms":0,"sn":0,"snum":1666,"sc":8.2,"ver":"2D","rt":"2017-01-13上映","dur":96,"imax":false,"src":"","nm":"少年巴比伦","showDate":"","img":"http://p1.meituan.net/165.220/movie/4ec62c782751384769be6e38ef9066879306567.jpg","preSale":0,"vd":"","dir":"相国强","star":"董子健,李梦,尚铁龙","cat":"剧情,喜剧,爱情","wish":7388,"3d":false,"pn":126,"scm":"迷茫愣头青，中年忆旧情","time":"","id":247448},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"snum":242766,"sc":7.8,"ver":"2D/中国巨幕/全景声","rt":"2016-12-23上映","dur":128,"imax":false,"src":"","nm":"摆渡人","showDate":"","img":"http://p1.meituan.net/165.220/movie/7f41742a5c2ea24fcd2018ad333451ae193120.jpg","preSale":0,"vd":"","dir":"张嘉佳","star":"梁朝伟,金城武,陈奕迅","cat":"喜剧,爱情","wish":203019,"3d":false,"pn":294,"scm":"情海行舟难，摆渡扬云帆","time":"","id":246388},{"late":false,"showInfo":"今天1家影院放映2场","cnms":0,"sn":0,"snum":13901,"sc":7.7,"ver":"2D","rt":"2016-12-30上映","dur":107,"imax":false,"src":"","nm":"你好，疯子","showDate":"","img":"http://p0.meituan.net/165.220/movie/7746f1a7ca7ad4a9607642f7bf976aff901630.jpg","preSale":0,"vd":"","dir":"饶晓志","star":"万茜,周一围,王自健","cat":"剧情,喜剧,悬疑","wish":23120,"3d":false,"pn":141,"scm":"七疯为正名，欢脱搞事情","time":"","id":345106},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"snum":8476,"sc":8.7,"ver":"2D","rt":"2016-12-30上映","dur":92,"imax":false,"src":"","nm":"北极大冒险","showDate":"","img":"http://p0.meituan.net/165.220/movie/7ba575a552284abeb0b3e8ecc221cb26555835.jpeg","preSale":0,"vd":"","dir":"罗杰·斯波蒂伍德","star":"达科塔·高尤,高兰·维斯耶克,布丽姬·穆娜","cat":"剧情,冒险,家庭","wish":2656,"3d":false,"pn":16,"scm":"小熊找妈妈，北极寻亲旅","time":"","id":627570},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"snum":2353,"sc":8.7,"ver":"2D","rt":"2017-01-01上映","dur":118,"imax":false,"src":"","nm":"单身日记：好孕来袭","showDate":"","img":"http://p1.meituan.net/165.220/movie/df7d088b9ff0bb68e9f7f69ee93b92431015953.jpg","preSale":0,"vd":"","dir":"沙朗·马奎尔","star":"芮妮·齐薇格,科林·费斯,帕特里克·德姆西","cat":"喜剧,爱情","wish":3977,"3d":false,"pn":138,"scm":"好孕来烦恼，孩爸哪里找","time":"","id":342613},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"snum":29,"sc":0,"ver":"2D","rt":"2017-01-09上映","dur":98,"imax":false,"src":"","nm":"青海湖畔","showDate":"","img":"http://p1.meituan.net/165.220/movie/50914e1b1bcf0ab254fa669f391fba40797574.png","preSale":0,"vd":"","dir":"沈星浩","star":"秦怡,佟瑞欣,伊力哈木·买买提","cat":"剧情","wish":180,"3d":false,"pn":2,"scm":"青藏遇冻土，气象解难题","time":"","id":366795},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":77,"sc":0,"ver":"2D","rt":"2015-06-10上映","dur":0,"imax":false,"src":"","nm":"白蛇传","showDate":"","img":"http://p1.meituan.net/165.220/movie/4f32f079a982d8c845da5e41562ebfae28009.jpg","preSale":0,"vd":"","dir":"周志刚","star":"金静,金静","cat":"戏曲","wish":172,"3d":false,"pn":0,"scm":"真正大IP，经典永流传","time":"","id":344727},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":283024,"sc":7.8,"ver":"2D/中国巨幕/全景声","rt":"2016-11-18上映","dur":140,"imax":false,"src":"","nm":"我不是潘金莲","showDate":"","img":"http://p1.meituan.net/165.220/movie/8e5eabeadf237a10227a3124419410ef549583.jpg","preSale":0,"vd":"","dir":"冯小刚","star":"范冰冰,郭涛,董成鹏","cat":"剧情,喜剧","wish":185572,"3d":false,"pn":211,"scm":"金莲戏中戏，官场局中局","time":"","id":341749},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":2179,"sc":7.3,"ver":"2D","rt":"2016-12-24上映","dur":95,"imax":false,"src":"","nm":"绝对控制","showDate":"","img":"http://p1.meituan.net/165.220/movie/1fb3e368b4fb93d0eca23dd0304e9a4e133077.jpg","preSale":0,"vd":"","dir":"约翰·摩尔","star":"皮尔斯·布鲁斯南,安娜·弗莱尔,斯戴芬妮·斯考特","cat":"悬疑,科幻,犯罪","wish":6517,"3d":false,"pn":19,"scm":"智能成隐患，邦德也犯难","time":"","id":531857},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":20120,"sc":7.3,"ver":"2D","rt":"2016-12-30上映","dur":89,"imax":false,"src":"","nm":"那年夏天你去了哪里","showDate":"","img":"http://p1.meituan.net/165.220/movie/6b765c72510e7f4cd2f0cd8a6e9b4b7c996096.png","preSale":0,"vd":"","dir":"周隼","star":"宋佳,林家栋,颜卓灵","cat":"悬疑,犯罪","wish":56283,"3d":false,"pn":134,"scm":"绑架十二年，归家惹事端","time":"","id":1187526},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":685,"sc":0,"ver":"2D","rt":"2016-12-31上映","dur":96,"imax":false,"src":"","nm":"人鱼校花","showDate":"","img":"http://p0.meituan.net/165.220/movie/8cd7cb6c44724e3c07f8deebdad98df33855354.jpg","preSale":0,"vd":"","dir":"林云翔,叶茗","star":"邹杨,文卓,田晓天","cat":"喜剧,爱情,奇幻","wish":14238,"3d":false,"pn":28,"scm":"误闯游泳池，人鱼追爱迟","time":"","id":343742},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":53,"sc":0,"ver":"2D","rt":"2017-01-06上映","dur":93,"imax":false,"src":"","nm":"浪漫搭档","showDate":"","img":"http://p0.meituan.net/165.220/movie/327d64025f2a096215843f9aad17ac81247598.jpg","preSale":0,"vd":"","dir":"刘夏同","star":"陈国坤,徐冬梅,刘承俊","cat":"喜剧,爱情,动作","wish":261,"3d":false,"pn":22,"scm":"虽身出戏班，军阀见也颤","time":"","id":1199081},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":42,"sc":0,"ver":"2D","rt":"2017-01-20上映","dur":90,"imax":false,"src":"","nm":"缺失的爱","showDate":"","img":"http://p0.meituan.net/165.220/movie/82a0337d984f64bb93e914051f26d7ae74274.jpg","preSale":0,"vd":"","dir":"曾光永","star":"龚蓓苾,郭艳,冯文娟","cat":"剧情","wish":188,"3d":false,"pn":7,"scm":"城市来包裹，乡村大混乱","time":"","id":1199972},{"late":false,"showInfo":"2017-01-24 本周二上映","cnms":0,"sn":0,"snum":42,"sc":0,"ver":"2D","rt":"本周二上映","dur":85,"imax":false,"src":"","nm":"老师也疯狂","showDate":"","img":"http://p1.meituan.net/165.220/movie/b0782b6f12e4281282e61e5a41cf7b3e269937.jpg","preSale":1,"vd":"","dir":"赵宏丽","star":"韩立,方青卓,黄一山","cat":"喜剧","wish":940,"3d":false,"pn":24,"scm":"麻辣新教师，鬼马教学法","time":"","id":343822},{"late":false,"showInfo":"2017-02-05 下周日上映","cnms":0,"sn":0,"snum":47,"sc":0,"ver":"2D","rt":"下周日上映","dur":85,"imax":false,"src":"","nm":"萤火奇兵","showDate":"","img":"http://p0.meituan.net/165.220/movie/45f4c80627636a935780a2e77963e297551097.jpg","preSale":1,"vd":"","dir":"邓伟锋","star":"姚雷,郭盛,李姗姗","cat":"喜剧,动画,奇幻","wish":2402,"3d":false,"pn":39,"scm":"萤火光燎原，灯灯保家园","time":"","id":346477},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":6,"sc":0,"ver":"2D","rt":"null上映","dur":0,"imax":false,"src":"","nm":"难忘的岁月","showDate":"","img":"http://p0.meituan.net/165.220/movie/2b2c6b6b346c5a896b4b07f0e4c5e6544797.jpg","preSale":0,"vd":"","dir":"","star":"陈小艺,刘冠翔,佟瑞欣","cat":"电视剧","wish":0,"3d":false,"pn":0,"scm":"","time":"","id":402719},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":0,"sc":0,"ver":"","rt":"null上映","dur":0,"imax":false,"src":"","nm":"老师也疯狂","showDate":"","img":"http://p0.meituan.net/165.220/mmdb/1dbdf00ff02b21684d9ac34f12ada27e3944.png","preSale":0,"vd":"","dir":"","star":"田原俊彦,野村宏伸,五十嵐いづみ","cat":"电视剧","wish":0,"3d":false,"pn":0,"scm":"","time":"","id":401315},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":0,"sc":7.3,"ver":"2D","rt":"1996-09-19上映","dur":96,"imax":false,"src":"","nm":"浮生","showDate":"","img":"http://p0.meituan.net/165.220/movie/7/6989417.jpg","preSale":0,"vd":"","dir":"罗卓瑶","star":"Annie Yip,Anthony Wong,Julian Pulvermacher","cat":"剧情","wish":1,"3d":false,"pn":1,"scm":"","time":"","id":10964},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":183,"sc":9,"ver":"2D","rt":"2015-07-08上映","dur":150,"imax":false,"src":"","nm":"红楼梦","showDate":"","img":"http://p1.meituan.net/165.220/movie/465278425a182d5d0aebb5edc731534527821.jpg","preSale":0,"vd":"","dir":"龚应恬","star":"翁佳慧,朱冰贞,邵天帅","cat":"戏曲","wish":0,"3d":false,"pn":10,"scm":"红楼风月情，昆剧变电影","time":"","id":257354},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":8841,"sc":7.2,"ver":"2D","rt":"2016-06-09上映","dur":78,"imax":false,"src":"","nm":"泰迪熊之玩具大战","showDate":"","img":"http://p1.meituan.net/165.220/movie/495971f9751f07a720373ad6008146e8575458.jpg","preSale":0,"vd":"","dir":"胡韵","star":"邓小婷,赵奔,白文显","cat":"动画,冒险,喜剧","wish":7076,"3d":false,"pn":8,"scm":"恶势力进攻，泰迪救萌宠","time":"","id":346658},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":1175,"sc":7.2,"ver":"2D","rt":"2016-12-29上映","dur":90,"imax":false,"src":"","nm":"冒牌卧底","showDate":"","img":"http://p0.meituan.net/165.220/movie/e3bb8f6367e67636fa0bf51242bce0a1740066.png","preSale":0,"vd":"","dir":"唐旭","star":"潘粤明,常远,吴樾","cat":"喜剧,犯罪","wish":11985,"3d":false,"pn":77,"scm":"线人不要怕，靠嘴走天下","time":"","id":345970},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":6089,"sc":9.6,"ver":"2D","rt":"2017-01-06上映","dur":91,"imax":false,"src":"","nm":"一路逆风","showDate":"","img":"http://p0.meituan.net/165.220/movie/49f7e42bed14bc2ebe791146d2444ced438579.jpeg","preSale":0,"vd":"","dir":"尼克·威克姆","star":"邓紫棋","cat":"音乐,纪录片","wish":3991,"3d":false,"pn":80,"scm":"紫棋心路史，巨星成长时","time":"","id":1198738},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":916,"sc":6.4,"ver":"2D","rt":"2017-01-07上映","dur":80,"imax":false,"src":"","nm":"辛巴达与美人鱼公主","showDate":"","img":"http://p1.meituan.net/165.220/movie/af36e3479b1fae9d5329ea8e509b0e52980137.jpg","preSale":0,"vd":"","dir":"李霞","star":"杨进,唐泽宗,吴凡","cat":"喜剧,冒险,科幻","wish":1844,"3d":false,"pn":25,"scm":"小工变船长，冒险新起航","time":"","id":1198735}]}
     */

    private ControlBean control;
    private int status;
    private DataBean data;

    public ControlBean getControl() {
        return control;
    }

    public void setControl(ControlBean control) {
        this.control = control;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class ControlBean {
        /**
         * expires : 1800
         */

        private int expires;

        public int getExpires() {
            return expires;
        }

        public void setExpires(int expires) {
            this.expires = expires;
        }
    }

    public static class DataBean {
        /**
         * hasNext : false
         * movies : [{"late":false,"showInfo":"今天205家影院放映1898场","cnms":0,"sn":0,"snum":16914,"sc":7.5,"ver":"2D/中国巨幕","rt":"2017-01-20上映","dur":117,"imax":false,"src":"","nm":"降临","showDate":"","img":"http://p0.meituan.net/165.220/movie/0807f31f1b8e0058774a23fba89858842258512.jpeg","preSale":0,"vd":"","dir":"丹尼斯·维伦纽瓦","star":"艾米·亚当斯,杰瑞米·雷纳,福里斯特·惠特克","cat":"悬疑,冒险,科幻","wish":16022,"3d":false,"pn":124,"scm":"外星来访客，目的难预测","time":"","id":338387},{"late":false,"showInfo":"今天209家影院放映1689场","cnms":0,"sn":0,"snum":71952,"sc":8.5,"ver":"3D/中国巨幕","rt":"2017-01-13上映","dur":118,"imax":false,"src":"","nm":"太空旅客","showDate":"","img":"http://p0.meituan.net/165.220/movie/9b7f7df143af8a13ccd17057d772e9e7654933.png","preSale":0,"vd":"","dir":"莫腾·泰杜姆","star":"詹妮弗·劳伦斯,克里斯·帕拉特,迈克尔·辛","cat":"爱情,冒险,科幻","wish":44420,"3d":true,"pn":169,"scm":"未达目的地，太空铁达尼","time":"","id":341201},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":9678,"sc":0,"ver":"3D/IMAX 3D/中国巨幕","rt":"本周六上映","dur":108,"imax":true,"src":"","nm":"西游伏妖篇","showDate":"","img":"http://p0.meituan.net/165.220/movie/cd2791a174bfc7c1bc630fbb281c30e0308728.jpg","preSale":1,"vd":"","dir":"徐克","star":"吴亦凡,林更新,杨一威","cat":"喜剧,动作,奇幻","wish":193667,"3d":true,"pn":216,"scm":"取经矛盾多，面和心不和","time":"","id":248904},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":9662,"sc":0,"ver":"2D/中国巨幕/全景声","rt":"本周六上映","dur":100,"imax":false,"src":"","nm":"大闹天竺","showDate":"","img":"http://p1.meituan.net/165.220/movie/015de6bbaa2ecc299254b24e4f96939d489607.jpg","preSale":1,"vd":"","dir":"王宝强","star":"王宝强,白客,岳云鹏","cat":"喜剧,动作,冒险","wish":225296,"3d":false,"pn":272,"scm":"宝强取真经，争当搞笑King","time":"","id":248935},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":2247,"sc":0,"ver":"2D/3D/中国巨幕","rt":"本周六上映","dur":108,"imax":false,"src":"","nm":"功夫瑜伽","showDate":"","img":"http://p1.meituan.net/165.220/movie/d273af80e581b4c60abcbb57a95ad2b72956123.jpg","preSale":1,"vd":"","dir":"唐季礼","star":"成龙,李治廷,张艺兴","cat":"喜剧,动作,冒险","wish":80289,"3d":true,"pn":228,"scm":"科学家寻宝，中印来回跑","time":"","id":248933},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":3183,"sc":0,"ver":"2D/中国巨幕/全景声","rt":"本周六上映","dur":102,"imax":false,"src":"","nm":"乘风破浪","showDate":"","img":"http://p0.meituan.net/165.220/movie/c6cadc16e53ee7a0f79a9455a147449d50210.jpeg","preSale":1,"vd":"","dir":"韩寒","star":"邓超,彭于晏,赵丽颖","cat":"剧情,喜剧,冒险","wish":41844,"3d":false,"pn":121,"scm":"阿浪梦追逐，意外入险途","time":"","id":1170255},{"late":false,"showInfo":"今天202家影院放映1032场","cnms":0,"sn":0,"snum":127938,"sc":8,"ver":"2D/3D/IMAX 3D/中国巨幕/全景声","rt":"2017-01-06上映","dur":134,"imax":true,"src":"","nm":"星球大战外传：侠盗一号","showDate":"","img":"http://p0.meituan.net/165.220/movie/ef1bc6e7987fcb64558d11cadb86b3be687974.jpg","preSale":0,"vd":"","dir":"加里斯·爱德华斯","star":"菲丽希缇·琼斯,迭戈·鲁纳,艾伦·图代克","cat":"动作,冒险,科幻","wish":100271,"3d":true,"pn":507,"scm":"姜文和子丹，去打太空战","time":"","id":247185},{"late":false,"showInfo":"今天178家影院放映770场","cnms":0,"sn":0,"snum":310139,"sc":8.7,"ver":"2D","rt":"2016-12-30上映","dur":113,"imax":false,"src":"","nm":"情圣","showDate":"","img":"http://p0.meituan.net/165.220/movie/8bd63a54c2ebcb79fbaa3777e2d72d0c199654.jpg","preSale":0,"vd":"","dir":"宋晓飞,董旭","star":"肖央,闫妮,小沈阳","cat":"喜剧,爱情","wish":37660,"3d":false,"pn":144,"scm":"渣男要出轨，结局很崩溃","time":"","id":1188324},{"late":false,"showInfo":"今天191家影院放映738场","cnms":0,"sn":0,"snum":24214,"sc":8.6,"ver":"2D/3D","rt":"2017-01-13上映","dur":86,"imax":false,"src":"","nm":"大卫贝肯之倒霉特工熊","showDate":"","img":"http://p1.meituan.net/165.220/movie/d0f9c85f526557c1d0ad3011e2c83cbb446135.png","preSale":0,"vd":"","dir":"李清舫,张遥函,雪萌","star":"汤水雨,徐佳琦,杨默","cat":"喜剧,冒险,家庭","wish":8342,"3d":true,"pn":79,"scm":"保护北极圈，笨熊命被玄","time":"","id":1197753},{"late":false,"showInfo":"2017-01-28 本周六上映","cnms":0,"sn":0,"snum":4830,"sc":9,"ver":"2D/3D","rt":"本周六上映","dur":91,"imax":false,"src":"","nm":"熊出没·奇幻空间","showDate":"","img":"http://p1.meituan.net/165.220/movie/cfcdb50d181a2111a2b79a0639db0f19764116.png","preSale":1,"vd":"","dir":"丁亮,林永长,林汇达","star":"尚雯婕,鲍春来,曾舜晞","cat":"动画,冒险","wish":23490,"3d":true,"pn":52,"scm":"熊抱春来到，保护金鹿角","time":"","id":1189089},{"late":false,"showInfo":"今天145家影院放映317场","cnms":0,"sn":0,"snum":12630,"sc":8.5,"ver":"2D/3D/中国巨幕","rt":"2017-01-13上映","dur":102,"imax":false,"src":"","nm":"魔弦传说","showDate":"","img":"http://p1.meituan.net/165.220/movie/410402a478c7e9eb35c060ef005070f8521338.jpg","preSale":0,"vd":"","dir":"塔拉维斯·柯奈特","star":"阿特·帕金森,马修·麦康纳,查理兹·塞隆","cat":"动画,奇幻,冒险","wish":13841,"3d":true,"pn":198,"scm":"男孩得庇佑，力战妖灵兽","time":"","id":246463},{"late":false,"showInfo":"今天96家影院放映207场","cnms":0,"sn":0,"snum":285145,"sc":9.4,"ver":"2D/中国巨幕","rt":"2016-12-08上映","dur":139,"imax":false,"src":"","nm":"血战钢锯岭","showDate":"","img":"http://p0.meituan.net/165.220/movie/018ceaadb90ac5c1b9ba33546d1fb746401981.jpg","preSale":0,"vd":"","dir":"梅尔·吉布森","star":"安德鲁·加菲尔德,雨果·维文,卢克·布雷西","cat":"剧情,战争","wish":32064,"3d":false,"pn":198,"scm":"士兵有信仰，战场拒拿枪","time":"","id":338349},{"late":false,"showInfo":"今天91家影院放映188场","cnms":0,"sn":0,"snum":5641,"sc":8,"ver":"2D","rt":"2017-01-13上映","dur":102,"imax":false,"src":"","nm":"天空之眼","showDate":"","img":"http://p1.meituan.net/165.220/movie/aa3edbf989db78fadc693ebee159f4dd3535520.jpg","preSale":0,"vd":"","dir":"加文·胡德","star":"海伦·米伦,亚伦·保尔,艾伦·里克曼","cat":"剧情,悬疑,战争","wish":6812,"3d":false,"pn":55,"scm":"高空狙击手，反恐破阴谋","time":"","id":246230},{"late":false,"showInfo":"今天51家影院放映100场","cnms":0,"sn":0,"snum":214419,"sc":8.5,"ver":"2D/3D/中国巨幕/全景声","rt":"2016-12-23上映","dur":124,"imax":false,"src":"","nm":"铁道飞虎","showDate":"","img":"http://p1.meituan.net/165.220/movie/fb54328788845ca6aaf8362875a699951041538.jpg","preSale":0,"vd":"","dir":"丁晟","star":"成龙,黄子韬,房祖名","cat":"剧情,喜剧,动作","wish":58366,"3d":true,"pn":356,"scm":"铁道抗日寇，有勇更有谋","time":"","id":248916},{"late":false,"showInfo":"今天58家影院放映100场","cnms":0,"sn":0,"snum":22983,"sc":8.7,"ver":"2D/3D","rt":"2017-01-07上映","dur":91,"imax":false,"src":"","nm":"猪猪侠之英雄猪少年","showDate":"","img":"http://p1.meituan.net/165.220/movie/a7b1c628181c0185e1745d4c80c9aba6164580.jpg","preSale":0,"vd":"","dir":"陆锦明,钟裕","star":"易烊千玺,陈志荣,彭雨菲","cat":"喜剧,动画,奇幻","wish":11755,"3d":true,"pn":75,"scm":"猪猪侠归来，再战大反派","time":"","id":1197558},{"late":false,"showInfo":"2017-02-03 下周五上映","cnms":0,"sn":0,"snum":282,"sc":0,"ver":"2D","rt":"下周五上映","dur":99,"imax":false,"src":"","nm":"东北往事之破马张飞","showDate":"","img":"http://p0.meituan.net/165.220/movie/d9d800469e30249c9319dc7c4fa0211651185.jpeg","preSale":1,"vd":"","dir":"郭大雷","star":"贾乃亮,马丽,梁超","cat":"喜剧,动作","wish":21552,"3d":false,"pn":123,"scm":"东北小混混，斗黑帮恶棍","time":"","id":344032},{"late":false,"showInfo":"今天34家影院放映85场","cnms":0,"sn":0,"snum":630803,"sc":8.4,"ver":"2D/3D","rt":"2016-12-16上映","dur":104,"imax":false,"src":"","nm":"长城","showDate":"","img":"http://p0.meituan.net/165.220/movie/e4a3447ebe8c44eea59ab7f68790c7e2179321.jpeg","preSale":0,"vd":"","dir":"张艺谋","star":"马特·达蒙,景甜,佩德罗·帕斯卡","cat":"剧情,冒险,奇幻","wish":242315,"3d":true,"pn":209,"scm":"五军战饕餮，中国魂不灭","time":"","id":246267},{"late":false,"showInfo":"今天25家影院放映47场","cnms":0,"sn":0,"snum":549253,"sc":9.2,"ver":"2D","rt":"2016-12-02上映","dur":107,"imax":false,"src":"","nm":"你的名字。","showDate":"","img":"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","preSale":0,"vd":"","dir":"新海诚","star":"上白石萌音,佟心竹,神木隆之介","cat":"动画,爱情,奇幻","wish":277114,"3d":false,"pn":286,"scm":"寻君千里行，心系君之名","time":"","id":344881},{"late":false,"showInfo":"2017-01-27 本周五上映","cnms":0,"sn":0,"snum":548,"sc":0,"ver":"2D","rt":"本周五上映","dur":116,"imax":false,"src":"","nm":"健忘村","showDate":"","img":"http://p0.meituan.net/165.220/movie/cd23a5f30b3918cf241074bad9589d0d421744.jpg","preSale":1,"vd":"","dir":"陈玉勋","star":"舒淇,王千源,张孝全","cat":"喜剧,奇幻,武侠","wish":13244,"3d":false,"pn":233,"scm":"偏僻小山村，通车换乾坤","time":"","id":345668},{"late":false,"showInfo":"今天18家影院放映31场","cnms":0,"sn":0,"snum":124789,"sc":9.1,"ver":"2D/3D/中国巨幕/全景声","rt":"2016-11-25上映","dur":107,"imax":false,"src":"","nm":"海洋奇缘","showDate":"","img":"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","preSale":0,"vd":"","dir":"罗恩·克莱蒙兹,约翰·马斯克,唐·霍尔,克里斯·威廉姆斯","star":"奥伊伊·卡瓦略,道恩·强森,瑞秋·豪斯","cat":"动画,动作,冒险","wish":42849,"3d":true,"pn":128,"scm":"航海家后代，征程向大海","time":"","id":246222},{"late":false,"showInfo":"今天14家影院放映24场","cnms":0,"sn":0,"snum":150,"sc":0,"ver":"2D/3D","rt":"2017-01-20上映","dur":90,"imax":false,"src":"","nm":"蛋计划","showDate":"","img":"http://p0.meituan.net/165.220/movie/486e0b84b0540c1a2bb08e1ae0615f60120249.jpg","preSale":0,"vd":"","dir":"李杨武","star":"胡婷,周微,孟雨田","cat":"喜剧,动画,冒险","wish":209,"3d":true,"pn":21,"scm":"草根小英雄，拯救大星球","time":"","id":343244},{"late":false,"showInfo":"今天22家影院放映24场","cnms":0,"sn":0,"snum":536,"sc":0,"ver":"2D","rt":"2017-01-20上映","dur":90,"imax":false,"src":"","nm":"心惊胆战","showDate":"","img":"http://p1.meituan.net/165.220/movie/040db77878efddaa622da5c90aca3079393144.jpg","preSale":0,"vd":"","dir":"陈鹏振","star":"惠英红,陈颖欣,黄德斌","cat":"惊悚","wish":842,"3d":false,"pn":26,"scm":"女为情假死，母亲变疯子","time":"","id":1199238},{"late":false,"showInfo":"今天12家影院放映15场","cnms":0,"sn":0,"snum":1443,"sc":9,"ver":"2D/3D","rt":"2017-01-13上映","dur":86,"imax":false,"src":"","nm":"超能龙骑侠","showDate":"","img":"http://p1.meituan.net/165.220/movie/72e473421c5304a7fd2f9f0abbac67021550343.jpg","preSale":0,"vd":"","dir":"刘可欣","star":"山新,乔诗语,李姗姗","cat":"动画,冒险,科幻","wish":6469,"3d":true,"pn":31,"scm":"打败大魔王，重见花果香","time":"","id":346662},{"late":false,"showInfo":"今天8家影院放映13场","cnms":0,"sn":0,"snum":307610,"sc":8.9,"ver":"3D/IMAX 3D/中国巨幕","rt":"2016-11-25上映","dur":133,"imax":true,"src":"","nm":"神奇动物在哪里","showDate":"","img":"http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg","preSale":0,"vd":"","dir":"大卫·叶茨","star":"埃迪·雷德梅恩,凯瑟琳·沃特斯顿,艾莉森·苏朵儿","cat":"冒险,奇幻,家庭","wish":130686,"3d":true,"pn":248,"scm":"神奇动物城，法师显超能","time":"","id":248918},{"late":false,"showInfo":"今天11家影院放映13场","cnms":0,"sn":0,"snum":9088,"sc":8.4,"ver":"2D","rt":"2017-01-06上映","dur":97,"imax":false,"src":"","nm":"玩命直播","showDate":"","img":"http://p0.meituan.net/165.220/movie/5f93a6f494de4778dedd0dff1671663f190718.jpg","preSale":0,"vd":"","dir":"亨利·朱斯特,阿里尔·舒尔曼","star":"艾玛·罗伯茨,戴夫·弗兰科,艾米丽·梅德","cat":"动作,冒险","wish":2328,"3d":false,"pn":149,"scm":"直播出人命，幕后太震惊","time":"","id":367889},{"late":false,"showInfo":"2017-02-01 下周三上映","cnms":0,"sn":0,"snum":118,"sc":0,"ver":"2D/3D","rt":"下周三上映","dur":90,"imax":false,"src":"","nm":"了不起的菲丽西","showDate":"","img":"http://p0.meituan.net/165.220/movie/b7137d7ef1fdd383255bf4d62308da142119370.jpg","preSale":1,"vd":"","dir":"埃里克·韦林,埃里克·萨默","star":"艾丽·范宁,卡莉·蕾·吉普森,戴恩·德哈恩","cat":"喜剧,动画,冒险","wish":7134,"3d":true,"pn":73,"scm":"孤儿院少女，逐梦去巴黎","time":"","id":1042603},{"late":false,"showInfo":"今天9家影院放映12场","cnms":0,"sn":0,"snum":15116,"sc":7.7,"ver":"3D","rt":"2016-12-31上映","dur":79,"imax":false,"src":"","nm":"冰雪女皇之冬日魔咒","showDate":"","img":"http://p1.meituan.net/165.220/movie/43599734212cffe752e257a8f86e61c46575058.jpg","preSale":0,"vd":"","dir":"阿列克谢·特斯蒂斯林","star":"贝拉·索恩,沙尔托·科普雷,肖恩·宾","cat":"喜剧,动画,家庭","wish":50214,"3d":true,"pn":133,"scm":"北风使劲吹，公主又悲催","time":"","id":246276},{"late":false,"showInfo":"今天8家影院放映12场","cnms":0,"sn":0,"snum":49,"sc":0,"ver":"2D","rt":"2017-01-20上映","dur":90,"imax":false,"src":"","nm":"大魔法师孟兜兜","showDate":"","img":"http://p1.meituan.net/165.220/movie/cdb2129dc0fe266c9b98fe40a2546083361581.jpg","preSale":0,"vd":"","dir":"孟晖","star":"郭太旭,杨小兰,石梁一骁","cat":"喜剧,动画","wish":592,"3d":false,"pn":36,"scm":"幻想有魔力，生活有乐趣","time":"","id":1199241},{"late":false,"showInfo":"今天8家影院放映10场","cnms":0,"sn":0,"snum":91876,"sc":7.6,"ver":"2D/中国巨幕/全景声","rt":"2016-12-16上映","dur":125,"imax":false,"src":"","nm":"罗曼蒂克消亡史","showDate":"","img":"http://p0.meituan.net/165.220/movie/c23a59322f0053bba6bb05853b1958507925907.jpg","preSale":0,"vd":"","dir":"程耳","star":"葛优,章子怡,浅野忠信","cat":"剧情,动作,悬疑","wish":60896,"3d":false,"pn":286,"scm":"教父葛大爷，死磕男间谍","time":"","id":246261},{"late":false,"showInfo":"2017-02-14上映","cnms":0,"sn":0,"snum":163,"sc":0,"ver":"2D/IMAX 2D/中国巨幕/全景声","rt":"2017-02-14上映","dur":129,"imax":true,"src":"","nm":"爱乐之城","showDate":"","img":"http://p0.meituan.net/165.220/movie/f4990a965755af1be2a16c421951c48219905345.jpg","preSale":1,"vd":"","dir":"达米恩·查泽雷","star":"瑞恩·高斯林,艾玛·斯通,约翰·传奇","cat":"爱情,歌舞","wish":9175,"3d":false,"pn":126,"scm":"爵士钢琴家，恋爱舞天涯","time":"","id":338436},{"late":false,"showInfo":"今天4家影院放映4场","cnms":0,"sn":0,"snum":5229,"sc":5.2,"ver":"2D","rt":"2017-01-06上映","dur":89,"imax":false,"src":"","nm":"恐怖理发店","showDate":"","img":"http://p0.meituan.net/165.220/movie/ef0e076422b75f9784574c5cc0367d0b136038.jpeg","preSale":0,"vd":"","dir":"陆诗雷","star":"殷果儿,姜星丘,任青安","cat":"爱情,惊悚,悬疑","wish":6983,"3d":false,"pn":22,"scm":"骷髅理发师，猛鬼追命时","time":"","id":343253},{"late":false,"showInfo":"今天3家影院放映4场","cnms":0,"sn":0,"snum":1754,"sc":0,"ver":"2D","rt":"2017-01-13上映","dur":84,"imax":false,"src":"","nm":"逗逗迪迪之美梦年年","showDate":"","img":"http://p0.meituan.net/165.220/movie/bac6981b45b5c188a87c840ecd0c9adb543403.jpg","preSale":0,"vd":"","dir":"张苑,王龙波,陆锦辉,陆锦明","star":"林美秀,曾允凡,孙国卿","cat":"动画,冒险","wish":8312,"3d":false,"pn":26,"scm":"噩梦从天降，兄妹寻真相","time":"","id":342584},{"late":false,"showInfo":"今天3家影院放映4场","cnms":0,"sn":0,"snum":482,"sc":9,"ver":"2D","rt":"2017-01-13上映","dur":110,"imax":false,"src":"","nm":"我的诗篇","showDate":"","img":"http://p1.meituan.net/165.220/movie/c90e380155fe29e7f7b728a44fde28052125871.jpg","preSale":0,"vd":"","dir":"吴飞跃,秦晓宇","star":"乌鸟鸟,陈年喜,老井","cat":"纪录片","wish":1628,"3d":false,"pn":22,"scm":"生产线诗歌，朴素却深刻","time":"","id":341084},{"late":false,"showInfo":"今天3家影院放映3场","cnms":0,"sn":0,"snum":22,"sc":0,"ver":"2D","rt":"2016-12-30上映","dur":110,"imax":false,"src":"","nm":"难忘金银滩","showDate":"","img":"http://p1.meituan.net/165.220/movie/70a956864b29369154c6e424707daba9273079.jpg","preSale":0,"vd":"","dir":"亮子","star":"王一,翟佳,濡雪","cat":"剧情,爱情,战争","wish":342,"3d":false,"pn":80,"scm":"知青建祖国，热血谱赞歌","time":"","id":344762},{"late":false,"showInfo":"今天2家影院放映3场","cnms":0,"sn":0,"snum":1666,"sc":8.2,"ver":"2D","rt":"2017-01-13上映","dur":96,"imax":false,"src":"","nm":"少年巴比伦","showDate":"","img":"http://p1.meituan.net/165.220/movie/4ec62c782751384769be6e38ef9066879306567.jpg","preSale":0,"vd":"","dir":"相国强","star":"董子健,李梦,尚铁龙","cat":"剧情,喜剧,爱情","wish":7388,"3d":false,"pn":126,"scm":"迷茫愣头青，中年忆旧情","time":"","id":247448},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"snum":242766,"sc":7.8,"ver":"2D/中国巨幕/全景声","rt":"2016-12-23上映","dur":128,"imax":false,"src":"","nm":"摆渡人","showDate":"","img":"http://p1.meituan.net/165.220/movie/7f41742a5c2ea24fcd2018ad333451ae193120.jpg","preSale":0,"vd":"","dir":"张嘉佳","star":"梁朝伟,金城武,陈奕迅","cat":"喜剧,爱情","wish":203019,"3d":false,"pn":294,"scm":"情海行舟难，摆渡扬云帆","time":"","id":246388},{"late":false,"showInfo":"今天1家影院放映2场","cnms":0,"sn":0,"snum":13901,"sc":7.7,"ver":"2D","rt":"2016-12-30上映","dur":107,"imax":false,"src":"","nm":"你好，疯子","showDate":"","img":"http://p0.meituan.net/165.220/movie/7746f1a7ca7ad4a9607642f7bf976aff901630.jpg","preSale":0,"vd":"","dir":"饶晓志","star":"万茜,周一围,王自健","cat":"剧情,喜剧,悬疑","wish":23120,"3d":false,"pn":141,"scm":"七疯为正名，欢脱搞事情","time":"","id":345106},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"snum":8476,"sc":8.7,"ver":"2D","rt":"2016-12-30上映","dur":92,"imax":false,"src":"","nm":"北极大冒险","showDate":"","img":"http://p0.meituan.net/165.220/movie/7ba575a552284abeb0b3e8ecc221cb26555835.jpeg","preSale":0,"vd":"","dir":"罗杰·斯波蒂伍德","star":"达科塔·高尤,高兰·维斯耶克,布丽姬·穆娜","cat":"剧情,冒险,家庭","wish":2656,"3d":false,"pn":16,"scm":"小熊找妈妈，北极寻亲旅","time":"","id":627570},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"snum":2353,"sc":8.7,"ver":"2D","rt":"2017-01-01上映","dur":118,"imax":false,"src":"","nm":"单身日记：好孕来袭","showDate":"","img":"http://p1.meituan.net/165.220/movie/df7d088b9ff0bb68e9f7f69ee93b92431015953.jpg","preSale":0,"vd":"","dir":"沙朗·马奎尔","star":"芮妮·齐薇格,科林·费斯,帕特里克·德姆西","cat":"喜剧,爱情","wish":3977,"3d":false,"pn":138,"scm":"好孕来烦恼，孩爸哪里找","time":"","id":342613},{"late":false,"showInfo":"今天2家影院放映2场","cnms":0,"sn":0,"snum":29,"sc":0,"ver":"2D","rt":"2017-01-09上映","dur":98,"imax":false,"src":"","nm":"青海湖畔","showDate":"","img":"http://p1.meituan.net/165.220/movie/50914e1b1bcf0ab254fa669f391fba40797574.png","preSale":0,"vd":"","dir":"沈星浩","star":"秦怡,佟瑞欣,伊力哈木·买买提","cat":"剧情","wish":180,"3d":false,"pn":2,"scm":"青藏遇冻土，气象解难题","time":"","id":366795},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":77,"sc":0,"ver":"2D","rt":"2015-06-10上映","dur":0,"imax":false,"src":"","nm":"白蛇传","showDate":"","img":"http://p1.meituan.net/165.220/movie/4f32f079a982d8c845da5e41562ebfae28009.jpg","preSale":0,"vd":"","dir":"周志刚","star":"金静,金静","cat":"戏曲","wish":172,"3d":false,"pn":0,"scm":"真正大IP，经典永流传","time":"","id":344727},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":283024,"sc":7.8,"ver":"2D/中国巨幕/全景声","rt":"2016-11-18上映","dur":140,"imax":false,"src":"","nm":"我不是潘金莲","showDate":"","img":"http://p1.meituan.net/165.220/movie/8e5eabeadf237a10227a3124419410ef549583.jpg","preSale":0,"vd":"","dir":"冯小刚","star":"范冰冰,郭涛,董成鹏","cat":"剧情,喜剧","wish":185572,"3d":false,"pn":211,"scm":"金莲戏中戏，官场局中局","time":"","id":341749},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":2179,"sc":7.3,"ver":"2D","rt":"2016-12-24上映","dur":95,"imax":false,"src":"","nm":"绝对控制","showDate":"","img":"http://p1.meituan.net/165.220/movie/1fb3e368b4fb93d0eca23dd0304e9a4e133077.jpg","preSale":0,"vd":"","dir":"约翰·摩尔","star":"皮尔斯·布鲁斯南,安娜·弗莱尔,斯戴芬妮·斯考特","cat":"悬疑,科幻,犯罪","wish":6517,"3d":false,"pn":19,"scm":"智能成隐患，邦德也犯难","time":"","id":531857},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":20120,"sc":7.3,"ver":"2D","rt":"2016-12-30上映","dur":89,"imax":false,"src":"","nm":"那年夏天你去了哪里","showDate":"","img":"http://p1.meituan.net/165.220/movie/6b765c72510e7f4cd2f0cd8a6e9b4b7c996096.png","preSale":0,"vd":"","dir":"周隼","star":"宋佳,林家栋,颜卓灵","cat":"悬疑,犯罪","wish":56283,"3d":false,"pn":134,"scm":"绑架十二年，归家惹事端","time":"","id":1187526},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":685,"sc":0,"ver":"2D","rt":"2016-12-31上映","dur":96,"imax":false,"src":"","nm":"人鱼校花","showDate":"","img":"http://p0.meituan.net/165.220/movie/8cd7cb6c44724e3c07f8deebdad98df33855354.jpg","preSale":0,"vd":"","dir":"林云翔,叶茗","star":"邹杨,文卓,田晓天","cat":"喜剧,爱情,奇幻","wish":14238,"3d":false,"pn":28,"scm":"误闯游泳池，人鱼追爱迟","time":"","id":343742},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":53,"sc":0,"ver":"2D","rt":"2017-01-06上映","dur":93,"imax":false,"src":"","nm":"浪漫搭档","showDate":"","img":"http://p0.meituan.net/165.220/movie/327d64025f2a096215843f9aad17ac81247598.jpg","preSale":0,"vd":"","dir":"刘夏同","star":"陈国坤,徐冬梅,刘承俊","cat":"喜剧,爱情,动作","wish":261,"3d":false,"pn":22,"scm":"虽身出戏班，军阀见也颤","time":"","id":1199081},{"late":false,"showInfo":"今天1家影院放映1场","cnms":0,"sn":0,"snum":42,"sc":0,"ver":"2D","rt":"2017-01-20上映","dur":90,"imax":false,"src":"","nm":"缺失的爱","showDate":"","img":"http://p0.meituan.net/165.220/movie/82a0337d984f64bb93e914051f26d7ae74274.jpg","preSale":0,"vd":"","dir":"曾光永","star":"龚蓓苾,郭艳,冯文娟","cat":"剧情","wish":188,"3d":false,"pn":7,"scm":"城市来包裹，乡村大混乱","time":"","id":1199972},{"late":false,"showInfo":"2017-01-24 本周二上映","cnms":0,"sn":0,"snum":42,"sc":0,"ver":"2D","rt":"本周二上映","dur":85,"imax":false,"src":"","nm":"老师也疯狂","showDate":"","img":"http://p1.meituan.net/165.220/movie/b0782b6f12e4281282e61e5a41cf7b3e269937.jpg","preSale":1,"vd":"","dir":"赵宏丽","star":"韩立,方青卓,黄一山","cat":"喜剧","wish":940,"3d":false,"pn":24,"scm":"麻辣新教师，鬼马教学法","time":"","id":343822},{"late":false,"showInfo":"2017-02-05 下周日上映","cnms":0,"sn":0,"snum":47,"sc":0,"ver":"2D","rt":"下周日上映","dur":85,"imax":false,"src":"","nm":"萤火奇兵","showDate":"","img":"http://p0.meituan.net/165.220/movie/45f4c80627636a935780a2e77963e297551097.jpg","preSale":1,"vd":"","dir":"邓伟锋","star":"姚雷,郭盛,李姗姗","cat":"喜剧,动画,奇幻","wish":2402,"3d":false,"pn":39,"scm":"萤火光燎原，灯灯保家园","time":"","id":346477},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":6,"sc":0,"ver":"2D","rt":"null上映","dur":0,"imax":false,"src":"","nm":"难忘的岁月","showDate":"","img":"http://p0.meituan.net/165.220/movie/2b2c6b6b346c5a896b4b07f0e4c5e6544797.jpg","preSale":0,"vd":"","dir":"","star":"陈小艺,刘冠翔,佟瑞欣","cat":"电视剧","wish":0,"3d":false,"pn":0,"scm":"","time":"","id":402719},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":0,"sc":0,"ver":"","rt":"null上映","dur":0,"imax":false,"src":"","nm":"老师也疯狂","showDate":"","img":"http://p0.meituan.net/165.220/mmdb/1dbdf00ff02b21684d9ac34f12ada27e3944.png","preSale":0,"vd":"","dir":"","star":"田原俊彦,野村宏伸,五十嵐いづみ","cat":"电视剧","wish":0,"3d":false,"pn":0,"scm":"","time":"","id":401315},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":0,"sc":7.3,"ver":"2D","rt":"1996-09-19上映","dur":96,"imax":false,"src":"","nm":"浮生","showDate":"","img":"http://p0.meituan.net/165.220/movie/7/6989417.jpg","preSale":0,"vd":"","dir":"罗卓瑶","star":"Annie Yip,Anthony Wong,Julian Pulvermacher","cat":"剧情","wish":1,"3d":false,"pn":1,"scm":"","time":"","id":10964},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":183,"sc":9,"ver":"2D","rt":"2015-07-08上映","dur":150,"imax":false,"src":"","nm":"红楼梦","showDate":"","img":"http://p1.meituan.net/165.220/movie/465278425a182d5d0aebb5edc731534527821.jpg","preSale":0,"vd":"","dir":"龚应恬","star":"翁佳慧,朱冰贞,邵天帅","cat":"戏曲","wish":0,"3d":false,"pn":10,"scm":"红楼风月情，昆剧变电影","time":"","id":257354},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":8841,"sc":7.2,"ver":"2D","rt":"2016-06-09上映","dur":78,"imax":false,"src":"","nm":"泰迪熊之玩具大战","showDate":"","img":"http://p1.meituan.net/165.220/movie/495971f9751f07a720373ad6008146e8575458.jpg","preSale":0,"vd":"","dir":"胡韵","star":"邓小婷,赵奔,白文显","cat":"动画,冒险,喜剧","wish":7076,"3d":false,"pn":8,"scm":"恶势力进攻，泰迪救萌宠","time":"","id":346658},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":1175,"sc":7.2,"ver":"2D","rt":"2016-12-29上映","dur":90,"imax":false,"src":"","nm":"冒牌卧底","showDate":"","img":"http://p0.meituan.net/165.220/movie/e3bb8f6367e67636fa0bf51242bce0a1740066.png","preSale":0,"vd":"","dir":"唐旭","star":"潘粤明,常远,吴樾","cat":"喜剧,犯罪","wish":11985,"3d":false,"pn":77,"scm":"线人不要怕，靠嘴走天下","time":"","id":345970},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":6089,"sc":9.6,"ver":"2D","rt":"2017-01-06上映","dur":91,"imax":false,"src":"","nm":"一路逆风","showDate":"","img":"http://p0.meituan.net/165.220/movie/49f7e42bed14bc2ebe791146d2444ced438579.jpeg","preSale":0,"vd":"","dir":"尼克·威克姆","star":"邓紫棋","cat":"音乐,纪录片","wish":3991,"3d":false,"pn":80,"scm":"紫棋心路史，巨星成长时","time":"","id":1198738},{"late":false,"showInfo":"今天暂无场次","cnms":0,"sn":0,"snum":916,"sc":6.4,"ver":"2D","rt":"2017-01-07上映","dur":80,"imax":false,"src":"","nm":"辛巴达与美人鱼公主","showDate":"","img":"http://p1.meituan.net/165.220/movie/af36e3479b1fae9d5329ea8e509b0e52980137.jpg","preSale":0,"vd":"","dir":"李霞","star":"杨进,唐泽宗,吴凡","cat":"喜剧,冒险,科幻","wish":1844,"3d":false,"pn":25,"scm":"小工变船长，冒险新起航","time":"","id":1198735}]
         */

        private boolean hasNext;
        private List<MoviesBean> movies;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<MoviesBean> getMovies() {
            return movies;
        }

        public void setMovies(List<MoviesBean> movies) {
            this.movies = movies;
        }

        public static class MoviesBean {
            /**
             * late : false
             * showInfo : 今天205家影院放映1898场
             * cnms : 0
             * sn : 0
             * snum : 16914
             * sc : 7.5
             * ver : 2D/中国巨幕
             * rt : 2017-01-20上映
             * dur : 117
             * imax : false
             * src :
             * nm : 降临
             * showDate :
             * img : http://p0.meituan.net/165.220/movie/0807f31f1b8e0058774a23fba89858842258512.jpeg
             * preSale : 0
             * vd :
             * dir : 丹尼斯·维伦纽瓦
             * star : 艾米·亚当斯,杰瑞米·雷纳,福里斯特·惠特克
             * cat : 悬疑,冒险,科幻
             * wish : 16022
             * 3d : false
             * pn : 124
             * scm : 外星来访客，目的难预测
             * time :
             * id : 338387
             */

            private boolean late;
            private String showInfo;
            private int cnms;
            private int sn;
            private int snum;
            private double sc;
            private String ver;
            private String rt;
            private int dur;
            private boolean imax;
            private String src;
            private String nm;
            private String showDate;
            private String img;
            private int preSale;
            private String vd;
            private String dir;
            private String star;
            private String cat;
            private int wish;
            @SerializedName("3d")
            private boolean _$3d;
            private int pn;
            private String scm;
            private String time;
            private int id;

            public boolean isLate() {
                return late;
            }

            public void setLate(boolean late) {
                this.late = late;
            }

            public String getShowInfo() {
                return showInfo;
            }

            public void setShowInfo(String showInfo) {
                this.showInfo = showInfo;
            }

            public int getCnms() {
                return cnms;
            }

            public void setCnms(int cnms) {
                this.cnms = cnms;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public int getSnum() {
                return snum;
            }

            public void setSnum(int snum) {
                this.snum = snum;
            }

            public double getSc() {
                return sc;
            }

            public void setSc(double sc) {
                this.sc = sc;
            }

            public String getVer() {
                return ver;
            }

            public void setVer(String ver) {
                this.ver = ver;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getDur() {
                return dur;
            }

            public void setDur(int dur) {
                this.dur = dur;
            }

            public boolean isImax() {
                return imax;
            }

            public void setImax(boolean imax) {
                this.imax = imax;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getNm() {
                return nm;
            }

            public void setNm(String nm) {
                this.nm = nm;
            }

            public String getShowDate() {
                return showDate;
            }

            public void setShowDate(String showDate) {
                this.showDate = showDate;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getPreSale() {
                return preSale;
            }

            public void setPreSale(int preSale) {
                this.preSale = preSale;
            }

            public String getVd() {
                return vd;
            }

            public void setVd(String vd) {
                this.vd = vd;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public int getWish() {
                return wish;
            }

            public void setWish(int wish) {
                this.wish = wish;
            }

            public boolean is_$3d() {
                return _$3d;
            }

            public void set_$3d(boolean _$3d) {
                this._$3d = _$3d;
            }

            public int getPn() {
                return pn;
            }

            public void setPn(int pn) {
                this.pn = pn;
            }

            public String getScm() {
                return scm;
            }

            public void setScm(String scm) {
                this.scm = scm;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "hasNext=" + hasNext +
                    ", movies=" + movies +
                    '}';
        }
    }
}
