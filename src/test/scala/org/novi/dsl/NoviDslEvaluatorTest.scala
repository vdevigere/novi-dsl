package org.novi.dsl

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NoviDslEvaluatorTest {

  @Test
  def testApply(): Unit = {
    val ace = NoviDslEvaluator(
      """
        |!org.novi.dsl.FalseActivationConfig("False-1") & (org.novi.dsl.FalseActivationConfig("False-2") | org.novi.dsl.TrueActivationConfig("True-3"))
        |""".stripMargin)

    assertThat(ace("Hello")).isTrue
  }
}
