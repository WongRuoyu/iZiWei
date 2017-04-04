package com.wong.iZiWei



/**
 * Created by Wong on 2016/5/22 0022.
 */
class MingPan(val lBirthDay: LunarBirthday) extends MingPanTables {
  private val _yearGan = this.lBirthDay.lunaD.year.tiangan
  private val _yearZhi = this.lBirthDay.lunaD.year.dizhi
  private val _month = this.lBirthDay.lunaD.month
  private val _day = this.lBirthDay.lunaD.day
  //  private val _month = this.lBirthDay.lunaD
  private val _hour = lBirthDay.hour
  //  lazy val stars = for (name <- StarNames.values) yield new Star(name)
  lazy val gonghuans = for (name <- GongHuanNames.values) yield new GongHuan(name)

  lazy val holders = Holder(DiZhi.ZI) :: Holder(DiZhi.CHOU) :: Holder(DiZhi.YIN) :: Holder(DiZhi.MAO) :: Holder(DiZhi.CHEN) :: Holder(DiZhi.SI) :: Holder(DiZhi.WU) :: Holder(DiZhi.WEI) :: Holder(DiZhi.SHEN) :: Holder(DiZhi.YOU) :: Holder(DiZhi.XU) :: Holder(DiZhi.HAI) :: Nil

  def init = {
    val mingGong = posMingGong
    //将星座按置各个宫位
    for (name <- StarNames.values) {
      posStar(name).foreach {
        pos =>
          holders(pos.id).addStar(new Star(name))
          println(pos + "Gong add star:" + name.toString)
      }
    }

  }

  def posStar(name: StarNames.Value): List[DiZhi.Value] = name.id match {
    case 0 => posZiWei
    case 1 => posTianJi
    case 2 => posTaiYang
    case 3 => posWuQu
    case 4 => posTianTong
    case 5 => posLianZhen
    case 6 => posTianFu
    case 7 => posTaiYin
    case 8 => posTanLang
    case 9 => posJuMen
    case 10 => posTianXiang
    case 11 => posTianLiang
    case 12 => posQiSha
    case 13 => posPoJun
    case 14 => posHuoXing
    case 15 => posLingXing
    case 16 => posTuoLuo
    case 17 => posQingYang
    case 18 => posZuoFu
    case 19 => posYouBi
    case 20 => posTianKui
    case 21 => posTianYue
    case 22 => posWenChang
    case 23 => posWenQu
    case 24 => posLuCun
    case 25 => posTianMa
    case 26 => posDiKong
    case 27 => posDiJie
    case 28 => posLongChi
    case 29 => posFengGe
    case 30 => posTianKu
    case 31 => posTianXu
    case 32 => posHongLuan
    case 33 => posTianXi
    case 34 => posGuChen
    case 35 => posGuaSu
    case 36 => posTianDe
    case 37 => posYueDe
    case 38 => posHuaGai
    case 39 => posTianCai
    case 40 => posTianShou
    case 41 => posPoSui
    case 42 => posXianChi
    case 43 => posDaHao
    case 44 => posManLian
    case 45 => posTianKong
    case 46 => posXunKong
    case 47 => posJieKong
    case 48 => posTianChu
    case 49 => posTianYue2
    case 50 => posTianXing
    case 51 => posTianYao
    case 52 => posTianWu
    case 53 => posJieShen
    case 54 => posYinSha
    case 55 => posTaiFu
    case 56 => posFengGao
    case 57 => posSanTai
    case 58 => posBaZuo
    case 59 => posEnGuang
    case 60 => posTianGui
    case _ => Nil
  }


  def posTianCai = DiZhi.beginAt(DiZhi.ZI)(this._yearZhi.id) :: Nil

  //  lazy val stars = Map[DiZhi.Value, List[Star]]

  def posMingGong = this.tbMingGong(_hour.id)(_month - 1) :: Nil


  def posShenGong = this.tbShenGong(_hour.id)(_month - 1) :: Nil


  def posGongGan(dizhi: DiZhi.Value) = this.tbGongGan(_yearGan.id)(dizhi.id) :: Nil

