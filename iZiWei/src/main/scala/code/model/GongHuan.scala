package com.wong.iZiWei


/**
 * Created by Wong on 2016/5/22 0022.
 */
class GongHuan(val name: GongHuanNames.Value) {
  def starts: List[Star]=Nil

  def addStart(star: Star): GongHuan = {
    this.starts :: starts
    this
  }
}
