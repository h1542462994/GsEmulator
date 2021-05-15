package org.tty.gsemulator.gs.effect.schema

import org.tty.gsemulator.gs.effect.GsBreakEffect

/**
 * 有关人物基础属性的结构
 */
class GsBaseEffectSchema {
    lateinit var levelStates: List<GsLevelState>
    lateinit var breakEffects: List<GsBreakEffect>
}