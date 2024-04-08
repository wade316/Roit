package com.example.retrofitstudy.DTO

import com.google.gson.annotations.SerializedName


data class MatchDTO(
    val info: Info,
    val metadata: Metadata
)

data class Info(
    val endOfGameResult: String,
    val gameCreation: Long,
    val gameDuration: Int,
    val gameEndTimestamp: Long,
    val gameId: Long,
    @SerializedName("gameMode")
    val gameMode: String,
    val gameName: String,
    val gameStartTimestamp: Long,
    val gameType: String,
    val gameVersion: String,
    val mapId: Int,
    val participants: List<Participant>,
    val platformId: String,
    val queueId: Int,
    val teams: List<Team>,
    val tournamentCode: String
)

data class Participant(
    val allInPings: Int,
    val assistMePings: Int,
    @SerializedName("assists")
    val assists: Int,
    val baronKills: Int,
    val basicPings: Int,
    val bountyLevel: Int,
    val challenges: Challenges,
    val champExperience: Int,
    @SerializedName("champLevel")
    val champLevel: Int,
    @SerializedName("championId")
    val championId: Int,
    val championName: String,
    val championTransform: Int,
    val commandPings: Int,
    val consumablesPurchased: Int,
    val damageDealtToBuildings: Int,
    val damageDealtToObjectives: Int,
    val damageDealtToTurrets: Int,
    val damageSelfMitigated: Int,
    val dangerPings: Int,
    @SerializedName("deaths")
    val deaths: Int,
    val detectorWardsPlaced: Int,
    val doubleKills: Int,
    val dragonKills: Int,
    val eligibleForProgression: Boolean,
    val enemyMissingPings: Int,
    val enemyVisionPings: Int,
    val firstBloodAssist: Boolean,
    val firstBloodKill: Boolean,
    val firstTowerAssist: Boolean,
    val firstTowerKill: Boolean,
    val gameEndedInEarlySurrender: Boolean,
    val gameEndedInSurrender: Boolean,
    val getBackPings: Int,
    val goldEarned: Int,
    val goldSpent: Int,
    val holdPings: Int,
    val individualPosition: String,
    val inhibitorKills: Int,
    val inhibitorTakedowns: Int,
    val inhibitorsLost: Int,
    @SerializedName("item0")
    val item0: Int,
    val item1: Int,
    val item2: Int,
    val item3: Int,
    val item4: Int,
    val item5: Int,
    val item6: Int,
    val itemsPurchased: Int,
    val killingSprees: Int,
    @SerializedName("kills")
    val kills: Int,
    @SerializedName("lane")
    val lane: String,
    val largestCriticalStrike: Int,
    val largestKillingSpree: Int,
    val largestMultiKill: Int,
    val longestTimeSpentLiving: Int,
    val magicDamageDealt: Int,
    val magicDamageDealtToChampions: Int,
    val magicDamageTaken: Int,
    val missions: Missions,
    val needVisionPings: Int,
    val neutralMinionsKilled: Int,
    val nexusKills: Int,
    val nexusLost: Int,
    val nexusTakedowns: Int,
    val objectivesStolen: Int,
    val objectivesStolenAssists: Int,
    val onMyWayPings: Int,
    val participantId: Int,
    val pentaKills: Int,
    val perks: Perks,
    val physicalDamageDealt: Int,
    val physicalDamageDealtToChampions: Int,
    val physicalDamageTaken: Int,
    val placement: Int,
    val playerAugment1: Int,
    val playerAugment2: Int,
    val playerAugment3: Int,
    val playerAugment4: Int,
    val playerScore0: Int,
    val playerScore1: Int,
    val playerScore10: Int,
    val playerScore11: Int,
    val playerScore2: Int,
    val playerScore3: Int,
    val playerScore4: Int,
    val playerScore5: Int,
    val playerScore6: Int,
    val playerScore7: Int,
    val playerScore8: Int,
    val playerScore9: Int,
    val playerSubteamId: Int,
    @SerializedName("profileIcon")
    val profileIcon: Int,
    val pushPings: Int,
    val puuid: String,
    val quadraKills: Int,
    @SerializedName("riotIdGameName")
    val riotIdGameName: String,
    val riotIdTagline: String,
    val role: String,
    val sightWardsBoughtInGame: Int,
    @SerializedName("spell1Casts")
    val spell1Casts: Int,
    val spell2Casts: Int,
    val spell3Casts: Int,
    val spell4Casts: Int,
    val subteamPlacement: Int,
    val summoner1Casts: Int,
    val summoner1Id: Int,
    val summoner2Casts: Int,
    val summoner2Id: Int,
    @SerializedName("summonerId")
    val summonerId: String,
    val summonerLevel: Int,
    val summonerName: String,
    val teamEarlySurrendered: Boolean,
    val teamId: Int,
    val teamPosition: String,
    val timeCCingOthers: Int,
    val timePlayed: Int,
    val totalAllyJungleMinionsKilled: Int,
    val totalDamageDealt: Int,
    val totalDamageDealtToChampions: Int,
    val totalDamageShieldedOnTeammates: Int,
    val totalDamageTaken: Int,
    val totalEnemyJungleMinionsKilled: Int,
    val totalHeal: Int,
    val totalHealsOnTeammates: Int,
    @SerializedName("totalMinionsKilled")
    val totalMinionsKilled: Int,
    val totalTimeCCDealt: Int,
    val totalTimeSpentDead: Int,
    val totalUnitsHealed: Int,
    val tripleKills: Int,
    val trueDamageDealt: Int,
    val trueDamageDealtToChampions: Int,
    val trueDamageTaken: Int,
    val turretKills: Int,
    val turretTakedowns: Int,
    val turretsLost: Int,
    val unrealKills: Int,
    val visionClearedPings: Int,
    val visionScore: Int,
    val visionWardsBoughtInGame: Int,
    @SerializedName("wardsKilled")
    val wardsKilled: Int,
    val wardsPlaced: Int,
    @SerializedName("win")
    val win: Boolean
)

