package org.novi.dsl

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.novi.core.activations.BaseActivation

import java.util.ServiceLoader
import scala.jdk.CollectionConverters.*

class NoviDslEvaluatorTest {

  @Test
  def testApply(): Unit = {
    val ace = NoviDslEvaluator(
      """
        |!org.novi.dsl.FalseActivationConfig("False-1") & (org.novi.dsl.FalseActivationConfig("False-2") | org.novi.dsl.TrueActivationConfig("True-3"))
        |""".stripMargin)

    assertThat(ace("Hello")).isTrue
  }

  @Test
  def testApplyServiceLoader(): Unit = {
    val loader = ServiceLoader.load(classOf[BaseActivation[_]])
    for (activation <- loader.asScala){
      assertThat(activation.configuration("""
                                 |!org.novi.dsl.FalseActivationConfig("False-1") & (org.novi.dsl.FalseActivationConfig("False-2") | org.novi.dsl.TrueActivationConfig("True-3"))
                                 |""".stripMargin)("hello")).isTrue
    }
  }
}
