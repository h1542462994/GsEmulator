package org.tty.gsemulator.gs.effect

import org.tty.gsemulator.gs.configuration.GsRoleArgKey
import org.tty.gsemulator.gs.role.GsRole
import org.tty.gsemulator.gs.state.GsEffectApplier
import org.tty.gsemulator.gs.state.GsState
import org.tty.gsemulator.kernal.Effect

class GsBreakEffect: Effect, GsEffectApplier {
    var roleBreakLevel: Int = 0
    var stateKey: String = ""
    var stateChange: Double = 0.0
    override fun applyEffect(role: GsRole, gsState: GsState) {
        val roleBreakLevel = role.arg.getArg(GsRoleArgKey.RoleBreakLevel) as Int
        val isActive = this.roleBreakLevel >= roleBreakLevel
        if (isActive) {
            var value = gsState.getArg(stateKey) as Double
            value += stateChange
            gsState.setArg(stateKey, value)
        }
    }
}