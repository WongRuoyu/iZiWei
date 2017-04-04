package com.wong.iZiWei

/**
 * Created by Administrator on 2016/5/21 0021.
 */
class LunarDate(val year: GanZhi, val month: Int, val day: Int) {
  override def toString: String = this.year.toString + "年" + month + "月" + day + "日"
}

object LunarDate {

  //无法使用LunarDate(ganzhi,1)来创建LunarDate对象。
  //报LunarDate.type doesnot take parameters
  def apply(year: GanZhi, month: Int, day: Int) = new LunarDate(year, month, day)
}