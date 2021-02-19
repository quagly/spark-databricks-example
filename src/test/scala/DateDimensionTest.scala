package com.zignallabs.sparkdatabricks

import com.holdenkarau.spark.testing.SharedSparkContext
import org.apache.spark.sql.functions._
import org.scalatest.{Matchers, WordSpec}

class DateDimensionTest extends WordSpec with Matchers with SharedSparkContext {

  "A DateDimension" when {
    "created" should {
      "not have duplicate date_values" in {
        val dateDimDefault = new DateDimension().createDataFrame()
        val duplicateDates = dateDimDefault.groupBy("date_value")
          .agg(count("date_value"))
          .where("count(date_value) > 1")

        duplicateDates.count shouldBe 0
      }
    }
  }
  /*
  test("test DateDimension default does NOT generate duplicate date_value") {
    //There should never be any duplicate date_values
    val dateDimDefault = new DateDimension().createDataFrame()

    val duplicateDates = dateDimDefault.groupBy("date_value")
      .agg(count("date_value"))
      .where("count(date_value) > 1")

    assert(duplicateDates.count === 0)
  }

   */

}
