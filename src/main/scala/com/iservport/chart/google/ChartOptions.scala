package com.iservport.chart.google

import scala.beans.BeanProperty

case class ChartOptions
(
  @BeanProperty title: String = "",
  @BeanProperty height: String = "200",
  @BeanProperty colors: Array[String] = Array(),
  @BeanProperty legend: String = "right",
  @BeanProperty pieHole: Double = 0.0,
  @BeanProperty fontSize: Int = 11,
  @BeanProperty chartArea: ChartArea = ChartArea(),
  @BeanProperty is3D: Boolean = false,
  animation: Option[Animation] = None
) {
  def getAnimation = animation match {
    case Some(a) => a
    case None => Animation(0)
  }
  val getSliceVisibilityThreshold = 0
  val getPieSliceTextStyle = ChartTextStyle()
}
