package org.novi.dsl.core

import org.novi.core.activations.BaseActivation

trait BaseActivationConfig(var configuration: String) extends BaseActivation[String] {

  def &(that: BaseActivationConfig): AndActivation = AndActivation(this, that, s"( ${this.configuration} & ${that.configuration} )")

  def |(that: BaseActivationConfig): OrActivation = OrActivation(this, that, s"( ${this.configuration} | ${that.configuration} )")

  def unary_! : NotActivation = NotActivation(this, s"!(${this.configuration})")

  override def configuration(configuration: String): BaseActivation[String] = {
    this.configuration = configuration
    this
  }

}
