package com.iservport.chart.google

import scala.beans.BeanProperty

case class ChartColumn
(
  @BeanProperty id:String,
  @BeanProperty label:String,
  @BeanProperty `type`:String = "string"
)
