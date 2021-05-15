package org.tty.gsemulator.gs.role

import org.tty.gsemulator.configuration.Configuration
import org.tty.gsemulator.configuration.KeyArg
import org.tty.gsemulator.configuration.KeyConfiguration
import org.tty.gsemulator.gs.configuration.GsRoleArgKey
import org.tty.gsemulator.gs.configuration.GsRoleConfigurationKey
import org.tty.gsemulator.gs.effect.GsBaseEffect
import org.tty.gsemulator.gs.effect.schema.GsBaseEffectSchema
import org.tty.gsemulator.gs.state.GsState
import org.tty.gsemulator.gs.state.GsStateCalculator

/**
 * Genshin人物
 */
class GsRole {
    /**
     * 人物的配置项
     */
    lateinit var configuration: KeyConfiguration<GsRoleConfigurationKey>
    /**
     * 人物的运行时参数
     */
    lateinit var arg: KeyArg<GsRoleArgKey>

    /**
     * 人物的状态计算器
     */
    lateinit var gsStateCalculator: GsStateCalculator

    fun gsInfo(): GsInfo {
        return configuration.getConfig(GsRoleConfigurationKey.GsRoleInfo) as GsInfo
    }

    fun gsBaseEffectSchema(): GsBaseEffectSchema {
        return configuration.getConfig(GsRoleConfigurationKey.GsRoleBaseEffectSchema) as GsBaseEffectSchema
    }

    fun gsBaseEffect(): GsBaseEffect {
        return GsBaseEffect().apply {
            this.gsBaseEffectSchema = this@GsRole.gsBaseEffectSchema()
        }
    }

    fun gsState(): GsState {
        return gsStateCalculator.calculateGsState(this)
    }
}