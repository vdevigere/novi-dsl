package org.novi.dsl.core

import org.slf4j.LoggerFactory

import javax.script.ScriptEngine

class NoviDslEvaluator(_configuration: String = null, scriptEngine: ScriptEngine) extends BaseActivationConfig(_configuration) {

  def this() = {
    this(null, new javax.script.ScriptEngineManager(getClass.getClassLoader).getEngineByName("scala"))
  }

  private val logger = LoggerFactory.getLogger(classOf[NoviDslEvaluator])

  override def apply(context: String): java.lang.Boolean = {
    logger.debug("Evaluating: {}", context)
    val result = scriptEngine.eval(configuration).asInstanceOf[BaseActivationConfig]
    result(context)
  }
}
