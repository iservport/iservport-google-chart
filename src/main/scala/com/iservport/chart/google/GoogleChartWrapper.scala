package com.iservport.chart.google

trait GoogleChartWrapper {

  val names: Array[String]

  val cols: Array[ChartColumn]

  val v: Array[Int]

  def getData: ChartData = ChartData(cols,values(v))

  def getType: String

  def values1(qtys: Array[Int]): Array[_ <: Any] = {
    val q:Array[ChartValueNumber] = Array(ChartValueNumber(1),ChartValueNumber(2),ChartValueNumber(3),ChartValueNumber(4),ChartValueNumber(5))//qtys.map(x => ChartValueNumber(x.asInstanceOf[Int]))
    val p = names.map(ChartValueName(_)).zip(q).flatMap(e => Array(e._1, e._2))
    p
  }

  def values(qtys: Array[Int]): Array[ChartRow] = {
    names.zipWithIndex.map(s => ChartRow(Array(ChartValueName(s._1), ChartValueNumber(v(s._2)))))
  }

}










