package com.iservport.chart.google

import scala.beans.BeanProperty

case class ChartData
(
  @BeanProperty cols:Array[ChartColumn],
  @BeanProperty rows:Array[ChartRow]
)
