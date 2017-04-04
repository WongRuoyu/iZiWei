package com.wong.iZiWei

/**
  * Created by WongRuoyu on 2017/1/14 0014.
  */
trait StartAt {
  this: Enumeration =>
  def beginAt(start:this.Value)={
    val (head,tail)=this.values.splitAt(start.id)
    (tail.toSeq ++ head.toSeq)
  }
}
