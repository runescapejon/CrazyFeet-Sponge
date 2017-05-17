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

public class CrazyHeadListener {
	// It's seem getPosition().add(0, 3, 0,) seem the right location for the
	// Head
	// - tested 2.5 is right
	@Listener
	public void onMoveHead(MoveEntityEvent event, @First Player player) {

		boolean fireh = false, noteh = false, magich = false, smokeh = false, hearth = false, pearlh = false,
				witchh = false;
		fireh = CrazyFeet.crazyFireHead.contains(player);
		noteh = CrazyFeet.crazyNoteHead.contains(player);
		magich = CrazyFeet.crazyMagicHead.contains(player);
		smokeh = CrazyFeet.crazySmokeHead.contains(player);
		hearth = CrazyFeet.crazyHeartHead.contains(player);
		pearlh = CrazyFeet.crazyPearlHead.contains(player);
		witchh = CrazyFeet.crazyWitchHead.contains(player);

		if (fireh) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.MOBSPAWNER_FLAMES).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (noteh) {
			// Crap Sponge api doesn't support color Notes seem like it
			// here is aqua notes <3
			player.spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.NOTE)
							.option(ParticleOptions.COLOR, Color.ofRgb(0, 255, 255)).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));

			// here is red notes
			player.spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.NOTE)
							.option(ParticleOptions.COLOR, Color.ofRgb(255, 0, 0)).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (magich) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.INSTANT_SPELL).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (smokeh) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.SMOKE).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (hearth) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.HEART).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (pearlh) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.ENDER_TELEPORT).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (witchh) {
			player.spawnParticles(ParticleEffect.builder().type(ParticleTypes.WITCH_SPELL).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
	}
}
