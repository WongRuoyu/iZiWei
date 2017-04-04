package com.wong.iZiWei


/**
 * Created by Wong on 2016/5/22 0022.
 */
class Star(val n: StarNames.Value) extends Light with StarLevel {
  val name = n

  override def toString = name.toString

  def light(dizhi: DiZhi.Value) = this.tblight(name.id)(dizhi.id)

  def isFirstLel = this.firstLevel.contains(this.name.toString)

  def isSecLeval = this.secLevel.contains(this.name.toString)
}

object Star {
  def apply(n: StarNames.Value) = new Star(n)
}

trait StarLevel {
  lazy val firstLevel = "紫薇" :: "天机" :: "太阳" :: "武曲" :: "天同" :: "廉贞" :: "天府" :: "太阴" :: "贪狼" :: "巨门" :: "天相" :: "天梁" :: "七杀" :: "破军" :: "左辅" :: "右弼" :: "祿存" :: "擎羊" :: "陀罗" :: "天魁" :: "天钺" :: Nil
  lazy val secLevel = "地劫" :: "地空" :: "台辅" :: "封诰" :: "天刑" :: "天姚" :: "天巫" :: "天月" :: "阴煞" :: "三台" :: "八座" :: "恩光" :: "天贵" :: "天官" :: "天福" :: "天厨" ::
    "天马" :: "解神" :: "天哭" :: "天虚" :: "龙池" :: "凤阁" :: "红鸾" :: "天喜" :: "孤辰" :: "寡宿" :: "蛮廉" :: "破碎" :: "天空" :: "月德" :: "天才" :: "天寿" ::
    Nil
}

trait Light {
  private lazy val ltZiWei = Array(2, 0, 0, 1, 4, 1, 0, 0, 1, 2, 3, 1)
  lazy val ltTianJi = Array(0, 4, 1, 1, 0, 2, 0, 4, 2, 1, 0, 2)
  lazy val ltTaiYang = Array(4, 4, 1, 0, 1, 1, 0, 2, 3, 3, 4, 4)
  lazy val ltWuQu = Array(1, 0, 3, 4, 0, 2, 1, 0, 2, 1, 0, 2)
  lazy val ltTianTong = Array(1, 4, 3, 0, 2, 0, 4, 4, 1, 2, 2, 0)
  lazy val ltLianZhen = Array(2, 1, 0, 3, 1, 4, 2, 0, 0, 2, 1, 4)
  lazy val ltTianFu = Array(0, 0, 0, 2, 0, 2, 1, 0, 2, 4, 0, 1)
  lazy val ltTaiYin = Array(0, 0, 3, 4, 3, 4, 4, 2, 2, 1, 1, 0)
  lazy val ltTanLang = Array(1, 0, 2, 3, 0, 4, 1, 0, 2, 0, 4)
  lazy val ltJuMen = Array(1, 1, 0, 0, 2, 2, 1, 4, 0, 0, 1, 1)
  lazy val ltTianXiang = Array(0, 0, 0, 4, 1, 2, 1, 2, 0, 4, 3, 2)
  lazy val ltTianLiang = Array(0, 1, 0, 0, 1, 4, 0, 1, 4, 2, 1, 4)
  lazy val ltQiSha = Array(1, 0, 0, 4, 1, 2, 1, 1, 0, 2, 0, 2)
  lazy val ltPoJun = Array(0, 1, 4, 1, 1, 2, 0, 0, 4, 4, 1, 2)
  lazy val tblight = Array(ltZiWei, ltTianJi, ltTaiYang, ltWuQu, ltTianTong, ltLianZhen, ltTianFu, ltTaiYin, ltTanLang, ltJuMen, ltTianXiang, ltTianLiang, ltQiSha, ltPoJun)
}
