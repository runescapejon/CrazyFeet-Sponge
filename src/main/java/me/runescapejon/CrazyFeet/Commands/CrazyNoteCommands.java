package me.runescapejon.CrazyFeet.Commands;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import me.runescapejon.CrazyFeet.utils.ConfigUtils;
import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import me.runescapejon.CrazyFeet.utils.Pair;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyNoteCommands implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cNote = CrazyFeet.getInstance().getCrazyNote();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazynote")) {
				if (ConfigUtils.onetimeparticle) {
					if (cNote.contains(player.getUniqueId())) {
						cNote.remove(player.getUniqueId());
						player.sendMessage(LanguageUtils.getText("crazyNoteDisabled",
								new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					} else {
						CrazyFeet.clearPlayer(player);
						cNote.add(player.getUniqueId());
						player.sendMessage(LanguageUtils.getText("crazyNoteEnabled",
								new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					}
			}
			if (ConfigUtils.onetimeparticle == false) {
				if (cNote.contains(player.getUniqueId())) {
					cNote.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyNoteDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cNote.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyNoteEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}

		}
		} else if (src.hasPermission("CrazyFeet.crazynoteother")) {
			Player targ = target.get();

			if (cNote.contains(targ.getUniqueId())) {
				cNote.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyNoteDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyNoteDisabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cNote.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyNoteEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyNoteEnabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}