  def wxj = this.tbWXJ(_yearGan.id)(posMingGong.head.id) :: Nil

  def posZiWei = this.tbZiWei(_day - 1)(wxj.head - 2) :: Nil

  def posTianJi = this.tbTianJi(this.posZiWei.head.id) :: Nil

  def posTaiYang = this.tbTaiYang(this.posZiWei.head.id) :: Nil

  def posWuQu = this.tbWuQu(this.posZiWei.head.id) :: Nil

  def posTianTong = this.tbTianTong(this.posZiWei.head.id) :: Nil

  def posLianZhen = this.tbLianZhen(this.posZiWei.head.id) :: Nil

  def posTianFu = this.tbTianFu(this.posZiWei.head.id) :: Nil

  def posTaiYin = this.tbTaiYin(posTianFu.head.id) :: Nil

  def posTanLang = this.tbTanLang(posTianFu.head.id) :: Nil

  def posJuMen = this.tbJuMen(posTianFu.head.id) :: Nil

  def posTianXiang = this.tbTianXiang(posTianFu.head.id) :: Nil

  def posTianLiang = this.tbTianLiang(posTianFu.head.id) :: Nil

  def posQiSha = this.tbQiSha(posTianFu.head.id) :: Nil

  def posPoJun = this.tbPoJun(posTianFu.head.id) :: Nil

  def posLuCun = this.tbLuCun(this._yearGan.id) :: Nil

  def posQingYang = this.tbQingYang(this._yearGan.id) :: Nil

  def posTuoLuo = this.tbTuoLuo(this._yearGan.id) :: Nil

  def posTianKui = this.tbTianKui(this._yearGan.id) :: Nil

  def posTianYue = this.tbTianYue(this._yearGan.id) :: Nil

  def posTianGuan = this.tbTianGuan(this._yearGan.id) :: Nil

  def posTianFu2 = this.tbTianFu2(this._yearGan.id) :: Nil

  def posTianChu = this.tbTianChu(this._yearGan.id) :: Nil

  def posJieKong = this.tbJieKong(this._yearGan.id) :: Nil

  def posTianMa = this.tbTianMa(this._yearZhi.id) :: Nil

  def posTianKong = this.tbTianKong(this._yearZhi.id) :: Nil

  def posTianKu = this.tbTianKu(this._yearZhi.id) :: Nil

  def posTianXu = this.tbTianXu(this._yearZhi.id) :: Nil

  def posLongChi = this.tbLongChi(this._yearZhi.id) :: Nil

  def posFengGe = this.tbFengGe(this._yearZhi.id) :: Nil

  def posHongLuan = this.tbHongLuan(this._yearZhi.id) :: Nil

  def posTianXi = this.tbTianXi(this._yearZhi.id) :: Nil

  def posGuChen = this.tbGuChen(this._yearZhi.id) :: Nil

  def posGuaSu = this.tbGuaSu(this._yearZhi.id) :: Nil

  def posZuoFu = this.tbZuoFu(this._month - 1) :: Nil

  def posYouBi = this.tbYouBi(this._month - 1) :: Nil

  def posTianXing = this.tbTianXing(this._month - 1) :: Nil

  def posTianYao = this.tbTianYao(this._month - 1) :: Nil

  def posJieShen = this.tbJieShen(this._month - 1) :: Nil

  def posTianWu = this.tbTianWu(this._month - 1) :: Nil

  def posTianYue2 = this.tbTianYue2(this._month - 1) :: Nil

  def posYinSha = this.tbYinSha(this._month - 1) :: Nil

  def posTianShou = DiZhi.beginAt(this.posShenGong.head)(this._yearZhi.id) :: Nil

  def posYueDe = this.tbYueDe(this._yearZhi.id) :: Nil

  def posTianDe = this.tbTianDe(this._yearZhi.id) :: Nil

  def posNianJie = this.tbNianJie(this._yearZhi.id) :: Nil

  def posJieSha = this.tbJieSha(this._yearZhi.id) :: Nil

