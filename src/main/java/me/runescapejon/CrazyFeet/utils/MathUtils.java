package me.runescapejon.CrazyFeet.utils;

import java.util.ArrayList;

import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.world.World;

public class MathUtils {
	// Welcome to this math class file here is where i bash my head against the
	// wall.. .-.

	private static void cloudMath(Player player, double x, double y, double z) {
		World world = player.getWorld();
		world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.CLOUD).build(),
				player.getLocation().getPosition().add(x, y, z));
	}

	public static void helixMath(Player player, Color c) {
		phi = phi + Math.PI / 16;
		double x, y, z;
		for (double t = 0; t <= 2 * Math.PI; t = t + Math.PI / 16) {
			for (double i = 0; i <= 1; i = i + 1) {
				x = 0.15 * (2 * Math.PI - t) * Math.cos(t + phi + i * Math.PI);
				y = 0.5 * t;
				z = 0.15 * (2 * Math.PI - t) * Math.sin(t + phi + i * Math.PI);
				World world = player.getWorld();
				world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
						.option(ParticleOptions.COLOR, c).build(), player.getLocation().getPosition().add(x, y, z));

			}
		}
	}

	public static void StyleGlobe(Player player) {
		phi = phi + Math.PI / 16;
		double x, y, z;
		x = 0.15 * (2 * Math.PI) * Math.cos(phi * Math.PI);
		y = 1;
		z = 0.15 * (2 * Math.PI) * Math.sin(phi * Math.PI);
		World world = player.getWorld();
		world.spawnParticles(
				ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
						.option(ParticleOptions.COLOR, Color.ofRgb(255, 0, 0)).build(),
				player.getLocation().getPosition().add(x, y, z));
	}

	public static int orbs = 4;
	public static int maxStepX = 80;
	private static int maxStepY = 60;
	private static int stepX = 0;
	private static int stepY = 0;

	public static void Ring(Player player) {
		for(int x = 0; x < Math.PI*2; x += Math.PI*2/5) { // Density is the amount of particles in your circle

			World world = player.getWorld();
            world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
					.option(ParticleOptions.COLOR, Color.ofRgb(255, 0, 0)).build(), player.getLocation().getPosition()
					.add(Math.sin(x), 10, Math.cos(x)));


	}
	}
	
	public static void Cloud(Player player) {
		cloudMath(player, 0, 2.5, 0);
		cloudMath(player, 0.2, 2.5, 0.2);
		cloudMath(player, 0, 2.5, 0.4);
		cloudMath(player, 0.4, 2.5, 0);
	}

	public static void Rain(Player player) {
		World world = player.getWorld();
		world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.WATER_DROP).build(),
				player.getLocation().getPosition().add(0, 2.5, 0));
	}

	public static double phi = 0;
	private static double pi = 0;

}
