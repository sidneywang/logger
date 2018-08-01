package com.orhanobut.logger

import com.bd.ee.bear.logger.AndroidLogAdapter
import com.bd.ee.bear.logger.FormatStrategy
import org.junit.Test

import com.google.common.truth.Truth.assertThat
import com.bd.ee.bear.logger.Logger.DEBUG
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class AndroidLogAdapterTest {

  @Test fun isLoggable() {
    val logAdapter = AndroidLogAdapter()

    assertThat(logAdapter.isLoggable(DEBUG, "tag")).isTrue()
  }

  @Test fun log() {
    val formatStrategy = mock(FormatStrategy::class.java)
    val logAdapter = AndroidLogAdapter(formatStrategy)

    logAdapter.log(DEBUG, null, "message")

    verify(formatStrategy).log(DEBUG, null, "message")
  }

}