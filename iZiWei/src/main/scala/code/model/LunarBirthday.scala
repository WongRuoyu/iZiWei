package com.wong.iZiWei



class LunarBirthday(val lunaD: LunarDate, val hour: DiZhi.Value) {
  override def toString: String = this.lunaD.toString + hour.toString + "时"
}

object LunarBirthday {
  def apply(lunaD: LunarDate, hour: DiZhi.Value) = new LunarBirthday(lunaD, hour)
}