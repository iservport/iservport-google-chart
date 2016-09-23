package com.iservport.chart.google

import com.fasterxml.jackson.databind.ObjectMapper

class GoogleChartWrapperSpec extends UnitSpec {

  "A chart row " should "contain number values" in {
    val row = ChartRow(Array(ChartValueNumber(1), ChartValueNumber(2)))
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(row) shouldEqual """{"c":[{"v":1},{"v":2}]}"""
  }

  it should "also contain string values" in {
    val row = ChartRow(Array(ChartValueName("A"), ChartValueName("B")))
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(row) shouldEqual """{"c":[{"v":"A"},{"v":"B"}]}"""
  }

  it should "also contain mixed values" in {
    val row = ChartRow(Array(ChartValueName("A"), ChartValueNumber(1)))
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(row) shouldEqual """{"c":[{"v":"A"},{"v":1}]}"""
  }

  "A chart column " should "contain string labels" in {
    val col = ChartColumn("ID", "LABEL")
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(col) shouldEqual """{"id":"ID","label":"LABEL","type":"string"}"""
  }

  it should "also contain numeric labels" in {
    val col = ChartColumn("ID", "LABEL", "number")
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(col) shouldEqual """{"id":"ID","label":"LABEL","type":"number"}"""
  }

  "Chart data " should "contain columns and rows" in {
    val cols = Array(ChartColumn("n", "NAME"), ChartColumn("q", "QTY", "number"))
    val rows = Array(ChartRow(Array(ChartValueName("A"), ChartValueNumber(1))),ChartRow(Array(ChartValueName("B"), ChartValueNumber(2))))
    val data = ChartData(cols,rows)
    val mapper = new ObjectMapper()
    mapper.writeValueAsString(data) shouldEqual """{"cols":[{"id":"n","label":"NAME","type":"string"},{"id":"q","label":"QTY","type":"number"}],"rows":[{"c":[{"v":"A"},{"v":1}]},{"c":[{"v":"B"},{"v":2}]}]}"""
  }

}
