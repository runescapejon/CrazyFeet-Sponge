package me.runescapejon.CrazyFeet.Listeners;

import org.spongepowered.api.event.network.ClientConnectionEvent.Join;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import me.runescapejon.CrazyFeet.CrazyFeet;
import me.runescapejon.CrazyFeet.Commands.Util.Files.CrazyAutoFireFile;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;

public class CrazyFeetJoinListener {
	// TODO: ugh i need to do this crazyjoin Listeners+
	@Listener
	public void onCrazyFireJoin(Join pJE) {
		Player player = pJE.getTargetEntity();
		if (CrazyAutoFireFile.cFPlayers.contains(player.getName())) {
			CrazyFeet.CrazyFire.add(player);
			player.sendMessage(Text.of(TextColors.GREEN,
					"You have joined the game with automatic CrazyFire. To disable this, type /crazyautofire"));
		} else {
			// doNothing
		}
	}
}
