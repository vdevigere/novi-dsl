package org.novi.dsl
import java.{lang, util}

class FalseActivationConfig(configuration: String) extends BaseActivationConfig(configuration) {
  override def apply(context: String): java.lang.Boolean = false

  override def apply(context: util.Map[String, AnyRef]): lang.Boolean = false
}