data class Challenges(
    val `12AssistStreakCount`: Int,
    val abilityUses: Int,
    val acesBefore15Minutes: Int,
    val alliedJungleMonsterKills: Int,
    val baronTakedowns: Int,
    val blastConeOppositeOpponentCount: Int,
    val bountyGold: Int,
    val buffsStolen: Int,
    val completeSupportQuestInTime: Int,
    val controlWardTimeCoverageInRiverOrEnemyHalf: Double,
    val controlWardsPlaced: Int,
    val damagePerMinute: Double,
    val damageTakenOnTeamPercentage: Double,
    val dancedWithRiftHerald: Int,
    val deathsByEnemyChamps: Int,
    val dodgeSkillShotsSmallWindow: Int,
    val doubleAces: Int,
    val dragonTakedowns: Int,
    val earliestBaron: Double,
    val earliestDragonTakedown: Double,
    val earlyLaningPhaseGoldExpAdvantage: Int,
    val effectiveHealAndShielding: Double,
    val elderDragonKillsWithOpposingSoul: Int,
    val elderDragonMultikills: Int,
    val enemyChampionImmobilizations: Int,
    val enemyJungleMonsterKills: Int,
    val epicMonsterKillsNearEnemyJungler: Int,
    val epicMonsterKillsWithin30SecondsOfSpawn: Int,
    val epicMonsterSteals: Int,
    val epicMonsterStolenWithoutSmite: Int,
    val fastestLegendary: Double,
    val firstTurretKilled: Int,
    val firstTurretKilledTime: Double,
    val flawlessAces: Int,
    val fullTeamTakedown: Int,
    val gameLength: Double,
    val getTakedownsInAllLanesEarlyJungleAsLaner: Int,
    @SerializedName("goldPerMinute")
    val goldPerMinute: Double,
    val hadOpenNexus: Int,
    val highestChampionDamage: Int,
    val highestWardKills: Int,
    val immobilizeAndKillWithAlly: Int,
    val initialBuffCount: Int,
    val initialCrabCount: Int,
    val jungleCsBefore10Minutes: Double,
    val junglerKillsEarlyJungle: Int,
    val junglerTakedownsNearDamagedEpicMonster: Int,
    val kTurretsDestroyedBeforePlatesFall: Int,
    @SerializedName("kda")
    val kda: Double,
    val killAfterHiddenWithAlly: Int,
    val killParticipation: Double,
    val killedChampTookFullTeamDamageSurvived: Int,
    val killingSprees: Int,
    val killsNearEnemyTurret: Int,
    val killsOnLanersEarlyJungleAsJungler: Int,
    val killsOnOtherLanesEarlyJungleAsLaner: Int,
    val killsOnRecentlyHealedByAramPack: Int,
    val killsUnderOwnTurret: Int,
    val killsWithHelpFromEpicMonster: Int,
    val knockEnemyIntoTeamAndKill: Int,
    val landSkillShotsEarlyGame: Int,
    val laneMinionsFirst10Minutes: Int,
    val laningPhaseGoldExpAdvantage: Int,
    val legendaryCount: Int,
    val legendaryItemUsed: List<Int>,
    val lostAnInhibitor: Int,
    val maxCsAdvantageOnLaneOpponent: Double,
    val maxKillDeficit: Int,
    val maxLevelLeadLaneOpponent: Int,
    val mejaisFullStackInTime: Int,
    val moreEnemyJungleThanOpponent: Double,
    val multiKillOneSpell: Int,
    val multiTurretRiftHeraldCount: Int,
    val multikills: Int,
    val multikillsAfterAggressiveFlash: Int,
    val outerTurretExecutesBefore10Minutes: Int,
    val outnumberedKills: Int,
    val outnumberedNexusKill: Int,
    val perfectDragonSoulsTaken: Int,
    val perfectGame: Int,
    val pickKillWithAlly: Int,
    val playedChampSelectPosition: Int,
    val poroExplosions: Int,
    val quickCleanse: Int,
    val quickFirstTurret: Int,
    val quickSoloKills: Int,
    val riftHeraldTakedowns: Int,
    val saveAllyFromDeath: Int,
    val scuttleCrabKills: Int,
    val shortestTimeToAceFromFirstTakedown: Double,
    val skillshotsDodged: Int,
    val skillshotsHit: Int,
    val snowballsHit: Int,
    val soloBaronKills: Int,
    val soloKills: Int,
    val stealthWardsPlaced: Int,
    val survivedSingleDigitHpCount: Int,
    val survivedThreeImmobilizesInFight: Int,
    val takedownOnFirstTurret: Int,
    val takedowns: Int,
    val takedownsAfterGainingLevelAdvantage: Int,
    val takedownsBeforeJungleMinionSpawn: Int,
    val takedownsFirstXMinutes: Int,
    val takedownsInAlcove: Int,
    val takedownsInEnemyFountain: Int,
    val teamBaronKills: Int,
    val teamDamagePercentage: Double,
    val teamElderDragonKills: Int,
    val teamRiftHeraldKills: Int,
    val tookLargeDamageSurvived: Int,
    val turretPlatesTaken: Int,
    val turretTakedowns: Int,
    val turretsTakenWithRiftHerald: Int,
    val twentyMinionsIn3SecondsCount: Int,
    val twoWardsOneSweeperCount: Int,
    val unseenRecalls: Int,
    val visionScoreAdvantageLaneOpponent: Double,
    val visionScorePerMinute: Double,
    val wardTakedowns: Int,
    val wardTakedownsBefore20M: Int,
    val wardsGuarded: Int
)

