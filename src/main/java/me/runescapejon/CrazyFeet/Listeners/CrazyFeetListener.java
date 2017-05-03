package me.runescapejon.CrazyFeet.Listeners;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.Color;

import me.runescapejon.CrazyFeet.CrazyFeet;

@SuppressWarnings("unused")
public class CrazyFeetListener {

	TextColor green = TextColors.GREEN;

	@Listener
	public void onCrazyFireMove(MoveEntityEvent event, @First Player player) {

		// Player player;
		// player = (Player)getTargetEntity();
		// that lines above are disabled causes console errors spam due to
		// detecting other entitys xD

		if (CrazyFeet.CrazyFire.contains(player)) {
			player.getWorld().spawnParticles(ParticleEffect.builder().type(ParticleTypes.MOBSPAWNER_FLAMES).build(),
					player.getLocation().getPosition().add(0, -1, 0));
		} else {
			event.setCancelled(false);
		}
	}

	//this Music Note's colors are broken by Sponge api
	@Listener
	public void onCrazyNoteMove(MoveEntityEvent event, @First Player player) {

		if (CrazyFeet.Crazynote.contains(player)) {
			// here is aqua notes <3
			player.getWorld().spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.NOTE)
							.option(ParticleOptions.COLOR, Color.ofRgb(0, 255, 255)).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));

			// here is red notes
			player.getWorld().spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.NOTE)
							.option(ParticleOptions.COLOR, Color.ofRgb(255, 0, 0)).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		} else {
			event.setCancelled(false);
		}
	}

	@Listener
	public void onCrazyMagicMove(MoveEntityEvent event, @First Player player) {

		if (CrazyFeet.CrazyMagic.contains(player)) {
			player.getWorld().spawnParticles(ParticleEffect.builder().type(ParticleTypes.INSTANT_SPELL).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		} else {
			event.setCancelled(false);
		}
	}

	@Listener
	public void onCrazySmokeMove(MoveEntityEvent event, @First Player player) {

		if (CrazyFeet.CrazySmoke.contains(player)) {
			player.getWorld().spawnParticles(ParticleEffect.builder().type(ParticleTypes.SMOKE).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		} else {
			event.setCancelled(false);
		}
	}

	@Listener
	public void onCrazyHeartMove(MoveEntityEvent event, @First Player player) {

		if (CrazyFeet.CrazyHeart.contains(player)) {
			player.getWorld().spawnParticles(ParticleEffect.builder().type(ParticleTypes.HEART).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		} else {
			event.setCancelled(false);
		}
	}

	@Listener
	public void onCrazyPearlMove(MoveEntityEvent event, @First Player player) {

		if (CrazyFeet.CrazyPearl.contains(player)) {
			player.getWorld().spawnParticles(ParticleEffect.builder().type(ParticleTypes.ENDER_TELEPORT).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		} else {
			event.setCancelled(false);
		}
	}

	@Listener
	public void onCrazyWitchMove(MoveEntityEvent event, @First Player player) {

		if (CrazyFeet.CrazyWitch.contains(player)) {
			player.getWorld().spawnParticles(ParticleEffect.builder().type(ParticleTypes.WITCH_SPELL).build(),
					player.getLocation().getPosition().add(0, 0.1, 0));
		} else {
			event.setCancelled(false);
		}
	}
}
