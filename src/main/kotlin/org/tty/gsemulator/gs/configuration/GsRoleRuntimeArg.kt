package org.tty.gsemulator.gs.configuration

import org.tty.gsemulator.configuration.KeyArg

class GsRoleRuntimeArg: KeyArg<GsRoleArgKey> {
    var roleLevel: Int = 0
    var roleBreakLevel: Int = 0

    override fun getArg(key: GsRoleArgKey): Any {
        return getArg(key.id)
    }

    override fun setArg(key: GsRoleArgKey, value: Any) {
        setArg(key.id, value)
    }
}