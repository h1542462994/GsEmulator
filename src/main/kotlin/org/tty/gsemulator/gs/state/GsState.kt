package org.tty.gsemulator.gs.state

import org.tty.gsemulator.configuration.KeyArg
import org.tty.gsemulator.kernal.State
import org.tty.gsemulator.kernal.StateEffect
import java.lang.StringBuilder

/**
 * Genshin中人物的状态，包括一系列数值以及当前的Buff。其中人物的状态是已经经过一系列Buff计算之后的状态。
 * @see [GsStateKey]
 */
class GsState: State, KeyArg<GsStateKey> {
    /**
     * 当前生命值 current hp
     */
    var hp: Double = 0.0

    /**
     * 基础生命值上限 base hp limit
     */
    var hpBase: Double = 0.0

    /**
     * 额外生命值上限 extra hp limit
     */
    var hpExtra: Double = 0.0

    /**
     * 基础攻击力 base attack
     */
    var atkBase: Double = 0.0

    /**
     * 额外攻击力 extra attack
     */
    var atkExtra: Double = 0.0

    /**
     * 基础防御力 base defense
     */
    var defBase: Double = 0.0

    /**
     * 额外防御力 extra
     */
    var defExtra: Double = 0.0

    /**
     * 当前的体力 energy
     */
    var ene: Double = 0.0

    /**
     * 体力值上限 energy limit
     */
    var eneL: Double = 0.0

    /**
     * 元素精通 element strategy
     */
    var ele: Double = 0.0

    /**
     * 暴击率 critical rate
     */
    var cri: Double = 0.0

    /**
     * 暴击伤害 critical damage
     */
    var criD: Double = 0.0

    /**
     * 治疗加成 treat buff
     */
    var trB: Double = 0.0

    /**
     * 受治疗加成 be treated buff
     */
    var btrB: Double = 0.0

    /**
     * 元素充能效率 element power efficiency
     */
    var eleE: Double = 0.0

    /**
     * 冷却缩减 cd down
     */
    var cdD: Double = 0.0

    /**
     * 护盾强效
     */
    var shiP: Double = 0.0

    /**
     * 元素伤害加成 element buff
     */
    var eleB: GsElementProperty = GsElementProperty()

    /**
     * 元素抗性 element defense
     */
    var eleD: GsElementProperty = GsElementProperty()

    /**
     * 人物的效果
     */
    var stateEffects: MutableList<StateEffect> = mutableListOf()

    override fun getArg(name: String): Any {
        return when {
            name.startsWith("eleB-") -> {
                val element = name.removePrefix("eleB-")
                eleB.getArg(element)
            }
            name.startsWith("eleD-") -> {
                val element = name.removePrefix("eleD-")
                eleD.getArg(element)
            }
            else -> {
                super.getArg(name)
            }
        }
    }

    override fun setArg(name: String, value: Any) {
        when {
            name.startsWith("eleB-") -> {
                val element = name.removePrefix("eleB-")
                eleB.setArg(element, value)
            }
            name.startsWith("eleD-") -> {
                val element = name.removePrefix("eleD-")
                eleD.setArg(element, value)
            }
            else -> {
                super.setArg(name, value)
            }
        }
    }

    override fun getArg(key: GsStateKey): Any {
        return getArg(key.id)
    }

    override fun setArg(key: GsStateKey, value: Any) {
        setArg(key.id, value)
    }

    override fun toString(): String {
        val builder = StringBuilder()
        for(gsStateKey in GsStateKey.values()) {
            builder.append("${gsStateKey.id}:${getArg(gsStateKey)}")
            builder.appendLine()
        }
        return builder.toString()
    }

    companion object {
        fun default(): GsState {
            return GsState().apply {
                cri = 5.0
                criD = 50.0
            }
        }
    }
}