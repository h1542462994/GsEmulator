package org.tty.gsemulator.gs.configuration

import org.tty.gsemulator.configuration.KeyConfiguration
import org.tty.gsemulator.gs.effect.schema.GsBaseEffectSchema
import org.tty.gsemulator.gs.role.GsInfo

class GsRoleRuntimeConfiguration: KeyConfiguration<GsRoleConfigurationKey> {
    lateinit var gsInfo: GsInfo
    lateinit var gsBaseEffectSchema: GsBaseEffectSchema

    override fun getConfig(name: String): Any {
        return when(name){
            GsRoleConfigurationKey.GsRoleInfo.id -> gsInfo
            GsRoleConfigurationKey.GsRoleBaseEffectSchema.id -> gsBaseEffectSchema
            else -> {
                throw IllegalArgumentException("key not found")
            }
        }
    }


    override fun getConfig(key: GsRoleConfigurationKey): Any {
        return getConfig(key.id)
    }
}