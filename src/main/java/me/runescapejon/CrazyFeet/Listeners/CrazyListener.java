package me.runescapejon.CrazyFeet.Listeners;

import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.NotePitch;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleType;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.filter.cause.Root;

import me.runescapejon.CrazyFeet.CrazyFeet;


import org.spongepowered.api.world.World;

import java.util.ArrayList;
import java.util.Random;

public class CrazyListener {
	private GameRegistry gameRegistry = Sponge.getRegistry();
	// It's seem getPosition().add(0, 3, 0,) seem the right location for the
	// Head
	// - tested 2.5 is right
	@Listener
	public void onMoveHead (MoveEntityEvent event,@Root Player player) {
		if (player.get(Keys.INVISIBLE).get()) {
			return;
		}
		double head = 2.5;
		double feet = 0.1;
		boolean fire = CrazyFeet.getInstance().getCrazyFire().contains(player.getUniqueId()),
				note = CrazyFeet.getInstance().getCrazyNote().contains(player.getUniqueId()),
				magic = CrazyFeet.getInstance().getCrazyMagic().contains(player.getUniqueId()),
				smoke = CrazyFeet.getInstance().getCrazySmoke().contains(player.getUniqueId()),
				heart = CrazyFeet.getInstance().getCrazyHeart().contains(player.getUniqueId()),
				pearl = CrazyFeet.getInstance().getCrazyPearl().contains(player.getUniqueId()),
				witch = CrazyFeet.getInstance().getCrazyWitch().contains(player.getUniqueId()),
				fireHead = CrazyFeet.getInstance().getCrazyFireHead().contains(player.getUniqueId()),
				noteHead = CrazyFeet.getInstance().getCrazyNoteHead().contains(player.getUniqueId()),
				magicHead = CrazyFeet.getInstance().getCrazyMagicHead().contains(player.getUniqueId()),
				smokeHead = CrazyFeet.getInstance().getCrazySmokeHead().contains(player.getUniqueId()),
				heartHead = CrazyFeet.getInstance().getCrazyHeartHead().contains(player.getUniqueId()),
				pearlHead = CrazyFeet.getInstance().getCrazyPearlHead().contains(player.getUniqueId()),
				witchHead = CrazyFeet.getInstance().getCrazyWitchHead().contains(player.getUniqueId());

		World world = player.getWorld();
		if (note) {
			// Thanks to @Cybermaxke for telling me how to change colors
			applyParticle(world,player,ParticleTypes.NOTE,true,feet);
		}
		if (fire) {
			applyParticle(world,player,ParticleTypes.MOBSPAWNER_FLAMES,false,feet);
		}
		if (magic) {
			applyParticle(world,player,ParticleTypes.INSTANT_SPELL,false,feet);
		}
		if (smoke) {
			applyParticle(world,player,ParticleTypes.SMOKE,false,feet);
		}
		if (heart) {
			applyParticle(world,player,ParticleTypes.HEART,false,feet);
		}
		if (pearl) {
			applyParticle(world,player,ParticleTypes.ENDER_TELEPORT,false,feet);
		}
		if (witch) {
			applyParticle(world,player,ParticleTypes.WITCH_SPELL,false,feet);
		}
		if (noteHead) {
			applyParticle(world,player,ParticleTypes.NOTE,true,head);
		}
		if (fireHead) {
			applyParticle(world,player,ParticleTypes.MOBSPAWNER_FLAMES,false,head);
		}
		if (magicHead) {
			applyParticle(world,player,ParticleTypes.INSTANT_SPELL,false,head);
		}
		if (smokeHead) {
			applyParticle(world,player,ParticleTypes.SMOKE,false,head);
		}
		if (heartHead) {
			applyParticle(world,player,ParticleTypes.HEART,false,head);
		}
		if (pearlHead) {
			applyParticle(world,player,ParticleTypes.ENDER_TELEPORT,false,head);
		}
		if (witchHead) {
			applyParticle(world,player,ParticleTypes.WITCH_SPELL,false,head);
		}
	}

	private void applyParticle (World world,Player player,ParticleType pType,boolean isNote,double bodyType) {
		Random randomGenerator = new Random();
		ArrayList<NotePitch> noteTypes = new ArrayList<>(getGameRegistry().getAllOf(NotePitch.class));
		if (isNote) {
			int index = randomGenerator.nextInt(noteTypes.size());
			world.spawnParticles(ParticleEffect.builder().type(pType)
							.option(ParticleOptions.NOTE,noteTypes.get(index)).build(),
					player.getLocation().getPosition().add(0,bodyType,0));
		} else {
			world.spawnParticles(ParticleEffect.builder().type(pType).build(),
					player.getLocation().getPosition().add(0,bodyType,0));
		}
	}
		private GameRegistry getGameRegistry () {
		return gameRegistry;
	}
}
