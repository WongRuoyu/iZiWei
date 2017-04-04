package com.wong.iZiWei

import com.wong.iZiWei.GanZhi

/**
 * Created by Wong on 2016/5/21 0021.
 */
class GanZhi(val tiangan: TianGan.Value, val dizhi: DiZhi.Value) {

  override def toString = this.tiangan.toString + this.dizhi.toString
}

object GanZhi {
  def apply(tiangan: TianGan.Value, dizhi: DiZhi.Value) = new GanZhi(tiangan, dizhi)
}
