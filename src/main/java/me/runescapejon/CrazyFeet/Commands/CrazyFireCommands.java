package me.runescapejon.CrazyFeet.Commands;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import me.runescapejon.CrazyFeet.utils.Pair;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyFireCommands implements CommandExecutor {

	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cFire = CrazyFeet.getInstance().getCrazyFire();
		final ArrayList<UUID> cbluehelix = CrazyFeet.getInstance().getCrazyBlueHelix();
		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazyfire")) {
				if (cFire.contains(player.getUniqueId())) {
					cFire.remove(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyFireDisabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cFire.add(player.getUniqueId());
					cbluehelix.remove(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyFireEnabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazyfireother")) {
			Player targ = target.get();

			if (cFire.contains(targ.getUniqueId())) {
				cFire.remove(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyFireDisabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyFireDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cFire.add(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyFireEnabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyFireEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
