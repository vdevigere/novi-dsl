package org.novi.dsl.activations

import org.novi.dsl.core.BaseActivationConfig

class FalseActivationConfig(configuration: String) extends BaseActivationConfig(configuration) {
  override def apply(context: String): java.lang.Boolean = false
}
