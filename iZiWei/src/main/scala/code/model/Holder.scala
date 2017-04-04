package com.wong.iZiWei


/**
 * Created by Wong on 2016/5/28 0028.
  * 命盘中12个位置
 */
class Holder(n: DiZhi.Value) {
  val name = n
  val stars = scala.collection.mutable.Set[Star]()
  val isShenGong = false
  def addStar(star: Star) = this.stars += star
}

object Holder {
  def apply(name: DiZhi.Value) = new Holder(name)
}