package me.runescapejon.CrazyFeet.utils;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class ConfigUtils {
	
	@Setting(value = "OneTimeParticle", comment = "Default is true, but turning this false will allow feet and heads to apply to player more then once. An multi-particle effect, must reboot to apply changes.")
	public static boolean onetimeparticle = true;
}