  def posDaHao = this.tbDaHao(this._yearZhi.id) :: Nil

  def posXianChi = this.tbXianChi(this._yearZhi.id) :: Nil

  def posHuaGai = this.tbHuaGai(this._yearZhi.id) :: Nil

  def posPoSui = this.tbPoSui(this._yearZhi.id) :: Nil

  def posManLian = this.tbManLian(this._yearZhi.id) :: Nil

  def posSanTai = {
    val tem = this._day % 12;
    DiZhi.beginAt(this.posZuoFu.head)(tem) :: Nil
  }


  //  def posSanTai = ((DiZhi.beginAt(this.posZuoFu.head) :: DiZhi.beginAt(this.posZuoFu.head) :: DiZhi.beginAt(this.posZuoFu.head))(this._day - 1)) :: Nil

  def posBaZuo: List[DiZhi.Value] = {
    val tem = this._day % 12;
    DiZhi.beginAt(this.posYouBi.head).reverse(tem) :: Nil;
  }


  def posWenChang = this.tbWenChang(this._hour.id) :: Nil

  def posWenQu = this.tbWenQu(this._hour.id) :: Nil

  def posHuoXing = this.tbHuoXing(this._yearGan.id)(this._hour.id) :: Nil

  def posLingXing = this.tbLingXing(this._yearGan.id)(this._hour.id) :: Nil

  def posEnGuang = {
    val index = this._day % 12
    DiZhi.beginAt(this.posWenChang.head)(index - 2) :: Nil
  }

  def posTianGui = {
    val index = this._day % 12
    DiZhi.beginAt(this.posWenQu.head)(index - 2) :: Nil
  }

  def posDiJie = this.tbDiJie(this._hour.id) :: Nil

  def posDiKong = this.tbDiKong(this._hour.id) :: Nil

  def posTaiFu = this.tbTaiFu(this._hour.id) :: Nil

  def posFengGao = this.tbFengGao(this._hour.id) :: Nil

  //旬空，两位
  def posXunKong = {
    val offset = TianGan.GUI.id - this._yearGan.id + 1;
    DiZhi.beginAt(this._yearZhi).slice(offset, offset + 1).toList
  }


}

object MingPan {
  def apply(lBirthDay: LunarBirthday) = new MingPan(lBirthDay)
}

trait MingPanTables {

  lazy val tbSiHua = Array(Map(SiHuaNames.KE -> StarNames.WUQU, SiHuaNames.QUAN -> StarNames.POJUN, SiHuaNames.LU -> StarNames.LIANZHEN, SiHuaNames.JI -> StarNames.TAIYANG),
    Map(SiHuaNames.KE -> StarNames.ZIWEI, SiHuaNames.QUAN -> StarNames.TIANLIANG, SiHuaNames.LU -> StarNames.TIANJI, SiHuaNames.JI -> StarNames.TAIYIN),
    Map(SiHuaNames.KE -> StarNames.WENCHANG, SiHuaNames.QUAN -> StarNames.TIANJI, SiHuaNames.LU -> StarNames.TIANTONG, SiHuaNames.JI -> StarNames.LIANZHEN),
    Map(SiHuaNames.KE -> StarNames.TIANJI, SiHuaNames.QUAN -> StarNames.TIANTONG, SiHuaNames.LU -> StarNames.TAIYIN, SiHuaNames.JI -> StarNames.JUMEN),
    Map(SiHuaNames.KE -> StarNames.TAIYANG, SiHuaNames.QUAN -> StarNames.TAIYIN, SiHuaNames.LU -> StarNames.TANLANG, SiHuaNames.JI -> StarNames.TIANJI),
    Map(SiHuaNames.KE -> StarNames.TIANLIANG, SiHuaNames.QUAN -> StarNames.TANLANG, SiHuaNames.LU -> StarNames.WUQU, SiHuaNames.JI -> StarNames.WENQU),
    Map(SiHuaNames.KE -> StarNames.TIANFU, SiHuaNames.QUAN -> StarNames.WUQU, SiHuaNames.LU -> StarNames.TAIYANG, SiHuaNames.JI -> StarNames.TIANTONG),
    Map(SiHuaNames.KE -> StarNames.WENQU, SiHuaNames.QUAN -> StarNames.TAIYANG, SiHuaNames.LU -> StarNames.JUMEN, SiHuaNames.JI -> StarNames.WENQU),
    Map(SiHuaNames.KE -> StarNames.TIANFU, SiHuaNames.QUAN -> StarNames.ZIWEI, SiHuaNames.LU -> StarNames.TIANLIANG, SiHuaNames.JI -> StarNames.WUQU),
    Map(SiHuaNames.KE -> StarNames.TAIYIN, SiHuaNames.QUAN -> StarNames.JUMEN, SiHuaNames.LU -> StarNames.POJUN, SiHuaNames.JI -> StarNames.TANLANG))

