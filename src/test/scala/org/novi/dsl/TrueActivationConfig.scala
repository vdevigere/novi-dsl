package org.novi.dsl
import java.{lang, util}

class TrueActivationConfig(configuration: String) extends BaseActivationConfig(configuration) {
  override def apply(context: String): java.lang.Boolean = true

  override def apply(context: util.Map[String, AnyRef]): lang.Boolean = true
}