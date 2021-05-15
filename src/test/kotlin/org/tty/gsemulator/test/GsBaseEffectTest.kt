package org.tty.gsemulator.test

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.tty.gsemulator.configuration.*
import org.tty.gsemulator.gs.configuration.*
import org.tty.gsemulator.gs.effect.*
import org.tty.gsemulator.gs.effect.schema.*
import org.tty.gsemulator.gs.role.*
import org.tty.gsemulator.gs.state.*


class GsBaseEffectTest {
    private lateinit var roleConfiguration: KeyConfiguration<GsRoleConfigurationKey>
    private lateinit var roleArg: KeyArg<GsRoleArgKey>
    private lateinit var gsRole: GsRole

    @BeforeEach
    public fun before() {
        roleConfiguration = GsRoleRuntimeConfiguration().apply {
            gsInfo = GsInfo().apply {
                name = "诺艾尔"
                sex = GsSex.Woman
                element = GsElement.Rock
                weapon = GsWeapon.TSword
                star = "心护座"
                org = "西风骑士团"
            }
            gsBaseEffectSchema = GsBaseEffectSchema().apply {
                levelStates = listOf(
                    GsLevelState().apply {
                        roleLevel = 1
                        roleBreakLevel = 0
                        hpBase = 500.0
                        atkBase = 20.0
                        defBase = 20.0
                    },
                    GsLevelState().apply {
                        roleLevel = 20
                        roleBreakLevel = 0
                        hpBase = 800.0
                        atkBase = 50.0
                        defBase = 50.0
                    },
                    GsLevelState().apply {
                        roleLevel = 20
                        roleBreakLevel = 1
                        hpBase = 1000.0
                        atkBase = 100.0
                        defBase = 100.0
                    },
                    GsLevelState().apply {
                        roleLevel = 40
                        roleBreakLevel = 1
                        hpBase = 2000.0
                        atkBase = 150.0
                        defBase = 150.0
                    },
                    GsLevelState().apply {
                        roleLevel = 40
                        roleBreakLevel = 2
                        hpBase = 2200.0
                        atkBase = 200.0
                        defBase = 200.0
                    },
                    GsLevelState().apply {
                        roleLevel = 50
                        roleBreakLevel = 2
                        hpBase = 5000.0
                        atkBase = 300.0
                        defBase = 300.0
                    },
                    GsLevelState().apply {
                        roleLevel = 50
                        roleBreakLevel = 3
                        hpBase = 5500.0
                        atkBase = 400.0
                        defBase = 500.0
                    },
                    GsLevelState().apply {
                        roleLevel = 60
                        roleBreakLevel = 3
                        hpBase = 10000.0
                        atkBase = 500.0
                        defBase = 600.0
                    },
                    GsLevelState().apply {
                        roleLevel = 60
                        roleBreakLevel = 4
                        hpBase = 12000.0
                        atkBase = 600.0
                        defBase = 700.0
                    },
                    GsLevelState().apply {
                        roleLevel = 70
                        roleBreakLevel = 4
                        hpBase = 14000.0
                        atkBase = 700.0
                        defBase = 800.0
                    },
                    GsLevelState().apply {
                        roleLevel = 70
                        roleBreakLevel = 5
                        hpBase = 15000.0
                        atkBase = 800.0
                        defBase = 900.0
                    },
                    GsLevelState().apply {
                        roleLevel = 80
                        roleBreakLevel = 5
                        hpBase = 19000.0
                        atkBase = 900.0
                        defBase = 1000.0
                    },
                    GsLevelState().apply {
                        roleLevel = 80
                        roleBreakLevel = 6
                        hpBase = 20000.0
                        atkBase = 1000.0
                        defBase = 1100.0
                    },
                    GsLevelState().apply {
                        roleLevel = 90
                        roleBreakLevel = 6
                        hpBase = 25000.0
                        atkBase = 1100.0
                        defBase = 1200.0
                    }

                )
                breakEffects = listOf(
                    GsBreakEffect().apply {
                        roleBreakLevel = 1
                        stateKey = GsStateKey.DefBase.id
                        stateChange = 40.0
                    },
                    GsBreakEffect().apply {
                        roleBreakLevel = 3
                        stateKey = GsStateKey.DefBase.id
                        stateChange = 40.0
                    },
                    GsBreakEffect().apply {
                        roleBreakLevel = 3
                        stateKey = GsStateKey.DefBase.id
                        stateChange = 40.0
                    }
                )
            }
        }
        roleArg = GsRoleRuntimeArg().apply {
            roleLevel = 81
            roleBreakLevel = 6
        }
        gsRole = GsRole().apply {
            this.configuration = roleConfiguration
            this.arg = roleArg
            this.gsStateCalculator = GsStateCalculatorImpl()
        }
    }



    @Test
    public fun run() {
        println(gsRole.gsState())
    }
}