data class Missions(
    val playerScore0: Int,
    val playerScore1: Int,
    val playerScore10: Int,
    val playerScore11: Int,
    val playerScore2: Int,
    val playerScore3: Int,
    val playerScore4: Int,
    val playerScore5: Int,
    val playerScore6: Int,
    val playerScore7: Int,
    val playerScore8: Int,
    val playerScore9: Int
)

data class Perks(
    val statPerks: StatPerks,
    val styles: List<Style>
)

data class StatPerks(
    val defense: Int,
    val flex: Int,
    val offense: Int
)

data class Style(
    val description: String,
    @SerializedName("selections")
    val selections: List<Selection>,
    val style: Int
)

data class Selection(
    @SerializedName("perk")
    val perk: Int,
    @SerializedName("var1")
    val var1: Int,
    @SerializedName("var2")
    val var2: Int,
    @SerializedName("var3")
    val var3: Int
)

data class Team(
    @SerializedName("bans")
    val bans: List<Ban>,
    val objectives: Objectives,
    @SerializedName("teamId")
    val teamId: Int,
    @SerializedName("win")
    val win: Boolean
)

data class Ban(
    @SerializedName("championId")
    val championId: Int,
    @SerializedName("pickTurn")
    val pickTurn: Int
)

data class Objectives(
    val baron: Baron,
    val champion: Champion,
    val dragon: Dragon,
    val horde: Horde,
    val inhibitor: Inhibitor,
    val riftHerald: RiftHerald,
    val tower: Tower
)

data class Baron(
    val first: Boolean,
    val kills: Int
)

data class Champion(
    val first: Boolean,
    @SerializedName("kills")
    val kills: Int
)

data class Dragon(
    val first: Boolean,
    val kills: Int
)

data class Horde(
    val first: Boolean,
    val kills: Int
)

data class Inhibitor(
    val first: Boolean,
    val kills: Int
)

data class RiftHerald(
    val first: Boolean,
    val kills: Int
)

data class Tower(
    val first: Boolean,
    val kills: Int
)

data class Metadata(
    val dataVersion: String,
    val matchId: String,
    val participants: List<String>
)