  lazy val tbLuCun = Array(DiZhi.YIN, DiZhi.MAO, DiZhi.SI, DiZhi.WU, DiZhi.SI, DiZhi.WU, DiZhi.SHEN, DiZhi.YOU, DiZhi.HAI, DiZhi.ZI)
  lazy val tbQingYang = Array(DiZhi.MAO, DiZhi.CHEN, DiZhi.WU, DiZhi.WEI, DiZhi.WU, DiZhi.YOU, DiZhi.XU, DiZhi.ZI, DiZhi.CHOU)
  lazy val tbTuoLuo = Array(DiZhi.CHOU, DiZhi.YIN, DiZhi.HAI, DiZhi.SI, DiZhi.HAI, DiZhi.SI, DiZhi.WEI, DiZhi.SHEN, DiZhi.XU, DiZhi.HAI)
  lazy val tbTianKui = Array(DiZhi.CHOU, DiZhi.ZI, DiZhi.HAI, DiZhi.HAI, DiZhi.CHOU, DiZhi.ZI, DiZhi.CHOU, DiZhi.WU, DiZhi.MAO, DiZhi.MAO)
  lazy val tbTianYue = Array(DiZhi.WEI, DiZhi.SHEN, DiZhi.YOU, DiZhi.YOU, DiZhi.WEI, DiZhi.SHEN, DiZhi.WEI, DiZhi.YIN, DiZhi.SI, DiZhi.SI)
  lazy val tbTianGuan = Array(DiZhi.WEI, DiZhi.CHEN, DiZhi.SI, DiZhi.YIN, DiZhi.MAO, DiZhi.YOU, DiZhi.HAI, DiZhi.YOU, DiZhi.XU, DiZhi.WU)
  //天福
  lazy val tbTianFu2 = Array(DiZhi.YOU, DiZhi.SHEN, DiZhi.ZI, DiZhi.HAI, DiZhi.MAO, DiZhi.YIN, DiZhi.WU, DiZhi.SI, DiZhi.WU, DiZhi.SI)
  lazy val tbTianChu = Array(DiZhi.SI, DiZhi.WU, DiZhi.ZI, DiZhi.SI, DiZhi.WU, DiZhi.SHEN, DiZhi.YIN, DiZhi.WU, DiZhi.YOU, DiZhi.HAI)
  lazy val tbJieKong = Array(DiZhi.SHEN, DiZhi.WU, DiZhi.CHEN, DiZhi.YIN, DiZhi.ZI, DiZhi.SHEN, DiZhi.WU, DiZhi.CHEN, DiZhi.YIN, DiZhi.ZI)
  //支系诸星
  lazy val tbTianMa = Array(DiZhi.YIN, DiZhi.HAI, DiZhi.SHEN, DiZhi.SI, DiZhi.YIN, DiZhi.HAI, DiZhi.SHEN, DiZhi.SI, DiZhi.YIN, DiZhi.HAI, DiZhi.SHEN, DiZhi.SI)
  lazy val tbTianKong = DiZhi.beginAt(DiZhi.CHOU)
  lazy val tbTianKu = DiZhi.beginAt(DiZhi.WEI).reverse
  lazy val tbTianXu = DiZhi.beginAt(DiZhi.WU)
  lazy val tbLongChi = DiZhi.beginAt(DiZhi.CHEN)
  lazy val tbFengGe = DiZhi.beginAt(DiZhi.HAI).reverse
  lazy val tbTianXi = DiZhi.beginAt(DiZhi.XU).reverse
  lazy val tbHongLuan = DiZhi.beginAt(DiZhi.CHEN).reverse
  lazy val tbGuChen = Array(DiZhi.YIN, DiZhi.YIN, DiZhi.SI, DiZhi.SI, DiZhi.SI, DiZhi.SHEN, DiZhi.SHEN, DiZhi.SHEN, DiZhi.HAI, DiZhi.HAI, DiZhi.HAI, DiZhi.YIN)
  lazy val tbGuaSu = Array(DiZhi.XU, DiZhi.XU, DiZhi.CHOU, DiZhi.CHOU, DiZhi.CHOU, DiZhi.CHEN, DiZhi.CHEN, DiZhi.CHEN, DiZhi.WEI, DiZhi.WEI, DiZhi.WEI, DiZhi.XU)


