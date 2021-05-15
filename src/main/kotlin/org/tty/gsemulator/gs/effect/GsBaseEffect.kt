package org.tty.gsemulator.gs.effect

import org.tty.gsemulator.gs.configuration.GsRoleArgKey
import org.tty.gsemulator.gs.effect.schema.GsBaseEffectSchema
import org.tty.gsemulator.gs.role.GsRole
import org.tty.gsemulator.gs.state.GsEffectApplier
import org.tty.gsemulator.gs.state.GsState
import org.tty.gsemulator.kernal.BaseEffect
import org.tty.gsemulator.util.lerp
import org.tty.gsemulator.util.percent

/**
 * Genshin人物的面板属性，包括人物的基础属性以及突破属性
 */
class GsBaseEffect: BaseEffect, GsEffectApplier {
    lateinit var gsBaseEffectSchema: GsBaseEffectSchema


    override fun applyEffect(role: GsRole, gsState: GsState) {
        val roleLevel = role.arg.getArg(GsRoleArgKey.RoleLevel) as Int
        val roleBreakLevel = role.arg.getArg(GsRoleArgKey.RoleBreakLevel) as Int
        val twoGsLevelState = gsBaseEffectSchema.levelStates.filter { it.roleBreakLevel == roleBreakLevel }
        assert(twoGsLevelState.size == 2)
        val min = twoGsLevelState.minByOrNull { it.roleLevel }!!
        val max = twoGsLevelState.maxByOrNull { it.roleLevel }!!
        assert(roleLevel in min.roleLevel .. max.roleLevel)
        // 计算比例
        val percent = percent(min.roleLevel, max.roleLevel, roleLevel)

        // 增加基础值
        val hpBase = lerp(min.hpBase, max.hpBase, percent)
        val atkBase = lerp(min.atkBase, max.atkBase, percent)
        val defBase = lerp(min.defBase, max.defBase, percent)

        gsState.hpBase += hpBase
        gsState.atkBase += atkBase
        gsState.defBase += defBase

        // 递归调用突破属性
        gsBaseEffectSchema.breakEffects.forEach {
            it.applyEffect(role, gsState)
        }
    }
}