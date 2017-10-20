package me.runescapejon.CrazyFeet.Listeners;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.NotePitches;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import me.runescapejon.CrazyFeet.CrazyFeet;

import org.spongepowered.api.world.World;

public class CrazyFeetListener {

	@Listener
	public void onMove(MoveEntityEvent event, @First Player player) {
		if (player.get(Keys.INVISIBLE).get()) {
			return;
		}
		boolean fire, note, magic, smoke, heart, pearl, witch;
		fire = CrazyFeet.getInstance().getCrazyFire().contains(player.getUniqueId());
		note = CrazyFeet.getInstance().getCrazyNote().contains(player.getUniqueId());
		magic = CrazyFeet.getInstance().getCrazyMagic().contains(player.getUniqueId());
		smoke = CrazyFeet.getInstance().getCrazySmoke().contains(player.getUniqueId());
		heart = CrazyFeet.getInstance().getCrazyHeart().contains(player.getUniqueId());
		pearl = CrazyFeet.getInstance().getCrazyPearl().contains(player.getUniqueId());
		witch = CrazyFeet.getInstance().getCrazyWitch().contains(player.getUniqueId());

		World world = player.getWorld();

		if (fire) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.MOBSPAWNER_FLAMES).build(),
					player.getLocation().getPosition().add(0, -1, 0));
		}
		if (note) {
			// Thanks to @Cybermaxke for telling me how to change colors
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.NOTE)
					.option(ParticleOptions.NOTE, NotePitches.G_SHARP0).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));

			// here is red notes
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.NOTE)
					.option(ParticleOptions.NOTE, NotePitches.C1).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (magic) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.INSTANT_SPELL).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (smoke) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.SMOKE).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (heart) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.HEART).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (pearl) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.ENDER_TELEPORT).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
		if (witch) {
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.WITCH_SPELL).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		}
	}
}
