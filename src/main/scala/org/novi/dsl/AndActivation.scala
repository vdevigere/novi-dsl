package org.novi.dsl

import org.slf4j.LoggerFactory

import java.{lang, util}


class AndActivation(op1: BaseActivationConfig, op2: BaseActivationConfig, configuration: String = null) extends BaseActivationConfig(configuration) {
  private val logger = LoggerFactory.getLogger(classOf[AndActivation])

  override def apply(context: String): java.lang.Boolean = {
    val result = op1.apply(context) & op2.apply(context)
    logger.debug("{} & {} = {}", op1.configuration, op2.configuration, result)
    result
  }

  override def apply(context: util.Map[String, AnyRef]): lang.Boolean = {
    val result = op1.apply(context) & op2.apply(context)
    logger.debug("{} & {} = {}", op1.configuration, op2.configuration, result)
    result
  }
}
