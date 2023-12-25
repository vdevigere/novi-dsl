package org.novi.dsl

class FalseActivationConfig(configuration: String) extends BaseActivationConfig(configuration) {
  override def apply(context: String): java.lang.Boolean = false
}
