package org.novi.dsl

import org.novi.core.activations.BaseActivation

import java.lang


trait BaseActivationConfig(var configuration: String) extends BaseActivation[String] {
  def apply(context: String): java.lang.Boolean

  def &(that: BaseActivationConfig): AndActivation = AndActivation(this, that, s"( ${this.configuration} & ${that.configuration} )")

  def |(that: BaseActivationConfig): OrActivation = OrActivation(this, that, s"( ${this.configuration} | ${that.configuration} )")

  def unary_! : NotActivation = NotActivation(this, s"!(${this.configuration})")

  override def configuration(configuration: String): BaseActivation[String] = {
    this.configuration = configuration
    this
  }

}