package org.novi.dsl

import org.slf4j.LoggerFactory

import java.io.File
import java.net.{URL, URLClassLoader}
import java.{lang, util}
import javax.script.ScriptEngine

class NoviDslEvaluator(_configuration: String = null, plugin_dir: String = "./plugin-activations/") extends BaseActivationConfig(_configuration) {

  def this() = {
    this(null)
  }

  private val logger = LoggerFactory.getLogger(classOf[NoviDslEvaluator])
  private val pluginDir = new File(plugin_dir)
  private val fList = pluginDir.listFiles()
  private var urls: Array[URL] = Array.empty
  if (fList != null) {
    for (f <- fList) {
      urls :+= f.toURI.toURL
    }
  }
  logger.debug("Files:{}", fList)
  private val urlClassLoader: URLClassLoader = URLClassLoader.newInstance(urls, getClass.getClassLoader)
  private val engineManager = new javax.script.ScriptEngineManager(urlClassLoader)
  private val engine: ScriptEngine = engineManager.getEngineByName("scala")
  logger.debug("Engine:{}", engine)
  override def apply(context: String): java.lang.Boolean = {
    logger.debug("Evaluating: {}", context)
    val result = engine.eval(configuration).asInstanceOf[BaseActivationConfig]
    result(context)
  }

  override def apply(context: util.Map[String, AnyRef]): lang.Boolean = {
    logger.debug("Evaluating: {}", context)
    val result = engine.eval(configuration).asInstanceOf[BaseActivationConfig]
    result(context)
  }
}
