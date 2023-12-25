package org.novi.dsl

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DSLTest {
  @Test
  def testEvaluate1(): Unit = {
    val bEval = FalseActivationConfig("False-1") | FalseActivationConfig("False-2") & TrueActivationConfig("True-3")
    assertThat(bEval("World")).isFalse()
  }

  @Test
  def testEvaluate2(): Unit = {
    val bEval = FalseActivationConfig("False-1") & FalseActivationConfig("False-2") | TrueActivationConfig("True-3")
    assertThat(bEval("World")).isTrue()
  }

  @Test
  def testEvaluate3(): Unit = {
    val bEval = FalseActivationConfig("False-1") & (FalseActivationConfig("False-2") | TrueActivationConfig("True-3"))
    assertThat(bEval("World")).isFalse()
  }

  @Test
  def testEvaluate4(): Unit = {
    val bEval = !FalseActivationConfig("False-1") & (FalseActivationConfig("False-2") | TrueActivationConfig("True-3"))
    assertThat(bEval("World")).isTrue()
  }
}
