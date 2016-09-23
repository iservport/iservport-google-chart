package com.iservport.chart.google

import scala.beans.BeanProperty

case class ChartArea
(
  @BeanProperty left:Int=0,
  @BeanProperty top:Int=20,
  @BeanProperty width:String="90%",
  @BeanProperty height:String="90%"
)
