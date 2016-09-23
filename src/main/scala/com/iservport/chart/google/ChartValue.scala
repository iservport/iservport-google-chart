package com.iservport.chart.google

import scala.beans.BeanProperty

trait ChartValue { val v: Any }

case class ChartValueName
(
  @BeanProperty v: String
) extends ChartValue

case class ChartValueNumber
(
  @BeanProperty v: Int
) extends ChartValue