package me.runescapejon.CrazyFeet.Listeners;

import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.util.Color;

import me.runescapejon.CrazyFeet.CrazyFeet;
public class CrazyFeetListener {

	@Listener
	public void onMove(MoveEntityEvent event, @First Player player) {

		boolean fire = false, note = false, magic = false, smoke = false, heart = false, pearl = false, witch = false;
		fire = CrazyFeet.crazyFire.contains(player);
		note = CrazyFeet.crazynote.contains(player);
		magic = CrazyFeet.crazyMagic.contains(player);
		smoke = CrazyFeet.crazySmoke.contains(player);
		heart = CrazyFeet.crazyHeart.contains(player);
		pearl = CrazyFeet.crazyPearl.contains(player);
		witch = CrazyFeet.crazyWitch.contains(player);

		if (fire) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.MOBSPAWNER_FLAMES).build(),
					player.getLocation().getPosition().add(0, -1, 0));
		}
		if (note) {
			// here is aqua notes <3
			player.spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.NOTE)
							.option(ParticleOptions.COLOR, Color.ofRgb(0, 255, 255)).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));

			// here is red notes
			player.spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.NOTE)
							.option(ParticleOptions.COLOR, Color.ofRgb(255, 0, 0)).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (magic) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.INSTANT_SPELL).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (smoke) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.SMOKE).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (heart) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.HEART).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (pearl) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.ENDER_TELEPORT).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (witch) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.WITCH_SPELL).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
	}
}
