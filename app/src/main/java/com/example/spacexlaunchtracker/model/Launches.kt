package com.example.spacexlaunchtracker.model

import com.google.gson.annotations.SerializedName


data class Launch(

	@field:SerializedName("launch_year")
	val launchYear: String? = null,

	@field:SerializedName("launch_date_utc")
	val launchDateUtc: String? = null,

	@field:SerializedName("last_ll_launch_date")
	val lastLlLaunchDate: String? = null,

	@field:SerializedName("is_tentative")
	val isTentative: Boolean? = null,


	@field:SerializedName("rocket")
	val rocket: Rocket? = null,

	@field:SerializedName("last_wiki_launch_date")
	val lastWikiLaunchDate: String? = null,

	@field:SerializedName("mission_id")
	val missionId: List<Any?>? = null,

	@field:SerializedName("launch_date_source")
	val launchDateSource: String? = null,

	@field:SerializedName("last_ll_update")
	val lastLlUpdate: String? = null,

	@field:SerializedName("crew")
	val crew: Any? = null,

	@field:SerializedName("launch_date_local")
	val launchDateLocal: String? = null,

	@field:SerializedName("tentative_max_precision")
	val tentativeMaxPrecision: String? = null,

	@field:SerializedName("launch_success")
	val launchSuccess: Boolean? = null,

	@field:SerializedName("links")
	val links: Links? = null,


	@field:SerializedName("details")
	val details: String? = null,

	@field:SerializedName("launch_site")
	val launchSite: LaunchSite? = null,

	@field:SerializedName("last_date_update")
	val lastDateUpdate: String? = null,

	@field:SerializedName("last_wiki_revision")
	val lastWikiRevision: String? = null,

	@field:SerializedName("mission_name")
	val missionName: String? = null,

	@field:SerializedName("static_fire_date_utc")
	val staticFireDateUtc: String? = null,

	@field:SerializedName("last_wiki_update")
	val lastWikiUpdate: String? = null,

	@field:SerializedName("flight_number")
	val flightNumber: Int? = null,

	@field:SerializedName("launch_window")
	val launchWindow: Int? = null,

	@field:SerializedName("ships")
	val ships: List<Any?>? = null,

	@field:SerializedName("launch_date_unix")
	val launchDateUnix: Int? = null,

	@field:SerializedName("static_fire_date_unix")
	val staticFireDateUnix: Int? = null,

	@field:SerializedName("tbd")
	val tbd: Boolean? = null,

	@field:SerializedName("timeline")
	val timeline: Timeline? = null,


	@field:SerializedName("telemetry")
	val telemetry: Telemetry? = null,

	@field:SerializedName("upcoming")
	val upcoming: Boolean? = null,


	@field:SerializedName("launch_failure_details")
	val launchFailureDetails: LaunchFailureDetails? = null
)

data class LaunchFailureDetails(

	@field:SerializedName("altitude")
	val altitude: Any? = null,

	@field:SerializedName("reason")
	val reason: String? = null,

	@field:SerializedName("time")
	val time: Int? = null
)


data class OrbitParams(

	@field:SerializedName("periapsis_km")
	val periapsisKm: Double? = null,

	@field:SerializedName("mean_anomaly")
	val meanAnomaly: Any? = null,

	@field:SerializedName("inclination_deg")
	val inclinationDeg: Double? = null,

	@field:SerializedName("regime")
	val regime: String? = null,

	@field:SerializedName("arg_of_pericenter")
	val argOfPericenter: Any? = null,

	@field:SerializedName("eccentricity")
	val eccentricity: Any? = null,

	@field:SerializedName("apoapsis_km")
	val apoapsisKm: Double? = null,

	@field:SerializedName("semi_major_axis_km")
	val semiMajorAxisKm: Any? = null,

	@field:SerializedName("raan")
	val raan: Any? = null,

	@field:SerializedName("epoch")
	val epoch: Any? = null,

	@field:SerializedName("lifespan_years")
	val lifespanYears: Any? = null,

	@field:SerializedName("reference_system")
	val referenceSystem: String? = null,

	@field:SerializedName("period_min")
	val periodMin: Any? = null,

	@field:SerializedName("mean_motion")
	val meanMotion: Any? = null,

	@field:SerializedName("longitude")
	val longitude: Any? = null
)

