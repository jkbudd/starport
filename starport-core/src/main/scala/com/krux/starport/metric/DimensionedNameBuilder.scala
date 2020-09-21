package com.krux.starport.metric

import com.amazonaws.services.cloudwatch.model.Dimension

import scala.collection.mutable.Map

class DimensionedNameBuilder(
  name: String,
  val dimensions: Map[String, Dimension] = Map().empty
) {

  def build(): DimensionedName = new DimensionedName(this.name, this.dimensions)

  def withDimension(name: String, value: String): DimensionedNameBuilder = {
    this.dimensions += ((name, new Dimension().withName(name).withValue(value)))
    this
  }

}