  //月系诸星
  lazy val tbZuoFu = DiZhi.beginAt(DiZhi.CHEN)
  lazy val tbYouBi = DiZhi.beginAt(DiZhi.HAI).reverse
  lazy val tbTianXing = DiZhi.beginAt(DiZhi.YOU)
  lazy val tbTianYao = DiZhi.beginAt(DiZhi.CHOU)
  lazy val tbJieShen = Array(DiZhi.SHEN, DiZhi.SHEN, DiZhi.XU, DiZhi.XU, DiZhi.ZI, DiZhi.ZI, DiZhi.YIN, DiZhi.YIN, DiZhi.CHEN, DiZhi.CHEN, DiZhi.WU, DiZhi.WU)
  lazy val tbTianWu = Array(DiZhi.SI, DiZhi.SHEN, DiZhi.YIN, DiZhi.HAI, DiZhi.SI, DiZhi.SHEN, DiZhi.YIN, DiZhi.HAI, DiZhi.SI, DiZhi.SHEN, DiZhi.YIN, DiZhi.HAI)
  //天月
  lazy val tbTianYue2 = Array(DiZhi.XU, DiZhi.SI, DiZhi.CHEN, DiZhi.YIN, DiZhi.WEI, DiZhi.MAO, DiZhi.HAI, DiZhi.WEI, DiZhi.YIN, DiZhi.WU, DiZhi.XU, DiZhi.YIN)
  lazy val tbYinSha = Array(DiZhi.YIN, DiZhi.ZI, DiZhi.XU, DiZhi.SHEN, DiZhi.WU, DiZhi.CHEN, DiZhi.YIN, DiZhi.ZI, DiZhi.XU, DiZhi.SHEN, DiZhi.WU, DiZhi.CHEN)

  lazy val tbYueDe = DiZhi.beginAt(DiZhi.SI)
  lazy val tbTianDe = DiZhi.beginAt(DiZhi.YOU)
  lazy val tbNianJie = DiZhi.beginAt(DiZhi.HAI).reverse
  lazy val tbJieSha = Array(DiZhi.SI, DiZhi.YIN, DiZhi.HAI, DiZhi.SHEN, DiZhi.SI, DiZhi.YIN, DiZhi.HAI, DiZhi.SHEN, DiZhi.SI, DiZhi.YIN, DiZhi.HAI, DiZhi.SHEN)

  lazy val tbDaHao = Array(DiZhi.WU, DiZhi.WEI, DiZhi.YOU, DiZhi.SHEN, DiZhi.HAI, DiZhi.XU, DiZhi.CHOU, DiZhi.ZI, DiZhi.MAO, DiZhi.YIN, DiZhi.SI, DiZhi.CHEN)
  lazy val tbXianChi = Array(DiZhi.YOU, DiZhi.WU, DiZhi.MAO, DiZhi.ZI, DiZhi.YOU, DiZhi.WU, DiZhi.MAO, DiZhi.ZI, DiZhi.YOU, DiZhi.WU, DiZhi.MAO, DiZhi.ZI)

