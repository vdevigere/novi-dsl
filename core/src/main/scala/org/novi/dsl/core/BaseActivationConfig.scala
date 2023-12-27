package org.novi.dsl.core

trait BaseActivationConfig(var configuration: String){

  def &(that: BaseActivationConfig): AndActivation = AndActivation(this, that, s"( ${this.configuration} & ${that.configuration} )")

  def |(that: BaseActivationConfig): OrActivation = OrActivation(this, that, s"( ${this.configuration} | ${that.configuration} )")

  def unary_! : NotActivation = NotActivation(this, s"!(${this.configuration})")

  def apply(context: String): java.lang.Boolean
}
