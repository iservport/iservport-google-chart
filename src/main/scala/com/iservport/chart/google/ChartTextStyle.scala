package com.iservport.chart.google

import scala.beans.BeanProperty

case class ChartTextStyle
(
  @BeanProperty color:String="black",
  @BeanProperty fontSize: Int = 36
)