  lazy val tbHuaGai = Array(DiZhi.CHEN, DiZhi.CHOU, DiZhi.XU, DiZhi.WEI, DiZhi.CHEN, DiZhi.CHOU, DiZhi.XU, DiZhi.WEI, DiZhi.CHEN, DiZhi.CHOU, DiZhi.XU, DiZhi.WEI)
  lazy val tbPoSui = Array(DiZhi.SI, DiZhi.CHOU, DiZhi.YOU, DiZhi.SI, DiZhi.CHOU, DiZhi.YOU, DiZhi.SI, DiZhi.CHOU, DiZhi.YOU, DiZhi.SI, DiZhi.CHOU, DiZhi.YOU)
  lazy val tbManLian = Array(DiZhi.SHEN, DiZhi.YOU, DiZhi.XU, DiZhi.SI, DiZhi.WU, DiZhi.WEI, DiZhi.YIN, DiZhi.MAO, DiZhi.CHEN, DiZhi.HAI, DiZhi.ZI, DiZhi.CHOU)
  //时系诸星
  lazy val tbWenChang = DiZhi.beginAt(DiZhi.HAI).reverse
  lazy val tbWenQu = DiZhi.beginAt(DiZhi.CHEN)

  lazy val tbHuoXing = Array(DiZhi.beginAt(DiZhi.YIN), DiZhi.beginAt(DiZhi.MAO), DiZhi.beginAt(DiZhi.CHOU), DiZhi.beginAt(DiZhi.YOU),
    DiZhi.beginAt(DiZhi.YIN), DiZhi.beginAt(DiZhi.MAO), DiZhi.beginAt(DiZhi.CHOU), DiZhi.beginAt(DiZhi.YOU),
    DiZhi.beginAt(DiZhi.YIN), DiZhi.beginAt(DiZhi.MAO), DiZhi.beginAt(DiZhi.CHOU), DiZhi.beginAt(DiZhi.YOU))
  lazy val tbLingXing = Array(DiZhi.beginAt(DiZhi.XU), DiZhi.beginAt(DiZhi.XU), DiZhi.beginAt(DiZhi.MAO), DiZhi.beginAt(DiZhi.XU),
    DiZhi.beginAt(DiZhi.XU), DiZhi.beginAt(DiZhi.XU), DiZhi.beginAt(DiZhi.MAO), DiZhi.beginAt(DiZhi.XU),
    DiZhi.beginAt(DiZhi.XU), DiZhi.beginAt(DiZhi.XU), DiZhi.beginAt(DiZhi.MAO), DiZhi.beginAt(DiZhi.XU))
  lazy val tbDiJie = DiZhi.beginAt(DiZhi.HAI)
  lazy val tbDiKong = DiZhi.values.toArray.reverse
  lazy val tbTaiFu = DiZhi.beginAt(DiZhi.WU)
  lazy val tbFengGao = DiZhi.beginAt(DiZhi.YIN)

  lazy val tbTaiYin = DiZhi.beginAt(DiZhi.CHOU)
  lazy val tbTanLang = DiZhi.beginAt(DiZhi.YIN)
  lazy val tbJuMen = DiZhi.beginAt(DiZhi.MAO)
  lazy val tbTianXiang = DiZhi.beginAt(DiZhi.CHEN)
  lazy val tbTianLiang = DiZhi.beginAt(DiZhi.SI)
  lazy val tbQiSha = DiZhi.beginAt(DiZhi.WU)
  lazy val tbPoJun = DiZhi.beginAt(DiZhi.XU)


  lazy val tbTianJi = DiZhi.beginAt(DiZhi.HAI)
  lazy val tbTaiYang = DiZhi.beginAt(DiZhi.YOU)
  lazy val tbWuQu = DiZhi.beginAt(DiZhi.SHEN)
  lazy val tbTianTong = DiZhi.beginAt(DiZhi.WEI)
  lazy val tbLianZhen = DiZhi.beginAt(DiZhi.CHEN)
  lazy val tbTianFu = Array(DiZhi.CHEN, DiZhi.MAO, DiZhi.YIN, DiZhi.CHOU, DiZhi.ZI, DiZhi.HAI, DiZhi.XU, DiZhi.YOU, DiZhi.SHEN, DiZhi.WEI, DiZhi.WU, DiZhi.SI)