data class Telemetry(

	@field:SerializedName("flight_club")
	val flightClub: Any? = null
)

data class CoresItem(

	@field:SerializedName("flight")
	val flight: Int? = null,

	@field:SerializedName("landing_type")
	val landingType: Any? = null,

	@field:SerializedName("gridfins")
	val gridfins: Boolean? = null,

	@field:SerializedName("landing_intent")
	val landingIntent: Boolean? = null,

	@field:SerializedName("legs")
	val legs: Boolean? = null,

	@field:SerializedName("land_success")
	val landSuccess: Any? = null,

	@field:SerializedName("landing_vehicle")
	val landingVehicle: Any? = null,

	@field:SerializedName("block")
	val block: Any? = null,

	@field:SerializedName("reused")
	val reused: Boolean? = null,

	@field:SerializedName("core_serial")
	val coreSerial: String? = null
)

data class Rocket(

	@field:SerializedName("second_stage")
	val secondStage: SecondStage? = null,

	@field:SerializedName("rocket_id")
	val rocketId: String? = null,

	@field:SerializedName("first_stage")
	val firstStage: FirstStage? = null,

	@field:SerializedName("rocket_type")
	val rocketType: String? = null,

	@field:SerializedName("rocket_name")
	val rocketName: String? = null,

	@field:SerializedName("fairings")
	val fairings: Fairings? = null
)

data class Timeline(

	@field:SerializedName("beco")
	val beco: Int? = null,

	@field:SerializedName("second_stage_ignition")
	val secondStageIgnition: Int? = null,

	@field:SerializedName("side_core_boostback")
	val sideCoreBoostback: Int? = null,

	@field:SerializedName("payload_deploy")
	val payloadDeploy: Int? = null,

	@field:SerializedName("stage1_lox_loading")
	val stage1LoxLoading: Int? = null,

	@field:SerializedName("seco-2")
	val seco2: Int? = null,

	@field:SerializedName("seco-1")
	val seco1: Int? = null,

	@field:SerializedName("stage2_lox_loading")
	val stage2LoxLoading: Int? = null,

	@field:SerializedName("ignition")
	val ignition: Int? = null,

	@field:SerializedName("seco-4")
	val seco4: Int? = null,

	@field:SerializedName("prelaunch_checks")
	val prelaunchChecks: Int? = null,

	@field:SerializedName("seco-3")
	val seco3: Int? = null,

	@field:SerializedName("stage2_rp1_loading")
	val stage2Rp1Loading: Int? = null,

	@field:SerializedName("center_core_landing")
	val centerCoreLanding: Int? = null,

	@field:SerializedName("side_core_landing")
	val sideCoreLanding: Int? = null,

	@field:SerializedName("liftoff")
	val liftoff: Int? = null,

	@field:SerializedName("center_stage_sep")
	val centerStageSep: Int? = null,

	@field:SerializedName("stage1_rp1_loading")
	val stage1Rp1Loading: Int? = null,

	@field:SerializedName("side_core_entry_burn")
	val sideCoreEntryBurn: Int? = null,

	@field:SerializedName("webcast_liftoff")
	val webcastLiftoff: Int? = null,

	@field:SerializedName("second_stage_restart")
	val secondStageRestart: Int? = null,

	@field:SerializedName("propellant_pressurization")
	val propellantPressurization: Int? = null,

	@field:SerializedName("engine_chill")
	val engineChill: Int? = null,

	@field:SerializedName("meco")
	val meco: Int? = null,

	@field:SerializedName("go_for_prop_loading")
	val goForPropLoading: Int? = null,

	@field:SerializedName("fairing_deploy")
	val fairingDeploy: Int? = null,

	@field:SerializedName("go_for_launch")
	val goForLaunch: Int? = null,

	@field:SerializedName("center_core_entry_burn")
	val centerCoreEntryBurn: Int? = null,

	@field:SerializedName("side_core_sep")
	val sideCoreSep: Int? = null,

	@field:SerializedName("maxq")
	val maxq: Int? = null,

	@field:SerializedName("rp1_loading")
	val rp1Loading: Int? = null,

	@field:SerializedName("first_stage_landing")
	val firstStageLanding: Int? = null,

	@field:SerializedName("first_stage_entry_burn")
	val firstStageEntryBurn: Int? = null,

	@field:SerializedName("stage_sep")
	val stageSep: Int? = null,

	@field:SerializedName("first_stage_boostback_burn")
	val firstStageBoostbackBurn: Int? = null,

	@field:SerializedName("dragon_solar_deploy")
	val dragonSolarDeploy: Int? = null,

	@field:SerializedName("dragon_bay_door_deploy")
	val dragonBayDoorDeploy: Int? = null,

	@field:SerializedName("dragon_separation")
	val dragonSeparation: Int? = null,

	@field:SerializedName("first_stage_landing_burn")
	val firstStageLandingBurn: Int? = null,

	@field:SerializedName("payload_deploy_2")
	val payloadDeploy2: Int? = null,

	@field:SerializedName("payload_deploy_1")
	val payloadDeploy1: Int? = null,

	@field:SerializedName("center_core_boostback")
	val centerCoreBoostback: Int? = null,

	@field:SerializedName("webcast_launch")
	val webcastLaunch: Int? = null
)

