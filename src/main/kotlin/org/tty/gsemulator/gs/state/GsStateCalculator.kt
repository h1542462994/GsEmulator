package org.tty.gsemulator.gs.state

import org.tty.gsemulator.gs.role.GsRole

/**
 * 策略模型，表示state的计算器
 */
interface GsStateCalculator {
    fun calculateGsState(role: GsRole): GsState
}