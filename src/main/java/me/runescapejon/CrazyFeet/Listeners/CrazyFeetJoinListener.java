package me.runescapejon.CrazyFeet.Listeners;

import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import org.spongepowered.api.event.network.ClientConnectionEvent.Join;

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
			CrazyFeet.getInstance().getCrazyFire().add(player.getUniqueId());
			player.sendMessage(LanguageUtils.getText("crazyFeetAutoFireOnJoin"));
		}
	}
}
