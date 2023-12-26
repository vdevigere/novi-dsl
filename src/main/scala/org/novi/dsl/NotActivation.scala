package org.novi.dsl

import org.slf4j.LoggerFactory

import java.{lang, util}


class NotActivation(op1: BaseActivationConfig, configuration: String = null) extends BaseActivationConfig(configuration) {
  private val logger = LoggerFactory.getLogger(classOf[NotActivation])

  override def apply(context: String): java.lang.Boolean = {
    val result = !op1.apply(context)
    logger.debug("!{} = {}", op1.configuration, result)
    result
  }

  override def apply(context: util.Map[String, AnyRef]): lang.Boolean = {
    val result = !op1.apply(context)
    logger.debug("!{} = {}", op1.configuration, result)
    result
  }
}
