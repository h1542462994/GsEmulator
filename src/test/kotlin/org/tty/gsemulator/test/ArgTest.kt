package org.tty.gsemulator.test

import org.junit.jupiter.api.Test
import org.tty.gsemulator.gs.state.GsElement
import org.tty.gsemulator.gs.state.GsElementProperty
import kotlin.test.assertEquals

/**
 * 测试[org.tty.gsemulator.configuration.Arg]和[org.tty.gsemulator.configuration.KeyArg]的正确性
 */
class ArgTest {

    @Test
    fun run() {
        val gsElementProperty = GsElementProperty().apply {
            thunder = 45.0
        }
        assertEquals(45.0, gsElementProperty.getArg("thunder"))
        assertEquals(45.0, gsElementProperty.getArg(GsElement.Thunder))

        gsElementProperty.setArg("fire", 30.0)
        assertEquals(30.0, gsElementProperty.getArg("fire"))
    }
}