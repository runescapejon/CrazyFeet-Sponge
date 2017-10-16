package me.runescapejon.CrazyFeet.Commands.head;

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
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyWitchHeadCommand implements CommandExecutor {

	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cWitchHead = CrazyFeet.getInstance().getCrazyWitchHead();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazywitchhead")) {
				if (cWitchHead.contains(player.getUniqueId())) {
					cWitchHead.remove(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyWitchHeadDisabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cWitchHead.add(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyWitchHeadEnabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazywitchheadother")) {
			Player targ = target.get();

			if (cWitchHead.contains(targ.getUniqueId())) {
				cWitchHead.remove(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyWitchHeadDisabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyWitchHeadDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cWitchHead.add(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyWitchHeadEnabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyWitchHeadEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