  lazy val tbZiWei = Array(Array(DiZhi.CHOU, DiZhi.CHEN, DiZhi.HAI, DiZhi.WU, DiZhi.YOU),
    Array(DiZhi.YIN, DiZhi.CHOU, DiZhi.CHEN, DiZhi.HAI, DiZhi.WU),
    Array(DiZhi.YIN, DiZhi.YIN, DiZhi.CHOU, DiZhi.CHEN, DiZhi.HAI),
    Array(DiZhi.MAO, DiZhi.SI, DiZhi.YIN, DiZhi.CHOU, DiZhi.CHEN),
    Array(DiZhi.MAO, DiZhi.YIN, DiZhi.ZI, DiZhi.YIN, DiZhi.CHOU),
    Array(DiZhi.CHEN, DiZhi.MAO, DiZhi.SI, DiZhi.WEI, DiZhi.YIN),
    Array(DiZhi.CHEN, DiZhi.WU, DiZhi.YIN, DiZhi.ZI, DiZhi.XU),
    Array(DiZhi.SI, DiZhi.MAO, DiZhi.MAO, DiZhi.SI, DiZhi.WEI),
    Array(DiZhi.SI, DiZhi.CHEN, DiZhi.CHOU, DiZhi.YIN, DiZhi.CHOU),
    Array(DiZhi.WU, DiZhi.WEI, DiZhi.WU, DiZhi.MAO, DiZhi.SI),
    Array(DiZhi.WU, DiZhi.CHEN, DiZhi.MAO, DiZhi.YIN, DiZhi.YIN),
    Array(DiZhi.WEI, DiZhi.SI, DiZhi.CHEN, DiZhi.CHOU, DiZhi.MAO),
    Array(DiZhi.WEI, DiZhi.SHEN, DiZhi.YIN, DiZhi.WU, DiZhi.HAI),
    Array(DiZhi.SHEN, DiZhi.SI, DiZhi.WEI, DiZhi.MAO, DiZhi.SHEN),
    Array(DiZhi.SHEN, DiZhi.WU, DiZhi.CHEN, DiZhi.CHEN, DiZhi.CHOU),
    Array(DiZhi.YOU, DiZhi.YOU, DiZhi.SI, DiZhi.YOU, DiZhi.WU),
    Array(DiZhi.YOU, DiZhi.WEI, DiZhi.MAO, DiZhi.YIN, DiZhi.MAO),
    Array(DiZhi.XU, DiZhi.WEI, DiZhi.SHEN, DiZhi.WEI, DiZhi.CHEN),
    Array(DiZhi.XU, DiZhi.XU, DiZhi.SI, DiZhi.CHEN, DiZhi.ZI),
    Array(DiZhi.HAI, DiZhi.WEI, DiZhi.WU, DiZhi.SI, DiZhi.YOU),
    Array(DiZhi.HAI, DiZhi.SHEN, DiZhi.CHEN, DiZhi.WU, DiZhi.YIN),
    Array(DiZhi.ZI, DiZhi.HAI, DiZhi.YOU, DiZhi.MAO, DiZhi.WEI),
    Array(DiZhi.ZI, DiZhi.SHEN, DiZhi.WU, DiZhi.SHEN, DiZhi.CHEN),
    Array(DiZhi.CHOU, DiZhi.YOU, DiZhi.WEI, DiZhi.SI, DiZhi.SI),
    Array(DiZhi.CHOU, DiZhi.ZI, DiZhi.SI, DiZhi.WU, DiZhi.CHOU),
    Array(DiZhi.YIN, DiZhi.YOU, DiZhi.XU, DiZhi.HAI, DiZhi.XU),
    Array(DiZhi.YIN, DiZhi.XU, DiZhi.WEI, DiZhi.CHEN, DiZhi.MAO),
    Array(DiZhi.MAO, DiZhi.CHOU, DiZhi.SHEN, DiZhi.YOU, DiZhi.SHEN),
    Array(DiZhi.MAO, DiZhi.XU, DiZhi.WU, DiZhi.WU, DiZhi.SI),
    Array(DiZhi.CHEN, DiZhi.HAI, DiZhi.HAI, DiZhi.WEI, DiZhi.WU)
  )

