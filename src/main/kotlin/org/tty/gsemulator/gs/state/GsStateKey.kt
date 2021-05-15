package org.tty.gsemulator.gs.state

/**
 * 在[GsState]中使用到的状态的键，表示状态中经常使用的数值状态。
 */
enum class GsStateKey(
    var id: String
) {
    /**
     * 当前生命值 current hp
     */
    Hp("hp"),

    /**
     * 基础生命值上限 base hp limit
     */
    HpBase("hpBase"),

    /**
     * 额外生命值上限 extra hp limit
     */
    HpExtra("hpExtra"),

    /**
     * 基础攻击力 base attack
     */
    AtkBase("atkBase"),

    /**
     * 额外攻击力 extra attack
     */
    AtkExtra("atkExtra"),

    /**
     * 基础防御力 base defense
     */
    DefBase("defBase"),

    /**
     * 额外防御力 extra defense
     */
    DefExtra("defExtra"),

    /**
     * 当前的体力 energy
     */
    Ene("ene"),

    /**
     * 体力值上限 energy limit
     */
    EneL("eneL"),



    /**
     * 元素精通 element strategy
     */
    Ele("ele"),

    /**
     * 暴击率 critical rate
     */
    Cri("cri"),

    /**
     * 暴击伤害 critical damage
     */
    CriD("criD"),

    /**
     * 治疗加成 treat buff
     */
    TrB("trB"),

    /**
     * 受治疗加成 be treated buff
     */
    BtrB("btrB"),

    /**
     * 元素充能效率 element power efficiency
     */
    EleE("eleE"),

    /**
     * 冷却缩减 cd down
     */
    CdD("cdD"),

    /**
     * 护盾强效 shield Power
     */
    ShiP("shiP"),

    /**
     * 元素加成 element buff
     */
    EleB("eleB"),

    /**
     * 元素抗性 element defense
     */
    EleD("eleD"),
}