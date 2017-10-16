package me.runescapejon.CrazyFeet.Listeners;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.data.type.NotePitches;
import me.runescapejon.CrazyFeet.CrazyFeet;
import org.spongepowered.api.world.World;

public class CrazyHeadListener {
	// It's seem getPosition().add(0, 3, 0,) seem the right location for the
	// Head
	// - tested 2.5 is right
	@Listener
	public void onMoveHead(MoveEntityEvent event, @First Player player) {
		if (player.get(Keys.INVISIBLE).get()) {
			return;
		}
		boolean fireh, noteh, magich, smokeh, hearth, pearlh, witchh;
		fireh = CrazyFeet.getInstance().getCrazyFireHead().contains(player);
		noteh = CrazyFeet.getInstance().getCrazyNoteHead().contains(player);
		magich = CrazyFeet.getInstance().getCrazyMagicHead().contains(player);
		smokeh = CrazyFeet.getInstance().getCrazySmokeHead().contains(player);
		hearth = CrazyFeet.getInstance().getCrazyHeartHead().contains(player);
		pearlh = CrazyFeet.getInstance().getCrazyPearlHead().contains(player);
		witchh = CrazyFeet.getInstance().getCrazyWitchHead().contains(player);

		World world = player.getWorld();

		if (fireh) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.MOBSPAWNER_FLAMES).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (noteh) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.NOTE)
			        .option(ParticleOptions.NOTE, NotePitches.G_SHARP0)
			        .build(),
					player.getLocation().getPosition().add(0, 0.1, 0));

			// here is red notes
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.NOTE)
			        .option(ParticleOptions.NOTE, NotePitches.C1)
			        .build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (magich) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.INSTANT_SPELL).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (smokeh) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.SMOKE).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (hearth) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.HEART).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (pearlh) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.ENDER_TELEPORT).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
		if (witchh) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.WITCH_SPELL).build(),
					player.getLocation().getPosition().add(0, 2.5, 0));
		}
	}
}