  //五行局
  lazy val tbWXJ = Array(Array(2, 2, 6, 6, 3, 3, 5, 5, 4, 4, 6, 6),
    Array(6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 5, 5),
    Array(5, 5, 3, 3, 2, 2, 4, 4, 6, 6, 3, 3),
    Array(3, 3, 4, 4, 6, 6, 2, 2, 5, 5, 4, 4),
    Array(4, 4, 2, 2, 5, 5, 6, 6, 3, 3, 2, 2),
    Array(2, 2, 6, 6, 3, 3, 5, 5, 4, 4, 6, 6),
    Array(6, 6, 5, 5, 4, 4, 3, 3, 2, 2, 5, 5),
    Array(5, 5, 3, 3, 2, 2, 4, 4, 6, 6, 3, 3),
    Array(3, 3, 4, 4, 6, 6, 2, 2, 5, 5, 4, 4),
    Array(4, 4, 2, 2, 5, 5, 6, 6, 3, 3, 2, 2))

  //十二宫天干表
  lazy val tbGongGan = Array(Array(TianGan.BING, TianGan.DING) ++ TianGan.beginAt(TianGan.BING),
    Array(TianGan.WU, TianGan.JI) ++ TianGan.beginAt(TianGan.WU),
    Array(TianGan.GENG, TianGan.XIN) ++ TianGan.beginAt(TianGan.GENG),
    Array(TianGan.REN, TianGan.GUI) ++ TianGan.beginAt(TianGan.REN),
    Array(TianGan.JIA, TianGan.YI) ++ TianGan.beginAt(TianGan.JIA),
    Array(TianGan.BING, TianGan.DING) ++ TianGan.beginAt(TianGan.BING),
    Array(TianGan.WU, TianGan.JI) ++ TianGan.beginAt(TianGan.WU),
    Array(TianGan.GENG, TianGan.XIN) ++ TianGan.beginAt(TianGan.GENG),
    Array(TianGan.REN, TianGan.GUI) ++ TianGan.beginAt(TianGan.REN),
    Array(TianGan.JIA, TianGan.YI) ++ TianGan.beginAt(TianGan.JIA)
  )


  //命宫位置表格
  lazy val tbMingGong = Array(DiZhi.beginAt(DiZhi.YIN), DiZhi.beginAt(DiZhi.CHOU), DiZhi.beginAt(DiZhi.ZI),
    DiZhi.beginAt(DiZhi.HAI), DiZhi.beginAt(DiZhi.XU), DiZhi.beginAt(DiZhi.YOU), DiZhi.beginAt(DiZhi.SHEN),
    DiZhi.beginAt(DiZhi.WEI), DiZhi.beginAt(DiZhi.WU), DiZhi.beginAt(DiZhi.SI), DiZhi.beginAt(DiZhi.CHEN), DiZhi.beginAt(DiZhi.MAO))


  //身宫位置表格
  lazy val tbShenGong = for (gong <- DiZhi.beginAt(DiZhi.YIN)) yield DiZhi.beginAt(gong)


}

trait MingPanUtils {
  def FengGong(dizhi: DiZhi.Value) = DiZhi.beginAt(dizhi)(6) :: Nil


  def HeGong(dizhi: DiZhi.Value) = {
    val seq = DiZhi.beginAt(dizhi)
    seq(0) :: seq(4) :: seq(8) :: Nil
  }

  def SanFangSiZheng(dizhi: DiZhi.Value) = this.HeGong(dizhi) :: this.FengGong(dizhi)
}