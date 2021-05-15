package org.tty.gsemulator.gs.state

import org.tty.gsemulator.gs.role.GsRole

class GsStateCalculatorImpl: GsStateCalculator {
    override fun calculateGsState(role: GsRole): GsState {
        val gsState = GsState.default()
        // 计算基础effect所带来的影响
        role.gsBaseEffect().applyEffect(role, gsState)
        return gsState
    }
}