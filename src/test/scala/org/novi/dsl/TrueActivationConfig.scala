package org.novi.dsl

class TrueActivationConfig(configuration: String) extends BaseActivationConfig(configuration) {
  def apply(context: String): java.lang.Boolean = true
}