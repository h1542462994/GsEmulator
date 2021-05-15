package org.tty.gsemulator.gs.state

import org.tty.gsemulator.gs.role.GsRole

interface GsEffectApplier {
    fun applyEffect(role: GsRole, gsState: GsState)
}