data class Links(

	@field:SerializedName("mission_patch_small")
	val missionPatchSmall: String? = null,

	@field:SerializedName("mission_patch")
	val missionPatch: String? = null,

	@field:SerializedName("video_link")
	val videoLink: String? = null,

	@field:SerializedName("flickr_images")
	val flickrImages: List<Any?>? = null,

	@field:SerializedName("reddit_recovery")
	val redditRecovery: Any? = null,

	@field:SerializedName("reddit_media")
	val redditMedia: Any? = null,

	@field:SerializedName("reddit_campaign")
	val redditCampaign: Any? = null,

	@field:SerializedName("wikipedia")
	val wikipedia: String? = null,

	@field:SerializedName("reddit_launch")
	val redditLaunch: Any? = null,

	@field:SerializedName("youtube_id")
	val youtubeId: String? = null,

	@field:SerializedName("presskit")
	val presskit: Any? = null,

	@field:SerializedName("article_link")
	val articleLink: String? = null
)

data class FirstStage(

	@field:SerializedName("cores")
	val cores: List<CoresItem?>? = null
)

data class PayloadsItem(

	@field:SerializedName("payload_type")
	val payloadType: String? = null,

	@field:SerializedName("payload_mass_kg")
	val payloadMassKg: Double? = null,

	@field:SerializedName("payload_id")
	val payloadId: String? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("norad_id")
	val noradId: List<Any?>? = null,

	@field:SerializedName("customers")
	val customers: List<String?>? = null,

	@field:SerializedName("orbit")
	val orbit: String? = null,

	@field:SerializedName("orbit_params")
	val orbitParams: OrbitParams? = null,

	@field:SerializedName("payload_mass_lbs")
	val payloadMassLbs: Double? = null,

	@field:SerializedName("reused")
	val reused: Boolean? = null,

	@field:SerializedName("manufacturer")
	val manufacturer: String? = null,

	@field:SerializedName("cargo_manifest")
	val cargoManifest: Any? = null,

	@field:SerializedName("cap_serial")
	val capSerial: String? = null,

	@field:SerializedName("mass_returned_lbs")
	val massReturnedLbs: Any? = null,

	@field:SerializedName("flight_time_sec")
	val flightTimeSec: Int? = null,

	@field:SerializedName("mass_returned_kg")
	val massReturnedKg: Any? = null,

	@field:SerializedName("uid")
	val uid: String? = null
)

data class SecondStage(

	@field:SerializedName("payloads")
	val payloads: List<PayloadsItem?>? = null,

	@field:SerializedName("block")
	val block: Int? = null
)

data class Fairings(

	@field:SerializedName("recovered")
	val recovered: Boolean? = null,

	@field:SerializedName("recovery_attempt")
	val recoveryAttempt: Boolean? = null,

	@field:SerializedName("ship")
	val ship: Any? = null,

	@field:SerializedName("reused")
	val reused: Boolean? = null
)

data class LaunchSite(

	@field:SerializedName("site_name")
	val siteName: String? = null,

	@field:SerializedName("site_id")
	val siteId: String? = null,

	@field:SerializedName("site_name_long")
	val siteNameLong: String? = null
)
